package org.cloudburstmc.protocol.bedrock.codec.v534.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.DeathInfoPacket;

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
