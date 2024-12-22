package com.st0x0ef.swplanets;

import com.st0x0ef.swplanets.common.registry.EntityRegistry;
import com.st0x0ef.swplanets.common.registry.TagsRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;

public class FabricSWPlanets implements ModInitializer {
	@Override
	public void onInitialize() {

		SWPlanets.LOG.info("Star Wars Planets 🚀!");
		SWPlanets.init();
		EntityRegistry.registerAttributes((type, builder) -> FabricDefaultAttributeRegistry.register(type.get(), builder.get()));


		BiomeModifications.addFeature(
				BiomeSelectors.tag(TagsRegistry.STARWARS_PLANETS),
				GenerationStep.Decoration.UNDERGROUND_ORES,
				ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "kyber_crystal_ore_deepslate"))
		);
		BiomeModifications.addFeature(
				BiomeSelectors.tag(TagsRegistry.TATOOINE_LIKE),
				GenerationStep.Decoration.UNDERGROUND_ORES,
				ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "kyber_crystal_ore_sandstone"))
		);
		BiomeModifications.addFeature(
				BiomeSelectors.tag(TagsRegistry.MANDALORE_BIOME),
				GenerationStep.Decoration.UNDERGROUND_ORES,
				ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "beskar_ore_sandstone"))
		);

		SWPlanets.postInit();
	}
}
