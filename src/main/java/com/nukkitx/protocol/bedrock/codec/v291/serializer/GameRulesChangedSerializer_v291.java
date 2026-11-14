package com.nukkitx.protocol.bedrock.codec.v291.serializer;

import com.nukkitx.protocol.bedrock.codec.BedrockCodecHelper;
import com.nukkitx.protocol.bedrock.codec.BedrockPacketSerializer;
import com.nukkitx.protocol.bedrock.packet.GameRulesChangedPacket;
import io.netty.buffer.ByteBuf;

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
