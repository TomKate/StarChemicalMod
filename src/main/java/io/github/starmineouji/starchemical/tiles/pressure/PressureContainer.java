package io.github.starmineouji.starchemical.tiles.pressure;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class PressureContainer extends Container {
	private static final int THIS_SLOT_FIRST = 0;
	private static final int PLAYER_INVENTORY_START = 2;
	private static final int PLAYER_QUICKINVENTORY_START = 29;
	private static final int TOTAL = 37;
	private PressureTileEntity tile;
public PressureContainer(EntityPlayer player, PressureTileEntity tileEntity) {
	// TODO Auto-generated constructor stub
	tile = tileEntity;
	tileEntity.openInventory(player);
	for (int x = 0; x < 1; x++) {
	this.addSlotToContainer(new Slot(tile, x + x , 8 + (x * 18), 0));
	}
	for (int y = 0; y < 3; y++) {
	for (int x = 0; x < 9; x++) {
	this.addSlotToContainer(new Slot(player.inventory, x + (y * 9) + 9, 8 + (x * 18), 140 + (y * 18)));
	}
	}
	for (int x = 0; x < 9; x++) {
	this.addSlotToContainer(new Slot(player.inventory, x, 8 + (x * 18), 198));
	}
}
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return tile.isUsableByPlayer(playerIn);
	}
	

}
