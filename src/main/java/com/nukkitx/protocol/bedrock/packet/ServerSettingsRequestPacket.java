package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class ServerSettingsRequestPacket implements BedrockPacket {
   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SERVER_SETTINGS_REQUEST;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ServerSettingsRequestPacket)) {
         return false;
      }

      ServerSettingsRequestPacket other = (ServerSettingsRequestPacket)o;
      return other.canEqual(this);
   }

   protected boolean canEqual(Object other) {
      return other instanceof ServerSettingsRequestPacket;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "ServerSettingsRequestPacket()";
   }
}
