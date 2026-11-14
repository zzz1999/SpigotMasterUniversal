package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.SetLastHurtByPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

public class SetLastHurtBySerializer_v291 implements BedrockPacketSerializer<SetLastHurtByPacket> {
   public static final SetLastHurtBySerializer_v291 INSTANCE = new SetLastHurtBySerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, SetLastHurtByPacket packet) {
      VarInts.writeInt(buffer, packet.getEntityTypeId());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, SetLastHurtByPacket packet) {
      packet.setEntityTypeId(VarInts.readInt(buffer));
   }

   protected SetLastHurtBySerializer_v291() {
   }
}
