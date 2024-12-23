package com.st0x0ef.swplanets.common.registry;


import com.st0x0ef.swplanets.SWPlanets;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class TabsRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(SWPlanets.MODID, Registries.CREATIVE_MODE_TAB);

    public static final RegistrySupplier<CreativeModeTab> SWPLANET_TAB = CREATIVE_MODE_TABS.register(
            "swplanet_tab",
            () -> CreativeTabRegistry.create(
                    Component.translatable("categorie.swplanet.main"),
                    () -> new ItemStack(ItemsRegistry.DARKSABER)
            )
    );
}
