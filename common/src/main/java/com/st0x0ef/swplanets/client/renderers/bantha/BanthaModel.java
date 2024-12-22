package com.st0x0ef.swplanets.client.renderers.bantha;// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.st0x0ef.swplanets.SWPlanets;
import com.st0x0ef.swplanets.common.entities.BanthaEntity;
import com.st0x0ef.swplanets.common.entities.animation.BanthaAnimation;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class BanthaModel extends HierarchicalModel<BanthaEntity> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SWPlanets.MODID, "bantha"), "main");

	private final ModelPart Model;
	private final ModelPart Body;
	private final ModelPart Body_Tail;
	private final ModelPart Body_Tail_Upper;
	private final ModelPart Body_Tail_Middle;
	private final ModelPart Body_Tail_Lower;
	private final ModelPart Body_Torso;
	private final ModelPart Ass;
	private final ModelPart Torso;
	private final ModelPart Neck;
	private final ModelPart Legs_Front;
	private final ModelPart Legs_Front_Right;
	private final ModelPart Legs_Front_Right_Upper;
	private final ModelPart Legs_Front_Right_Lower;
	private final ModelPart Legs_Front_Left;
	private final ModelPart Legs_Front_Left_Upper;
	private final ModelPart Legs_Front_Left_Lower;
	private final ModelPart Legs_Hind;
	private final ModelPart Legs_Hind_Right;
	private final ModelPart Legs_Hind_Right_Upper;
	private final ModelPart Legs_Hind_Right_Lower;
	private final ModelPart Legs_Hind_Left;
	private final ModelPart Legs_Hind_Left_Lower;
	private final ModelPart Legs_Hind_Left_Upper;
	private final ModelPart Head;
	private final ModelPart Head_Upper;
	private final ModelPart Horns;
	private final ModelPart Head_Mouth;
	private final ModelPart Head_Mouth_Upper;
	private final ModelPart Head_Mouth_Lower;
	private final ModelPart Head_Mouth_Lower_Lowest;
	private final ModelPart Nose;

	public BanthaModel(ModelPart root) {
		this.Model = root.getChild("Model");
		this.Body = Model.getChild("Body");
		this.Body_Tail = Body.getChild("Body_Tail");
		this.Body_Tail_Upper = Body_Tail.getChild("Body_Tail_Upper");
		this.Body_Tail_Middle = Body_Tail.getChild("Body_Tail_Middle");
		this.Body_Tail_Lower = Body_Tail.getChild("Body_Tail_Lower");
		this.Body_Torso = Body.getChild("Body_Torso");
		this.Ass = Body_Torso.getChild("Ass");
		this.Torso = Body_Torso.getChild("Torso");
		this.Neck = Body_Torso.getChild("Neck");

		this.Legs_Front = Body.getChild("Legs_Front");
		this.Legs_Front_Right = Legs_Front.getChild("Legs_Front_Right");
		this.Legs_Front_Right_Upper = Legs_Front_Right.getChild("Legs_Front_Right_Upper");
		this.Legs_Front_Right_Lower = Legs_Front_Right.getChild("Legs_Front_Right_Lower");

		this.Legs_Front_Left = Legs_Front.getChild("Legs_Front_Left");
		this.Legs_Front_Left_Upper = Legs_Front_Left.getChild("Legs_Front_Left_Upper");
		this.Legs_Front_Left_Lower = Legs_Front_Left.getChild("Legs_Front_Left_Lower");

		this.Legs_Hind = Body.getChild("Legs_Hind");
		this.Legs_Hind_Right = Legs_Hind.getChild("Legs_Hind_Right");
		this.Legs_Hind_Right_Upper = Legs_Hind_Right.getChild("Legs_Hind_Right_Upper");
		this.Legs_Hind_Right_Lower = Legs_Hind_Right.getChild("Legs_Hind_Right_Lower");

		this.Legs_Hind_Left = Legs_Hind.getChild("Legs_Hind_Left");
		this.Legs_Hind_Left_Lower = Legs_Hind_Left.getChild("Legs_Hind_Left_Lower");
		this.Legs_Hind_Left_Upper = Legs_Hind_Left.getChild("Legs_Hind_Left_Upper");

		this.Head = Model.getChild("Head");
		this.Head_Upper = Head.getChild("Head_Upper");
		this.Horns = Head_Upper.getChild("Horns");
		this.Head_Mouth = Head.getChild("Head_Mouth");
		this.Head_Mouth_Upper = Head_Mouth.getChild("Head_Mouth_Upper");
		this.Head_Mouth_Lower = Head_Mouth.getChild("Head_Mouth_Lower");
		this.Head_Mouth_Lower_Lowest = Head_Mouth_Lower.getChild("Head_Mouth_Lower_Lowest");
		this.Nose = Head.getChild("Nose");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Model = partdefinition.addOrReplaceChild("Model", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Body = Model.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Body_Tail = Body.addOrReplaceChild("Body_Tail", CubeListBuilder.create(), PartPose.offset(-0.0125F, -0.5285F, 6.3352F));

		PartDefinition Body_Tail_Upper = Body_Tail.addOrReplaceChild("Body_Tail_Upper", CubeListBuilder.create(), PartPose.offset(0.0125F, -2.3088F, -2.7735F));

		PartDefinition cube_r1 = Body_Tail_Upper.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(20, 57).mirror().addBox(-1.5F, -2.0F, -1.5F, 3.0F, 4.075F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Body_Tail_Middle = Body_Tail.addOrReplaceChild("Body_Tail_Middle", CubeListBuilder.create(), PartPose.offset(0.0126F, -0.0205F, -1.9773F));

		PartDefinition cube_r2 = Body_Tail_Middle.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(5, 53).addBox(-1.4375F, -1.3125F, -0.3125F, 2.875F, 2.675F, 0.725F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0455F, -0.0325F, 1.4137F, 0.0F, 0.0F));

		PartDefinition Body_Tail_Lower = Body_Tail.addOrReplaceChild("Body_Tail_Lower", CubeListBuilder.create(), PartPose.offset(0.0203F, 0.2434F, 0.4466F));

		PartDefinition cube_r3 = Body_Tail_Lower.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(5, 57).mirror().addBox(-1.3625F, -1.6125F, -0.0875F, 2.75F, 2.325F, 0.65F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.0125F, -0.2434F, -0.4469F, -1.5839F, 0.0F, 0.0F));

		PartDefinition Body_Torso = Body.addOrReplaceChild("Body_Torso", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Ass = Body_Torso.addOrReplaceChild("Ass", CubeListBuilder.create().texOffs(45, 37).addBox(-2.0F, -1.875F, -1.1375F, 4.0F, 3.75F, 2.275F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.125F, 1.0625F));

		PartDefinition Torso = Body_Torso.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(25, 45).addBox(-2.4F, -2.6375F, -1.5062F, 4.8F, 4.4F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(2, 45).addBox(-2.65F, -1.6375F, -1.6562F, 5.3F, 4.15F, 3.325F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.7125F, -1.5187F));

		PartDefinition Neck = Body_Torso.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(45, 44).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.25F, -3.925F));

		PartDefinition Legs_Front = Body.addOrReplaceChild("Legs_Front", CubeListBuilder.create(), PartPose.offset(2.85F, -1.075F, -4.15F));

		PartDefinition Legs_Front_Right = Legs_Front.addOrReplaceChild("Legs_Front_Right", CubeListBuilder.create(), PartPose.offset(-5.7F, 0.0F, 0.0F));

		PartDefinition Legs_Front_Right_Upper = Legs_Front_Right.addOrReplaceChild("Legs_Front_Right_Upper", CubeListBuilder.create(), PartPose.offset(0.225F, -2.05F, 0.1F));

		PartDefinition cube_r4 = Legs_Front_Right_Upper.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(51, 57).mirror().addBox(-0.5F, -1.125F, -0.825F, 1.175F, 2.925F, 1.55F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0858F, 0.0159F, 0.1826F));

		PartDefinition Legs_Front_Right_Lower = Legs_Front_Right.addOrReplaceChild("Legs_Front_Right_Lower", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r5 = Legs_Front_Right_Lower.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(31, 54).mirror().addBox(-0.65F, -0.95F, -0.95F, 1.4F, 1.95F, 1.775F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.0087F, 0.0F));

		PartDefinition Legs_Front_Left = Legs_Front.addOrReplaceChild("Legs_Front_Left", CubeListBuilder.create(), PartPose.offset(-0.225F, -2.05F, 0.1F));

		PartDefinition Legs_Front_Left_Upper = Legs_Front_Left.addOrReplaceChild("Legs_Front_Left_Upper", CubeListBuilder.create(), PartPose.offset(-0.0245F, 0.3421F, -0.0801F));

		PartDefinition cube_r6 = Legs_Front_Left_Upper.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(51, 57).addBox(-0.675F, -1.125F, -0.825F, 1.175F, 2.925F, 1.55F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0245F, -0.3421F, 0.0801F, -0.0858F, -0.0159F, -0.1826F));

		PartDefinition Legs_Front_Left_Lower = Legs_Front_Left.addOrReplaceChild("Legs_Front_Left_Lower", CubeListBuilder.create(), PartPose.offset(0.225F, 2.05F, -0.1F));

		PartDefinition cube_r7 = Legs_Front_Left_Lower.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(31, 54).addBox(-0.75F, -0.95F, -0.95F, 1.4F, 1.95F, 1.775F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0087F, 0.0F));

		PartDefinition Legs_Hind = Body.addOrReplaceChild("Legs_Hind", CubeListBuilder.create(), PartPose.offset(2.85F, -1.075F, 1.175F));

		PartDefinition Legs_Hind_Right = Legs_Hind.addOrReplaceChild("Legs_Hind_Right", CubeListBuilder.create(), PartPose.offset(-5.7F, 0.0F, 0.0F));

		PartDefinition Legs_Hind_Right_Upper = Legs_Hind_Right.addOrReplaceChild("Legs_Hind_Right_Upper", CubeListBuilder.create(), PartPose.offset(0.225F, -2.05F, 0.1F));

		PartDefinition cube_r8 = Legs_Hind_Right_Upper.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(51, 51).mirror().addBox(-0.5F, -1.125F, -0.825F, 1.175F, 2.525F, 1.55F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0858F, -0.0015F, 0.1841F));

		PartDefinition Legs_Hind_Right_Lower = Legs_Hind_Right.addOrReplaceChild("Legs_Hind_Right_Lower", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r9 = Legs_Hind_Right_Lower.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(50, 10).addBox(-0.65F, -0.95F, -0.95F, 1.4F, 1.95F, 1.775F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.0087F, 0.0F));

		PartDefinition Legs_Hind_Left = Legs_Hind.addOrReplaceChild("Legs_Hind_Left", CubeListBuilder.create(), PartPose.offset(-0.225F, -2.05F, 0.1F));

		PartDefinition Legs_Hind_Left_Lower = Legs_Hind_Left.addOrReplaceChild("Legs_Hind_Left_Lower", CubeListBuilder.create(), PartPose.offset(0.225F, 2.05F, -0.1F));

		PartDefinition cube_r10 = Legs_Hind_Left_Lower.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(31, 54).addBox(-0.75F, -0.95F, -0.95F, 1.4F, 1.95F, 1.775F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0087F, 0.0F));

		PartDefinition Legs_Hind_Left_Upper = Legs_Hind_Left.addOrReplaceChild("Legs_Hind_Left_Upper", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r11 = Legs_Hind_Left_Upper.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(51, 51).addBox(-0.675F, -1.125F, -0.825F, 1.175F, 2.525F, 1.55F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0858F, 0.0015F, -0.1841F));

		PartDefinition Head = Model.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, -6.0F));

		PartDefinition Head_Upper = Head.addOrReplaceChild("Head_Upper", CubeListBuilder.create(), PartPose.offset(0.0F, -0.5449F, -0.2055F));

		PartDefinition cube_r12 = Head_Upper.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(26, 39).addBox(-0.95F, -0.7F, -1.125F, 2.0F, 1.25F, 1.75F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -0.1998F, -0.1688F, -0.5659F, 0.0151F, 0.1739F));

		PartDefinition cube_r13 = Head_Upper.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(48, 30).addBox(-0.85F, -1.5F, -0.75F, 1.825F, 3.25F, 2.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0125F, 0.5397F, 0.2866F, 0.0F, 0.5454F, 0.0F));

		PartDefinition cube_r14 = Head_Upper.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(48, 30).addBox(-0.975F, -1.5F, -0.75F, 1.825F, 3.25F, 2.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0125F, 0.5397F, 0.2866F, 0.0F, -0.5454F, 0.0F));

		PartDefinition cube_r15 = Head_Upper.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(26, 39).addBox(-1.05F, -0.7F, -1.125F, 2.0F, 1.25F, 1.75F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -0.1998F, -0.1688F, -0.5659F, -0.0151F, -0.1739F));

		PartDefinition cube_r16 = Head_Upper.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(39, 53).addBox(-1.5F, -0.625F, -0.375F, 3.0F, 1.975F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.2709F, -0.3544F, -1.2043F, 0.0F, 0.0F));

		PartDefinition Horns = Head_Upper.addOrReplaceChild("Horns", CubeListBuilder.create(), PartPose.offset(0.0F, 4.5397F, 6.2116F));

		PartDefinition cube_r17 = Horns.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(12, 40).addBox(0.5F, -4.75F, -8.0F, 1.0F, 2.0F, 1.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.05F, -0.4F, -0.3491F, 0.0F, -0.48F));

		PartDefinition cube_r18 = Horns.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(7, 41).addBox(0.75F, 3.25F, -7.75F, 0.75F, 1.5F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.05F, -0.4F, -0.9835F, -0.7173F, -1.4035F));

		PartDefinition cube_r19 = Horns.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(13, 38).addBox(-1.0F, 3.0F, -7.75F, 1.75F, 0.75F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.05F, -0.4F, -0.9835F, -0.7173F, -1.4035F));

		PartDefinition cube_r20 = Horns.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(3, 41).mirror().addBox(-2.25F, 3.0F, -7.5F, 0.75F, 1.25F, 0.75F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.05F, -0.4F, -0.8068F, -0.9229F, -1.6434F));

		PartDefinition cube_r21 = Horns.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(3, 41).addBox(1.5F, 3.0F, -7.5F, 0.75F, 1.25F, 0.75F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.05F, -0.4F, -0.8068F, 0.9229F, 1.6434F));

		PartDefinition cube_r22 = Horns.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(13, 38).mirror().addBox(-0.75F, 3.0F, -7.75F, 1.75F, 0.75F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(7, 41).addBox(-1.5F, 3.25F, -7.75F, 0.75F, 1.5F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.05F, -0.4F, -0.9835F, 0.7173F, 1.4035F));

		PartDefinition cube_r23 = Horns.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(12, 40).addBox(-1.5F, -4.75F, -8.0F, 1.0F, 2.0F, 1.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.05F, -0.4F, -0.3491F, 0.0F, 0.48F));

		PartDefinition Head_Mouth = Head.addOrReplaceChild("Head_Mouth", CubeListBuilder.create(), PartPose.offset(0.0F, 1.4843F, -1.0958F));

		PartDefinition Head_Mouth_Upper = Head_Mouth.addOrReplaceChild("Head_Mouth_Upper", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0255F, 0.6122F));

		PartDefinition cube_r24 = Head_Mouth_Upper.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(47, 23).addBox(-1.5F, -0.4375F, -0.525F, 3.0F, 0.875F, 1.725F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0255F, -0.6122F, -0.2269F, 0.0F, 0.0F));

		PartDefinition cube_r25 = Head_Mouth_Upper.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(40, 24).addBox(-0.2125F, -0.0875F, -1.1375F, 1.525F, 0.2F, 2.05F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0875F, -0.1261F, 0.1051F, -0.0962F, -0.0971F, 0.0839F));

		PartDefinition cube_r26 = Head_Mouth_Upper.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(40, 24).mirror().addBox(-1.3125F, -0.0875F, -1.1375F, 1.525F, 0.2F, 2.05F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.0875F, -0.1261F, 0.1051F, -0.0962F, 0.0971F, -0.0839F));

		PartDefinition cube_r27 = Head_Mouth_Upper.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(48, 16).mirror().addBox(-1.4125F, -0.4875F, -0.9125F, 2.7F, 1.375F, 2.025F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0625F, -0.1011F, 0.1051F, -0.0654F, 0.0F, 0.0F));

		PartDefinition Head_Mouth_Lower = Head_Mouth.addOrReplaceChild("Head_Mouth_Lower", CubeListBuilder.create(), PartPose.offset(0.0F, 0.8469F, 0.3702F));

		PartDefinition cube_r28 = Head_Mouth_Lower.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(38, 22).addBox(-0.1875F, -0.0875F, -1.0625F, 1.575F, 0.2F, 1.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0875F, -0.7474F, 0.147F, 0.0044F, -0.0876F, 0.0738F));

		PartDefinition cube_r29 = Head_Mouth_Lower.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(38, 22).addBox(-1.3875F, -0.0875F, -1.0625F, 1.575F, 0.2F, 1.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0875F, -0.7474F, 0.147F, 0.0044F, 0.0876F, -0.0738F));

		PartDefinition cube_r30 = Head_Mouth_Lower.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(48, 27).addBox(-1.375F, 0.125F, -1.425F, 2.5F, 1.05F, 1.625F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.125F, -0.9384F, 0.6321F, 0.0873F, 0.0F, 0.0F));

		PartDefinition Head_Mouth_Lower_Lowest = Head_Mouth_Lower.addOrReplaceChild("Head_Mouth_Lower_Lowest", CubeListBuilder.create(), PartPose.offset(0.0F, 0.7277F, 0.0723F));

		PartDefinition cube_r31 = Head_Mouth_Lower_Lowest.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(36, 17).addBox(-0.75F, -1.9F, -6.175F, 1.5F, 0.75F, 0.7F, new CubeDeformation(0.0F))
		.texOffs(37, 35).addBox(-1.05F, -2.75F, -6.35F, 2.1F, 1.0F, 1.4F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.9411F, 5.9782F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Nose = Head.addOrReplaceChild("Nose", CubeListBuilder.create(), PartPose.offset(0.0F, 0.7831F, -1.0576F));

		PartDefinition cube_r32 = Nose.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(2, 37).addBox(-0.125F, -0.025F, 0.2875F, 0.425F, 0.4F, 0.375F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0875F, -0.496F, -0.2118F, -0.5454F, 0.0F, 0.0F));

		PartDefinition cube_r33 = Nose.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(6, 35).mirror().addBox(-0.35F, 0.35F, 0.0375F, 0.775F, 0.425F, 0.375F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.0375F, -0.496F, -0.2118F, -0.2007F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}


	@Override
	public ModelPart root() {
		return Body;
	}

	@Override
	public void setupAnim(BanthaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animateWalk(BanthaAnimation.run, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(entity.idleAnimationState, BanthaAnimation.idle, ageInTicks, 1f);
		this.animate(entity.sitAnimationState, BanthaAnimation.liedown, ageInTicks, 1f);
		this.animate(entity.sitUpAnimationState, BanthaAnimation.standup, ageInTicks, 1f);
		this.animate(entity.sitPoseAnimationState, BanthaAnimation.idlelying, ageInTicks, 1f);

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		poseStack.pushPose();
		poseStack.scale(5, 5, 5);
		poseStack.translate(0, -1.2, 0);
		Model.render(poseStack, buffer, packedLight, packedOverlay, color);
		poseStack.popPose();
	}
}