package org.cloudburstmc.protocol.bedrock.codec.v388.serializer;

import io.netty.buffer.ByteBuf;
import java.util.Set;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.data.EmoteFlag;
import org.cloudburstmc.protocol.bedrock.packet.EmotePacket;
import org.cloudburstmc.protocol.common.util.VarInts;

public class EmoteSerializer_v388 implements BedrockPacketSerializer<EmotePacket> {
   public static final EmoteSerializer_v388 INSTANCE = new EmoteSerializer_v388();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, EmotePacket packet) {
      VarInts.writeUnsignedLong(buffer, packet.getRuntimeEntityId());
      helper.writeString(buffer, packet.getEmoteId());
      this.writeFlags(buffer, helper, packet.getFlags());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, EmotePacket packet) {
      packet.setRuntimeEntityId(VarInts.readUnsignedLong(buffer));
      packet.setEmoteId(helper.readString(buffer));
      this.readFlags(buffer, helper, packet.getFlags());
   }

   protected void writeFlags(ByteBuf buffer, BedrockCodecHelper helper, Set<EmoteFlag> flags) {
      int flagsData = 0;

      for (EmoteFlag flag : flags) {
         flagsData |= 1 << flag.ordinal();
      }

      buffer.writeByte(flagsData);
   }

   protected void readFlags(ByteBuf buffer, BedrockCodecHelper helper, Set<EmoteFlag> flags) {
      int flagsData = buffer.readUnsignedByte();

      for (EmoteFlag flag : EmoteFlag.values()) {
         if ((flagsData & 1L << flag.ordinal()) != 0L) {
            flags.add(flag);
         }
      }
   }

   protected EmoteSerializer_v388() {
   }
}
