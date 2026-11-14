package org.cloudburstmc.protocol.bedrock.codec.v662.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.v618.serializer.ResourcePacksInfoSerializer_v618;
import org.cloudburstmc.protocol.bedrock.packet.ResourcePacksInfoPacket;

public class ResourcePacksInfoSerializer_v622 extends ResourcePacksInfoSerializer_v618 {
   public static final ResourcePacksInfoSerializer_v622 INSTANCE = new ResourcePacksInfoSerializer_v622();

   @Override
   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, ResourcePacksInfoPacket packet) {
      buffer.writeBoolean(packet.isForcedToAccept());
      buffer.writeBoolean(packet.isHasAddonPacks());
      buffer.writeBoolean(packet.isScriptingEnabled());
      buffer.writeBoolean(packet.isForcingServerPacksEnabled());
      this.writePacks(buffer, packet.getBehaviorPackInfos(), helper, false);
      this.writePacks(buffer, packet.getResourcePackInfos(), helper, true);
      this.writeCDNEntries(buffer, packet, helper);
   }

   @Override
   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, ResourcePacksInfoPacket packet) {
      packet.setForcedToAccept(buffer.readBoolean());
      packet.setHasAddonPacks(buffer.readBoolean());
      packet.setScriptingEnabled(buffer.readBoolean());
      packet.setForcingServerPacksEnabled(buffer.readBoolean());
      this.readPacks(buffer, packet.getBehaviorPackInfos(), helper, false);
      this.readPacks(buffer, packet.getResourcePackInfos(), helper, true);
      this.readCDNEntries(buffer, packet, helper);
   }

   protected ResourcePacksInfoSerializer_v622() {
   }
}
