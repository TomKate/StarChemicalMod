package io.github.starmineouji.starchemical.elem.base;

import java.util.Map;
import java.util.Random;

import com.google.common.base.Objects;

import io.github.starmineouji.starchemical.StarChemicalMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * 放射性物質の原子
 * 
 * @author starmineouji
 *
 */
public class RadioactiveElement extends Element {
	protected long Half_Life;
	protected Map<String, Integer> Afterhalf;

	public RadioactiveElement(String name, int number, long half_life, Map<String, Integer> afterhalf, String ESymbol) {
		// TODO Auto-generated constructor stub
		super(name, number, ESymbol);
		Half_Life = half_life;
		Afterhalf = afterhalf;
		ITEM = new RItem(new RBlock());
	}

	public class RBlock extends Block {
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return Objects.hashCode(name);
		}

		public RBlock() {
			super(Material.ROCK);
			// TODO Auto-generated constructor stub
			setRegistryName(StarChemicalMod.MODID, name).setCreativeTab(StarChemicalMod.elems).setUnlocalizedName(name)
					.setHardness(1.5F).setResistance(1.0F);
		}
	}

	public class RItem extends Element.EItem {
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return Objects.hashCode(name, ESymbol);
		}

		public RItem(Block b) {
			// TODO Auto-generated constructor stub
			super(b);
		}

		@SideOnly(Side.SERVER)
		@Override
		public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
			// TODO Auto-generated method stub
			NBTTagCompound nbt = stack.getTagCompound();
			if (nbt == null)
				nbt = new NBTTagCompound();
			if (nbt.hasKey("Life")) {
				nbt.setLong("Life", nbt.getLong("Life") - 1);
				if (nbt.getLong("Life") <= 0) {
					worldIn.createExplosion(entityIn, entityIn.lastTickPosX, entityIn.lastTickPosY,
							entityIn.lastTickPosZ, 2, false);
					entityIn.replaceItemInInventory(itemSlot, new ItemStack(Block.getBlockFromName("minecraft:air")));
				}
			} else
				nbt.setLong("Life", Half_Life);
			stack.setTagCompound(nbt);
			StarChemicalMod.logger.info("Updated");
			super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
		}
	}
}