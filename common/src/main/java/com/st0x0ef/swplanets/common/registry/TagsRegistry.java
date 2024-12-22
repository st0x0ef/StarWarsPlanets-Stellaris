package com.st0x0ef.swplanets.common.registry;

import com.st0x0ef.swplanets.SWPlanets;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class TagsRegistry {

    public static final TagKey<Biome> STARWARS_PLANETS;
    public static final TagKey<Biome> TATOOINE_LIKE;
    public static final TagKey<Biome> MANDALORE_BIOME;

    public static final TagKey<Block> CUSTOM_BLOB_CAN_SPAWN;


    public static final TagKey<Item> BLASTERS;
    public static final TagKey<Item> BLASTER_UPGRADES;
    public static final TagKey<Item> LIGHT_SABERS;
    public static final TagKey<Item> JAWAS_TRADES;

    static {
        STARWARS_PLANETS = TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "starwars_planets"));
        TATOOINE_LIKE = TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "tatooine_like"));
        MANDALORE_BIOME = TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "mandalore_biomes"));

        CUSTOM_BLOB_CAN_SPAWN = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "custom_blob_can_spawn"));

        BLASTERS = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "blasters"));
        BLASTER_UPGRADES = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "blaster_upgrades"));
        LIGHT_SABERS = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "light_sabers"));
        JAWAS_TRADES = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "jawas_trades"));
    }


}
