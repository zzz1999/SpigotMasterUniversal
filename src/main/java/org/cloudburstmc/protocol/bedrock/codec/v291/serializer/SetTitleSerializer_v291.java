package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.SetTitlePacket;
import org.cloudburstmc.protocol.common.util.TextConverter;
import org.cloudburstmc.protocol.common.util.VarInts;

public class SetTitleSerializer_v291 implements BedrockPacketSerializer<SetTitlePacket> {
   public static final SetTitleSerializer_v291 INSTANCE = new SetTitleSerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, SetTitlePacket packet) {
      VarInts.writeInt(buffer, packet.getType().ordinal());
      TextConverter converter = helper.getTextConverter();
      helper.writeString(buffer, converter.serialize(packet.getText(CharSequence.class)));
      VarInts.writeInt(buffer, packet.getFadeInTime());
      VarInts.writeInt(buffer, packet.getStayTime());
      VarInts.writeInt(buffer, packet.getFadeOutTime());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, SetTitlePacket packet) {
      packet.setType(SetTitlePacket.Type.values()[VarInts.readInt(buffer)]);
      TextConverter converter = helper.getTextConverter();
      packet.setText(converter.deserialize(helper.readString(buffer)));
      packet.setFadeInTime(VarInts.readInt(buffer));
      packet.setStayTime(VarInts.readInt(buffer));
      packet.setFadeOutTime(VarInts.readInt(buffer));
   }

   protected SetTitleSerializer_v291() {
   }
}
