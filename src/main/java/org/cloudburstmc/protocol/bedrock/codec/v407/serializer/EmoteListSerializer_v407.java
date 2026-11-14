package org.cloudburstmc.protocol.bedrock.codec.v407.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.EmoteListPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

public class EmoteListSerializer_v407 implements BedrockPacketSerializer<EmoteListPacket> {
   public static final EmoteListSerializer_v407 INSTANCE = new EmoteListSerializer_v407();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, EmoteListPacket packet) {
      VarInts.writeUnsignedLong(buffer, packet.getRuntimeEntityId());
      helper.writeArray(buffer, packet.getPieceIds(), helper::writeUuid);
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, EmoteListPacket packet) {
      packet.setRuntimeEntityId(VarInts.readUnsignedLong(buffer));
      helper.readArray(buffer, packet.getPieceIds(), helper::readUuid);
   }

   protected EmoteListSerializer_v407() {
   }
}
