package org.cloudburstmc.protocol.bedrock.codec.v361.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.nbt.NbtMap;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.UpdateBlockPropertiesPacket;

public class UpdateBlockPropertiesSerializer_v361 implements BedrockPacketSerializer<UpdateBlockPropertiesPacket> {
   public static final UpdateBlockPropertiesSerializer_v361 INSTANCE = new UpdateBlockPropertiesSerializer_v361();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, UpdateBlockPropertiesPacket packet) {
      helper.writeTag(buffer, packet.getProperties());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, UpdateBlockPropertiesPacket packet) {
      packet.setProperties(helper.readTag(buffer, NbtMap.class));
   }

   protected UpdateBlockPropertiesSerializer_v361() {
   }
}
