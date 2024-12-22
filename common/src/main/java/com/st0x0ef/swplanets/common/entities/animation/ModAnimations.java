package com.st0x0ef.swplanets.common.entities.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class ModAnimations {

    public static final AnimationDefinition JAWA_WALK = AnimationDefinition.Builder.withLength(0.7083434f).looping()
            .addAnimation("Model",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5416766f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.7083434f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("h_head",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0.25f, KeyframeAnimations.posVec(0f, -1f, 3f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("h_head",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.25f, KeyframeAnimations.degreeVec(-15f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("Torso",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.25f, KeyframeAnimations.degreeVec(-10f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("LeftLeg",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.7083434f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("LeftLeg",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.degreeVec(-20f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(30f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.7083434f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("RightLeg",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.7083434f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("RightLeg",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.16766666f, KeyframeAnimations.degreeVec(15f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.4583433f, KeyframeAnimations.degreeVec(-17.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.7083434f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("LeftArm",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, -1f, 3f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.7083434f, KeyframeAnimations.posVec(0f, -1f, 3f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("LeftArm",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(47.5f, 0f, -45f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.4583433f, KeyframeAnimations.degreeVec(-30f, 0f, -45f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5416766f, KeyframeAnimations.degreeVec(-17.5f, 0f, -45f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.7083434f, KeyframeAnimations.degreeVec(47.5f, 0f, -45f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("RightArm",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, -1f, 3f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.7083434f, KeyframeAnimations.posVec(0f, -1f, 3f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("RightArm",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(-45f, 0f, 45f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5416766f, KeyframeAnimations.degreeVec(22.5f, 0f, 45f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.7083434f, KeyframeAnimations.degreeVec(-45f, 0f, 45f),
                                    AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition JAWA_IDLE = AnimationDefinition.Builder.withLength(2f).looping()
            .addAnimation("LeftArm",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("LeftArm",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(35f, 7f, -10f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(32f, 15.37f, -22f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2f, KeyframeAnimations.degreeVec(35f, 7f, -10f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("RightArm",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(35f, 7f, 10f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(35f, -15.37f, 22f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2f, KeyframeAnimations.degreeVec(35f, 7f, 10f),
                                    AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition JAWA_DEATH = AnimationDefinition.Builder.withLength(0.625f)
            .addAnimation("Body",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.posVec(0f, 1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.625f, KeyframeAnimations.posVec(0f, -8f, 7f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("Body",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.degreeVec(-5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.625f, KeyframeAnimations.degreeVec(-85f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("LeftLeg",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("LeftLeg",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.degreeVec(-10f, 0f, -15f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("RightLeg",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("RightLeg",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.degreeVec(10f, 0f, 15f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("LeftArm",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.posVec(2f, -3f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.625f, KeyframeAnimations.posVec(1f, -3f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("LeftArm",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, -130f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.625f, KeyframeAnimations.degreeVec(37.5f, 0f, -130f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("RightArm",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.posVec(-2f, -3f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.625f, KeyframeAnimations.posVec(-1f, -3f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("RightArm",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 130f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.625f, KeyframeAnimations.degreeVec(37.5f, 0f, 130f),
                                    AnimationChannel.Interpolations.LINEAR))).build();

    public static final AnimationDefinition JAWA_TRADING = AnimationDefinition.Builder.withLength(1f)
            .addAnimation("h_head",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, -7.5f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.7083434f, KeyframeAnimations.degreeVec(0f, 2.5f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("RightArm",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.degreeVec(-150f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.4583433f, KeyframeAnimations.degreeVec(-140f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.625f, KeyframeAnimations.degreeVec(-162.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR))).build();
}
