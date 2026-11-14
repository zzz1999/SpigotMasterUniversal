package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.InventoryContentPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

public class InventoryContentSerializer_v291 implements BedrockPacketSerializer<InventoryContentPacket> {
   public static final InventoryContentSerializer_v291 INSTANCE = new InventoryContentSerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, InventoryContentPacket packet) {
      VarInts.writeUnsignedInt(buffer, packet.getContainerId());
      helper.writeArray(buffer, packet.getContents(), (buf, item) -> helper.writeItem(buf, item));
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, InventoryContentPacket packet) {
      packet.setContainerId(VarInts.readUnsignedInt(buffer));
      helper.readArray(buffer, packet.getContents(), buf -> helper.readItem(buf));
   }

   protected InventoryContentSerializer_v291() {
   }
}
