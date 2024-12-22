package com.st0x0ef.swplanets.common.registry;

import com.st0x0ef.swplanets.SWPlanets;
import com.st0x0ef.swplanets.common.menu.BlasterUpgraderMenu;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.entity.BlockEntity;

public class MenusRegistry {

    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(SWPlanets.MODID, Registries.MENU);
    public static final RegistrySupplier<MenuType<BlasterUpgraderMenu>> BLASTER_UPGRADER = MENUS.register("blaster_upgrader_menu",
        () -> RegistryHelpers.createMenuType(BlasterUpgraderMenu::new));

    private static <T extends BaseContainerMenu<E>, E extends BlockEntity> MenuType<T> createMenuType(ModMenus.Factory<T, E> factory, Class<E> clazz) {
        return RegistryHelpers.createMenuType((id, inventory, buf) -> factory.create(
            id,
            inventory,
            BaseContainerMenu.getBlockEntityFromBuf(inventory.player.level(), buf, clazz)
        ));

    }
}
