package fr.tathan.swplanets.common.registry;

import fr.tathan.swplanets.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ClipContext;
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

    public static void init() {
    }

    static {
        STARWARS_PLANETS = TagKey.create(Registries.BIOME, new ResourceLocation(Constants.MODID, "starwars_planets"));
        TATOOINE_LIKE = TagKey.create(Registries.BIOME, new ResourceLocation(Constants.MODID, "tatooine_like"));
        MANDALORE_BIOME = TagKey.create(Registries.BIOME, new ResourceLocation(Constants.MODID, "mandalore_biomes"));

        CUSTOM_BLOB_CAN_SPAWN = TagKey.create(Registries.BLOCK, new ResourceLocation(Constants.MODID, "custom_blob_can_spawn"));

        BLASTERS = TagKey.create(Registries.ITEM, new ResourceLocation(Constants.MODID, "blasters"));
        BLASTER_UPGRADES = TagKey.create(Registries.ITEM, new ResourceLocation(Constants.MODID, "blaster_upgrades"));
        LIGHT_SABERS = TagKey.create(Registries.ITEM, new ResourceLocation(Constants.MODID, "light_sabers"));
        JAWAS_TRADES = TagKey.create(Registries.ITEM, new ResourceLocation(Constants.MODID, "jawas_trades"));
    }


}
