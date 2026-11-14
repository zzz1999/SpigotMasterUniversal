package org.cloudburstmc.protocol.bedrock.codec.v332.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.SpawnParticleEffectPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

public class SpawnParticleEffectSerializer_v332 implements BedrockPacketSerializer<SpawnParticleEffectPacket> {
   public static final SpawnParticleEffectSerializer_v332 INSTANCE = new SpawnParticleEffectSerializer_v332();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, SpawnParticleEffectPacket packet) {
      buffer.writeByte(packet.getDimensionId());
      VarInts.writeLong(buffer, packet.getUniqueEntityId());
      helper.writeVector3f(buffer, packet.getPosition());
      helper.writeString(buffer, packet.getIdentifier());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, SpawnParticleEffectPacket packet) {
      packet.setDimensionId(buffer.readUnsignedByte());
      packet.setUniqueEntityId(VarInts.readLong(buffer));
      packet.setPosition(helper.readVector3f(buffer));
      packet.setIdentifier(helper.readString(buffer));
   }

   protected SpawnParticleEffectSerializer_v332() {
   }
}
