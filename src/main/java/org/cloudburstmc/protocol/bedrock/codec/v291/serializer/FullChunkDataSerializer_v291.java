package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.LevelChunkPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

public class FullChunkDataSerializer_v291 implements BedrockPacketSerializer<LevelChunkPacket> {
   public static final FullChunkDataSerializer_v291 INSTANCE = new FullChunkDataSerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, LevelChunkPacket packet) {
      VarInts.writeInt(buffer, packet.getChunkX());
      VarInts.writeInt(buffer, packet.getChunkZ());
      helper.writeByteBuf(buffer, packet.getData());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, LevelChunkPacket packet) {
      packet.setChunkX(VarInts.readInt(buffer));
      packet.setChunkZ(VarInts.readInt(buffer));
      packet.setData(helper.readByteBuf(buffer));
   }

   protected FullChunkDataSerializer_v291() {
   }
}
