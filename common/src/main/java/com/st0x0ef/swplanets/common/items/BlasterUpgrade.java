package com.st0x0ef.swplanets.common.items;

import net.minecraft.world.item.Item;

public class BlasterUpgrade extends Item {

    private final boolean zoom;
    private final int distance;
    private final boolean explosion;

    public BlasterUpgrade(Properties $$0, boolean zoom, int distance, boolean explosion) {
        super($$0);
        this.zoom = zoom;
        this.distance = distance;
        this.explosion = explosion;
    }

    public boolean getZoom() {
        return zoom;
    }

    public int getLifeTime() {
        return distance;
    }
    public boolean getExplosion() {
        return explosion;
    }

}
