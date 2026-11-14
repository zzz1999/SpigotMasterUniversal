package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class ServerSettingsRequestPacket implements BedrockPacket {
   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SERVER_SETTINGS_REQUEST;
   }

   public ServerSettingsRequestPacket clone() {
      try {
         return (ServerSettingsRequestPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ServerSettingsRequestPacket)) {
         return false;
      }

      ServerSettingsRequestPacket other = (ServerSettingsRequestPacket)o;
      return other.canEqual(this);
   }

   protected boolean canEqual(final Object other) {
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
