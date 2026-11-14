package org.cloudburstmc.protocol.bedrock.codec.v567.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.ClientCheatAbilityPacket;

public class ClientCheatAbilitySerializer_v567 implements BedrockPacketSerializer<ClientCheatAbilityPacket> {
   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, ClientCheatAbilityPacket packet) {
      helper.writePlayerAbilities(buffer, packet);
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, ClientCheatAbilityPacket packet) {
      helper.readPlayerAbilities(buffer, packet);
   }
}
