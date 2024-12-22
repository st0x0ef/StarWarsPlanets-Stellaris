package com.st0x0ef.swplanets.common.registry;


import com.st0x0ef.swplanets.SWPlanets;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class LevelRegistry {
    public static final ResourceKey<Level> ENDOR_ORBIT;
    public static final ResourceKey<Level> HOTH_ORBIT;
    public static final ResourceKey<Level> MANDALORE_ORBIT;
    public static final ResourceKey<Level> TAOOINE_ORBIT;
    public static final ResourceKey<Level> MUSTAFAR_ORBIT;
    public static final ResourceKey<Level> ENDOR;
    public static final ResourceKey<Level> TATOOINE;
    public static final ResourceKey<Level> MUSTAFAR;
    public static final ResourceKey<Level> HOTH;
    public static final ResourceKey<Level> MANDALORE;

    static {
        ENDOR_ORBIT = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "endor_orbit"));
        HOTH_ORBIT = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "hot_orbit"));
        MANDALORE_ORBIT = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "mandalore_orbit"));
        TAOOINE_ORBIT = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "tatooine_orbit"));
        MUSTAFAR_ORBIT = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "mustafar_orbit"));
        ENDOR = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "endor"));
        TATOOINE = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "tatooine"));
        MUSTAFAR = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "mustafar"));
        HOTH = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "hot"));
        MANDALORE = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "mandalore"));
    }
}
