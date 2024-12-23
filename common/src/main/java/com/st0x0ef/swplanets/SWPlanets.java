package com.st0x0ef.swplanets;

import com.st0x0ef.swplanets.common.registry.*;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class SWPlanets {
    public static final String MODID = "swplanets";
    public static final String MOD_NAME = "Star Wars Planets";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static void init() {
        SoundsRegistry.SOUNDS.register();
        DataComponentRegistry.DATA_COMPONENT_TYPE.register();
        BlocksRegistry.BLOCKS.register();
        BlockEntitiesRegistry.BLOCK_ENTITY_TYPES.register();
        ItemsRegistry.ITEMS.register();
        ArmorMaterialRegistry.ARMOR_MATERIAL.register();
        TabsRegistry.CREATIVE_MODE_TABS.register();
        EntityRegistry.ENTITY_TYPES.register();
        MenusRegistry.MENU_TYPE.register();
        FeatureRegistry.FEATURES.register();
        EntityRegistry.registerSpawnPlacements();
    }

    public static void postInit() {
        Map<Item, CauldronInteraction> map = CauldronInteraction.WATER.map();
        map.put(ItemsRegistry.STORMTROOPER_BOOTS.get(), CauldronInteraction.DYED_ITEM);
        map.put(ItemsRegistry.STORMTROOPER_CHESTPLATE.get(), CauldronInteraction.DYED_ITEM);
        map.put(ItemsRegistry.STORMTROOPER_LEGGINGS.get(), CauldronInteraction.DYED_ITEM);
        map.put(ItemsRegistry.STORMTROOPER_MASK.get(), CauldronInteraction.DYED_ITEM);
    }
}