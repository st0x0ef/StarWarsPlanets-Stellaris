package com.st0x0ef.swplanets.common.items;

import com.st0x0ef.stellaris.common.systems.energy.base.EnergyItem;
import com.st0x0ef.stellaris.common.systems.energy.impl.SimpleEnergyContainer;
import com.st0x0ef.stellaris.common.systems.energy.impl.WrappedItemEnergyContainer;
import com.st0x0ef.stellaris.common.systems.item.ItemStackHolder;
import com.st0x0ef.stellaris.platform.systems.energy.EnergyContainer;
import com.st0x0ef.swplanets.common.data.BlasterComponent;
import com.st0x0ef.swplanets.common.entities.LaserEntity;
import com.st0x0ef.swplanets.common.registry.DataComponentRegistry;
import com.st0x0ef.swplanets.common.registry.ItemsRegistry;
import com.st0x0ef.swplanets.common.registry.SoundsRegistry;
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

import java.util.List;
public class Blaster extends TieredItem {
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
            level.playSeededSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundsRegistry.BLASTER_SOUND, SoundSource.PLAYERS, 1.0F, 1.0F, 0);
            LaserEntity laser = new LaserEntity(level, getExplosionUpgrade(stack));
            laser.setPos(entity.getX(), entity.getY() + 1.5, entity.getZ());
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
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 200;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (Screen.hasShiftDown()) {
            addUpgradesComponents(stack, tooltipComponents);
        } else {
            tooltipComponents.add(Component.translatable("tooltip.swplanets.shift"));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
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
        BlasterComponent component = new BlasterComponent(upgradeItem.getZoom(), upgradeItem.getExplosion());
        stack.set(DataComponentRegistry.BLASTER_COMPONENT.get(), component);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack $$0, Level level, LivingEntity $$2) {
        return $$0;
    }

    public boolean getZoomUpgrade(ItemStack stack) {
        return stack.get(DataComponentRegistry.BLASTER_COMPONENT.get()).zoom_upgrade();
    }

    public boolean getExplosionUpgrade(ItemStack stack) {
        return stack.get(DataComponentRegistry.BLASTER_COMPONENT.get()).explosion_upgrade();
    }
}
