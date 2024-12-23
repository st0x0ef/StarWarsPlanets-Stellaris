package com.st0x0ef.swplanets.common.menu;


import com.st0x0ef.stellaris.common.menus.slot.ResultSlot;
import com.st0x0ef.swplanets.common.registry.MenusRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class BlasterUpgraderMenu extends AbstractContainerMenu {
    private final Inventory inventory;

    public BlasterUpgraderMenu(int id, Inventory inventory, FriendlyByteBuf buf) {
        this(id, inventory, new SimpleContainer(3));
    }
    public BlasterUpgraderMenu(int id, Inventory inventory, Container container) {

        super(MenusRegistry.BLASTER_UPGRADER_MENU.get(), id);

        this.inventory = inventory;

        addSlots();

        checkContainerSize(this.inventory, 3);

        addPlayerHotbar(inventory);
        addPlayerInventory(inventory);
    }

    protected void addSlots() {
        addSlot(new Slot(inventory, 0, 33, 59));
        addSlot(new Slot(inventory, 1, 81, 59));
        addSlot(new ResultSlot(inventory, 2, 136, 59));
    }

    @Override
    public ItemStack quickMoveStack(Player player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot.hasItem()) {
            ItemStack originalStack = slot.getItem();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.getContainerSize()) {
                if (!this.moveItemStackTo(originalStack, this.inventory.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(originalStack, 0, this.inventory.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return newStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return this.inventory.stillValid(player);
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, (84 + i * 18) + 58));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 200));
        }
    }
}
