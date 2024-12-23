package com.st0x0ef.swplanets.client.screens;


import com.mojang.blaze3d.systems.RenderSystem;
import com.st0x0ef.swplanets.SWPlanets;
import com.st0x0ef.swplanets.common.menu.BlasterUpgraderMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BlasterUpgraderScreen extends AbstractContainerScreen<BlasterUpgraderMenu> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "textures/gui/blaster_upgrader.png");

    public BlasterUpgraderScreen(BlasterUpgraderMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
        this.imageWidth = 184;
        this.imageHeight = 201;
        this.inventoryLabelY = this.imageHeight - 92;
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(graphics, mouseX, mouseY, partialTicks);
        super.render(graphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(graphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float f, int i, int j) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        guiGraphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
    }
}
