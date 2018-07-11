package io.github.starmineouji.starchemical;

import java.io.File;
import java.util.Locale;

import org.apache.logging.log4j.Logger;

import io.github.starmineouji.starchemical.elem.base.Element;
import io.github.starmineouji.starchemical.lib.Lambdas;
import io.github.starmineouji.starchemical.register.ElementRegister;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = StarChemicalMod.MODID, name = StarChemicalMod.NAME, version = StarChemicalMod.VERSION)
public class StarChemicalMod {
	// MEMO: \u2080 ~ \u2089 = 小さい文字
	public static final String MODID = "starchemical";
	public static final String NAME = "StarChemicalMod";
	public static final String VERSION = "0.0.1-TEST";
	public static final CreativeTabs elems = new Elements();
	public static Localizer localiser;

	public static Logger logger;

	@Mod.EventHandler
	public void construct(FMLConstructionEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) throws Exception {
		logger = event.getModLog();
//		Element.addElement(new Element("Netherlium", 150, "Nt"));
//		Element.addElement(new Element("Enderlium", 151, "Ed"));
		Locale loc = Locale.getDefault();
		String locstr = (loc.getLanguage() + "_" + loc.getCountry()).toLowerCase();
		File file = new File("./config/starchemical/core.cfg");
		file.getParentFile().mkdirs();
		file.createNewFile();
		Configuration cfg = new Configuration(file);
		String path = cfg.getString("lang_path", "networks", "presets/github", "言語ファイルの参照先($で言語)");
		if (!path.equals("presets/github")) {
			localiser = new Localizer(
					new File(path.replaceAll("\\$", (locstr == null || locstr.equals("_") ? "ja_jp" : locstr))));
		} else
			localiser = new Localizer();
		cfg.save();
		ElementRegister.addElement("Hydrogen", 1, "H");
		ElementRegister.addElement("Hellium", 2, "He");
		ElementRegister.addElement("Lithium", 3, "Li");
		ElementRegister.addElement("Beryllium", 4, "Be");
		ElementRegister.addElement("Natrium", 11, "Na");
		ElementRegister.addElement("Magnesium", 12, "Mg");
		ElementRegister.addElement("Kalium", 19, "K");
		ElementRegister.addElement("Calcium", 20, "Ca");
		ElementRegister.addElement("Rubidium", 37, "Rb");
		ElementRegister.addElement("Strontium", 38, "Sr");
		ElementRegister.addElement("Caesium", 55, "Cs");
		ElementRegister.addRElement("Francium", 87, 1308 * 20, Lambdas.toMap(map -> {
		}), "Fr");
		// Hydrogen,Hellium,Lithium,Beryllium,Natrium,Kalium,Rubidium,Caesium,Francium,Magnesium,Calcium,Strontium

	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		for (Element elem : Element.elements.values()) {
			ModelLoader.setCustomModelResourceLocation(elem.getItem(), 0,
					new ModelResourceLocation(elem.getItem().getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(elem.getItemBlock(), 0,
					new ModelResourceLocation(elem.getItemBlock().getRegistryName(), "inventory"));
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
