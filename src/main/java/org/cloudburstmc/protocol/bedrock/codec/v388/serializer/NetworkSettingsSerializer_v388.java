package org.cloudburstmc.protocol.bedrock.codec.v388.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.NetworkSettingsPacket;

public class NetworkSettingsSerializer_v388 implements BedrockPacketSerializer<NetworkSettingsPacket> {
   public static final NetworkSettingsSerializer_v388 INSTANCE = new NetworkSettingsSerializer_v388();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, NetworkSettingsPacket packet) {
      buffer.writeShortLE(packet.getCompressionThreshold());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, NetworkSettingsPacket packet) {
      packet.setCompressionThreshold(buffer.readUnsignedShortLE());
   }

   protected NetworkSettingsSerializer_v388() {
   }
}
