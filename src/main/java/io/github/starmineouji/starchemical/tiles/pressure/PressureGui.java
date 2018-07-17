package io.github.starmineouji.starchemical.tiles.pressure;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.Locale;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class PressureGui extends GuiContainer {

	private PressureTileEntity tileEntity;
	private static final ResourceLocation GUITEXTURE = new ResourceLocation("starchemical", "textures/gui/container/pressure.png");

	public PressureGui(EntityPlayer player, PressureTileEntity tileEntity) {
		super(new PressureContainer(player, tileEntity));
		this.tileEntity = tileEntity;
		ySize = 222;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
	Locale l = new Locale();
	fontRenderer.drawString(l.formatMessage(tileEntity.getName(), null), 8, 6, 4210752);
	fontRenderer.drawString(l.formatMessage("container.inventory", null), 8, ySize - 150, 4210752);
	}
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
	//GL11.glColor4f(0x00, 0x00, 0x00, 0xff);
	mc.getTextureManager().bindTexture(GUITEXTURE);
	int k = (width - xSize) / 2;
	int l = (height - ySize) / 2;
	this.drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
	}

}
