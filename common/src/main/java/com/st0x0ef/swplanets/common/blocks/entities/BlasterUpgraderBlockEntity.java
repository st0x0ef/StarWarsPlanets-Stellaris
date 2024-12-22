package com.st0x0ef.swplanets.common.blocks.entities;

import com.st0x0ef.stellaris.common.blocks.entities.machines.BaseEnergyContainerBlockEntity;
import com.st0x0ef.swplanets.SWPlanets;
import com.st0x0ef.swplanets.common.items.Blaster;
import com.st0x0ef.swplanets.common.items.BlasterUpgrade;
import com.st0x0ef.swplanets.common.menu.BlasterUpgraderMenu;
import com.st0x0ef.swplanets.common.registry.BlockEntitiesRegistry;
import com.st0x0ef.swplanets.common.registry.TagsRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class BlasterUpgraderBlockEntity extends BaseEnergyContainerBlockEntity {
    private static final int[] INPUT_SLOTS = {0, 1};
    public BlasterUpgraderBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntitiesRegistry.BLASTER_UPGRADER.get(), pos, state);
    }


    @Override
    protected Component getDefaultName() {
        return Component.literal("Blaster Upgrader");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory) {
        return new BlasterUpgraderMenu( i, inventory, this);
    }

    private boolean hasRecipe() {
        boolean hasBlasterInFirstSlot = getItem(0).is(TagsRegistry.BLASTERS);
        boolean hasUpgradeInSecondSlot = getItem(1).getItem() instanceof BlasterUpgrade;
        return hasBlasterInFirstSlot && hasUpgradeInSecondSlot;
    }

    private void craft(){
        ItemStack upgrade_input = getItem(1);
        ItemStack vehicle_input = getItem(0);

        if (!upgrade_input.isEmpty() && !vehicle_input.isEmpty()) {
            if (upgrade_input.getItem() instanceof BlasterUpgrade upgrade) {
                SWPlanets.LOG.error("Upgrade " + upgrade.getZoom());
                ItemStack output = vehicle_input.copy();

                if (output.getItem() instanceof Blaster blaster) {
                    blaster.setUpgrade(upgrade, output);
                }

                output.setCount(1);
                SWPlanets.LOG.error("Crafting Blaster");
                removeItem(0, 1);
                removeItem(1, 1);
                setItem(2, output);
            }
        }

    }

    @Override
    public int getMaxCapacity() {
        return 3000;
    }

    @Override
    public void tick() {
        if(level.isClientSide()) {
            return;
        }

        if(hasRecipe()) {
            craft();
        } else {
            setChanged(level, worldPosition, getBlockState());
        }
    }
}
