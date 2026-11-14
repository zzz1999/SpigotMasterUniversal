package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class ClientToServerHandshakePacket implements BedrockPacket {
   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CLIENT_TO_SERVER_HANDSHAKE;
   }

   public ClientToServerHandshakePacket clone() {
      try {
         return (ClientToServerHandshakePacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ClientToServerHandshakePacket)) {
         return false;
      }

      ClientToServerHandshakePacket other = (ClientToServerHandshakePacket)o;
      return other.canEqual(this);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ClientToServerHandshakePacket;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "ClientToServerHandshakePacket()";
   }
}
