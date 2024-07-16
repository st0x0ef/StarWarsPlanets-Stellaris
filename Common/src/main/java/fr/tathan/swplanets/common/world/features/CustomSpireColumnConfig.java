package fr.tathan.swplanets.common.world.features;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import earth.terrarium.adastra.common.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.BasaltColumnsFeature;
import net.minecraft.world.level.levelgen.feature.DeltaFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.ColumnFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import org.jetbrains.annotations.Nullable;

public class CustomSpireColumnConfig implements FeatureConfiguration {

    public static final Codec<CustomSpireColumnConfig> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(IntProvider.codec(0, 3).fieldOf("reach").forGetter((columnFeatureConfiguration) -> {
            return columnFeatureConfiguration.reach;
        }), IntProvider.codec(1, 10).fieldOf("height").forGetter((columnFeatureConfiguration) -> {
            return columnFeatureConfiguration.height;
        }), BlockState.CODEC.fieldOf("block").forGetter((columnFeatureConfiguration) -> {
                    return columnFeatureConfiguration.block;
        })).apply(instance, CustomSpireColumnConfig::new);
    });
    private final IntProvider reach;
    private final IntProvider height;
    private final BlockState block;

    public CustomSpireColumnConfig(IntProvider reach, IntProvider height, BlockState block) {
        this.reach = reach;
        this.height = height;
        this.block = block;
    }

    public IntProvider reach() {
        return this.reach;
    }

    public IntProvider height() {
        return this.height;
    }

    public BlockState block() {
        return block;
    }
}
