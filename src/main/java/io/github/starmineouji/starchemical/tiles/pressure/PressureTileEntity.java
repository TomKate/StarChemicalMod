package io.github.starmineouji.starchemical.tiles.pressure;

import io.github.starmineouji.starchemical.main.StarChemicalMod;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class PressureTileEntity extends TileEntity implements IInventory {
	private ItemStack I = new ItemStack(Block.getBlockFromName("air")),
			O = new ItemStack(Block.getBlockFromName("air"));
	private boolean IsIEmptuy, IsOEmpty, AreTheyEmpty;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "starchemical.pressure.name";
	}

	@Override
	public boolean hasCustomName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return AreTheyEmpty;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		if (index >= 2)
			throw new ArrayIndexOutOfBoundsException(index);
		return index == 1 ? O : I;
	}

    	@Override
    	public ItemStack decrStackSize(int index, int count) {
        	if (index >= 2) {
            		throw new ArrayIndexOutOfBoundsException(index);
       		}
        	return index == 1 ? ItemStackHelper.getAndSplit(Lists.newArrayList(O), index, count) :
                	ItemStackHelper.getAndSplit(Lists.newArrayList(I), index, count);
    }

	@Override
	public void deserializeNBT(NBTTagCompound nbt) {
		// TODO Auto-generated method stub
		NBTTagCompound in = nbt.getCompoundTag("in");
		I = new ItemStack(Item.getByNameOrId(in.getString("itemid")), in.getInteger("count"));
		I.deserializeNBT(in.getCompoundTag("nbt"));
		NBTTagCompound out = nbt.getCompoundTag("out");
		O = new ItemStack(Item.getByNameOrId(out.getString("itemid")), out.getInteger("count"));
		O.deserializeNBT(out.getCompoundTag("nbt"));
	}
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		// TODO Auto-generated method stub
		NBTTagCompound in = nbt.getCompoundTag("in");
		I = new ItemStack(Item.getByNameOrId(in.getString("itemid")), in.getInteger("count"));
		I.deserializeNBT(in.getCompoundTag("nbt"));
		NBTTagCompound out = nbt.getCompoundTag("out");
		O = new ItemStack(Item.getByNameOrId(out.getString("itemid")), out.getInteger("count"));
		O.deserializeNBT(out.getCompoundTag("nbt"));
	}
	@Override
	public NBTTagCompound serializeNBT() {
		// TODO Auto-generated method stub
		NBTTagCompound nbt = new NBTTagCompound();
		NBTTagCompound nbtIn = new NBTTagCompound();
		ResourceLocation InR = I.getItem().getRegistryName();
		nbtIn.setString("itemid", InR.getResourceDomain() + ":" + InR.getResourcePath());
		nbtIn.setInteger("count", I.getCount());
		nbtIn.setTag("nbt", I.serializeNBT());
		nbt.setTag("in", nbtIn);
		NBTTagCompound nbtOut = new NBTTagCompound();
		ResourceLocation OutR = I.getItem().getRegistryName();
		nbtOut.setString("itemid", OutR.getResourceDomain() + ":" + OutR.getResourcePath());
		nbtOut.setInteger("count", O.getCount());
		nbtOut.setTag("nbt", O.serializeNBT());
		nbt.setTag("out", nbtOut);
		return nbt;
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		// TODO Auto-generated method stub
		NBTTagCompound nbtIn = new NBTTagCompound();
		ResourceLocation InR = I.getItem().getRegistryName();
		nbtIn.setString("itemid", InR.getResourceDomain() + ":" + InR.getResourcePath());
		nbtIn.setInteger("count", I.getCount());
		nbtIn.setTag("nbt", I.writeToNBT(new NBTTagCompound()));
		nbt.setTag("In", nbtIn);
		NBTTagCompound nbtOut = new NBTTagCompound();
		ResourceLocation OutR = I.getItem().getRegistryName();
		nbtOut.setString("itemid", OutR.getResourceDomain() + ":" + OutR.getResourcePath());
		nbtOut.setInteger("count", O.getCount());
		nbtOut.setTag("nbt", O.writeToNBT(new NBTTagCompound()));
		nbt.setTag("out", nbtOut);
		return nbt;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		if (index >= 2)
			throw new ArrayIndexOutOfBoundsException(index);
		return index == 1 ? O = new ItemStack(Block.getBlockFromName("air"))
				: (I = new ItemStack(Block.getBlockFromName("air")));
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		if (index >= 3)
			throw new ArrayIndexOutOfBoundsException(index);
		if (index == 0)
			I = stack;
		if (index == 1)
			O = stack;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 45;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void openInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		I = new ItemStack(Block.getBlockFromName("air"));
		O = new ItemStack(Block.getBlockFromName("air"));
	}
}
