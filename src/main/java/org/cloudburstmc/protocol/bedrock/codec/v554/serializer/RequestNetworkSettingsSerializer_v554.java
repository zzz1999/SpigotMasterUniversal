package org.cloudburstmc.protocol.bedrock.codec.v554.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.RequestNetworkSettingsPacket;

public class RequestNetworkSettingsSerializer_v554 implements BedrockPacketSerializer<RequestNetworkSettingsPacket> {
   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, RequestNetworkSettingsPacket packet) {
      buffer.writeInt(packet.getProtocolVersion());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, RequestNetworkSettingsPacket packet) {
      packet.setProtocolVersion(buffer.readInt());
   }
}
