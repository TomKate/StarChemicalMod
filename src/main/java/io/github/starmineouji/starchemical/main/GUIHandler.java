package io.github.starmineouji.starchemical.main;

import io.github.starmineouji.starchemical.tiles.pressure.PressureContainer;
import io.github.starmineouji.starchemical.tiles.pressure.PressureGui;
import io.github.starmineouji.starchemical.tiles.pressure.PressureTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		if (te instanceof PressureTileEntity || ID == 1)
			return new PressureContainer(player, (PressureTileEntity) te);
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		if (te instanceof PressureTileEntity || ID == 1)
			return new PressureGui(player, (PressureTileEntity) te);
		return null;
	}

}
