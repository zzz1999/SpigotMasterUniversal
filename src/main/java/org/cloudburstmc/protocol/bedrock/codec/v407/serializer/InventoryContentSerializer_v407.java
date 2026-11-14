package org.cloudburstmc.protocol.bedrock.codec.v407.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.InventoryContentPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

public class InventoryContentSerializer_v407 implements BedrockPacketSerializer<InventoryContentPacket> {
   public static final InventoryContentSerializer_v407 INSTANCE = new InventoryContentSerializer_v407();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, InventoryContentPacket packet) {
      VarInts.writeUnsignedInt(buffer, packet.getContainerId());
      helper.writeArray(buffer, packet.getContents(), helper::writeNetItem);
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, InventoryContentPacket packet) {
      packet.setContainerId(VarInts.readUnsignedInt(buffer));
      helper.readArray(buffer, packet.getContents(), helper::readNetItem);
   }

   protected InventoryContentSerializer_v407() {
   }
}
