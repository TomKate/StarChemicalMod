package io.github.starmineouji.schemicalmod.elem.base;

import java.util.HashSet;
import java.util.Set;

import io.github.starmineouji.schemicalmod.StarChemicalMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class Element {
	public static Set<Element> elements = new HashSet<>();
	
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
		elements.add(element);
		return element;
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

	public static Set<Element> getElements() {
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