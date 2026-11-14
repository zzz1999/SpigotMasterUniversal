package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.SetDifficultyPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

public class SetDifficultySerializer_v291 implements BedrockPacketSerializer<SetDifficultyPacket> {
   public static final SetDifficultySerializer_v291 INSTANCE = new SetDifficultySerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, SetDifficultyPacket packet) {
      VarInts.writeUnsignedInt(buffer, packet.getDifficulty());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, SetDifficultyPacket packet) {
      packet.setDifficulty(VarInts.readUnsignedInt(buffer));
   }

   protected SetDifficultySerializer_v291() {
   }
}
