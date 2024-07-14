package fr.tathan.swplanets.client;

import earth.terrarium.adastra.client.ClientPlatformUtils;
import earth.terrarium.botarium.client.ClientHooks;
import fr.tathan.swplanets.client.renderers.bantha.BanthaModel;
import fr.tathan.swplanets.client.renderers.bantha.BanthaRenderer;
import fr.tathan.swplanets.client.renderers.jawa.JawaModel;
import fr.tathan.swplanets.client.renderers.jawa.JawaRenderer;
import fr.tathan.swplanets.client.screens.BlasterUpgraderScreen;
import fr.tathan.swplanets.common.registry.EntityRegistry;
import fr.tathan.swplanets.common.registry.MenusRegistry;
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
