package com.st0x0ef.swplanets.common.items;

import com.st0x0ef.swplanets.common.data_components.BlasterUpgrades;
import com.st0x0ef.swplanets.common.entities.LaserEntity;
import com.st0x0ef.swplanets.common.items.upgrades.BlasterUpgrade;
import com.st0x0ef.swplanets.common.items.upgrades.SpyglassUpgrade;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

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

            List<BlasterUpgrade> modules = getUpgrades(stack);


            level.playSeededSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundsRegistry.BLASTER_SOUND, SoundSource.PLAYERS, 1.0F, 1.0F, 0);
            LaserEntity laser = new LaserEntity(level);
            laser.setPos(entity.getX(), entity.getY() + 1.5, entity.getZ());
            laser.shootFromRotation(entity, entity.getXRot(), entity.getYRot(), 0.0F, 3.0F, 1.0F);
            laser.setItem(ItemsRegistry.LASER_ITEM.get().getDefaultInstance());

            modules.forEach((upgrade) -> upgrade.onShoot(stack, level, entity, laser));

            level.addFreshEntity(laser);
        }
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        if (isSpyglass(stack)) {
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
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);

        List<BlasterUpgrade> modules = getUpgrades(stack);

        if (Screen.hasShiftDown()) {
            if (!modules.isEmpty()) {
                tooltipComponents.add(Component.translatable("spacesuit.stellaris.modules"));
                modules.forEach(spaceSuitModule -> tooltipComponents.add(spaceSuitModule.displayName().withStyle(ChatFormatting.GRAY)));
            }
        } else {
            tooltipComponents.add(Component.translatable("tooltip.swplanets.shift"));
        }

    }

    public boolean isSpyglass(ItemStack stack) {
        return stack.getOrDefault(DataComponentRegistry.BLASTER_COMPONENT.get(), BlasterUpgrades.empty()).getUpgrades().stream().anyMatch(upgrade -> upgrade instanceof SpyglassUpgrade);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack $$0, Level level, LivingEntity $$2) {
        return $$0;
    }

    public BlasterUpgrades getUpgrade(ItemStack stack) {
        return stack.getOrDefault(DataComponentRegistry.BLASTER_COMPONENT.get(), BlasterUpgrades.empty());
    }

    public List<BlasterUpgrade> getUpgrades(ItemStack stack) {
        return stack.getOrDefault(DataComponentRegistry.BLASTER_COMPONENT.get(), BlasterUpgrades.empty()).getUpgrades();
    }

}
