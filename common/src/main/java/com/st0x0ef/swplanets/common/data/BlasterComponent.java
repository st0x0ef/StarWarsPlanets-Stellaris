package com.st0x0ef.swplanets.common.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record BlasterComponent(boolean zoom_upgrade, boolean explosion_upgrade) {
    public static final Codec<BlasterComponent> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.BOOL.fieldOf("zoom_upgrade").forGetter(BlasterComponent::zoom_upgrade),
            Codec.BOOL.fieldOf("explosion_upgrade").forGetter(BlasterComponent::explosion_upgrade)
    ).apply(instance, BlasterComponent::new));

    public static final StreamCodec<ByteBuf, BlasterComponent> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.BOOL, BlasterComponent::zoom_upgrade, ByteBufCodecs.BOOL, BlasterComponent::explosion_upgrade, BlasterComponent::new);
}
