package fr.tathan.swplanets.common.registry;

import fr.tathan.swplanets.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;

public class DamageSourceRegistry {

    public static final ResourceKey<DamageType> BLASTER = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(Constants.MODID, "blaster"));

    public static DamageSource create(Level level, ResourceKey<DamageType> key) {
        return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(key));
    }

}
