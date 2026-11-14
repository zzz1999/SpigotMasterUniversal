package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.SetDisplayObjectivePacket;
import org.cloudburstmc.protocol.common.util.TextConverter;
import org.cloudburstmc.protocol.common.util.VarInts;

public class SetDisplayObjectiveSerializer_v291 implements BedrockPacketSerializer<SetDisplayObjectivePacket> {
   public static final SetDisplayObjectiveSerializer_v291 INSTANCE = new SetDisplayObjectiveSerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, SetDisplayObjectivePacket packet) {
      helper.writeString(buffer, packet.getDisplaySlot());
      helper.writeString(buffer, packet.getObjectiveId());
      TextConverter converter = helper.getTextConverter();
      helper.writeString(buffer, converter.serialize(packet.getDisplayName(CharSequence.class)));
      helper.writeString(buffer, packet.getCriteria());
      VarInts.writeInt(buffer, packet.getSortOrder());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, SetDisplayObjectivePacket packet) {
      packet.setDisplaySlot(helper.readString(buffer));
      packet.setObjectiveId(helper.readString(buffer));
      TextConverter converter = helper.getTextConverter();
      packet.setDisplayName(converter.deserialize(helper.readString(buffer)));
      packet.setCriteria(helper.readString(buffer));
      packet.setSortOrder(VarInts.readInt(buffer));
   }

   protected SetDisplayObjectiveSerializer_v291() {
   }
}
