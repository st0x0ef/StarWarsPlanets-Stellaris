package com.st0x0ef.swplanets.common.registry;

import com.st0x0ef.swplanets.SWPlanets;
import com.st0x0ef.swplanets.common.entities.BanthaEntity;
import com.st0x0ef.swplanets.common.entities.JawaEntity;
import com.st0x0ef.swplanets.common.entities.LaserEntity;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.function.BiConsumer;
import java.util.function.Supplier;


public class EntityRegistry {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(SWPlanets.MODID, Registries.ENTITY_TYPE);

    public static final RegistrySupplier<EntityType<LaserEntity>> LASER = ENTITY_TYPES.register("laser",() -> EntityType.Builder.<LaserEntity>of(LaserEntity::new, MobCategory.MISC).fireImmune().sized(0.4f, 0.4f).build(new ResourceLocation(Constants.MODID, "laser").toString()));
    public static final RegistrySupplier<EntityType<JawaEntity>> JAWA = ENTITY_TYPES.register("jawa",() ->
            EntityType.Builder.of(JawaEntity::new, MobCategory.AMBIENT)
                    .fireImmune()
                    .sized(0.4f, 1.5f)
                    .build("jawa"));

    public static final RegistrySupplier<EntityType<BanthaEntity>> BANTHA = ENTITY_TYPES.register("bantha",() ->
            EntityType.Builder.of(BanthaEntity::new, MobCategory.AMBIENT)
                    .fireImmune()
                    .sized(2f, 1.7f)
                    .build("bantha"));


    public static void registerAttributes(BiConsumer<Supplier<? extends EntityType<? extends LivingEntity>>, Supplier<AttributeSupplier.Builder>> attributes) {
        attributes.accept(JAWA, JawaEntity::addAttributes);
        attributes.accept(BANTHA, BanthaEntity::addAttributes);
    }

    public static void registerSpawnPlacements() {
        SpawnPlacements.register(EntityRegistry.BANTHA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BanthaEntity::checkMobSpawnRules);
        SpawnPlacements.register(EntityRegistry.JAWA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, JawaEntity::checkMobSpawnRules);
    }
}

