package com.st0x0ef.swplanets.forge;

import com.st0x0ef.swplanets.client.renderers.bantha.BanthaModel;
import com.st0x0ef.swplanets.client.renderers.bantha.BanthaRenderer;
import com.st0x0ef.swplanets.client.renderers.jawa.JawaModel;
import com.st0x0ef.swplanets.client.renderers.jawa.JawaRenderer;
import com.st0x0ef.swplanets.client.screens.BlasterUpgraderScreen;
import com.st0x0ef.swplanets.common.registry.EntityRegistry;
import com.st0x0ef.swplanets.common.registry.MenusRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class NeoForgeSWPlanetsClient {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityRegistry.JAWA.get(), JawaRenderer::new);
        event.registerEntityRenderer(EntityRegistry.BANTHA.get(), BanthaRenderer::new);
    }

    @SubscribeEvent
    public static void registerEntityLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(JawaModel.LAYER_LOCATION, JawaModel::createBodyLayer);
        event.registerLayerDefinition(BanthaModel.LAYER_LOCATION, BanthaModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerScreen(RegisterMenuScreensEvent event) {
        event.register(MenusRegistry.BLASTER_UPGRADER_MENU.get(), BlasterUpgraderScreen::new);
    }
}
