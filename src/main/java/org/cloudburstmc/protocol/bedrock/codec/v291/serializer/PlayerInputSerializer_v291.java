package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.PlayerInputPacket;

public class PlayerInputSerializer_v291 implements BedrockPacketSerializer<PlayerInputPacket> {
   public static final PlayerInputSerializer_v291 INSTANCE = new PlayerInputSerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, PlayerInputPacket packet) {
      helper.writeVector2f(buffer, packet.getInputMotion());
      buffer.writeBoolean(packet.isJumping());
      buffer.writeBoolean(packet.isSneaking());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, PlayerInputPacket packet) {
      packet.setInputMotion(helper.readVector2f(buffer));
      packet.setJumping(buffer.readBoolean());
      packet.setSneaking(buffer.readBoolean());
   }

   protected PlayerInputSerializer_v291() {
   }
}
