package org.cloudburstmc.protocol.bedrock.codec.v361.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.ClientCacheStatusPacket;

public class ClientCacheStatusSerializer_v361 implements BedrockPacketSerializer<ClientCacheStatusPacket> {
   public static final ClientCacheStatusSerializer_v361 INSTANCE = new ClientCacheStatusSerializer_v361();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, ClientCacheStatusPacket packet) {
      buffer.writeBoolean(packet.isSupported());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, ClientCacheStatusPacket packet) {
      packet.setSupported(buffer.readBoolean());
   }

   protected ClientCacheStatusSerializer_v361() {
   }
}
