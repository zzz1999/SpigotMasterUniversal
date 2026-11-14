package org.cloudburstmc.protocol.bedrock.codec.v407.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.ItemStackRequestPacket;

public class ItemStackRequestSerializer_v407 implements BedrockPacketSerializer<ItemStackRequestPacket> {
   public static final ItemStackRequestSerializer_v407 INSTANCE = new ItemStackRequestSerializer_v407();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, ItemStackRequestPacket packet) {
      helper.writeArray(buffer, packet.getRequests(), helper::writeItemStackRequest);
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, ItemStackRequestPacket packet) {
      helper.readArray(buffer, packet.getRequests(), helper::readItemStackRequest, helper.getEncodingSettings().maxInventoryActionsOrRequests());
   }

   protected ItemStackRequestSerializer_v407() {
   }
}
