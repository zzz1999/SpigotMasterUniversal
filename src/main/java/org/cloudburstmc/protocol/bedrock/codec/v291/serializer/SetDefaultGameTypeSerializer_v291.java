package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.SetDefaultGameTypePacket;
import org.cloudburstmc.protocol.common.util.VarInts;

public class SetDefaultGameTypeSerializer_v291 implements BedrockPacketSerializer<SetDefaultGameTypePacket> {
   public static final SetDefaultGameTypeSerializer_v291 INSTANCE = new SetDefaultGameTypeSerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, SetDefaultGameTypePacket packet) {
      VarInts.writeInt(buffer, packet.getGamemode());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, SetDefaultGameTypePacket packet) {
      packet.setGamemode(VarInts.readInt(buffer));
   }

   protected SetDefaultGameTypeSerializer_v291() {
   }
}
