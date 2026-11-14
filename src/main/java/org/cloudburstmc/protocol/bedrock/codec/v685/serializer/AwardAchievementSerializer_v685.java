package org.cloudburstmc.protocol.bedrock.codec.v685.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.AwardAchievementPacket;

public class AwardAchievementSerializer_v685 implements BedrockPacketSerializer<AwardAchievementPacket> {
   public static final AwardAchievementSerializer_v685 INSTANCE = new AwardAchievementSerializer_v685();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, AwardAchievementPacket packet) {
      buffer.writeIntLE(packet.getAchievementId());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, AwardAchievementPacket packet) {
      packet.setAchievementId(buffer.readIntLE());
   }

   protected AwardAchievementSerializer_v685() {
   }
}
