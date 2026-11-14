package org.cloudburstmc.protocol.bedrock.codec.v575.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.UnlockedRecipesPacket;

public class UnlockedRecipesSerializer_v575 implements BedrockPacketSerializer<UnlockedRecipesPacket> {
   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, UnlockedRecipesPacket packet) {
      buffer.writeBoolean(packet.getAction() == UnlockedRecipesPacket.ActionType.NEWLY_UNLOCKED);
      helper.writeArray(buffer, packet.getUnlockedRecipes(), helper::writeString);
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, UnlockedRecipesPacket packet) {
      packet.setAction(buffer.readBoolean() ? UnlockedRecipesPacket.ActionType.NEWLY_UNLOCKED : UnlockedRecipesPacket.ActionType.INITIALLY_UNLOCKED);
      helper.readArray(buffer, packet.getUnlockedRecipes(), helper::readString);
   }
}
