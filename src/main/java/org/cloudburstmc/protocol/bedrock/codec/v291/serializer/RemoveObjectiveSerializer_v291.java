package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.RemoveObjectivePacket;

public class RemoveObjectiveSerializer_v291 implements BedrockPacketSerializer<RemoveObjectivePacket> {
   public static final RemoveObjectiveSerializer_v291 INSTANCE = new RemoveObjectiveSerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, RemoveObjectivePacket packet) {
      helper.writeString(buffer, packet.getObjectiveId());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, RemoveObjectivePacket packet) {
      packet.setObjectiveId(helper.readString(buffer));
   }

   protected RemoveObjectiveSerializer_v291() {
   }
}
