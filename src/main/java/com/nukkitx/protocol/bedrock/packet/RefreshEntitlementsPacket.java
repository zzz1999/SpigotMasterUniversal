package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class RefreshEntitlementsPacket implements BedrockPacket {
   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.REFRESH_ENTITLEMENTS;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RefreshEntitlementsPacket)) {
         return false;
      }

      RefreshEntitlementsPacket other = (RefreshEntitlementsPacket)o;
      return other.canEqual(this);
   }

   protected boolean canEqual(Object other) {
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
