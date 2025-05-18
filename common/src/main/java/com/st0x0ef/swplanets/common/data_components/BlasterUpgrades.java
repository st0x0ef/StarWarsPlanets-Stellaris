package com.st0x0ef.swplanets.common.data_components;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.st0x0ef.swplanets.common.items.upgrades.BlasterUpgrade;
import com.st0x0ef.swplanets.common.registry.DataComponentRegistry;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public record BlasterUpgrades(List<ItemStack> modules) implements Serializable {

    public static BlasterUpgrades empty() {
        return new BlasterUpgrades(List.of());
    }

    public static final Codec<BlasterUpgrades> CODEC = ItemStack.CODEC.listOf().xmap(BlasterUpgrades::new, modules -> modules.modules);
    public static final StreamCodec<RegistryFriendlyByteBuf, BlasterUpgrades> STREAM_CODEC = ItemStack.STREAM_CODEC
            .apply(ByteBufCodecs.list())
            .map(BlasterUpgrades::new, modules -> modules.modules);


    public ItemStack getItemUnsafe(int index) {
        return this.modules.get(index);
    }

    public Stream<ItemStack> itemCopyStream() {
        return this.modules.stream().map(ItemStack::copy);
    }

    public Iterable<ItemStack> items() {
        return this.modules;
    }

    public Iterable<ItemStack> itemsCopy() {
        return Lists.transform(this.modules, ItemStack::copy);
    }

    public static ItemStack getIfContains(ItemStack stack, Item module) {
        ItemStack moduleToReturn = ItemStack.EMPTY;
        BlasterUpgrades spaceSuitModules = stack.getOrDefault(DataComponentRegistry.BLASTER_COMPONENT.get(), empty());
        if (spaceSuitModules.items() == null) {
            return moduleToReturn;
        }
        for (ItemStack moduleStack : spaceSuitModules.items()) {
            if (moduleStack.is(module)) {
                moduleToReturn = moduleStack;
                break;
            }
        }
        return moduleToReturn;
    }

    public static boolean containsAllInModules(ItemStack stack, List<Item> modules) {
        boolean containsAll = true;
        for (Item item : modules) {
            if (item instanceof BlasterUpgrade validUpgrade) {
                if (!containsInModules(stack, validUpgrade)) {
                    containsAll = false;
                }
                break;
            }
        }
        return containsAll;
    }

    public static boolean containsInModules(ItemStack stack, ItemStack module) {
        return containsInModules(stack, getUpgrade(module));
    }

    public static boolean containsInModules(ItemStack stack, BlasterUpgrade upgrades) {
        if (stack.isEmpty()) {
            return false;
        }
        BlasterUpgrades blasterUpgrades = stack.get(DataComponentRegistry.BLASTER_COMPONENT.get());
        if (blasterUpgrades == null) {
            return false;
        }
        boolean boolToReturn = false;
        for (BlasterUpgrade upgrades1 : blasterUpgrades.getUpgrades()) {
            if (upgrades1 == upgrades) {
                boolToReturn = true;
                break;
            }
        }

        return boolToReturn;
    }

    public List<BlasterUpgrade> getUpgrades() {
        return Lists.transform(this.modules, BlasterUpgrades::getUpgrade);
    }

    private static BlasterUpgrade getUpgrade(ItemStack itemStack) {
        if (itemStack.getItem() instanceof BlasterUpgrade spaceSuitModule) {
            return spaceSuitModule;
        }
        return null; //failsafe, shouldn't happen unless tampered with or incorrect checks for upgrade station
    }

    public static class Mutable {

        private final List<ItemStack> modules;

        public Mutable(BlasterUpgrades contents) {
            this.modules = new ArrayList<>(contents.modules);
        }

        public BlasterUpgrades.Mutable insert(ItemStack stack) {
            if (!stack.isEmpty() && stack.getItem().canFitInsideContainerItems()) {
                this.modules.add(stack);
            }
            return this;
        }

        public BlasterUpgrades toImmutable() {
            return new BlasterUpgrades(List.copyOf(this.modules));
        }
    }
}