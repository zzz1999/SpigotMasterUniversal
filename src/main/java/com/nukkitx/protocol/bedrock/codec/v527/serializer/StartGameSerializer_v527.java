package com.nukkitx.protocol.bedrock.codec.v527.serializer;

import com.nukkitx.protocol.bedrock.codec.BedrockCodecHelper;
import com.nukkitx.protocol.bedrock.codec.v465.serializer.StartGameSerializer_v465;
import com.nukkitx.protocol.bedrock.packet.StartGamePacket;
import io.netty.buffer.ByteBuf;
import org.cloudburstmc.nbt.NbtMap;

public class StartGameSerializer_v527 extends StartGameSerializer_v465 {
   @Override
   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, StartGamePacket packet) {
      super.serialize(buffer, helper, packet);
      helper.writeTag(buffer, packet.getPlayerPropertyData());
      buffer.writeLongLE(packet.getBlockRegistryChecksum());
      helper.writeUuid(buffer, packet.getWorldTemplateId());
   }

   @Override
   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, StartGamePacket packet) {
      super.deserialize(buffer, helper, packet);
      packet.setPlayerPropertyData(helper.readTag(buffer, NbtMap.class));
      packet.setBlockRegistryChecksum(buffer.readLongLE());
      packet.setWorldTemplateId(helper.readUuid(buffer));
   }

   @Override
   protected long readSeed(ByteBuf buf) {
      return buf.readLongLE();
   }

   @Override
   protected void writeSeed(ByteBuf buf, long seed) {
      buf.writeLongLE(seed);
   }
}
