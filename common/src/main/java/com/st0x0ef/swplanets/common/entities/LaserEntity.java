package com.st0x0ef.swplanets.common.entities;


import com.st0x0ef.swplanets.common.registry.DamageSourceRegistry;
import com.st0x0ef.swplanets.common.registry.EntityRegistry;
import com.st0x0ef.swplanets.common.registry.ItemsRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class LaserEntity extends Fireball {
    public int life;
    public int lifetime;
    public boolean explode;

    public LaserEntity(EntityType<? extends Fireball> entityType, Level level) {
        super(entityType, level);
        this.life = 0;

    }

    public LaserEntity(Level level, Boolean explode) {
        super(EntityRegistry.LASER.get(), level);
        this.lifetime = 60;
        this.explode = explode;
    }

    public LaserEntity(Level level) {
        super(EntityRegistry.LASER.get(), level);
        this.lifetime = 60;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Life", this.life);
        tag.putInt("LifeTime", this.lifetime);
        tag.putBoolean("Explode", this.explode);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.life = tag.getInt("Life");
        this.lifetime = tag.getInt("LifeTime");
        this.explode = tag.getBoolean("Explode");
    }


    @Override
    public void tick() {
        super.tick();

        if(!this.level().isClientSide) {
            this.clearFire();
        }

        if(this.isInWater()) this.life += 6; else ++this.life;

        if(!this.level().isClientSide && this.life > this.lifetime ) {
            this.discard();
        }
    }

    @Override
    public boolean isOnFire() {
        return false;
    }

    @Override
    protected boolean shouldBurn() {
        return true;
    }


    @Override
    public boolean hurt(DamageSource source, float damage) {
        return true;
    }

    @Override
    public boolean isPickable() {
        return false;
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        result.getEntity().hurt(DamageSourceRegistry.create(result.getEntity().level(), DamageSourceRegistry.BLASTER), 6.0F);
    }

    @Override
    public ItemStack getItem() {
        return ItemsRegistry.LASER_ITEM.get().getDefaultInstance();
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);

        if(this.explode) {
            this.level().explode(null, this.getX(), this.getY(), this.getZ(), 2f, true, Level.ExplosionInteraction.BLOCK);
        }

        this.discard();
    }
}