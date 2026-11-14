package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class ClientboundCloseFormPacket implements BedrockPacket {
   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CLIENTBOUND_CLOSE_FORM;
   }

   public ClientboundCloseFormPacket clone() {
      try {
         return (ClientboundCloseFormPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ClientboundCloseFormPacket)) {
         return false;
      }

      ClientboundCloseFormPacket other = (ClientboundCloseFormPacket)o;
      return other.canEqual(this);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ClientboundCloseFormPacket;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "ClientboundCloseFormPacket()";
   }
}
