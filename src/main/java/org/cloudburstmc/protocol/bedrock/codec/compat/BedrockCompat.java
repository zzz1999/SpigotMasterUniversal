package org.cloudburstmc.protocol.bedrock.codec.compat;

import org.cloudburstmc.protocol.bedrock.codec.BedrockCodec;
import org.cloudburstmc.protocol.bedrock.codec.compat.serializer.LoginSerializerCompat;
import org.cloudburstmc.protocol.bedrock.codec.compat.serializer.PlayStatusSerializerCompat;
import org.cloudburstmc.protocol.bedrock.codec.compat.serializer.RequestNetworkSettingsSerializerCompat;
import org.cloudburstmc.protocol.bedrock.codec.v291.serializer.DisconnectSerializer_v291;
import org.cloudburstmc.protocol.bedrock.codec.v622.Bedrock_v622;
import org.cloudburstmc.protocol.bedrock.codec.v622.serializer.DisconnectSerializer_v622;
import org.cloudburstmc.protocol.bedrock.codec.v712.Bedrock_v712;
import org.cloudburstmc.protocol.bedrock.codec.v712.serializer.DisconnectSerializer_v712;
import org.cloudburstmc.protocol.bedrock.data.PacketRecipient;
import org.cloudburstmc.protocol.bedrock.packet.DisconnectPacket;
import org.cloudburstmc.protocol.bedrock.packet.LoginPacket;
import org.cloudburstmc.protocol.bedrock.packet.PlayStatusPacket;
import org.cloudburstmc.protocol.bedrock.packet.RequestNetworkSettingsPacket;

public class BedrockCompat {
   public static BedrockCodec CODEC = BedrockCodec.builder()
      .helper(() -> NoopBedrockCodecHelper.INSTANCE)
      .registerPacket(LoginPacket::new, LoginSerializerCompat.INSTANCE, 1, PacketRecipient.SERVER)
      .registerPacket(PlayStatusPacket::new, PlayStatusSerializerCompat.INSTANCE, 2, PacketRecipient.CLIENT)
      .registerPacket(DisconnectPacket::new, DisconnectSerializer_v712.INSTANCE, 5, PacketRecipient.BOTH)
      .registerPacket(RequestNetworkSettingsPacket::new, RequestNetworkSettingsSerializerCompat.INSTANCE, 193, PacketRecipient.SERVER)
      .protocolVersion(0)
      .minecraftVersion("0.0.0")
      .build();
   public static BedrockCodec CODEC_v291 = CODEC.toBuilder().updateSerializer(DisconnectPacket.class, DisconnectSerializer_v291.INSTANCE).build();
   public static BedrockCodec CODEC_v622 = CODEC.toBuilder().updateSerializer(DisconnectPacket.class, DisconnectSerializer_v622.INSTANCE).build();

   public static BedrockCodec disconnectCompat(int protocolVersion) {
      if (protocolVersion < Bedrock_v622.CODEC.getProtocolVersion()) {
         return CODEC_v291;
      } else {
         return protocolVersion < Bedrock_v712.CODEC.getProtocolVersion() ? CODEC_v622 : CODEC;
      }
   }
}
