package io.github.starmineouji.schemicalmod;

import io.github.starmineouji.schemicalmod.elem.base.Element;
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
		return Element.elements.iterator().next().getItem().getDefaultInstance();
	}

}
