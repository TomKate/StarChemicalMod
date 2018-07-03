package io.github.starmineouji.starchemical;

import org.apache.logging.log4j.Logger;

import io.github.starmineouji.starchemical.elem.base.Element;
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
		Element.addElement("Hydrogen", 1, "H");
	Element.addElement("Hellium", 2, "He");
		Element.addElement("Lithium", 3, "Li");
		Element.addElement("Beryllium", 4, "Be");
		Element.addElement("Natrium",11, "Na");
		Element.addElement("Kalium", 19, "K");
		Element.addElement("Rubidium", 37, "Rb");
		Element.addElement("Caesium", 55, "Cs");
		Element.addElement("Francium", 87, "Fr");
		//Hydrogen,Hellium,Lithium,Beryllium,Natrium,Kalium,Rubidium,Caesium,Francium
		logger.info(Element.elements.values().iterator().next().getItemblock().getRegistryName());
		for (Element elem : Element.elements.values()) {
			if (event.getSide().isClient()) {
				ModelLoader.setCustomModelResourceLocation(elem.getItemblock(), 0,
						new ModelResourceLocation(elem.getItemblock().getRegistryName(), "inventory"));
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
			event.getRegistry().registerAll(elem.getItemblock());
		}
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

	}
}
