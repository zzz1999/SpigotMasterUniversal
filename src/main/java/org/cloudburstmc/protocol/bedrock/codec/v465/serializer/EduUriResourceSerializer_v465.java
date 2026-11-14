package org.cloudburstmc.protocol.bedrock.codec.v465.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.data.EduSharedUriResource;
import org.cloudburstmc.protocol.bedrock.packet.EduUriResourcePacket;

public class EduUriResourceSerializer_v465 implements BedrockPacketSerializer<EduUriResourcePacket> {
   public static final EduUriResourceSerializer_v465 INSTANCE = new EduUriResourceSerializer_v465();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, EduUriResourcePacket packet) {
      helper.writeString(buffer, packet.getEduSharedUriResource().getButtonName());
      helper.writeString(buffer, packet.getEduSharedUriResource().getLinkUri());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, EduUriResourcePacket packet) {
      packet.setEduSharedUriResource(new EduSharedUriResource(helper.readString(buffer), helper.readString(buffer)));
   }

   protected EduUriResourceSerializer_v465() {
   }
}
