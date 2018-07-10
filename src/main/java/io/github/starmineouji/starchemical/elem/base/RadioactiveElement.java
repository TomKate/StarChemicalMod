package io.github.starmineouji.starchemical.elem.base;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.google.common.base.Objects;

import io.github.starmineouji.starchemical.Localizer;
import io.github.starmineouji.starchemical.StarChemicalMod;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

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
			super.addInformation(stack, worldIn, tooltip, flagIn);
			tooltip.add(TextFormatting.RED + StarChemicalMod.localiser.getMessage("chemical.radioactive"));
			try {
				long life = stack.getTagCompound().getLong("Life");
				long tick = life % 20, second = life / 20 % 60, minute = life / 20 / 60 % 60;
				tooltip.add(StarChemicalMod.localiser.getMessage("time.remaining") + ":" + life / 20 / 60 / 60
						+ StarChemicalMod.localiser.getMessage("time.hour") + minute + StarChemicalMod.localiser.getMessage("time.minute") + second
						+  StarChemicalMod.localiser.getMessage("time.sec")  + tick + "Tick");
			} catch (Exception e) {
			}
		}
	}
}