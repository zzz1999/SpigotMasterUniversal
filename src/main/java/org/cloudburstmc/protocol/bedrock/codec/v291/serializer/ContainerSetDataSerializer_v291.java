package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.ContainerSetDataPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

public class ContainerSetDataSerializer_v291 implements BedrockPacketSerializer<ContainerSetDataPacket> {
   public static final ContainerSetDataSerializer_v291 INSTANCE = new ContainerSetDataSerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, ContainerSetDataPacket packet) {
      buffer.writeByte(packet.getWindowId());
      VarInts.writeInt(buffer, packet.getProperty());
      VarInts.writeInt(buffer, packet.getValue());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, ContainerSetDataPacket packet) {
      packet.setWindowId(buffer.readByte());
      packet.setProperty(VarInts.readInt(buffer));
      packet.setValue(VarInts.readInt(buffer));
   }

   protected ContainerSetDataSerializer_v291() {
   }
}
