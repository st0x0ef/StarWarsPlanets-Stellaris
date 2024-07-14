package fr.tathan.swplanets.client.renderers.bantha;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.tathan.swplanets.Constants;
import fr.tathan.swplanets.common.entities.BanthaEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BanthaRenderer extends MobRenderer<BanthaEntity, BanthaModel> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Constants.MODID, "bantha"), "main");

	public BanthaRenderer(EntityRendererProvider.Context context) {
		super(context, new BanthaModel(context.bakeLayer(BanthaModel.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(BanthaEntity entity) {
		return new ResourceLocation(Constants.MODID, "textures/entity/bantha.png");
	}

	@Override
	protected void scale(BanthaEntity livingEntity, PoseStack poseStack, float partialTickTime) {
	}
}