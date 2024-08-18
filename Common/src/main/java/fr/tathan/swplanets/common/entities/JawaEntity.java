package fr.tathan.swplanets.common.entities;

import earth.terrarium.adastra.common.registry.ModItems;
import fr.tathan.swplanets.Constants;
import fr.tathan.swplanets.common.config.SWPlanetsConfig;
import fr.tathan.swplanets.common.registry.EntityRegistry;
import fr.tathan.swplanets.common.registry.TagsRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class JawaEntity extends Animal {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(JawaEntity.class, EntityDataSerializers.BOOLEAN);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public final AnimationState tradeAnimationState = new AnimationState();
    public int tradeAnimationTimeout = 0;

    public boolean isTrading = false;
    public AnimationState dieAnimationState = new AnimationState();
    public Map<Item, Integer> TRADED_ITEMS = new HashMap<>();

    public int TRADES_LEFT;

    public JawaEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        this.addItems();
        Random generator = new Random();
        TRADES_LEFT = generator.nextInt(0, SWPlanetsConfig.jawaMaxTrade);
    }

    public void addItems() {
        TRADED_ITEMS.put(ModItems.WRENCH.get(), 1);
        TRADED_ITEMS.put(ModItems.STEEL_CABLE.get(), 10);
        TRADED_ITEMS.put(ModItems.DESH_CABLE.get(), 5);
        TRADED_ITEMS.put(ModItems.SOLAR_PANEL.get(), 2);
        TRADED_ITEMS.put(ModItems.GAS_TANK.get(), 2);
        TRADED_ITEMS.put(ModItems.IRON_PLATE.get(), 15);
        TRADED_ITEMS.put(ModItems.PHOTOVOLTAIC_VESNIUM_CELL.get(), 3);

    }

    @Override
    protected void tickDeath() {
        super.tickDeath();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("tradesLeft", this.TRADES_LEFT);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.TRADES_LEFT = compound.getInt("tradesLeft");
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1D, Ingredient.of(ModItems.WRENCH.get()), false));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 4f));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
    }

    @Override
    public void tick() {
        super.tick();
        if(this.level().isClientSide()) {
            setupAnimationStates();
        }
    }
    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        if(this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 40;
            attackAnimationState.start(this.tickCount);
        } else {
            --this.attackAnimationTimeout;
        }

        if(this.isTrading && tradeAnimationTimeout <= 0) {
            tradeAnimationTimeout = 25;
            tradeAnimationState.start(this.tickCount);
        } else {
            --this.tradeAnimationTimeout;
        }

        if (tradeAnimationTimeout == 25) {
            tradeAnimationState.stop();
        }

        if(!this.isTrading) {
            tradeAnimationState.stop();
        }

        if(!this.isAttacking()) {
            attackAnimationState.stop();
        }
    }

    public static AttributeSupplier.Builder addAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20D)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.MOVEMENT_SPEED, 0.3);
    }


    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return EntityRegistry.JAWA.get().create(level);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);

    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6F, 1f);
        } else {
            f = 0f;
        }

        this.walkAnimation.update(f, 0.2f);
    }

    @Override
    public void die(DamageSource damageSource) {
        this.dieAnimationState.start(this.tickCount);
        super.die(damageSource);
    }

    @Override
    public InteractionResult interactAt(Player player, Vec3 vec, InteractionHand hand) {

        trade(player, hand);

        return super.interactAt(player, vec, hand);
    }

    public void trade(Player player, InteractionHand hand) {

        this.isTrading = true;

        ItemStack stack = player.getItemInHand(hand);
        tradeAnimationState.start(this.tickCount);

        if (stack.is(TagsRegistry.JAWAS_TRADES)) {
            if (TRADES_LEFT < 0) {
                return;
            }

            player.getItemInHand(hand).grow(-1);

            ItemEntity items = new ItemEntity(this.level(), this.position().x, this.position().y, this.position().z, getTradeItems());
            this.level().addFreshEntity(items);
            TRADES_LEFT--;
        }

    }

    public ItemStack getTradeItems() {
        Random generator = new Random();

        List<Item> keys = new ArrayList<Item>(TRADED_ITEMS.keySet());
        Item randomKey = keys.get( generator.nextInt(keys.size()) );

        int stacksSize = TRADED_ITEMS.get(randomKey);
        ItemStack randomItem = new ItemStack(randomKey) ;
        randomItem.setCount(stacksSize);

        return randomItem;

    }
}
