package org.cloudburstmc.protocol.bedrock.codec.v388.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.PlayerListPacket;
import org.cloudburstmc.protocol.common.util.TextConverter;
import org.cloudburstmc.protocol.common.util.VarInts;

public class PlayerListSerializer_v388 implements BedrockPacketSerializer<PlayerListPacket> {
   public static final PlayerListSerializer_v388 INSTANCE = new PlayerListSerializer_v388();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, PlayerListPacket packet) {
      buffer.writeByte(packet.getAction().ordinal());
      VarInts.writeUnsignedInt(buffer, packet.getEntries().size());

      for (PlayerListPacket.Entry entry : packet.getEntries()) {
         helper.writeUuid(buffer, entry.getUuid());
         if (packet.getAction() == PlayerListPacket.Action.ADD) {
            VarInts.writeLong(buffer, entry.getEntityId());
            TextConverter converter = helper.getTextConverter();
            helper.writeString(buffer, converter.serialize(entry.getName(CharSequence.class)));
            helper.writeString(buffer, entry.getXuid());
            helper.writeString(buffer, entry.getPlatformChatId());
            buffer.writeIntLE(entry.getBuildPlatform());
            helper.writeSkin(buffer, entry.getSkin());
            buffer.writeBoolean(entry.isTeacher());
            buffer.writeBoolean(entry.isHost());
         }
      }
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, PlayerListPacket packet) {
      PlayerListPacket.Action action = PlayerListPacket.Action.values()[buffer.readUnsignedByte()];
      packet.setAction(action);
      int length = VarInts.readUnsignedInt(buffer);

      for (int i = 0; i < length; i++) {
         PlayerListPacket.Entry entry = new PlayerListPacket.Entry(helper.readUuid(buffer));
         if (action == PlayerListPacket.Action.ADD) {
            entry.setEntityId(VarInts.readLong(buffer));
            TextConverter converter = helper.getTextConverter();
            entry.setName(converter.deserialize(helper.readString(buffer)));
            entry.setXuid(helper.readString(buffer));
            entry.setPlatformChatId(helper.readString(buffer));
            entry.setBuildPlatform(buffer.readIntLE());
            entry.setSkin(helper.readSkin(buffer));
            entry.setTeacher(buffer.readBoolean());
            entry.setHost(buffer.readBoolean());
         }

         packet.getEntries().add(entry);
      }
   }

   protected PlayerListSerializer_v388() {
   }
}
