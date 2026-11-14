package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.ModalFormRequestPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

public class ModalFormRequestSerializer_v291 implements BedrockPacketSerializer<ModalFormRequestPacket> {
   public static final ModalFormRequestSerializer_v291 INSTANCE = new ModalFormRequestSerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, ModalFormRequestPacket packet) {
      VarInts.writeUnsignedInt(buffer, packet.getFormId());
      helper.writeString(buffer, packet.getFormData());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, ModalFormRequestPacket packet) {
      packet.setFormId(VarInts.readUnsignedInt(buffer));
      packet.setFormData(helper.readString(buffer));
   }

   protected ModalFormRequestSerializer_v291() {
   }
}
