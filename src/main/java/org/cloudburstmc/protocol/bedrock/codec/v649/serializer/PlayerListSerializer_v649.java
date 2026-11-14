package org.cloudburstmc.protocol.bedrock.codec.v649.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.v390.serializer.PlayerListSerializer_v390;
import org.cloudburstmc.protocol.bedrock.packet.PlayerListPacket;

public class PlayerListSerializer_v649 extends PlayerListSerializer_v390 {
   public static final PlayerListSerializer_v649 INSTANCE = new PlayerListSerializer_v649();

   @Override
   protected void writeEntryBase(ByteBuf buffer, BedrockCodecHelper helper, PlayerListPacket.Entry entry) {
      super.writeEntryBase(buffer, helper, entry);
      buffer.writeBoolean(entry.isSubClient());
   }

   @Override
   protected PlayerListPacket.Entry readEntryBase(ByteBuf buffer, BedrockCodecHelper helper) {
      PlayerListPacket.Entry entry = super.readEntryBase(buffer, helper);
      entry.setSubClient(buffer.readBoolean());
      return entry;
   }

   protected PlayerListSerializer_v649() {
   }
}
