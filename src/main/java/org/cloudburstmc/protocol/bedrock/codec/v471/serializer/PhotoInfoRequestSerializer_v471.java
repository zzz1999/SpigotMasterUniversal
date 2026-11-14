package org.cloudburstmc.protocol.bedrock.codec.v471.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.PhotoInfoRequestPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

public class PhotoInfoRequestSerializer_v471 implements BedrockPacketSerializer<PhotoInfoRequestPacket> {
   public static final PhotoInfoRequestSerializer_v471 INSTANCE = new PhotoInfoRequestSerializer_v471();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, PhotoInfoRequestPacket packet) {
      VarInts.writeLong(buffer, packet.getPhotoId());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, PhotoInfoRequestPacket packet) {
      packet.setPhotoId(VarInts.readLong(buffer));
   }

   protected PhotoInfoRequestSerializer_v471() {
   }
}
