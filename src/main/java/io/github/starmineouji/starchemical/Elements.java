package io.github.starmineouji.starchemical;

import io.github.starmineouji.starchemical.elem.base.Element;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class Elements extends CreativeTabs {
	public Elements() {
		// TODO Auto-generated constructor stub
		super("elements");
	}

	@Override
	public ItemStack getTabIconItem() {
		// TODO Auto-generated method stub
		return Element.elements.values().iterator().next().getItemblock().getDefaultInstance();
	}

}
