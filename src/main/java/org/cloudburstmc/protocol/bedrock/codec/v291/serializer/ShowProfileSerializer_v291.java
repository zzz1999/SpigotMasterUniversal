package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.ShowProfilePacket;

public class ShowProfileSerializer_v291 implements BedrockPacketSerializer<ShowProfilePacket> {
   public static final ShowProfileSerializer_v291 INSTANCE = new ShowProfileSerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, ShowProfilePacket packet) {
      helper.writeString(buffer, packet.getXuid());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, ShowProfilePacket packet) {
      packet.setXuid(helper.readString(buffer));
   }

   protected ShowProfileSerializer_v291() {
   }
}
