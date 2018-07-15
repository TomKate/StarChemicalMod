package io.github.starmineouji.starchemical.main;

import ic2.api.item.IC2Items;
import net.minecraftforge.fml.common.Loader;

public class Bridge {
public static class NotLoadedException extends Exception{

	public NotLoadedException(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}
	
}
public static void SupportIC2() throws NotLoadedException{
	if (Loader.isModLoaded("ic2")) throw new NotLoadedException("IndustrialCraft2-experimental");
	IC2Items.getItem("");
}
public static void SupportMinecraftAndForge() {
	
}
}