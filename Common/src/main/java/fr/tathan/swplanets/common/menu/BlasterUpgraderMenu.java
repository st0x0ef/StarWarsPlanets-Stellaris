package fr.tathan.swplanets.common.menu;

import earth.terrarium.adastra.common.menus.base.BaseContainerMenu;
import earth.terrarium.adastra.common.menus.machines.CompressorMenu;
import earth.terrarium.adastra.common.menus.slots.CustomSlot;
import fr.tathan.swplanets.common.blocks.entities.BlasterUpgraderEntity;
import fr.tathan.swplanets.common.registry.MenusRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;

public class BlasterUpgraderMenu extends BaseContainerMenu<BlasterUpgraderEntity> {
    public BlasterUpgraderMenu( int id, Inventory inventory, FriendlyByteBuf buf) {

        this(id, inventory, (BlasterUpgraderEntity) inventory.player.level().getBlockEntity(buf.readBlockPos()));
    }
    public BlasterUpgraderMenu( int id, Inventory inventory, BlasterUpgraderEntity entity) {

        super(MenusRegistry.BLASTER_UPGRADER.get(), id, inventory, entity);
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
}
