package org.cloudburstmc.protocol.bedrock.codec.v534.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.EditorNetworkPacket;

public class EditorNetworkSerializer_v534 implements BedrockPacketSerializer<EditorNetworkPacket> {
   public static final EditorNetworkSerializer_v534 INSTANCE = new EditorNetworkSerializer_v534();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, EditorNetworkPacket packet) {
      helper.writeTag(buffer, packet.getPayload());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, EditorNetworkPacket packet) {
      packet.setPayload(helper.readTag(buffer, Object.class));
   }

   protected EditorNetworkSerializer_v534() {
   }
}
