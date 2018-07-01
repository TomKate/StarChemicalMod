package io.github.starmineouji.schemicalmod;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import io.github.starmineouji.schemicalmod.elem.base.Element;
import io.github.starmineouji.schemicalmod.elem.base.RadioactiveElement;
import io.github.starmineouji.schemicalmod.lib.Lambdas;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
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
	public static final String MODID = "sccraft";
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
		Element.addElement(new RadioactiveElement("Nether", 150, 100, Lambdas.toMap(map -> {
			map.put("H", 1);
			map.put("Ne", 1);
			map.put("Fe", 1);
			map.put("U", 5);
		}), "Nt"));
		ElementRegister.preInit(event);
	}

	@SubscribeEvent
	public void registBlocks(RegistryEvent.Register<Block> event) {
		ElementRegister.registblock(event);
	}

	@SubscribeEvent
	public void registItems(RegistryEvent.Register<Item> event) {
		ElementRegister.registitem(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

	}
}
