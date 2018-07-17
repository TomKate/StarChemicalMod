package io.github.starmineouji.starchemical.tiles.pressure;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

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
		this.addSlotToContainer(new Slot(tile, 0, 55, 35));
		this.addSlotToContainer(new Slot(tile, 1, 116, 35));
		// this.addSlotToContainer(new Slot(player.inventory, 2 ,9, 85));
		int i = 1;
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				this.addSlotToContainer(new Slot(player.inventory, i + 8, 8 + (x * 18), 84 + (y * 18)));
				i++;
			}
		}
		for (int x = 0; x < 9; x++) {
			int j = x * 18;
			System.out.println(j);
			this.addSlotToContainer(new Slot(player.inventory, x, 8 + j, 142));
		}
		this.addSlotToContainer(new Slot(player.inventory, 106, 8 + 160, 142));
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return tile.isUsableByPlayer(playerIn);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotNumber) {
		ItemStack itemStack = null;
		Slot slot = (Slot) inventorySlots.get(slotNumber);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemStack1 = slot.getStack();
			itemStack = itemStack1.copy();
			if (THIS_SLOT_FIRST <= slotNumber && slotNumber < PLAYER_INVENTORY_START) {
				//圧縮機のインベントリならプレイヤーのインベントリに移動
				if (!this.mergeItemStack(itemStack1, PLAYER_INVENTORY_START, TOTAL, true)) {
					return null;
				}
			} else {
				if (PLAYER_INVENTORY_START <= slotNumber && slotNumber < PLAYER_QUICKINVENTORY_START) {
					//プレイヤーのインベントリならクイックスロットに移動。
					if (!this.mergeItemStack(itemStack1, PLAYER_QUICKINVENTORY_START, TOTAL, false)) {
						return null;
					}
				} else if (PLAYER_QUICKINVENTORY_START <= slotNumber && slotNumber < TOTAL && !this
						.mergeItemStack(itemStack1, PLAYER_INVENTORY_START, PLAYER_QUICKINVENTORY_START, false)) {
					return null;
				}
			}
			if (itemStack1.getCount() == 0) {
			} else {
				slot.onSlotChanged();
			}
			if (itemStack1.getCount() == itemStack.getCount()) {
				return null;
			}
			slot.onTake(player, itemStack1);
		}
		return itemStack;
	}
}
