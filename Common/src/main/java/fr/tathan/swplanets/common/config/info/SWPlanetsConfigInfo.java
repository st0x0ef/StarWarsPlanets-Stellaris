package fr.tathan.swplanets.common.config.info;

import com.teamresourceful.resourcefulconfig.api.types.info.ResourcefulConfigColor;
import com.teamresourceful.resourcefulconfig.api.types.info.ResourcefulConfigInfo;
import com.teamresourceful.resourcefulconfig.api.types.info.ResourcefulConfigLink;
import com.teamresourceful.resourcefulconfig.api.types.options.TranslatableValue;
import earth.terrarium.adastra.common.config.info.AdAstraConfigColor;

public class SWPlanetsConfigInfo implements ResourcefulConfigInfo {
    @Override
    public TranslatableValue title() {
        return new TranslatableValue(
                "Star Wars Planets",
                "config.swplanets.title"
        );

    }

    @Override
    public TranslatableValue description() {
        return new TranslatableValue(
                "May the force be with you.",
                "config.swplanets.description"
        );
    }

    @Override
    public String icon() {
        return "planet";
    }

    @Override
    public ResourcefulConfigColor color() {
        return AdAstraConfigColor.INSTANCE;
    }

    @Override
    public ResourcefulConfigLink[] links() {
        return SWPlanetsLink.LINKS;
    }

    @Override
    public boolean isHidden() {
        return false;
    }
}
