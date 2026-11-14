package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.CameraPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

public class CameraSerializer_v291 implements BedrockPacketSerializer<CameraPacket> {
   public static final CameraSerializer_v291 INSTANCE = new CameraSerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, CameraPacket packet) {
      VarInts.writeLong(buffer, packet.getCameraUniqueEntityId());
      VarInts.writeLong(buffer, packet.getPlayerUniqueEntityId());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, CameraPacket packet) {
      packet.setCameraUniqueEntityId(VarInts.readLong(buffer));
      packet.setPlayerUniqueEntityId(VarInts.readLong(buffer));
   }

   protected CameraSerializer_v291() {
   }
}
