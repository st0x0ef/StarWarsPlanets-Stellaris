package com.st0x0ef.swplanets.common.menu;

import com.st0x0ef.stellaris.common.menus.BaseItemCombinerMenu;
import com.st0x0ef.swplanets.common.data_components.BlasterUpgrades;
import com.st0x0ef.swplanets.common.items.Blaster;
import com.st0x0ef.swplanets.common.items.upgrades.BlasterUpgrade;
import com.st0x0ef.swplanets.common.registry.BlocksRegistry;
import com.st0x0ef.swplanets.common.registry.DataComponentRegistry;
import com.st0x0ef.swplanets.common.registry.MenusRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.ItemCombinerMenuSlotDefinition;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class BlasterUpgraderMenu extends BaseItemCombinerMenu  {

    public static BlasterUpgraderMenu create(int containerId, Inventory playerInventory, FriendlyByteBuf buf) {
        return new BlasterUpgraderMenu(containerId, playerInventory, ContainerLevelAccess.NULL);
    }

    public BlasterUpgraderMenu(int containerId, Inventory playerInventory, ContainerLevelAccess access) {
        super(MenusRegistry.BLASTER_UPGRADER_MENU.get(), containerId, playerInventory, access);
    }

    @Override
    protected boolean mayPickup(Player player, boolean hasStack) {
        return true;
    }

    @Override
    protected void onTake(Player player, ItemStack stack) {
        this.inputSlots.setItem(0, ItemStack.EMPTY);
        this.inputSlots.setItem(1, ItemStack.EMPTY);

    }

    @Override
    protected boolean isValidBlock(BlockState state) {
        return state.is(BlocksRegistry.BLASTER_UPGRADER.get());
    }

    @Override
    public void createResult() {
        if (this.player.level().isClientSide) {
            return;
        }

        ItemStack itemStack = this.inputSlots.getItem(0).copy();
        ItemStack upgrade = this.inputSlots.getItem(1);

        if (upgrade.getItem() instanceof BlasterUpgrade validModule) {
            if (!itemStack.isEmpty() &&
                    !upgrade.isEmpty() &&
                    !BlasterUpgrades.containsInModules(itemStack, upgrade) &&
                    BlasterUpgrades.containsAllInModules(itemStack, validModule.requires())) {

                BlasterUpgrades.Mutable mutable = new BlasterUpgrades.Mutable(itemStack.getOrDefault(DataComponentRegistry.BLASTER_COMPONENT.get(), BlasterUpgrades.empty()));
                itemStack.set(DataComponentRegistry.BLASTER_COMPONENT.get(), mutable.insert(upgrade).toImmutable());

                this.resultSlots.setItem(0, itemStack);
                this.broadcastChanges();

            }
            else {
                this.resultSlots.setItem(0, ItemStack.EMPTY);
            }
        }

    }

    @Override
    protected ItemCombinerMenuSlotDefinition createInputSlotDefinitions() {
        return ItemCombinerMenuSlotDefinition.create()
                .withSlot(0, 33, 59, itemStack -> itemStack.getItem() instanceof Blaster)
                .withSlot(1, 81, 59, itemStack -> itemStack.getItem() instanceof BlasterUpgrade)
                .withResultSlot(2, 136, 59)
                .build();
    }
}
