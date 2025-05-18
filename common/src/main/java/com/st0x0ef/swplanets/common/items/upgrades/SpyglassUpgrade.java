package com.st0x0ef.swplanets.common.items.upgrades;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;

public class SpyglassUpgrade extends Item implements BlasterUpgrade{

    public SpyglassUpgrade(Properties properties) {
        super(properties);
    }

    @Override
    public MutableComponent displayName() {
        return Component.literal("Spyglass Upgrade");
    }
}
