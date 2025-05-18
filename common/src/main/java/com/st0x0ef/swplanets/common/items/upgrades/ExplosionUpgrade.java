package com.st0x0ef.swplanets.common.items.upgrades;

import com.st0x0ef.swplanets.common.entities.LaserEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ExplosionUpgrade extends Item implements BlasterUpgrade{

    public ExplosionUpgrade(Properties properties) {
        super(properties);
    }

    @Override
    public MutableComponent displayName() {
        return Component.literal("Explosion Upgrade");
    }

    @Override
    public void onShoot(ItemStack stack, Level level, LivingEntity entity, LaserEntity laser) {
        laser.explode = true;
    }
}
