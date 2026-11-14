package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.SetSpawnPositionPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

public class SetSpawnPositionSerializer_v291 implements BedrockPacketSerializer<SetSpawnPositionPacket> {
   public static final SetSpawnPositionSerializer_v291 INSTANCE = new SetSpawnPositionSerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, SetSpawnPositionPacket packet) {
      VarInts.writeInt(buffer, packet.getSpawnType().ordinal());
      helper.writeBlockPosition(buffer, packet.getBlockPosition());
      buffer.writeBoolean(packet.isSpawnForced());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, SetSpawnPositionPacket packet) {
      packet.setSpawnType(SetSpawnPositionPacket.Type.values()[VarInts.readInt(buffer)]);
      packet.setBlockPosition(helper.readBlockPosition(buffer));
      packet.setSpawnForced(buffer.readBoolean());
   }

   protected SetSpawnPositionSerializer_v291() {
   }
}
