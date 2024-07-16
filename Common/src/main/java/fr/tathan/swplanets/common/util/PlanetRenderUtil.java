package fr.tathan.swplanets.common.util;

import earth.terrarium.adastra.AdAstra;
import earth.terrarium.adastra.client.utils.DimensionRenderingUtils;
import fr.tathan.swplanets.Constants;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class PlanetRenderUtil {

    public static final ResourceLocation OUTER_RIMS = new ResourceLocation(Constants.MODID, "outer_rims");

    public static final ResourceLocation ENDOR = new ResourceLocation(Constants.MODID, "textures/sky/endor.png");
    public static final ResourceLocation HOTH = new ResourceLocation(Constants.MODID, "textures/sky/hot.png");
    public static final ResourceLocation MANDALORE = new ResourceLocation(Constants.MODID, "textures/sky/mandalore.png");
    public static final ResourceLocation MUSTAFAR = new ResourceLocation(Constants.MODID, "textures/sky/mustafar.png");
    public static final ResourceLocation TATOOINE = new ResourceLocation(Constants.MODID, "textures/sky/tatooine.png");
    public static final ResourceLocation DEATH_STAR = new ResourceLocation(Constants.MODID, "textures/sky/deathstar.png");

    public static final List<ResourceLocation> STAR_WARS_PLANETS_TEXTURES = List.of(
            MUSTAFAR,
            TATOOINE,
            MANDALORE,
            ENDOR,
            HOTH
    );


}
