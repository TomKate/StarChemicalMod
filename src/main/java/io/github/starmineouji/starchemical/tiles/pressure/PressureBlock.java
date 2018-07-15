package io.github.starmineouji.starchemical.tiles.pressure;

import io.github.starmineouji.starchemical.main.StarChemicalMod;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PressureBlock extends Block implements ITileEntityProvider {

	public PressureBlock() {
		super(Material.IRON);
		// TODO Auto-generated constructor stub
	}
@Override
public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
	// TODO Auto-generated method stub
	PressureTileEntity te = (PressureTileEntity)worldIn.getTileEntity(pos);
	ItemStack stackInSlot = te.getStackInSlot(1);
	super.breakBlock(worldIn, pos, state);
}
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new PressureTileEntity();
	}
@Override
public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
		EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
	// TODO Auto-generated method stub
	playerIn.openGui(StarChemicalMod.instance, 1, worldIn, (int)hitX, (int)hitY, (int)hitZ);
	return true;
}
}
