package com.st0x0ef.swplanets.common.entities;


import com.st0x0ef.swplanets.common.registry.DamageSourceRegistry;
import com.st0x0ef.swplanets.common.registry.EntityRegistry;
import com.st0x0ef.swplanets.common.registry.ItemsRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class LaserEntity extends Fireball {
    public int life;
    public int lifetime;
    public boolean explode;

    public LaserEntity(EntityType<? extends Fireball> $$0, Level $$1) {
        super($$0, $$1);
        this.life = 0;

    }

    public LaserEntity( double x, double y, double z, double offsetX, double offsetY, double offsetZ, Level level, Boolean explode) {
        super(EntityRegistry.LASER.get(), x, y, z, offsetX, offsetY, offsetZ, level);
        this.lifetime = 60;
        this.explode = explode;
    }

    public LaserEntity(LivingEntity shooter, double offsetX, double offsetY, double offsetZ, Level level) {
        super(EntityRegistry.LASER.get(), shooter, offsetX, offsetY, offsetZ, level);
        this.lifetime = 60;

    }

    @Override
    public void addAdditionalSaveData(CompoundTag $$0) {
        super.addAdditionalSaveData($$0);
        $$0.putInt("Life", this.life);
        $$0.putInt("LifeTime", this.lifetime);
        $$0.putBoolean("Explode", this.explode);

    }

    @Override
    public void readAdditionalSaveData(CompoundTag $$0) {
        super.readAdditionalSaveData($$0);
        this.life = $$0.getInt("Life");
        this.lifetime = $$0.getInt("LifeTime");
        this.explode = $$0.getBoolean("Explode");
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
    public boolean hurt(DamageSource $$0, float $$1) {
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