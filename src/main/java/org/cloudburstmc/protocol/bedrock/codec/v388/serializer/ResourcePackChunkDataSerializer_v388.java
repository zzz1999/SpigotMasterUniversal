package org.cloudburstmc.protocol.bedrock.codec.v388.serializer;

import io.netty.buffer.ByteBuf;
import java.util.UUID;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.ResourcePackChunkDataPacket;

public class ResourcePackChunkDataSerializer_v388 implements BedrockPacketSerializer<ResourcePackChunkDataPacket> {
   public static final ResourcePackChunkDataSerializer_v388 INSTANCE = new ResourcePackChunkDataSerializer_v388();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, ResourcePackChunkDataPacket packet) {
      String packInfo = packet.getPackId().toString() + (packet.getPackVersion() == null ? "" : '_' + packet.getPackVersion());
      helper.writeString(buffer, packInfo);
      buffer.writeIntLE(packet.getChunkIndex());
      buffer.writeLongLE(packet.getProgress());
      helper.writeByteBuf(buffer, packet.getData());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, ResourcePackChunkDataPacket packet) {
      String[] packInfo = helper.readString(buffer).split("_");
      packet.setPackId(UUID.fromString(packInfo[0]));
      if (packInfo.length > 1) {
         packet.setPackVersion(packInfo[1]);
      }

      packet.setChunkIndex(buffer.readIntLE());
      packet.setProgress(buffer.readLongLE());
      packet.setData(helper.readByteBuf(buffer));
   }

   protected ResourcePackChunkDataSerializer_v388() {
   }
}
