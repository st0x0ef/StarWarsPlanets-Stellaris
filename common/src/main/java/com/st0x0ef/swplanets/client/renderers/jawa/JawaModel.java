package com.st0x0ef.swplanets.client.renderers.jawa;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.st0x0ef.swplanets.SWPlanets;
import com.st0x0ef.swplanets.common.entities.JawaEntity;
import com.st0x0ef.swplanets.common.entities.animation.ModAnimations;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class JawaModel extends HierarchicalModel<JawaEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "jawa"), "main");
	private final ModelPart Model;

	public JawaModel(ModelPart root) {
		this.Model = root.getChild("Model");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Model = partdefinition.addOrReplaceChild("Model", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Body = Model.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, -10.0F, 0.0F));

		PartDefinition h_head = Body.addOrReplaceChild("h_head", CubeListBuilder.create().texOffs(0, 15).addBox(-4.0F, -7.0F, -2.5F, 8.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 0.5F));

		PartDefinition Cloak = h_head.addOrReplaceChild("Cloak", CubeListBuilder.create().texOffs(38, 31).addBox(-5.0F, -23.0F, -3.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(38, 22).addBox(3.0F, -23.0F, -3.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(-0.002F))
				.texOffs(0, 37).addBox(-4.0F, -24.0F, -3.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(-0.002F))
				.texOffs(36, 10).addBox(-3.0F, -25.0F, -3.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.002F))
				.texOffs(36, 0).addBox(1.0F, -25.0F, -3.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(-0.002F))
				.texOffs(21, 8).addBox(-2.0F, -26.0F, -3.0F, 4.0F, 2.0F, 7.0F, new CubeDeformation(0.003F))
				.texOffs(19, 20).addBox(-2.0F, -24.0F, -3.0F, 6.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(29, 35).addBox(4.0F, -21.0F, -3.0F, 1.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(20, 29).addBox(-5.0F, -21.0F, -3.0F, 1.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 27).addBox(-4.0F, -22.0F, 3.0F, 8.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(47, 0).addBox(-1.0F, -27.0F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(11, 37).addBox(-1.0F, -28.0F, 3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(36, 2).addBox(-2.0F, -27.0F, 2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(20, 29).addBox(1.0F, -27.0F, 2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(21, 17).addBox(-1.0F, -27.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(21, 0).addBox(-4.0F, -15.0F, -3.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(-0.002F)), PartPose.offset(0.0F, 15.0F, -0.5F));

		PartDefinition Torso = Body.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -15.0F, -2.0F, 8.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 0.0F));

		PartDefinition ToolBelt = Torso.addOrReplaceChild("ToolBelt", CubeListBuilder.create().texOffs(39, 0).addBox(3.0F, -15.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 39).addBox(2.0F, -15.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(38, 35).addBox(2.0F, -14.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(38, 25).addBox(1.0F, -14.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(38, 23).addBox(1.0F, -13.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(38, 21).addBox(0.0F, -13.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(38, 19).addBox(0.0F, -12.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 38).addBox(-1.0F, -12.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 37).addBox(-2.0F, -12.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(36, 31).addBox(-2.0F, -13.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(36, 13).addBox(-1.0F, -13.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(36, 11).addBox(-4.0F, -9.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(36, 9).addBox(-4.0F, -10.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(23, 34).addBox(-3.0F, -10.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(20, 33).addBox(-3.0F, -11.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(29, 31).addBox(-2.0F, -11.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(30, 18).addBox(-4.0F, -8.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(29, 29).addBox(-5.0F, -7.0F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(29, 29).addBox(-4.0F, -7.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(27, 17).addBox(-4.0F, -8.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(21, 2).addBox(-3.0F, -8.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(26, 2).addBox(-3.0F, -12.0F, 3.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 17).addBox(1.0F, -12.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 15).addBox(1.0F, -13.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 2).addBox(2.0F, -13.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(2.0F, -14.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftLeg = Body.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 46).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 5.0F, 0.5F));

		PartDefinition RightLeg = Body.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(47, 9).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 5.0F, 0.5F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(4.0F, -4.0F, 0.0F));

		PartDefinition cube_r1 = LeftArm.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(15, 43).addBox(0.0F, 0.0F, -2.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -0.6109F, 0.0F, 0.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(-4.0F, -4.0F, 0.0F));

		PartDefinition cube_r2 = RightArm.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(45, 40).addBox(-3.0F, 0.0F, -2.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -0.6109F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(JawaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animateWalk(ModAnimations.JAWA_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((JawaEntity) entity).idleAnimationState, ModAnimations.JAWA_IDLE, ageInTicks, 1f);

		this.animate(((JawaEntity) entity).dieAnimationState, ModAnimations.JAWA_DEATH, ageInTicks, 1f);
		this.animate(entity.tradeAnimationState, ModAnimations.JAWA_TRADING, ageInTicks, 1f);

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		Model.render(poseStack, buffer, packedLight, packedOverlay, color);
	}

	@Override
	public ModelPart root() {
		return Model;
	}
}