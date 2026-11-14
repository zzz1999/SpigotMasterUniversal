package org.cloudburstmc.protocol.bedrock.codec.v419.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.v388.serializer.PlayerAuthInputSerializer_v388;
import org.cloudburstmc.protocol.bedrock.packet.PlayerAuthInputPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

public class PlayerAuthInputSerializer_v419 extends PlayerAuthInputSerializer_v388 {
   public static final PlayerAuthInputSerializer_v419 INSTANCE = new PlayerAuthInputSerializer_v419();

   @Override
   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, PlayerAuthInputPacket packet) {
      super.serialize(buffer, helper, packet);
      VarInts.writeUnsignedLong(buffer, packet.getTick());
      helper.writeVector3f(buffer, packet.getDelta());
   }

   @Override
   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, PlayerAuthInputPacket packet) {
      super.deserialize(buffer, helper, packet);
      packet.setTick(VarInts.readUnsignedLong(buffer));
      packet.setDelta(helper.readVector3f(buffer));
   }

   protected PlayerAuthInputSerializer_v419() {
   }
}
