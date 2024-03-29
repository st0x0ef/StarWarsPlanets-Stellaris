package fr.tathan.swplanets.client;

import earth.terrarium.adastra.client.ClientPlatformUtils;
import earth.terrarium.adastra.client.renderers.entities.mobs.PygroBruteRenderer;
import earth.terrarium.adastra.client.renderers.entities.mobs.PygroRenderer;
import earth.terrarium.adastra.common.registry.ModEntityTypes;
import earth.terrarium.botarium.client.ClientHooks;
import fr.tathan.swplanets.client.renderers.JawaModel;
import fr.tathan.swplanets.client.renderers.JawaRenderer;
import fr.tathan.swplanets.client.screens.BlasterUpgraderScreen;
import fr.tathan.swplanets.common.entities.JawaEntity;
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
    }
    public static void onRegisterEntityLayers(ClientPlatformUtils.LayerDefinitionRegistry consumer) {
        consumer.register(JawaModel.LAYER_LOCATION, JawaModel::createBodyLayer);
    }

}
