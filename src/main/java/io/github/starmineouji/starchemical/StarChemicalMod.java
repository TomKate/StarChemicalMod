package io.github.starmineouji.starchemical;

import org.apache.logging.log4j.Logger;

import io.github.starmineouji.starchemical.elem.base.Element;
import io.github.starmineouji.starchemical.elem.base.RadioactiveElement;
import io.github.starmineouji.starchemical.lib.Lambdas;
import io.github.starmineouji.starchemical.register.ElementRegister;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = StarChemicalMod.MODID, name = StarChemicalMod.NAME, version = StarChemicalMod.VERSION)
public class StarChemicalMod {
	// MEMO: \u2080 ~ \u2089 = 小さい文字
	public static final String MODID = "starchemical";
	public static final String NAME = "StarChemicalMod";
	public static final String VERSION = "0.0.1-TEST";
	public static final CreativeTabs elems = new Elements();

	public static Logger logger;

	@Mod.EventHandler
	public void construct(FMLConstructionEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
//		Element.addElement(new Element("Netherlium", 150, "Nt"));
//		Element.addElement(new Element("Enderlium", 151, "Ed"));
		ElementRegister.addElement("Hydrogen", 1, "H");
		ElementRegister.addElement("Hellium", 2, "He");
		ElementRegister.addElement("Lithium", 3, "Li");
		ElementRegister.addElement("Beryllium", 4, "Be");
		ElementRegister.addElement("Natrium", 11, "Na");
		ElementRegister.addElement("Magnesium", 12, "Mg");
		ElementRegister.addElement("Kalium", 19, "K");
		ElementRegister.addElement("Rubidium", 37, "Rb");
		ElementRegister.addElement("Caesium", 55, "Cs");
		ElementRegister.addRElement("Francium", 87, 1308 * 20, Lambdas.toMap(map -> {
		}), "Fr");
		// Hydrogen,Hellium,Lithium,Beryllium,Natrium,Kalium,Rubidium,Caesium,Francium,Magnesium
		logger.info(Element.elements.values().iterator().next().getItem().getRegistryName());
		for (Element elem : Element.elements.values()) {
			if (event.getSide().isClient()) {
				ModelLoader.setCustomModelResourceLocation(elem.getItem(), 0,
						new ModelResourceLocation(elem.getItem().getRegistryName(), "inventory"));
				ModelLoader.setCustomModelResourceLocation(elem.getItemBlock(), 0,
						new ModelResourceLocation(elem.getItemBlock().getRegistryName(), "inventory"));
			}
		}
	}

	@SubscribeEvent
	public void registBlocks(RegistryEvent.Register<Block> event) {
		for (Element elem : Element.elements.values()) {
			event.getRegistry().registerAll(elem.getBlock());
		}
	}

	@SubscribeEvent
	public void registItems(RegistryEvent.Register<Item> event) {
		for (Element elem : Element.elements.values()) {
			event.getRegistry().registerAll(elem.getItem(), elem.getItemBlock());
		}
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

	}
}
