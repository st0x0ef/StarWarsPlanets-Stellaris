package fr.tathan.swplanets.common.world.features;

import com.mojang.serialization.Codec;
import earth.terrarium.adastra.common.registry.ModBlocks;
import earth.terrarium.adastra.common.registry.ModFeatures;
import fr.tathan.swplanets.common.registry.TagsRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.data.worldgen.features.MiscOverworldFeatures;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;

/**
 * Custom Blob to let blob spawn on wanted blocks
 * From the MarsBlockBlockFeature from Ad Astra
 */
public class TatooineStoneFeature extends Feature<BlockStateConfiguration> {

    public TatooineStoneFeature(Codec<BlockStateConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<BlockStateConfiguration> context) {
        BlockPos blockPos = context.origin();
        WorldGenLevel worldGenLevel = context.level();
        RandomSource randomSource = context.random();

        BlockStateConfiguration blockStateConfiguration;
        for (blockStateConfiguration = context.config(); blockPos.getY() > worldGenLevel.getMinBuildHeight() + 3; blockPos = blockPos.below()) {
            if (!worldGenLevel.isEmptyBlock(blockPos.below())) {
                BlockState state = worldGenLevel.getBlockState(blockPos.below());
                if (state.is(TagsRegistry.CUSTOM_BLOB_CAN_SPAWN)) break;
            }
        }

        if (blockPos.getY() <= worldGenLevel.getMinBuildHeight() + 3) {
            return false;
        } else {
            for (int i = 0; i < 3; ++i) {
                int j = randomSource.nextInt(2);
                int k = randomSource.nextInt(2);
                int l = randomSource.nextInt(2);
                float f = (float) (j + k + l) * 0.333F + 0.5F;

                for (BlockPos blockPos2 : BlockPos.betweenClosed(blockPos.offset(-j, -k, -l), blockPos.offset(j, k, l))) {
                    if (blockPos2.distSqr(blockPos) <= (double) (f * f)) {
                        worldGenLevel.setBlock(blockPos2, blockStateConfiguration.state, 3);
                    }
                }

                blockPos = blockPos.offset(-1 + randomSource.nextInt(2), -randomSource.nextInt(2), -1 + randomSource.nextInt(2));
            }

            return true;
        }
    }

}

