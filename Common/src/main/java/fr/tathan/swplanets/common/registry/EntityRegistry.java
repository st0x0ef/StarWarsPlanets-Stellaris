package fr.tathan.swplanets.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import fr.tathan.swplanets.Constants;
import fr.tathan.swplanets.common.entities.BanthaEntity;
import fr.tathan.swplanets.common.entities.JawaEntity;
import fr.tathan.swplanets.common.entities.LaserEntity;

import net.minecraft.core.registries.BuiltInRegistries;
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

    public static final ResourcefulRegistry<EntityType<?>> ENTITY_TYPES = ResourcefulRegistries.create(BuiltInRegistries.ENTITY_TYPE, Constants.MODID);

    public static final RegistryEntry<EntityType<LaserEntity>> LASER = ENTITY_TYPES.register("laser",() -> EntityType.Builder.<LaserEntity>of(LaserEntity::new, MobCategory.MISC).fireImmune().sized(0.4f, 0.4f).build(new ResourceLocation(Constants.MODID, "laser").toString()));
    public static final RegistryEntry<EntityType<JawaEntity>> JAWA = ENTITY_TYPES.register("jawa",() ->
            EntityType.Builder.<JawaEntity>of(JawaEntity::new, MobCategory.AMBIENT)
                    .fireImmune()
                    .sized(0.4f, 1.5f)
                    .build("jawa"));

    public static final RegistryEntry<EntityType<BanthaEntity>> BANTHA = ENTITY_TYPES.register("bantha",() ->
            EntityType.Builder.<BanthaEntity>of(BanthaEntity::new, MobCategory.AMBIENT)
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

