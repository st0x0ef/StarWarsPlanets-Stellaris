package com.st0x0ef.swplanets.common.items;

import com.st0x0ef.swplanets.common.registry.ItemsRegistry;
import net.minecraft.tags.TagKey;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public enum StarWarsTiers implements Tier {
    PLASTIC(3, 1561, 8.0F, 3.0F, 10, () -> Ingredient.of(ItemsRegistry.PLASTIC_PLATE.get())),
    BESKAR(0, 2031, 12.0F, 0.0F, 22, () -> Ingredient.of(ItemsRegistry.BESKAR.get())),
    LIGHT_SABER(0, 2031, 12.0F, 0.0F, 22, () -> Ingredient.of(ItemsRegistry.KYBER_CRYSTAL.get()));

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    StarWarsTiers(int $$0, int $$1, float $$2, float $$3, int $$4, Supplier<Ingredient> $$5) {
        this.level = $$0;
        this.uses = $$1;
        this.speed = $$2;
        this.damage = $$3;
        this.enchantmentValue = $$4;
        this.repairIngredient = new LazyLoadedValue<>($$5);
    }

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.damage;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return null;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}