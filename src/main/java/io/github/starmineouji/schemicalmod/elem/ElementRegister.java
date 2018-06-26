package io.github.starmineouji.schemicalmod.elem;

import io.github.starmineouji.schemicalmod.StarChemicalMod;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLStateEvent;

public class ElementRegister {
	public static void preInit(FMLStateEvent e) {
		for (Element elem : Element.elements) {
			fluidregist(elem.FGAS, new ModelResourceLocation("sccraft:blocks/"+elem.name+"_gas", "fluid"), 
					elem.GAS, e);
			fluidregist(elem.FFLUID, new ModelResourceLocation("sccraft:blocks/"+elem.name+"_fluid", "fluid"), 
					elem.FLUID,e);
		if (e.getSide().isClient()) {
			ModelLoader.setCustomModelResourceLocation(elem.IBLOCK, 0,
					new ModelResourceLocation(elem.IBLOCK.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(elem.IFLUID, 0,
					new ModelResourceLocation(elem.IFLUID.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(elem.IGAS, 0,
					new ModelResourceLocation(elem.IGAS.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(elem.ITEM, 0,
					new ModelResourceLocation(elem.ITEM.getRegistryName(), "inventory"));
		}
		}
	}

	private static void fluidregist(Fluid Liquid, ModelResourceLocation loc, Block BlockedLiquid, FMLStateEvent event) {
		Block sampleFluidBlock = BlockedLiquid;
		if (event.getSide().isClient()) {
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(sampleFluidBlock), new ItemMeshDefinition() {
				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {
					return loc;
				}
			});
			ModelLoader.setCustomStateMapper(sampleFluidBlock, new StateMapperBase() {
				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState p_178132_1_) {
					return loc;
				}
			});
		}
	}

	public static void registblock(RegistryEvent.Register<Block> event) {
		for (Element elem : Element.elements) {
			event.getRegistry().registerAll(elem.BLOCK, elem.FLUID, elem.GAS);
		}
	}
	public static void registitem(RegistryEvent.Register<Item> event) {
		for (Element elem : Element.elements) {
			event.getRegistry().registerAll(elem.IBLOCK, elem.IFLUID, elem.IGAS, elem.ITEM);
		}
	}
}
