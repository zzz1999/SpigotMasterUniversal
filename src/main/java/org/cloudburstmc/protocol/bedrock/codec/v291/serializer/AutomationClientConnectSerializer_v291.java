package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.AutomationClientConnectPacket;

public class AutomationClientConnectSerializer_v291 implements BedrockPacketSerializer<AutomationClientConnectPacket> {
   public static final AutomationClientConnectSerializer_v291 INSTANCE = new AutomationClientConnectSerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, AutomationClientConnectPacket packet) {
      helper.writeString(buffer, packet.getAddress());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, AutomationClientConnectPacket packet) {
      packet.setAddress(helper.readString(buffer));
   }

   protected AutomationClientConnectSerializer_v291() {
   }
}
