package com.st0x0ef.swplanets.common.registry;


import com.st0x0ef.swplanets.SWPlanets;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;

import java.util.function.Supplier;

public class TabsRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(SWPlanets.MODID, Registries.CREATIVE_MODE_TAB);


    public static final Supplier<CreativeModeTab> TAB = new ResourcefulCreativeTab(ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "main"))
        .setItemIcon(ItemsRegistry.BLUE_LIGHT_SABER)
        .addRegistry(ItemsRegistry.ITEMS)
        .build();
}
