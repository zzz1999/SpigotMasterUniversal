package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.ServerSettingsRequestPacket;

public class ServerSettingsRequestSerializer_v291 implements BedrockPacketSerializer<ServerSettingsRequestPacket> {
   public static final ServerSettingsRequestSerializer_v291 INSTANCE = new ServerSettingsRequestSerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, ServerSettingsRequestPacket packet) {
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, ServerSettingsRequestPacket packet) {
   }

   protected ServerSettingsRequestSerializer_v291() {
   }
}
