package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.ChunkRadiusUpdatedPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

public class ChunkRadiusUpdatedSerializer_v291 implements BedrockPacketSerializer<ChunkRadiusUpdatedPacket> {
   public static final ChunkRadiusUpdatedSerializer_v291 INSTANCE = new ChunkRadiusUpdatedSerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, ChunkRadiusUpdatedPacket packet) {
      VarInts.writeInt(buffer, packet.getRadius());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, ChunkRadiusUpdatedPacket packet) {
      packet.setRadius(VarInts.readInt(buffer));
   }

   protected ChunkRadiusUpdatedSerializer_v291() {
   }
}
