package com.st0x0ef.swplanets.common.items;


import com.st0x0ef.swplanets.common.registry.SoundsRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class JediLightSaber extends SwordItem  {

    public JediLightSaber(Tier pTier, Properties pProperties) {
        super(pTier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.setRemainingFireTicks(6);
        if (!pAttacker.level().isClientSide) {
            pAttacker.level().playSeededSound(null, pAttacker.getX(), pAttacker.getY(), pAttacker.getZ(), SoundsRegistry.SABER_ATTACK_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F, 0);
        }

        return super.hurtEnemy(pStack, pTarget, pAttacker);

    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.swplanets.jedilightsaber.tooltip.shift"));
        tooltipComponents.add(Component.translatable("tooltip.swplanets.jedilightsaber.tooltip.shift.two"));
    }
}