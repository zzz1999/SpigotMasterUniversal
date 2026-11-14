package com.nukkitx.protocol.bedrock.codec.v589.serializer;

import com.nukkitx.protocol.bedrock.codec.BedrockCodecHelper;
import com.nukkitx.protocol.bedrock.codec.v575.serializer.UnlockedRecipesSerializer_v575;
import com.nukkitx.protocol.bedrock.packet.UnlockedRecipesPacket;
import io.netty.buffer.ByteBuf;

public class UnlockedRecipesSerializer_v589 extends UnlockedRecipesSerializer_v575 {
   protected static final UnlockedRecipesPacket.ActionType[] ACTIONS = UnlockedRecipesPacket.ActionType.values();

   @Override
   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, UnlockedRecipesPacket packet) {
      buffer.writeIntLE(packet.getAction().ordinal());
      helper.writeArray(buffer, packet.getUnlockedRecipes(), helper::writeString);
   }

   @Override
   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, UnlockedRecipesPacket packet) {
      packet.setAction(ACTIONS[buffer.readIntLE()]);
      helper.readArray(buffer, packet.getUnlockedRecipes(), helper::readString);
   }
}
