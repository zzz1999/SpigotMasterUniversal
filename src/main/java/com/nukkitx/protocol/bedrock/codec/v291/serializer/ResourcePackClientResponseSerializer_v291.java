package com.nukkitx.protocol.bedrock.codec.v291.serializer;

import com.nukkitx.protocol.bedrock.codec.BedrockCodecHelper;
import com.nukkitx.protocol.bedrock.codec.BedrockPacketSerializer;
import com.nukkitx.protocol.bedrock.packet.ResourcePackClientResponsePacket;
import io.netty.buffer.ByteBuf;

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
