package com.st0x0ef.swplanets.common.world.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class CustomSpireColumnConfig implements FeatureConfiguration {

    public static final Codec<CustomSpireColumnConfig> CODEC = RecordCodecBuilder.create((instance) -> instance.group(IntProvider.codec(0, 3).fieldOf("reach").forGetter((columnFeatureConfiguration) -> columnFeatureConfiguration.reach), IntProvider.codec(1, 10).fieldOf("height").forGetter((columnFeatureConfiguration) -> columnFeatureConfiguration.height), BlockState.CODEC.fieldOf("block").forGetter((columnFeatureConfiguration) -> columnFeatureConfiguration.block)).apply(instance, CustomSpireColumnConfig::new));
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
