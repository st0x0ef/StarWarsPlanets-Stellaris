package com.st0x0ef.swplanets.common.registry;

import com.st0x0ef.swplanets.SWPlanets;
import com.st0x0ef.swplanets.common.data.BlasterComponent;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;

public class DataComponentRegistry {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPE = DeferredRegister.create(SWPlanets.MODID, Registries.DATA_COMPONENT_TYPE);

    public static final RegistrySupplier<DataComponentType<BlasterComponent>> BLASTER_COMPONENT = DATA_COMPONENT_TYPE.register("blaster_component",
            () -> DataComponentType.<BlasterComponent>builder().persistent(BlasterComponent.CODEC).networkSynchronized(BlasterComponent.STREAM_CODEC).build());

}
