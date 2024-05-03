package fr.tathan.swplanets.common.items;

import earth.terrarium.adastra.common.items.EtrionicCapacitorItem;
import earth.terrarium.adastra.common.items.ZipGunItem;
import earth.terrarium.adastra.common.utils.TooltipUtils;
import earth.terrarium.botarium.common.energy.base.BotariumEnergyItem;
import earth.terrarium.botarium.common.energy.base.EnergyContainer;
import earth.terrarium.botarium.common.energy.impl.SimpleEnergyContainer;
import earth.terrarium.botarium.common.energy.impl.WrappedItemEnergyContainer;
import earth.terrarium.botarium.common.fluid.FluidConstants;
import earth.terrarium.botarium.common.fluid.base.FluidContainer;
import earth.terrarium.botarium.common.fluid.base.FluidHolder;
import earth.terrarium.botarium.common.item.ItemStackHolder;
import fr.tathan.swplanets.common.config.SWPlanetsConfig;
import fr.tathan.swplanets.common.entities.LaserEntity;
import fr.tathan.swplanets.common.registry.ItemsRegistry;
import fr.tathan.swplanets.common.registry.SoundsRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
public class Blaster extends TieredItem implements BotariumEnergyItem<WrappedItemEnergyContainer> {

    public static final String ZOOM_UPGRADE = "Mode";
    public static final String EXPLOSION_UPGRADE = "Explosion";


    public Blaster(Properties properties) {
        super(StarWarsTiers.PLASTIC, properties);
    }



    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand handIn) {
        player.startUsingItem(handIn);

        return InteractionResultHolder.consume(player.getItemInHand(handIn));

    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int $$3) {
        if (!level.isClientSide) {
            boolean useEnergy = useEnergy(stack, 100L);
            if (!useEnergy) return;

            level.playSeededSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundsRegistry.BLASTER_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F, 0);
            LaserEntity laser = new LaserEntity( entity.getX(), entity.getY(), entity.getZ(), 0, 0, 0, level, getExplosionUpgrade(stack));            laser.setPos(entity.getX(), entity.getY() + 1.5, entity.getZ());
            laser.shootFromRotation(entity, entity.getXRot(), entity.getYRot(), 0.0F, 3.0F, 1.0F);
            laser.setItem(ItemsRegistry.LASER_ITEM.get().getDefaultInstance());
            level.addFreshEntity(laser);

        }

    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        if (getZoomUpgrade(stack)) {
            return UseAnim.SPYGLASS;
        } else {
            return UseAnim.BOW;
        }
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 200;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level $$1, List<Component> components, TooltipFlag $$3) {
        var energy = getEnergyStorage(stack);

        if(Screen.hasShiftDown()) {
            addUpgradesComponents(stack, components);
            components.add(TooltipUtils.getEnergyComponent(energy.getStoredEnergy(), energy.getMaxCapacity()));

        } else {
            components.add(Component.translatable("tooltip.swplanets.shift"));

        }
        super.appendHoverText(stack, $$1, components, $$3);
    }

    public void addUpgradesComponents(ItemStack stack, List<Component> components) {
        Component zoom;
        Component explosion;

        if (getZoomUpgrade(stack)) {
            zoom = Component.literal("✔").withStyle(ChatFormatting.GREEN);
        } else {
            zoom = Component.literal("✘").withStyle(ChatFormatting.RED);
        }
        if (getExplosionUpgrade(stack)) {
            explosion = Component.literal("✔").withStyle(ChatFormatting.GREEN);
        } else {
            explosion = Component.literal("✘").withStyle(ChatFormatting.RED);
        }

        components.add(Component.literal("Zoom: ").append(zoom));
        components.add(Component.literal("Explosion: ").append(explosion));
    }

    public void setUpgrade(BlasterUpgrade upgradeItem, ItemStack stack) {

        var tag = stack.getOrCreateTag();

        if(stack.getItem() instanceof Blaster blaster) {

            if(!blaster.getZoomUpgrade(stack) ) {
                tag.putBoolean(ZOOM_UPGRADE, upgradeItem.getZoom());
            }

            if(!blaster.getZoomUpgrade(stack) ) {
                tag.putBoolean(EXPLOSION_UPGRADE, upgradeItem.getExplosion());
            }
        }

    }

    @Override
    public ItemStack finishUsingItem(ItemStack $$0, Level level, LivingEntity $$2) {
        return $$0;
    }

    @Override
    public WrappedItemEnergyContainer getEnergyStorage(ItemStack holder) {
        return new WrappedItemEnergyContainer(
                holder,
                new SimpleEnergyContainer(SWPlanetsConfig.maxBlasterEnergy) {
                    @Override
                    public long maxInsert() {
                        return 100;
                    }

                    @Override
                    public long maxExtract() {
                        return 500;
                    }
                });

    }

    @Override
    public boolean isBarVisible(@NotNull ItemStack stack) {
        return getEnergyStorage(stack).getStoredEnergy() > 0;
    }

    @Override
    public int getBarWidth(@NotNull ItemStack stack) {
        var energyStorage = getEnergyStorage(stack);
        return (int) (((double) energyStorage.getStoredEnergy() / energyStorage.getMaxCapacity()) * 13);
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return 0x63dcc2;
    }

    public boolean useEnergy(ItemStack stack, long amount) {
        if (!(stack.getItem() instanceof Blaster)) return false;
        ItemStackHolder holder = new ItemStackHolder(stack);

        var container = EnergyContainer.of(holder);
        if (container == null) return false;
        container.extractEnergy(amount, false);
        stack.setTag(holder.getStack().getTag());
        return container.getStoredEnergy() > 0;
    }

    public boolean getZoomUpgrade(ItemStack stack) {
        return stack.getOrCreateTag().getBoolean(ZOOM_UPGRADE);
    }
    public boolean getExplosionUpgrade(ItemStack stack) {
        return stack.getOrCreateTag().getBoolean(EXPLOSION_UPGRADE);
    }

}
