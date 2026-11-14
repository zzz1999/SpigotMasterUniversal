package com.nukkitx.protocol.bedrock.codec.v419.serializer;

import com.nukkitx.protocol.bedrock.codec.BedrockCodecHelper;
import com.nukkitx.protocol.bedrock.codec.BedrockPacketSerializer;
import com.nukkitx.protocol.bedrock.packet.PlayerFogPacket;
import io.netty.buffer.ByteBuf;

public class PlayerFogSerializer_v419 implements BedrockPacketSerializer<PlayerFogPacket> {
   public static final PlayerFogSerializer_v419 INSTANCE = new PlayerFogSerializer_v419();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, PlayerFogPacket packet) {
      helper.writeArray(buffer, packet.getFogStack(), (buf, hlp, fogEffect) -> hlp.writeString(buf, fogEffect));
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, PlayerFogPacket packet) {
      helper.readArray(buffer, packet.getFogStack(), (buf, hlp) -> hlp.readString(buf));
   }

   protected PlayerFogSerializer_v419() {
   }
}
