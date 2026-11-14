package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.HurtArmorPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

public class HurtArmorSerializer_v291 implements BedrockPacketSerializer<HurtArmorPacket> {
   public static final HurtArmorSerializer_v291 INSTANCE = new HurtArmorSerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, HurtArmorPacket packet) {
      VarInts.writeInt(buffer, packet.getDamage());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, HurtArmorPacket packet) {
      packet.setDamage(VarInts.readInt(buffer));
   }

   protected HurtArmorSerializer_v291() {
   }
}
