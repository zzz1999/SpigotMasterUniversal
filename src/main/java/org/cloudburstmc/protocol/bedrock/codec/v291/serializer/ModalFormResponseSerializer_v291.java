package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.ModalFormResponsePacket;
import org.cloudburstmc.protocol.common.util.VarInts;

public class ModalFormResponseSerializer_v291 implements BedrockPacketSerializer<ModalFormResponsePacket> {
   public static final ModalFormResponseSerializer_v291 INSTANCE = new ModalFormResponseSerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, ModalFormResponsePacket packet) {
      VarInts.writeUnsignedInt(buffer, packet.getFormId());
      helper.writeString(buffer, packet.getFormData());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, ModalFormResponsePacket packet) {
      packet.setFormId(VarInts.readUnsignedInt(buffer));
      packet.setFormData(helper.readString(buffer));
   }

   protected ModalFormResponseSerializer_v291() {
   }
}
