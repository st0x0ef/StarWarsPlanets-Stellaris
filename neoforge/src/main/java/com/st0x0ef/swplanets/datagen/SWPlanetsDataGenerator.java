package com.st0x0ef.swplanets.datagen;

import fr.tathan.swplanets.SWPlanets;
import fr.tathan.swplanets.datagen.provider.PlanetsRendererProvider;
import fr.tathan.swplanets.datagen.provider.base.StructureUpdater;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;


@Mod.EventBusSubscriber(modid = SWPlanets.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SWPlanetsDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();


        generator.addProvider(event.includeClient(), new PlanetsRendererProvider(packOutput));
        generator.addProvider(true, new StructureUpdater("structures", SWPlanets.MODID, existingFileHelper, packOutput));

    }
}
