package org.cloudburstmc.protocol.bedrock.codec.v313.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.nbt.NbtMap;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.AvailableEntityIdentifiersPacket;

public class AvailableEntityIdentifiersSerializer_v313 implements BedrockPacketSerializer<AvailableEntityIdentifiersPacket> {
   public static final AvailableEntityIdentifiersSerializer_v313 INSTANCE = new AvailableEntityIdentifiersSerializer_v313();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, AvailableEntityIdentifiersPacket packet) {
      helper.writeTag(buffer, packet.getIdentifiers());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, AvailableEntityIdentifiersPacket packet) {
      packet.setIdentifiers(helper.readTag(buffer, NbtMap.class));
   }

   protected AvailableEntityIdentifiersSerializer_v313() {
   }
}
