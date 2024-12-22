package com.st0x0ef.swplanets.client.renderers.jawa;

import com.st0x0ef.swplanets.SWPlanets;
import com.st0x0ef.swplanets.common.entities.JawaEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class JawaRenderer extends MobRenderer<JawaEntity, JawaModel> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "jawa"), "main");

	public JawaRenderer(EntityRendererProvider.Context context) {
		super(context, new JawaModel(context.bakeLayer(JawaModel.LAYER_LOCATION)), 0.5f);
	}


	@Override
	public ResourceLocation getTextureLocation(JawaEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "textures/entity/jawa.png");
	}
}