package com.st0x0ef.swplanets.client;


import com.st0x0ef.swplanets.client.renderers.bantha.BanthaModel;
import com.st0x0ef.swplanets.client.renderers.bantha.BanthaRenderer;
import com.st0x0ef.swplanets.client.renderers.jawa.JawaModel;
import com.st0x0ef.swplanets.client.renderers.jawa.JawaRenderer;
import com.st0x0ef.swplanets.client.screens.BlasterUpgraderScreen;
import com.st0x0ef.swplanets.common.registry.EntityRegistry;
import com.st0x0ef.swplanets.common.registry.MenusRegistry;
import net.minecraft.client.gui.screens.MenuScreens;

public class SWPlanetsClient {

    public static void init() {
        registerScreens();
        registerRenderers();
    }

    private static void registerScreens() {
        MenuScreens.register(MenusRegistry.BLASTER_UPGRADER.get(), BlasterUpgraderScreen::new);
    }

    private static void registerRenderers() {
        ClientHooks.registerEntityRenderer(EntityRegistry.JAWA, JawaRenderer::new);
        ClientHooks.registerEntityRenderer(EntityRegistry.BANTHA, BanthaRenderer::new);

    }
    public static void onRegisterEntityLayers(ClientPlatformUtils.LayerDefinitionRegistry consumer) {
        consumer.register(JawaModel.LAYER_LOCATION, JawaModel::createBodyLayer);
        consumer.register(BanthaModel.LAYER_LOCATION, BanthaModel::createBodyLayer);

    }

}
