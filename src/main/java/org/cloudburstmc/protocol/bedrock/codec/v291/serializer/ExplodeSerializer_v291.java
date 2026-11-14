package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.ExplodePacket;
import org.cloudburstmc.protocol.common.util.VarInts;

public class ExplodeSerializer_v291 implements BedrockPacketSerializer<ExplodePacket> {
   public static final ExplodeSerializer_v291 INSTANCE = new ExplodeSerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, ExplodePacket packet) {
      helper.writeVector3f(buffer, packet.getPosition());
      VarInts.writeInt(buffer, (int)(packet.getRadius() * 32.0F));
      helper.writeArray(buffer, packet.getRecords(), helper::writeVector3i);
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, ExplodePacket packet) {
      packet.setPosition(helper.readVector3f(buffer));
      packet.setRadius(VarInts.readInt(buffer) / 32.0F);
      helper.readArray(buffer, packet.getRecords(), helper::readVector3i);
   }

   protected ExplodeSerializer_v291() {
   }
}
