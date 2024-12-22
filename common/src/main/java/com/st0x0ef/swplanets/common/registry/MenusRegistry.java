package com.st0x0ef.swplanets.common.registry;

import com.st0x0ef.swplanets.SWPlanets;
import com.st0x0ef.swplanets.common.menu.BlasterUpgraderMenu;
import dev.architectury.registry.menu.MenuRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;

public class MenusRegistry {
    public static final DeferredRegister<MenuType<?>> MENU_TYPE = DeferredRegister.create(SWPlanets.MODID, Registries.MENU);

    public static final RegistrySupplier<MenuType<BlasterUpgraderMenu>> BLASTER_UPGRADER_MENU = MENU_TYPE.register("blaster_upgrader_menu", () -> MenuRegistry.ofExtended(BlasterUpgraderMenu::new));

}
