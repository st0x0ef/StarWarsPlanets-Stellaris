package com.st0x0ef.swplanets.client.renderers.clone_armors;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class CloneTrooper extends HumanoidModel<LivingEntity> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("swplanets", "clonetrooper"), "main");
	private final ModelPart bone;
	private final ModelPart leftLeg;
	private final ModelPart rightLeg;
	private final ModelPart body;
	private final ModelPart bone5;
	private final ModelPart leftArm;
	private final ModelPart rightArm;
	private final ModelPart head;
	private final ModelPart bone2;

	private final HumanoidModel<LivingEntity> parentModel;
	private final EquipmentSlot slot;


	public CloneTrooper(ModelPart root, EquipmentSlot slot, ItemStack stack, @Nullable HumanoidModel<LivingEntity> parentModel) {
		super(root, RenderType::entityCutout);
		this.parentModel = parentModel;

		this.bone = root.getChild("bone");
		this.leftLeg = this.bone.getChild("right_leg");
		this.rightLeg = this.bone.getChild("left_leg");
		this.body = this.bone.getChild("body");
		this.bone5 = this.body.getChild("bone5");
		this.leftArm = this.bone.getChild("left_arm");
		this.rightArm = this.bone.getChild("right_arm");
		this.head = this.bone.getChild("head");
		this.bone2 = this.head.getChild("bone2");
		this.slot = slot;

		this.setVisible();
	}



	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition LeftLeg = bone.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(58, 17).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(1.9F, 7.0F, 0.0F));

		PartDefinition RightLeg = bone.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 65).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(17, 65).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(-1.9F, 7.0F, 0.0F));

		PartDefinition Body = bone.addOrReplaceChild("body", CubeListBuilder.create().texOffs(33, 0).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(33, 17).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.25F))
		.texOffs(54, 41).addBox(-3.0F, -12.0F, 2.0F, 6.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));

		PartDefinition bone5 = Body.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(54, 34).addBox(1.0F, -1.5F, -3.75F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.35F))
		.texOffs(69, 41).addBox(8.75F, -2.0F, -2.75F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(75, 8).addBox(0.25F, -2.0F, -2.75F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(68, 56).addBox(1.25F, -2.0F, -4.5F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(75, 0).addBox(6.75F, -2.0F, -4.5F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(72, 72).addBox(7.0F, -2.0F, -3.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(72, 64).addBox(1.0F, -2.0F, -3.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -1.25F, 1.75F));

		PartDefinition LeftArm = bone.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(17, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(34, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F))
		.texOffs(34, 65).addBox(-0.25F, -2.75F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -3.0F, 0.0F));

		PartDefinition RightArm = bone.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(17, 48).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(34, 48).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)).mirror(false)
		.texOffs(34, 65).mirror().addBox(-3.75F, -2.75F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, -3.0F, 0.0F));

		PartDefinition Head = bone.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 17).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

		PartDefinition bone2 = Head.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 34).addBox(-1.75F, -1.1567F, -4.6613F, 3.0F, 3.0F, 10.0F, new CubeDeformation(-0.25F))
		.texOffs(27, 34).addBox(-8.75F, -1.1567F, -4.6613F, 3.0F, 3.0F, 10.0F, new CubeDeformation(-0.25F)), PartPose.offset(3.75F, -0.4933F, -0.5887F));

		return LayerDefinition.create(meshdefinition, 96, 96);
	}

	@Override
	protected Iterable<ModelPart> headParts() {
		return ImmutableList.of(head);
	}

	@Override
	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of(body, rightArm, leftArm, rightLeg, leftLeg, hat);
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		parentModel.copyPropertiesTo(this);
	}

	private void setVisible() {
		this.setAllVisible(false);
		switch (this.slot) {
			case HEAD -> this.head.visible = true;
			case CHEST -> {
				this.body.visible = true;
				this.leftArm.visible = true;
				this.rightArm.visible = true;
			}
			case LEGS -> {
				this.leftLeg.visible = true;
				this.rightLeg.visible = true;
			}

		}
	}

}