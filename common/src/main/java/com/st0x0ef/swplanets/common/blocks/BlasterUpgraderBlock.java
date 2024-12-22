package com.st0x0ef.swplanets.common.blocks;


import com.mojang.serialization.MapCodec;
import com.st0x0ef.stellaris.common.blocks.machines.BaseMachineBlock;
import com.st0x0ef.swplanets.common.registry.BlockEntitiesRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BlasterUpgraderBlock extends BaseMachineBlock {

    public BlasterUpgraderBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return simpleCodec(BlasterUpgraderBlock::new);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntitiesRegistry.BLASTER_UPGRADER.get().create(pos, state);
    }

    @Override
    public BlockEntityType<?> getBlockEntityType() {
        return BlockEntitiesRegistry.BLASTER_UPGRADER.get();
    }

    @Override
    public boolean hasTicker(Level level) {
        return !level.isClientSide();
    }
}
