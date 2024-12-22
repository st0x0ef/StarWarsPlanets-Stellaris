package com.st0x0ef.swplanets;

import com.st0x0ef.swplanets.client.renderers.bantha.BanthaModel;
import com.st0x0ef.swplanets.client.renderers.bantha.BanthaRenderer;
import com.st0x0ef.swplanets.client.renderers.jawa.JawaModel;
import com.st0x0ef.swplanets.client.renderers.jawa.JawaRenderer;
import com.st0x0ef.swplanets.client.screens.BlasterUpgraderScreen;
import com.st0x0ef.swplanets.common.registry.EntityRegistry;
import com.st0x0ef.swplanets.common.registry.ItemsRegistry;
import com.st0x0ef.swplanets.common.registry.MenusRegistry;
import dev.architectury.registry.menu.MenuRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;

public class FabricSWPlanetsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(EntityRegistry.LASER.get(), (p_174060_) -> new ThrownItemRenderer<>(p_174060_, 0.75F, true));

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xFFFFFF, ItemsRegistry.STORMTROOPER_MASK.get(), ItemsRegistry.STORMTROOPER_CHESTPLATE.get(), ItemsRegistry.STORMTROOPER_LEGGINGS.get(), ItemsRegistry.STORMTROOPER_LEGGINGS.get());
        FabricLoader.getInstance().getModContainer(SWPlanets.MODID).ifPresent(modContainer -> ResourceManagerHelper.registerBuiltinResourcePack(ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "old_lightsabers_models"), modContainer, ResourcePackActivationType.NORMAL));

        // GUI
        MenuRegistry.registerScreenFactory(MenusRegistry.BLASTER_UPGRADER_MENU.get(), BlasterUpgraderScreen::new);

        // Entities rendering
        EntityRendererRegistry.register(EntityRegistry.JAWA.get(), JawaRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.BANTHA.get(), BanthaRenderer::new);

        // Entities model layer
        EntityModelLayerRegistry.registerModelLayer(JawaModel.LAYER_LOCATION, JawaModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(BanthaModel.LAYER_LOCATION, BanthaModel::createBodyLayer);
    }
}
