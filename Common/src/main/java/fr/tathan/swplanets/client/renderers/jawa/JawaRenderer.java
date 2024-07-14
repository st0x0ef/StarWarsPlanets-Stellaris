package fr.tathan.swplanets.client.renderers.jawa;

import fr.tathan.swplanets.Constants;
import fr.tathan.swplanets.common.entities.JawaEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class JawaRenderer extends MobRenderer<JawaEntity, JawaModel> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Constants.MODID, "jawa"), "main");

	public JawaRenderer(EntityRendererProvider.Context context) {
		super(context, new JawaModel(context.bakeLayer(JawaModel.LAYER_LOCATION)), 0.5f);
	}


	@Override
	public ResourceLocation getTextureLocation(JawaEntity entity) {
		return new ResourceLocation(Constants.MODID, "textures/entity/jawa.png");
	}
}