package org.cloudburstmc.protocol.bedrock.codec.v354.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.LecternUpdatePacket;

public class LecternUpdateSerializer_v354 implements BedrockPacketSerializer<LecternUpdatePacket> {
   public static final LecternUpdateSerializer_v354 INSTANCE = new LecternUpdateSerializer_v354();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, LecternUpdatePacket packet) {
      buffer.writeByte(packet.getPage());
      buffer.writeByte(packet.getTotalPages());
      helper.writeBlockPosition(buffer, packet.getBlockPosition());
      buffer.writeBoolean(packet.isDroppingBook());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, LecternUpdatePacket packet) {
      packet.setPage(buffer.readUnsignedByte());
      packet.setTotalPages(buffer.readUnsignedByte());
      packet.setBlockPosition(helper.readBlockPosition(buffer));
      packet.setDroppingBook(buffer.readBoolean());
   }

   protected LecternUpdateSerializer_v354() {
   }
}
