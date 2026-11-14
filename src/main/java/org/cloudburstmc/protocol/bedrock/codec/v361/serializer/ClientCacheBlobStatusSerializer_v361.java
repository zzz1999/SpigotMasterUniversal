package org.cloudburstmc.protocol.bedrock.codec.v361.serializer;

import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.longs.LongList;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.ClientCacheBlobStatusPacket;
import org.cloudburstmc.protocol.common.util.Preconditions;
import org.cloudburstmc.protocol.common.util.VarInts;

public class ClientCacheBlobStatusSerializer_v361 implements BedrockPacketSerializer<ClientCacheBlobStatusPacket> {
   public static final ClientCacheBlobStatusSerializer_v361 INSTANCE = new ClientCacheBlobStatusSerializer_v361();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, ClientCacheBlobStatusPacket packet) {
      LongList nacks = packet.getNaks();
      LongList acks = packet.getAcks();
      VarInts.writeUnsignedInt(buffer, nacks.size());
      VarInts.writeUnsignedInt(buffer, acks.size());
      nacks.forEach(buffer::writeLongLE);
      acks.forEach(buffer::writeLongLE);
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, ClientCacheBlobStatusPacket packet) {
      int maxLength = helper.getEncodingSettings().maxListSize();
      int naksLength = VarInts.readUnsignedInt(buffer);
      Preconditions.checkArgument(maxLength <= 0 || naksLength <= maxLength, "Tried to read %s Nacks but maximum is %s", naksLength, maxLength);
      int acksLength = VarInts.readUnsignedInt(buffer);
      Preconditions.checkArgument(maxLength <= 0 || acksLength <= maxLength, "Tried to read %s Nacks but maximum is %s", acksLength, maxLength);
      LongList naks = packet.getNaks();

      for (int i = 0; i < naksLength; i++) {
         naks.add(buffer.readLongLE());
      }

      LongList acks = packet.getAcks();

      for (int i = 0; i < acksLength; i++) {
         acks.add(buffer.readLongLE());
      }
   }

   protected ClientCacheBlobStatusSerializer_v361() {
   }
}
