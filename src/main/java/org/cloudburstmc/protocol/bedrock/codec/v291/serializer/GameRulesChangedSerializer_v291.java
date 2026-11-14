package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.GameRulesChangedPacket;

public class GameRulesChangedSerializer_v291 implements BedrockPacketSerializer<GameRulesChangedPacket> {
   public static final GameRulesChangedSerializer_v291 INSTANCE = new GameRulesChangedSerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, GameRulesChangedPacket packet) {
      helper.writeArray(buffer, packet.getGameRules(), helper::writeGameRule);
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, GameRulesChangedPacket packet) {
      helper.readArray(buffer, packet.getGameRules(), helper::readGameRule);
   }

   protected GameRulesChangedSerializer_v291() {
   }
}
