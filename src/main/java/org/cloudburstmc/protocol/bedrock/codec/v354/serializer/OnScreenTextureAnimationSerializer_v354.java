package org.cloudburstmc.protocol.bedrock.codec.v354.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.OnScreenTextureAnimationPacket;

public class OnScreenTextureAnimationSerializer_v354 implements BedrockPacketSerializer<OnScreenTextureAnimationPacket> {
   public static final OnScreenTextureAnimationSerializer_v354 INSTANCE = new OnScreenTextureAnimationSerializer_v354();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, OnScreenTextureAnimationPacket packet) {
      buffer.writeIntLE((int)packet.getEffectId());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, OnScreenTextureAnimationPacket packet) {
      packet.setEffectId(buffer.readUnsignedIntLE());
   }

   protected OnScreenTextureAnimationSerializer_v354() {
   }
}
