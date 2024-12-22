package com.st0x0ef.swplanets.common.registry;


import com.st0x0ef.swplanets.SWPlanets;
import com.st0x0ef.swplanets.common.world.features.CustomSpireColumn;
import com.st0x0ef.swplanets.common.world.features.CustomSpireColumnConfig;
import com.st0x0ef.swplanets.common.world.features.TatooineStoneFeature;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;

public class FeatureRegistry {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(SWPlanets.MODID, Registries.FEATURE);

    public static final RegistrySupplier<Feature<CustomSpireColumnConfig>> CUSTOM_SPIRE_COLUMN = FEATURES.register("custom_spire_column", () -> new CustomSpireColumn(CustomSpireColumnConfig.CODEC));

    public static final RegistrySupplier<Feature<BlockStateConfiguration>> TATOOINE_STONE_FEATURE = FEATURES.register("tatooine_rocks", () -> new TatooineStoneFeature(BlockStateConfiguration.CODEC));
}
