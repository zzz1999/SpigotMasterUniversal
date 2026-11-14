package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.ResourcePackClientResponsePacket;

public class ResourcePackClientResponseSerializer_v291 implements BedrockPacketSerializer<ResourcePackClientResponsePacket> {
   public static final ResourcePackClientResponseSerializer_v291 INSTANCE = new ResourcePackClientResponseSerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, ResourcePackClientResponsePacket packet) {
      buffer.writeByte(packet.getStatus().ordinal());
      helper.writeArray(buffer, packet.getPackIds(), ByteBuf::writeShortLE, helper::writeString);
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, ResourcePackClientResponsePacket packet) {
      ResourcePackClientResponsePacket.Status status = ResourcePackClientResponsePacket.Status.values()[buffer.readUnsignedByte()];
      packet.setStatus(status);
      helper.readArray(buffer, packet.getPackIds(), ByteBuf::readUnsignedShortLE, helper::readString);
   }

   protected ResourcePackClientResponseSerializer_v291() {
   }
}
