package com.st0x0ef.swplanets.common.items.upgrades;

import com.st0x0ef.swplanets.common.entities.LaserEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public interface BlasterUpgrade {

    MutableComponent displayName(); //TODO add in gui

    default List<Item> requires() {
        return List.of();
    }

    default void addToTooltips(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
    }

    default void onShoot(ItemStack stack, Level level, LivingEntity entity, LaserEntity laser) {
    }
}
