package fr.tathan.swplanets.common.config;

import com.teamresourceful.resourcefulconfig.api.annotations.Comment;
import com.teamresourceful.resourcefulconfig.api.annotations.Config;
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigEntry;
import com.teamresourceful.resourcefulconfig.api.types.options.EntryType;

@Config(
        value = "swplanets"
)
public class CommonConfig {

    @ConfigEntry(
            id = "explosionUpgradeRadius",
            type = EntryType.FLOAT,
            translation = "config.stellaris.explosionUpgradeRadius"
    )
    @Comment("What should be the radius of the explosion for the laser when the blaster have the Explosion Upgrade.")
    public static float explosionUpgradeRadius = 2.0F;

    @ConfigEntry(
            id = "explosionUpgradeFire",
            type = EntryType.BOOLEAN,
            translation = "config.stellaris.explosionUpgradeFire"
    )
    @Comment("Should the explosion upgrade for the blaster set the world on fire?")
    public static boolean explosionUpgradeFire = false;

}
