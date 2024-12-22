package com.st0x0ef.swplanets.common.blocks.entities;

import com.st0x0ef.stellaris.common.blocks.entities.machines.BaseEnergyBlockEntity;
import com.st0x0ef.swplanets.SWPlanets;
import com.st0x0ef.swplanets.common.items.BlasterUpgrade;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BlasterUpgraderEntity extends BaseEnergyBlockEntity {
    public static final List<ConfigurationEntry> SIDE_CONFIG = List.of(
        new ConfigurationEntry(ConfigurationType.SLOT, Configuration.NONE, ConstantComponents.SIDE_CONFIG_INPUT_SLOTS)
    );
    private static final int[] INPUT_SLOTS = {0, 1};
    public BlasterUpgraderEntity(BlockPos pos, BlockState state) {
        super(pos, state, 3);
        this.setRedstoneControl(RedstoneControl.NEVER_ON);
    }

    @Override
    public List<ConfigurationEntry> getDefaultConfig() {
        return SIDE_CONFIG;
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        return INPUT_SLOTS;
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
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
            setChanged(level, pos, state);
        }
    }
}
