package fr.tathan.swplanets.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.adastra.AdAstra;
import earth.terrarium.adastra.common.world.features.InfernalSpireColumnFeature;
import earth.terrarium.adastra.common.world.features.MarsBlockBlobFeature;
import fr.tathan.swplanets.Constants;
import fr.tathan.swplanets.common.blocks.BlasterUpgraderBlock;
import fr.tathan.swplanets.common.world.features.CustomSpireColumn;
import fr.tathan.swplanets.common.world.features.CustomSpireColumnConfig;
import fr.tathan.swplanets.common.world.features.TatooineStoneFeature;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ColumnFeatureConfiguration;
import net.minecraft.world.level.material.MapColor;

public class FeatureRegistry {

    public static final ResourcefulRegistry<Feature<?>> FEATURES = ResourcefulRegistries.create(BuiltInRegistries.FEATURE, Constants.MODID);

    public static final RegistryEntry<Feature<CustomSpireColumnConfig>> CUSTOM_SPIRE_COLUMN = FEATURES.register("custom_spire_column", () -> new CustomSpireColumn(CustomSpireColumnConfig.CODEC));

    public static final RegistryEntry<Feature<BlockStateConfiguration>> TATOOINE_STONE_FEATURE = FEATURES.register("tatooine_rocks", () -> new TatooineStoneFeature(BlockStateConfiguration.CODEC));
}
