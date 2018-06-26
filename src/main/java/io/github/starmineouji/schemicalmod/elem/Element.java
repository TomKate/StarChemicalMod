package io.github.starmineouji.schemicalmod.elem;

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

	public Element(ElementType type, String name, int number) {
		super();
		this.type = type;
		this.name = name;
		Number = number;
		FGAS = new Fluid(name + "_gas", new ResourceLocation("sccraft:blocks/" + name + "_gas_still"),
				new ResourceLocation("sccraft:blocks/" + name + "_gas_flow"));
		FFLUID = new Fluid(name + "_fluid", new ResourceLocation("sccraft:blocks/" + name + "_fluid_still"),
				new ResourceLocation("sccraft:blocks/" + name + "_fluid_flow"));
		FluidRegistry.registerFluid(FFLUID);
		FluidRegistry.registerFluid(FGAS);
		GAS = new EGus();
		BLOCK = new EBlock();
		FLUID = new EFluid();
		ITEM = new EItem();
		IBLOCK = new ItemBlock(BLOCK).setRegistryName(StarChemicalMod.MODID, name + "_block");
		IFLUID = new ItemBlock(FLUID).setRegistryName(StarChemicalMod.MODID, name + "_fluid_block");
		IGAS = new ItemBlock(GAS).setRegistryName(StarChemicalMod.MODID, name + "_gas_block");
	}

	public static Element addElement(ElementType type, String name, int number) {
		Element element = new Element(type, name, number);
		elements.add(element);
		return element;
	}

	public final ElementType type;
	public final String name;

	/**
	 * å¥éqî‘çÜ
	 */
	public final int Number;
	public final Block BLOCK, FLUID, GAS;
	public final Fluid FGAS, FFLUID;
	public final Item ITEM, IBLOCK, IFLUID, IGAS;

	public class EBlock extends Block {

		public EBlock() {
			super(Material.ROCK);
			// TODO Auto-generated constructor stub
			setRegistryName(StarChemicalMod.MODID, name + "_block").setCreativeTab(StarChemicalMod.elems)
					.setUnlocalizedName(name + "_block").setHardness(1.5F).setResistance(1.0F);
		}
	}

	public class EFluid extends BlockFluidClassic {
		public EFluid() {
			super(FFLUID, Material.WATER);
			setRegistryName(StarChemicalMod.MODID, name + "_fluid_block");
			this.setUnlocalizedName(name + "_fluid_block");
			this.setCreativeTab(StarChemicalMod.elems);
		}
	}

	public class EGus extends BlockFluidClassic {

		public EGus() {
			super(FGAS, Material.WATER);
			setRegistryName(StarChemicalMod.MODID, name + "_gas_block");
			this.setUnlocalizedName(name + "_gas_block");
			this.setCreativeTab(StarChemicalMod.elems);
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

	public static enum ElementType {
		GAS, FLUID, SOLID
	}

}