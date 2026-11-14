package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import java.util.UUID;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.SetScoreboardIdentityPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

public class SetScoreboardIdentitySerializer_v291 implements BedrockPacketSerializer<SetScoreboardIdentityPacket> {
   public static final SetScoreboardIdentitySerializer_v291 INSTANCE = new SetScoreboardIdentitySerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, SetScoreboardIdentityPacket packet) {
      SetScoreboardIdentityPacket.Action action = packet.getAction();
      buffer.writeByte(action.ordinal());
      helper.writeArray(buffer, packet.getEntries(), (buf, entry) -> {
         VarInts.writeLong(buffer, entry.getScoreboardId());
         if (action == SetScoreboardIdentityPacket.Action.ADD) {
            helper.writeUuid(buffer, entry.getUuid());
         }
      });
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, SetScoreboardIdentityPacket packet) {
      SetScoreboardIdentityPacket.Action action = SetScoreboardIdentityPacket.Action.values()[buffer.readUnsignedByte()];
      packet.setAction(action);
      helper.readArray(buffer, packet.getEntries(), buf -> {
         long scoreboardId = VarInts.readLong(buffer);
         UUID uuid = null;
         if (action == SetScoreboardIdentityPacket.Action.ADD) {
            uuid = helper.readUuid(buffer);
         }

         return new SetScoreboardIdentityPacket.Entry(scoreboardId, uuid);
      });
   }

   protected SetScoreboardIdentitySerializer_v291() {
   }
}
