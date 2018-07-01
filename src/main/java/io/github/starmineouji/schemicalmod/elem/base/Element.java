package io.github.starmineouji.schemicalmod.elem.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import io.github.starmineouji.schemicalmod.StarChemicalMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class Element {
	public static Map<String, Element> elements = new HashMap<>();
	
	public Element() {

	}

	public Element(String name, int number, String ESymbol) {
		super();
		this.name = name;
		Number = number;
		BLOCK = new EBlock();
		ITEM = new EItem();
		IBLOCK = new ItemBlock(BLOCK).setRegistryName(StarChemicalMod.MODID, name + "_block");
	}

	public static Element addElement(String name, int number, String ESymbol) {
		Element element = new Element(name, number, ESymbol);
		elements.put(ESymbol, element);
		return element;
	}
	public static Element addElement(Element e) {
		elements.put(e.ESymbol, e);
		return e;
	}
	protected String name, ESymbol;

	/**
	 * å¥éqî‘çÜ
	 */
	protected int Number;
	protected Block BLOCK;
	protected Item ITEM, IBLOCK;

	public class EBlock extends Block {

		public EBlock() {
			super(Material.ROCK);
			// TODO Auto-generated constructor stub
			setRegistryName(StarChemicalMod.MODID, name + "_block").setCreativeTab(StarChemicalMod.elems)
					.setUnlocalizedName(name + "_block").setHardness(1.5F).setResistance(1.0F);
		}
	}

	public class EItem extends Item {
		public EItem() {
			// TODO Auto-generated constructor stub
			setRegistryName(StarChemicalMod.MODID, name);
			setCreativeTab(StarChemicalMod.elems);
			setUnlocalizedName(name);
		}
	}

	public static Map<String, Element> getElements() {
		return elements;
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return Number;
	}

	public Block getBlock() {
		return BLOCK;
	}
	public Item getItem() {
		return ITEM;
	}

	public Item getItemblock() {
		return IBLOCK;
	}
}