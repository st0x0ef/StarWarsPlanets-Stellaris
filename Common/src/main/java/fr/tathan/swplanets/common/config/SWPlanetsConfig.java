package fr.tathan.swplanets.common.config;

import com.teamresourceful.resourcefulconfig.api.annotations.Comment;
import com.teamresourceful.resourcefulconfig.api.annotations.Config;
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigEntry;
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigInfo;
import com.teamresourceful.resourcefulconfig.api.types.options.EntryType;
import fr.tathan.swplanets.common.config.info.SWPlanetsConfigInfo;


@ConfigInfo.Provider(SWPlanetsConfigInfo.class)
@Config(
        value = "swplanets"
)
public class SWPlanetsConfig {

    @ConfigEntry(
            id = "explosionUpgradeRadius",
            type = EntryType.FLOAT,
            translation = "config.swplanets.explosionUpgradeRadius"
    )
    @Comment("What should be the radius of the explosion for the laser when the blaster have the Explosion Upgrade.")
    public static float explosionUpgradeRadius = 2.0F;

    @ConfigEntry(
            id = "explosionUpgradeFire",
            type = EntryType.BOOLEAN,
            translation = "config.swplanets.explosionUpgradeFire"
    )
    @Comment("Should the explosion upgrade for the blaster set the world on fire?")
    public static boolean explosionUpgradeFire = false;

    @ConfigEntry(
            id = "maxBlasterEnergy",
            type = EntryType.LONG,
            translation = "config.swplanets.maxBlasterEnergy"
    )
    @Comment("What is the max energy a blaster can have ?")
    public static long maxBlasterEnergy = 10_000;


    @ConfigEntry(
            id = "lightSabersAttackModifier",
            type = EntryType.INTEGER,
            translation = "config.swplanets.lightSabersAttackModifier"
    )
    @Comment("What should be the attack modifier for the light sabers?")
    public static int lightSabersAttackModifier = 13;

}
