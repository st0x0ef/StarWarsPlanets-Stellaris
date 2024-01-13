package fr.tathan.swplanets.common.registry;

import fr.tathan.swplanets.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BlocksRegistry {

    public static final RegistrationProvider<Block> BLOCKS = RegistrationProvider.get(Registries.BLOCK, Constants.MODID);

    /** ORES */
    public static final RegistryObject<Block> CRYSTAL_KYBER_ORE = BLOCKS.register("kyber_crystal_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).sound(SoundType.STONE).strength(3.0F, 3.0F).explosionResistance(3).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CRYSTAL_KYBER_ORE_SANDSTONE = BLOCKS.register("kyber_crystal_ore_sandstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).sound(SoundType.STONE).strength(3.0F, 3.0F).explosionResistance(3).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> BESKAR_ORE_SANDSTONE = BLOCKS.register("beskar_ore_sandstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).sound(SoundType.STONE).strength(3.0F, 3.0F).explosionResistance(3).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MUSTAFAR_SAND = BLOCKS.register("mustafar_sand", () -> new FallingBlock(BlockBehaviour.Properties.copy(Blocks.SAND).sound(SoundType.SAND).strength(0.5f, 0.5f)));
    public static final RegistryObject<Block> MUSTAFAR_STONE = BLOCKS.register("mustafar_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE).strength(1.5f, 1f).requiresCorrectToolForDrops()));

    public static void init() {
    }

}