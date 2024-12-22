package com.st0x0ef.swplanets.common.registry;

import com.st0x0ef.swplanets.SWPlanets;
import com.st0x0ef.swplanets.common.blocks.entities.BlasterUpgraderEntity;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class BlockEntitiesRegistry {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(SWPlanets.MODID, Registries.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<?>> BLASTER_UPGRADER = BLOCK_ENTITY_TYPES.register(
        "blaster_upgrader",
        () -> RegistryHelpers.createBlockEntityType(
            BlasterUpgraderEntity::new,
            BlocksRegistry.BLASTER_UPGRADER.get()));


}
