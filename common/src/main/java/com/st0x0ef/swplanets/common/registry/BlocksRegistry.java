package com.st0x0ef.swplanets.common.registry;


import com.st0x0ef.swplanets.SWPlanets;
import com.st0x0ef.swplanets.common.blocks.BlasterUpgraderBlock;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class BlocksRegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(SWPlanets.MODID, Registries.BLOCK);

    public static final BlockBehaviour.Properties IRON_PROPERTIES = BlockBehaviour.Properties.of()
        .mapColor(MapColor.METAL)
        .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
        .requiresCorrectToolForDrops()
        .strength(5, 6)
        .sound(SoundType.COPPER);

    /** ORES */
    public static final RegistrySupplier<Block> CRYSTAL_KYBER_ORE = BLOCKS.register("kyber_crystal_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE).sound(SoundType.STONE).strength(3.0F, 3.0F).explosionResistance(3).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> CRYSTAL_KYBER_ORE_SANDSTONE = BLOCKS.register("kyber_crystal_ore_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).sound(SoundType.STONE).strength(3.0F, 3.0F).explosionResistance(3).requiresCorrectToolForDrops()));

    public static final RegistrySupplier<Block> BESKAR_ORE_SANDSTONE = BLOCKS.register("beskar_ore_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).sound(SoundType.STONE).strength(3.0F, 3.0F).explosionResistance(3).requiresCorrectToolForDrops()));

   //public static final RegistryObject<Block> MUSTAFAR_SAND = BLOCKS.register("mustafar_sand", () -> new FallingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SAND).sound(SoundType.SAND).strength(0.5f, 0.5f)));
    public static final RegistrySupplier<Block> MUSTAFAR_STONE = BLOCKS.register("mustafar_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5f, 1f).requiresCorrectToolForDrops()));

    public static final RegistrySupplier<Block> BLASTER_UPGRADER = BLOCKS.register("blaster_upgrader", () -> new BlasterUpgraderBlock(IRON_PROPERTIES));

    public static final RegistrySupplier<Block> TATOOINE_STONE = BLOCKS.register("tatooine_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.SAND).strength(1.5f, 1f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> TATOOINE_STONE_STONE_STAIRS = BLOCKS.register("tatooine_stone_stairs", () -> new StairBlock(TATOOINE_STONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)));
    public static final RegistrySupplier<Block> TATOOINE_STONE_STONE_SLAB = BLOCKS.register("tatooine_stone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)));

}
