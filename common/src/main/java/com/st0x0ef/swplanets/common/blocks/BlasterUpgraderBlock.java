package com.st0x0ef.swplanets.common.blocks;


import com.mojang.serialization.MapCodec;
import com.st0x0ef.stellaris.common.blocks.machines.BaseMachineBlock;
import com.st0x0ef.swplanets.common.blocks.entities.BlasterUpgraderBlockEntity;
import com.st0x0ef.swplanets.common.menu.BlasterUpgraderMenu;
import com.st0x0ef.swplanets.common.registry.BlockEntitiesRegistry;
import io.netty.buffer.Unpooled;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

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
