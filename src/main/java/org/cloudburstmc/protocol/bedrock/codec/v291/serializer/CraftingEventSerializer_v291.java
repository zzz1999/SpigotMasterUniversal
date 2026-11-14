package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.data.inventory.CraftingType;
import org.cloudburstmc.protocol.bedrock.packet.CraftingEventPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

public class CraftingEventSerializer_v291 implements BedrockPacketSerializer<CraftingEventPacket> {
   public static final CraftingEventSerializer_v291 INSTANCE = new CraftingEventSerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, CraftingEventPacket packet) {
      buffer.writeByte(packet.getContainerId());
      VarInts.writeInt(buffer, packet.getType().ordinal());
      helper.writeUuid(buffer, packet.getUuid());
      helper.writeArray(buffer, packet.getInputs(), helper::writeItem);
      helper.writeArray(buffer, packet.getOutputs(), helper::writeItem);
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, CraftingEventPacket packet) {
      packet.setContainerId(buffer.readByte());
      packet.setType(CraftingType.values()[VarInts.readInt(buffer)]);
      packet.setUuid(helper.readUuid(buffer));
      helper.readArray(buffer, packet.getInputs(), helper::readItem, 9);
      helper.readArray(buffer, packet.getOutputs(), helper::readItem, 2);
   }

   protected CraftingEventSerializer_v291() {
   }
}
