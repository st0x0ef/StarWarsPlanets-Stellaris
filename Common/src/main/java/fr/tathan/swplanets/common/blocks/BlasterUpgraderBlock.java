package fr.tathan.swplanets.common.blocks;

import earth.terrarium.adastra.common.blockentities.base.ContainerMachineBlockEntity;
import earth.terrarium.adastra.common.blockentities.base.RedstoneControl;
import earth.terrarium.adastra.common.blockentities.base.sideconfig.Configuration;
import earth.terrarium.adastra.common.blockentities.base.sideconfig.ConfigurationEntry;
import earth.terrarium.adastra.common.blockentities.base.sideconfig.ConfigurationType;
import earth.terrarium.adastra.common.blocks.base.MachineBlock;
import earth.terrarium.adastra.common.constants.ConstantComponents;
import earth.terrarium.adastra.common.utils.TransferUtils;
import earth.terrarium.botarium.common.menu.ExtraDataMenuProvider;
import earth.terrarium.botarium.common.menu.MenuHooks;
import fr.tathan.swplanets.Constants;
import fr.tathan.swplanets.common.blocks.entities.BlasterUpgraderEntity;
import fr.tathan.swplanets.common.items.Blaster;
import fr.tathan.swplanets.common.items.BlasterUpgrade;
import fr.tathan.swplanets.common.menu.BlasterUpgraderMenu;
import fr.tathan.swplanets.common.registry.BlockEntitiesRegistry;
import fr.tathan.swplanets.common.registry.TagsRegistry;
import io.netty.buffer.Unpooled;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Predicate;

public class BlasterUpgraderBlock extends MachineBlock {

    public BlasterUpgraderBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide()) {
            MenuHooks.openMenu((ServerPlayer)player, menuProvider( level, pos));
        }
        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return entity(state).create(pos, state);
    }

    public BlockEntityType<?> entity(BlockState state) {
        return BlockEntitiesRegistry.BLASTER_UPGRADER.get();
    }

    public ExtraDataMenuProvider menuProvider(Level level, BlockPos blockPos) {
        return new ExtraDataMenuProvider() {
            @Override
            public Component getDisplayName() {
                return Component.literal("Blaster Upgrader");
            }

            @Override
            public void writeExtraData(ServerPlayer player, FriendlyByteBuf buffer) {
                buffer.writeBlockPos(blockPos);
            }

            @Override
            public AbstractContainerMenu createMenu(int id, Inventory playerInventory, Player player) {
                return new BlasterUpgraderMenu(id, playerInventory, (BlasterUpgraderEntity) level.getBlockEntity(blockPos));
            }

        };
    }

    @Nullable
    @Override
    public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return new ExtraDataMenuProvider() {
            @Override
            public Component getDisplayName() {
                return Component.literal("Blaster Upgrader");
            }

            @Override
            public void writeExtraData(ServerPlayer player, FriendlyByteBuf buffer) {
                buffer.writeBlockPos(pos);
            }

            @Override
            public AbstractContainerMenu createMenu(int id, Inventory playerInventory, Player player) {
                return new BlasterUpgraderMenu(id, playerInventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
            }

        };
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, BlockEntitiesRegistry.BLASTER_UPGRADER.get(),
                (level1, blockPos, blockState, blockEntity) -> {
                   blockEntity.tick(level1, level1.getGameTime(), blockState, blockPos);

                });
    }
}
