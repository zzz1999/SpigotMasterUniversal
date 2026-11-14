package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.data.inventory.ContainerType;
import org.cloudburstmc.protocol.bedrock.packet.ContainerOpenPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

public class ContainerOpenSerializer_v291 implements BedrockPacketSerializer<ContainerOpenPacket> {
   public static final ContainerOpenSerializer_v291 INSTANCE = new ContainerOpenSerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, ContainerOpenPacket packet) {
      buffer.writeByte(packet.getId());
      buffer.writeByte(packet.getType().getId());
      helper.writeBlockPosition(buffer, packet.getBlockPosition());
      VarInts.writeLong(buffer, packet.getUniqueEntityId());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, ContainerOpenPacket packet) {
      packet.setId(buffer.readByte());
      packet.setType(ContainerType.from(buffer.readByte()));
      packet.setBlockPosition(helper.readBlockPosition(buffer));
      packet.setUniqueEntityId(VarInts.readLong(buffer));
   }

   protected ContainerOpenSerializer_v291() {
   }
}
