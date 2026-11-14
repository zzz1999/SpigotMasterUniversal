package org.cloudburstmc.protocol.bedrock.codec.v313.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.NetworkChunkPublisherUpdatePacket;
import org.cloudburstmc.protocol.common.util.VarInts;

public class NetworkChunkPublisherUpdateSerializer_v313 implements BedrockPacketSerializer<NetworkChunkPublisherUpdatePacket> {
   public static final NetworkChunkPublisherUpdateSerializer_v313 INSTANCE = new NetworkChunkPublisherUpdateSerializer_v313();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, NetworkChunkPublisherUpdatePacket packet) {
      helper.writeVector3i(buffer, packet.getPosition());
      VarInts.writeUnsignedInt(buffer, packet.getRadius());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, NetworkChunkPublisherUpdatePacket packet) {
      packet.setPosition(helper.readVector3i(buffer));
      packet.setRadius(VarInts.readUnsignedInt(buffer));
   }

   protected NetworkChunkPublisherUpdateSerializer_v313() {
   }
}
