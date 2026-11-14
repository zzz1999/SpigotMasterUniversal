package org.cloudburstmc.protocol.bedrock.codec.v388.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.nbt.NbtMap;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.data.structure.StructureTemplateResponseType;
import org.cloudburstmc.protocol.bedrock.packet.StructureTemplateDataResponsePacket;

public class StructureTemplateDataResponseSerializer_v388 implements BedrockPacketSerializer<StructureTemplateDataResponsePacket> {
   public static final StructureTemplateDataResponseSerializer_v388 INSTANCE = new StructureTemplateDataResponseSerializer_v388();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, StructureTemplateDataResponsePacket packet) {
      helper.writeString(buffer, packet.getName());
      boolean save = packet.isSave();
      buffer.writeBoolean(save);
      if (save) {
         helper.writeTag(buffer, packet.getTag());
      }

      buffer.writeByte(packet.getType().ordinal());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, StructureTemplateDataResponsePacket packet) {
      packet.setName(helper.readString(buffer));
      boolean save = buffer.readBoolean();
      packet.setSave(save);
      if (save) {
         packet.setTag(helper.readTag(buffer, NbtMap.class));
      }

      packet.setType(StructureTemplateResponseType.from(buffer.readByte()));
   }

   protected StructureTemplateDataResponseSerializer_v388() {
   }
}
