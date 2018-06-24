package io.github.starmineouji.schemicalmod.elem;

import io.github.starmineouji.schemicalmod.StarChemicalMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Element {

	public Element(Block bLOCK, Block fLUID, ElementType type, String name, int number) {
		super();
		BLOCK = bLOCK;
		FLUID = fLUID;
		this.type = type;
		this.name = name;
		Number = number;
	}

	public final Block BLOCK;

	public class EBlock extends Block {

		public EBlock() {
			super(Material.ROCK);
			// TODO Auto-generated constructor stub
			setRegistryName(StarChemicalMod.MODID, name + "_block").setCreativeTab(StarChemicalMod.elems)
					.setUnlocalizedName(name + "_block").setHardness(1.5F).setResistance(1.0F);
		}
	}

	public final Block FLUID;

	public class EFluid extends BlockFluidClassic {
		public EFluid() {
			super(new Fluid(name + "_fluid", new ResourceLocation("blocks/" + name + "_fluid_still"),
					new ResourceLocation("blocks/" + name + "_fluidwater_flow")), Material.WATER);
			this.setUnlocalizedName(name+"_fluid_block");
			this.setCreativeTab(StarChemicalMod.elems);
		}
	}


	public static enum ElementType {
		GAS, FLUID, SOLID
	}

	public final ElementType type;
	public final String name;

	public final int
	/**
	 * å¥éqî‘çÜ
	 */
	Number;

}