package org.cloudburstmc.protocol.bedrock.codec.v786.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.data.GraphicsMode;
import org.cloudburstmc.protocol.bedrock.packet.UpdateClientOptionsPacket;

public class UpdateClientOptionsSerializer_v786 implements BedrockPacketSerializer<UpdateClientOptionsPacket> {
   public static final UpdateClientOptionsSerializer_v786 INSTANCE = new UpdateClientOptionsSerializer_v786();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, UpdateClientOptionsPacket packet) {
      helper.writeOptionalNull(buffer, packet.getGraphicsMode(), (buf, graphicsMode) -> buf.writeByte(graphicsMode.ordinal()));
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, UpdateClientOptionsPacket packet) {
      packet.setGraphicsMode(helper.readOptional(buffer, null, buf -> GraphicsMode.from(buffer.readUnsignedByte())));
   }

   protected UpdateClientOptionsSerializer_v786() {
   }
}
