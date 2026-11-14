package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.MinecraftPacket;
import org.cloudburstmc.protocol.common.PacketSignal;

public interface BedrockPacket extends MinecraftPacket, Cloneable {
   PacketSignal handle(BedrockPacketHandler handler);

   BedrockPacketType getPacketType();

   BedrockPacket clone();
}
