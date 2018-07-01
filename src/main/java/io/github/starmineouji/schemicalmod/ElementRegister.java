package io.github.starmineouji.schemicalmod;

import io.github.starmineouji.schemicalmod.elem.base.Element;
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
		if (e.getSide().isClient()) {
			ModelLoader.setCustomModelResourceLocation(elem.getItemblock(), 0,
					new ModelResourceLocation(elem.getItemblock().getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(elem.getItem(), 0,
					new ModelResourceLocation(elem.getItem().getRegistryName(), "inventory"));
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
			event.getRegistry().registerAll(elem.getBlock());
		}
	}
	public static void registitem(RegistryEvent.Register<Item> event) {
		for (Element elem : Element.elements) {
			event.getRegistry().registerAll(elem.getItemblock(), elem.getItem());
		}
	}
}
