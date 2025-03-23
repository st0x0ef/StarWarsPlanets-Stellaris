package com.st0x0ef.swplanets.common.menu;


import com.st0x0ef.stellaris.common.menus.BaseContainer;
import com.st0x0ef.stellaris.common.menus.slot.ResultSlot;
import com.st0x0ef.swplanets.common.registry.MenusRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;

public class BlasterUpgraderMenu extends BaseContainer {
    private final Container container;

    public BlasterUpgraderMenu(int id, Inventory inventory, FriendlyByteBuf buf) {
        this(id, inventory, new SimpleContainer(3));
    }
    public BlasterUpgraderMenu(int id, Inventory inventory, Container container) {
        super(MenusRegistry.BLASTER_UPGRADER_MENU.get(), id, 3, inventory, 11, 119);

        this.container = container;

        addSlots();
    }

    protected void addSlots() {
        addSlot(new Slot(container, 0, 33, 59));
        addSlot(new Slot(container, 1, 81, 59));
        addSlot(new ResultSlot(container, 2, 136, 59));
    }

    @Override
    public boolean stillValid(Player player) {
        return this.container.stillValid(player);
    }
}
