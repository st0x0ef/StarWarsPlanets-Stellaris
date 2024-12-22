package com.st0x0ef.swplanets.common.util;

import com.st0x0ef.swplanets.SWPlanets;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class PlanetRenderUtil {

    public static final ResourceLocation OUTER_RIMS = ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "outer_rims");

    public static final ResourceLocation ENDOR = ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "textures/sky/endor.png");
    public static final ResourceLocation HOTH = ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "textures/sky/hot.png");
    public static final ResourceLocation MANDALORE = ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "textures/sky/mandalore.png");
    public static final ResourceLocation MUSTAFAR = ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "textures/sky/mustafar.png");
    public static final ResourceLocation TATOOINE = ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "textures/sky/tatooine.png");
    public static final ResourceLocation DEATH_STAR = ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "textures/sky/deathstar.png");

    public static final List<ResourceLocation> STAR_WARS_PLANETS_TEXTURES = List.of(
            MUSTAFAR,
            TATOOINE,
            MANDALORE,
            ENDOR,
            HOTH
    );
}
