package org.cloudburstmc.protocol.bedrock.codec.v534.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.UpdateAbilitiesPacket;

public class UpdateAbilitiesSerializer_v534 implements BedrockPacketSerializer<UpdateAbilitiesPacket> {
   public static final UpdateAbilitiesSerializer_v534 INSTANCE = new UpdateAbilitiesSerializer_v534();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, UpdateAbilitiesPacket packet) {
      helper.writePlayerAbilities(buffer, packet);
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, UpdateAbilitiesPacket packet) {
      helper.readPlayerAbilities(buffer, packet);
   }

   protected UpdateAbilitiesSerializer_v534() {
   }
}
