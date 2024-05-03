package fr.tathan.swplanets;

import earth.terrarium.adastra.AdAstra;
import earth.terrarium.adastra.common.registry.ModEntityTypes;
import earth.terrarium.adastra.common.registry.ModItems;
import fr.tathan.swplanets.common.config.CommonConfig;
import fr.tathan.swplanets.common.registry.*;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.item.Item;

import java.util.Map;

public class CommonClass {

    public static void init() {

        Constants.CONFIGURATOR.register(CommonConfig.class);

        // TabsRegistry.init();
        BlocksRegistry.BLOCKS.init();
        TagsRegistry.init();
        ArmorMaterialRegistry.init();
        ItemsRegistry.ITEMS.init();
        SoundsRegistry.SOUNDS.init();
        EntityRegistry.ENTITY_TYPES.init();
        BlockEntitiesRegistry.BLOCK_ENTITY_TYPES.init();
        MenusRegistry.MENUS.init();
        TabsRegistry.init();
        LevelRegistry.init();
        TabsRegistry.CREATIVE_MODE_TABS.init();
        Constants.LOG.info("Hello There !");

    }

    public static void postInit() {
        Map<Item, CauldronInteraction> map = CauldronInteraction.WATER.map();
        map.put(ItemsRegistry.STORMTROOPER_BOOTS.get(), CauldronInteraction.DYED_ITEM);
        map.put(ItemsRegistry.STORMTROOPER_CHESTPLATE.get(), CauldronInteraction.DYED_ITEM);
        map.put(ItemsRegistry.STORMTROOPER_LEGGINGS.get(), CauldronInteraction.DYED_ITEM);
        map.put(ItemsRegistry.STORMTROOPER_MASK.get(), CauldronInteraction.DYED_ITEM);
    }
}