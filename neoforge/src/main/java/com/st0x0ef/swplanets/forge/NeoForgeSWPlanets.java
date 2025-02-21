package com.st0x0ef.swplanets.forge;


import com.st0x0ef.swplanets.SWPlanets;
import com.st0x0ef.swplanets.common.entities.BanthaEntity;
import com.st0x0ef.swplanets.common.entities.JawaEntity;
import com.st0x0ef.swplanets.common.registry.EntityRegistry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@Mod(SWPlanets.MODID)
public class NeoForgeSWPlanets {

    public NeoForgeSWPlanets(IEventBus bus) {
        SWPlanets.LOG.info("Star Wars Planets 🚀!");

        SWPlanets.init();
        bus.addListener(NeoForgeSWPlanets::commonSetup);
        bus.addListener(NeoForgeSWPlanets::onAttributes);
    }

    public static void commonSetup(FMLCommonSetupEvent event) {
        SWPlanets.postInit();
    }

    public static void onAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityRegistry.JAWA.get(), JawaEntity.addAttributes().build());
        event.put(EntityRegistry.BANTHA.get(), BanthaEntity.addAttributes().build());
    }
}