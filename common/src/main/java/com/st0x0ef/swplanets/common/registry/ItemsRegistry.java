package com.st0x0ef.swplanets.common.registry;

import com.st0x0ef.stellaris.common.items.CustomArmorItem;
import com.st0x0ef.swplanets.SWPlanets;
import com.st0x0ef.swplanets.common.data.BlasterComponent;
import com.st0x0ef.swplanets.common.items.*;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
public class ItemsRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(SWPlanets.MODID, Registries.ITEM);

    public static final RegistrySupplier<Item> KYBER_CRYSTAL = ITEMS.register("kyber_crystal", () -> new Item(new Item.Properties().stacksTo(16).arch$tab(TabsRegistry.SWPLANET_TAB)));

    /** Light Saber */
    public static final RegistrySupplier<Item> LIGHT_SABER_BASE = ITEMS.register("light_saber_base", () -> new Item(new Item.Properties().stacksTo(1).arch$tab(TabsRegistry.SWPLANET_TAB)));


    /**Jedi Light Saber*/
    public static final RegistrySupplier<Item> BLUE_LIGHT_SABER = ITEMS.register("light_saber_blue", () -> new JediLightSaber(StarWarsTiers.LIGHT_SABER, new Item.Properties().fireResistant().stacksTo(1).arch$tab(TabsRegistry.SWPLANET_TAB)));
    public static final RegistrySupplier<Item> GREEN_LIGHT_SABER = ITEMS.register("light_saber_green", () -> new JediLightSaber(StarWarsTiers.LIGHT_SABER, new Item.Properties().fireResistant().stacksTo(1).arch$tab(TabsRegistry.SWPLANET_TAB)));
    public static final RegistrySupplier<Item> VIOLET_LIGHT_SABER = ITEMS.register("light_saber_violet", () -> new JediLightSaber(StarWarsTiers.LIGHT_SABER, new Item.Properties().fireResistant().stacksTo(1).arch$tab(TabsRegistry.SWPLANET_TAB)));

    /** Sith Light Sabers **/
    public static final RegistrySupplier<Item> RED_LIGHT_SABER = ITEMS.register("light_saber_red", () -> new SithLightSaber(StarWarsTiers.LIGHT_SABER, new Item.Properties().fireResistant().stacksTo(1).arch$tab(TabsRegistry.SWPLANET_TAB)));
    public static final RegistrySupplier<Item> KYLO_REN_LIGHT_SABER = ITEMS.register("light_saber_kylo_ren", () -> new SithLightSaber(StarWarsTiers.LIGHT_SABER, new Item.Properties().fireResistant().stacksTo(1).arch$tab(TabsRegistry.SWPLANET_TAB)));
    public static final RegistrySupplier<Item> DARK_MAUL_LIGHT_SABER = ITEMS.register("light_saber_dark_maul", () -> new SithLightSaber(StarWarsTiers.LIGHT_SABER, new Item.Properties().fireResistant().stacksTo(1).arch$tab(TabsRegistry.SWPLANET_TAB)));


    /** Mandalorian **/
    public static final RegistrySupplier<BlockItem> BESKAR_ORE_SANDSTONE_ITEM = ITEMS.register("beskar_ore_sandstone", () -> new BlockItem(BlocksRegistry.BESKAR_ORE_SANDSTONE.get(), new Item.Properties().arch$tab(TabsRegistry.SWPLANET_TAB)));

    public static final RegistrySupplier<BlockItem> KYBER_CRYSTAl_ORE_ITEM = ITEMS.register("kyber_crystal_ore", () -> new BlockItem(BlocksRegistry.CRYSTAL_KYBER_ORE.get(), new Item.Properties().arch$tab(TabsRegistry.SWPLANET_TAB)));
    public static final RegistrySupplier<BlockItem> KYBER_CRYSTAl_ORE_SANDSTONE_ITEM = ITEMS.register("kyber_crystal_ore_sandstone", () -> new BlockItem(BlocksRegistry.CRYSTAL_KYBER_ORE_SANDSTONE.get(), new Item.Properties().arch$tab(TabsRegistry.SWPLANET_TAB)));
    public static final RegistrySupplier<BlockItem> MUSTAFAR_STONE_ITEM = ITEMS.register("mustafar_stone", () -> new BlockItem(BlocksRegistry.MUSTAFAR_STONE.get(), new Item.Properties().arch$tab(TabsRegistry.SWPLANET_TAB)));
    //public static final RegistryObject<BlockItem> MUSTAFAR_SAND_ITEM = ITEMS.register("mustafar_sand", () -> new BlockItem(BlocksRegistry.MUSTAFAR_SAND.get(), new Item.Properties().arch$tab(TabsRegistry.SWPLANET_TAB)));
    public static final RegistrySupplier<Item> LASER_ITEM = ITEMS.register("laser_item", () -> new Item(new Item.Properties().arch$tab(TabsRegistry.SWPLANET_TAB)));


    public static final RegistrySupplier<ArmorItem> STORMTROOPER_MASK = ITEMS.register("stormtrooper_mask",
            () -> new CustomArmorItem(ArmorMaterialRegistry.STORMTROOPER, ArmorItem.Type.HELMET,
                    new Item.Properties().arch$tab(TabsRegistry.SWPLANET_TAB)));

    public static final RegistrySupplier<Item> STORMTROOPER_CHESTPLATE = ITEMS.register("stormtrooper_chestplate",
            () -> new CustomArmorItem(ArmorMaterialRegistry.STORMTROOPER, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().arch$tab(TabsRegistry.SWPLANET_TAB)));
    public static final RegistrySupplier<Item> STORMTROOPER_LEGGINGS = ITEMS.register("stormtrooper_leggings",
            () -> new CustomArmorItem(ArmorMaterialRegistry.STORMTROOPER, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().arch$tab(TabsRegistry.SWPLANET_TAB)));
    public static final RegistrySupplier<Item> STORMTROOPER_BOOTS = ITEMS.register("stormtrooper_boots",
            () -> new CustomArmorItem(ArmorMaterialRegistry.STORMTROOPER, ArmorItem.Type.BOOTS,
                    new Item.Properties().arch$tab(TabsRegistry.SWPLANET_TAB)));
    public static final RegistrySupplier<Item> PLASTIC_PLATE = ITEMS.register("plastic_plate", () -> new Item(new Item.Properties().stacksTo(64)));


    /** Beskar*/
    public static final RegistrySupplier<ArmorItem> BESKAR_HELMET = ITEMS.register("beskar_armor_helmet",
            () -> new ArmorItem(ArmorMaterialRegistry.BESKAR, ArmorItem.Type.HELMET,
                    new Item.Properties().arch$tab(TabsRegistry.SWPLANET_TAB)));

    public static final RegistrySupplier<Item> BESKAR_CHESTPLATE = ITEMS.register("beskar_armor_chestplate",
            () -> new ArmorItem(ArmorMaterialRegistry.BESKAR, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().arch$tab(TabsRegistry.SWPLANET_TAB)));
    public static final RegistrySupplier<Item> BESKAR_LEGGINGS = ITEMS.register("beskar_armor_leggings",
            () -> new ArmorItem(ArmorMaterialRegistry.BESKAR, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().arch$tab(TabsRegistry.SWPLANET_TAB)));
    public static final RegistrySupplier<Item> BESKAR_BOOTS = ITEMS.register("beskar_armor_boots",
            () -> new ArmorItem(ArmorMaterialRegistry.BESKAR, ArmorItem.Type.BOOTS,
                    new Item.Properties().arch$tab(TabsRegistry.SWPLANET_TAB)));
    public static final RegistrySupplier<Item> DARKSABER = ITEMS.register("darksaber", () -> new SwordItem(StarWarsTiers.BESKAR, new Item.Properties().fireResistant().stacksTo(1).arch$tab(TabsRegistry.SWPLANET_TAB)));
    public static final RegistrySupplier<Item> BESKAR = ITEMS.register("beskar", () -> new Item(new Item.Properties().fireResistant().stacksTo(16).arch$tab(TabsRegistry.SWPLANET_TAB)));

    /** Blaster */
    //Blasters
    public static final RegistrySupplier<Item> BLASTER = ITEMS.register("blaster", () -> new Blaster(new Item.Properties().durability(2000).component(DataComponentRegistry.BLASTER_COMPONENT.get(), new BlasterComponent(false, false)).arch$tab(TabsRegistry.SWPLANET_TAB)));

    // Blaster Upgrade
    public static final RegistrySupplier<BlockItem> BLASTER_UPGRADER = ITEMS.register("blaster_upgrader", () -> new BlockItem(BlocksRegistry.BLASTER_UPGRADER.get(), new Item.Properties().arch$tab(TabsRegistry.SWPLANET_TAB)));
    public static final RegistrySupplier<Item> BLASTER_ZOOM_UPGRADE = ITEMS.register("blaster_zoom_upgrade", () -> new BlasterUpgrade(new Item.Properties().stacksTo(16).arch$tab(TabsRegistry.SWPLANET_TAB), true, 0, false));
    public static final RegistrySupplier<BlasterUpgrade> BLASTER_EXPLOSION_UPGRADE = ITEMS.register("blaster_explosion_upgrade", () -> new BlasterUpgrade(new Item.Properties().stacksTo(16).arch$tab(TabsRegistry.SWPLANET_TAB), false, 0, true));

    /** Blocks */
    public static final RegistrySupplier<BlockItem> TATOOINE_STONE = ITEMS.register("tatooine_stone", () -> new BlockItem(BlocksRegistry.TATOOINE_STONE.get(),  new Item.Properties().arch$tab(TabsRegistry.SWPLANET_TAB)));
    public static final RegistrySupplier<BlockItem> TATOOINE_STONE_SLAB = ITEMS.register("tatooine_stone_slab", () -> new BlockItem(BlocksRegistry.TATOOINE_STONE_STONE_SLAB.get(),  new Item.Properties().arch$tab(TabsRegistry.SWPLANET_TAB)));
    public static final RegistrySupplier<BlockItem> TATOOINE_STONE_STAIRS = ITEMS.register("tatooine_stone_stairs", () -> new BlockItem(BlocksRegistry.TATOOINE_STONE_STONE_STAIRS.get(),  new Item.Properties().arch$tab(TabsRegistry.SWPLANET_TAB)));

}
