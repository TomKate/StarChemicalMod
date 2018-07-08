package io.github.starmineouji.starchemical.elem.base;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import com.google.common.base.Objects;

import io.github.starmineouji.starchemical.StarChemicalMod;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
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
		ITEM = new RItem();
	}

	public static RadioactiveElement addRElement(String name, int number, long half_life,
			Map<String, Integer> afterhalf, String ESymbol) {
		RadioactiveElement ra = new RadioactiveElement(name, number, half_life, afterhalf, ESymbol);
		Element.elements.put(ESymbol, ra);
		return ra;
	}

	public class RItem extends Element.EItem {
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return Objects.hashCode(name, ESymbol);
		}

		public RItem() {
			// TODO Auto-generated constructor stub
			super();
		}

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
					entityIn.replaceItemInInventory(itemSlot, new ItemStack(ITEM, stack.getCount() / 2));
				}
			} else
				nbt.setLong("Life", Half_Life);
			stack.setTagCompound(nbt);
			super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
		}

		@Override
		public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
			// TODO Auto-generated method stub
			tooltip.add("原子記号:"+ESymbol);
			tooltip.add("原子番号:"+Number);
			tooltip.add(TextFormatting.RED + "放射性物質");
			try {
				long life = stack.getTagCompound().getLong("Life");
				long tick = life % 20, second = life / 20 % 60, minute = life / 20 / 60 % 60;
				tooltip.add("半減期まで残り" + life / 20 / 60 / 60 + "時間" + minute + "分" + second + "秒" + tick + "Tick");
			} catch (Exception e) {
			}
		}
	}
}