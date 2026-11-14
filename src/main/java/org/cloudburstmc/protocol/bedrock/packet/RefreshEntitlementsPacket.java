package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class RefreshEntitlementsPacket implements BedrockPacket {
   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.REFRESH_ENTITLEMENTS;
   }

   public RefreshEntitlementsPacket clone() {
      try {
         return (RefreshEntitlementsPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RefreshEntitlementsPacket)) {
         return false;
      }

      RefreshEntitlementsPacket other = (RefreshEntitlementsPacket)o;
      return other.canEqual(this);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof RefreshEntitlementsPacket;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "RefreshEntitlementsPacket()";
   }
}
