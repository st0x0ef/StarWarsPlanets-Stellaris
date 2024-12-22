package com.st0x0ef.swplanets.common.menu;


import com.st0x0ef.swplanets.common.blocks.entities.BlasterUpgraderBlockEntity;
import com.st0x0ef.swplanets.common.registry.MenusRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class BlasterUpgraderMenu extends AbstractContainerMenu {
    public BlasterUpgraderMenu( int id, Inventory inventory, FriendlyByteBuf buf) {
        this(id);
    }
    public BlasterUpgraderMenu(int id) {

        super(MenusRegistry.BLASTER_UPGRADER_MENU.get(), id);
    }

    @Override
    protected int getContainerInputEnd() {
        return 2;
    }

    @Override
    protected int getInventoryStart() {
        return 0;
    }
    @Override
    protected int startIndex() {
        return 0;
    }

    @Override
    public int getPlayerInvXOffset() {
        return 12;
    }


    @Override
    public int getPlayerInvYOffset() {
        return 115;
    }

    @Override
    protected void addMenuSlots() {
        addSlot(new Slot(entity, 0, 33, 59));
        addSlot(new Slot(entity, 1, 81, 59));
        addSlot(CustomSlot.noPlace(entity, 2, 136, 59));
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return false;
    }
}
