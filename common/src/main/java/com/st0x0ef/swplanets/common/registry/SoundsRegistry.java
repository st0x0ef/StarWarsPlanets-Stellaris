package com.st0x0ef.swplanets.common.registry;

import com.st0x0ef.swplanets.SWPlanets;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class SoundsRegistry {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(SWPlanets.MODID, Registries.SOUND_EVENT);

    public static final RegistrySupplier<SoundEvent> STAR_WARS_OPENING_MUSIC = SOUNDS.register("star_wars_opening_music", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "star_wars_opening_music")));
    public static final RegistrySupplier<SoundEvent> SABER_ATTACK_SOUND = SOUNDS.register("saber_attack_sound", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "saber_attack_sound")));
    public static final RegistrySupplier<SoundEvent> BLASTER_SOUND = SOUNDS.register("blaster_sound", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "blaster_sound")));
    public static final RegistrySupplier<SoundEvent> LIGHT_SABER_SOUND_1 = SOUNDS.register("light_saber_sound_1", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "light_saber_sound_1")));
    public static final RegistrySupplier<SoundEvent> LIGHT_SABER_SOUND_2 = SOUNDS.register("light_saber_sound_2", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "light_saber_sound_2")));
    public static final RegistrySupplier<SoundEvent> LIGHT_SABER_SOUND_3 = SOUNDS.register("light_saber_sound_3", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "light_saber_sound_3")));
}
