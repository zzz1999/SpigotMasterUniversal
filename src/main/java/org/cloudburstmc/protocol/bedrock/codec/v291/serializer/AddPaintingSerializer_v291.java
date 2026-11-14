package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.AddPaintingPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

public class AddPaintingSerializer_v291 implements BedrockPacketSerializer<AddPaintingPacket> {
   public static final AddPaintingSerializer_v291 INSTANCE = new AddPaintingSerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, AddPaintingPacket packet) {
      VarInts.writeLong(buffer, packet.getUniqueEntityId());
      VarInts.writeUnsignedLong(buffer, packet.getRuntimeEntityId());
      helper.writeBlockPosition(buffer, packet.getPosition().toInt());
      VarInts.writeInt(buffer, packet.getDirection());
      helper.writeString(buffer, packet.getMotive());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, AddPaintingPacket packet) {
      packet.setUniqueEntityId(VarInts.readLong(buffer));
      packet.setRuntimeEntityId(VarInts.readUnsignedLong(buffer));
      packet.setPosition(helper.readBlockPosition(buffer).toFloat());
      packet.setDirection(VarInts.readInt(buffer));
      packet.setMotive(helper.readString(buffer));
   }

   protected AddPaintingSerializer_v291() {
   }
}
