package com.nukkitx.protocol.bedrock.codec.v544.serializer;

import com.nukkitx.protocol.bedrock.codec.BedrockCodecHelper;
import com.nukkitx.protocol.bedrock.codec.v291.serializer.ModalFormResponseSerializer_v291;
import com.nukkitx.protocol.bedrock.data.ModalFormCancelReason;
import com.nukkitx.protocol.bedrock.packet.ModalFormResponsePacket;
import com.nukkitx.protocol.common.util.VarInts;
import io.netty.buffer.ByteBuf;
import java.util.Objects;
import java.util.Optional;

public class ModalFormResponseSerializer_v544 extends ModalFormResponseSerializer_v291 {
   protected static final ModalFormCancelReason[] VALUES = ModalFormCancelReason.values();

   @Override
   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, ModalFormResponsePacket packet) {
      VarInts.writeUnsignedInt(buffer, packet.getFormId());
      helper.writeOptional(buffer, Objects::nonNull, packet.getFormData(), helper::writeString);
      helper.writeOptional(
         buffer, Optional::isPresent, packet.getCancelReason(), (buf, reason) -> buf.writeByte(((ModalFormCancelReason)reason.get()).ordinal())
      );
   }

   @Override
   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, ModalFormResponsePacket packet) {
      packet.setFormId(VarInts.readUnsignedInt(buffer));
      packet.setFormData(helper.readOptional(buffer, null, helper::readString));
      packet.setCancelReason(helper.readOptional(buffer, Optional.empty(), byteBuf -> Optional.of(VALUES[byteBuf.readByte()])));
   }
}
