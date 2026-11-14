package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.RiderJumpPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

public class RiderJumpSerializer_v291 implements BedrockPacketSerializer<RiderJumpPacket> {
   public static final RiderJumpSerializer_v291 INSTANCE = new RiderJumpSerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, RiderJumpPacket packet) {
      VarInts.writeUnsignedInt(buffer, packet.getJumpStrength());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, RiderJumpPacket packet) {
      packet.setJumpStrength(VarInts.readInt(buffer));
   }

   protected RiderJumpSerializer_v291() {
   }
}
