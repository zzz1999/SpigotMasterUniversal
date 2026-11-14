package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.NetworkStackLatencyPacket;

public class NetworkStackLatencySerializer_v291 implements BedrockPacketSerializer<NetworkStackLatencyPacket> {
   public static final NetworkStackLatencySerializer_v291 INSTANCE = new NetworkStackLatencySerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, NetworkStackLatencyPacket packet) {
      buffer.writeLongLE(packet.getTimestamp());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, NetworkStackLatencyPacket packet) {
      packet.setTimestamp(buffer.readLongLE());
   }

   protected NetworkStackLatencySerializer_v291() {
   }
}
