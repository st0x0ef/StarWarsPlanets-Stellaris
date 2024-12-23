package com.st0x0ef.swplanets.common.registry;

import com.st0x0ef.swplanets.SWPlanets;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;

import static net.minecraft.core.registries.Registries.ARMOR_MATERIAL;

public class ArmorMaterialRegistry {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIAL = DeferredRegister.create(SWPlanets.MODID, Registries.ARMOR_MATERIAL);


    public static final ArmorMaterial STORMTROOPER_MATERIAL = new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 5);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 8);
            }),
            14,
            SoundEvents.ARMOR_EQUIP_ELYTRA,
            () -> Ingredient.of(ItemsRegistry.PLASTIC_PLATE.get()),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID,"stormtrooper"))),
            2.0F, 0.0F);

    public static final ArmorMaterial BESKAR_MATERIAL = new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 4);
                map.put(ArmorItem.Type.LEGGINGS, 7);
                map.put(ArmorItem.Type.CHESTPLATE, 9);
                map.put(ArmorItem.Type.HELMET, 4);
                map.put(ArmorItem.Type.BODY, 14);
            }),
            14,
            SoundEvents.ARMOR_EQUIP_ELYTRA,
            () -> Ingredient.of(ItemsRegistry.BESKAR.get()),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID,"beskar_armor"))),
            1.0F, 1.0F);


    public static final RegistrySupplier<ArmorMaterial> STORMTROOPER = ARMOR_MATERIAL.register("stormtrooper", () -> STORMTROOPER_MATERIAL);
    public static final RegistrySupplier<ArmorMaterial> BESKAR = ARMOR_MATERIAL.register("beskar_armor", () -> BESKAR_MATERIAL);

}
