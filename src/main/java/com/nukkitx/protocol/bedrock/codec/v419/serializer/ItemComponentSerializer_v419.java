package com.nukkitx.protocol.bedrock.codec.v419.serializer;

import com.nukkitx.protocol.bedrock.codec.BedrockCodecHelper;
import com.nukkitx.protocol.bedrock.codec.BedrockPacketSerializer;
import com.nukkitx.protocol.bedrock.data.inventory.ComponentItemData;
import com.nukkitx.protocol.bedrock.packet.ItemComponentPacket;
import io.netty.buffer.ByteBuf;
import org.cloudburstmc.nbt.NbtMap;

public class ItemComponentSerializer_v419 implements BedrockPacketSerializer<ItemComponentPacket> {
   public static final ItemComponentSerializer_v419 INSTANCE = new ItemComponentSerializer_v419();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, ItemComponentPacket packet) {
      helper.writeArray(buffer, packet.getItems(), (buf, packetHelper, item) -> {
         packetHelper.writeString(buf, item.getName());
         packetHelper.writeTag(buf, item.getData());
      });
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, ItemComponentPacket packet) {
      helper.readArray(buffer, packet.getItems(), (buf, packetHelper) -> {
         String name = packetHelper.readString(buf);
         NbtMap data = packetHelper.readTag(buf, NbtMap.class);
         return new ComponentItemData(name, data);
      });
   }

   protected ItemComponentSerializer_v419() {
   }
}
