package com.nukkitx.protocol.bedrock.codec.v534.serializer;

import com.nukkitx.protocol.bedrock.codec.BedrockCodecHelper;
import com.nukkitx.protocol.bedrock.codec.BedrockPacketSerializer;
import com.nukkitx.protocol.bedrock.packet.DeathInfoPacket;
import io.netty.buffer.ByteBuf;

public class DeathInfoSerializer_v534 implements BedrockPacketSerializer<DeathInfoPacket> {
   public static final DeathInfoSerializer_v534 INSTANCE = new DeathInfoSerializer_v534();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, DeathInfoPacket packet) {
      helper.writeString(buffer, packet.getCauseAttackName());
      helper.writeArray(buffer, packet.getMessageList(), helper::writeString);
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, DeathInfoPacket packet) {
      packet.setCauseAttackName(helper.readString(buffer));
      helper.readArray(buffer, packet.getMessageList(), helper::readString);
   }

   protected DeathInfoSerializer_v534() {
   }
}
