package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class ClientCacheStatusPacket implements BedrockPacket {
   private boolean supported;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CLIENT_CACHE_STATUS;
   }

   public ClientCacheStatusPacket clone() {
      try {
         return (ClientCacheStatusPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public boolean isSupported() {
      return this.supported;
   }

   public void setSupported(final boolean supported) {
      this.supported = supported;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ClientCacheStatusPacket)) {
         return false;
      }

      ClientCacheStatusPacket other = (ClientCacheStatusPacket)o;
      return !other.canEqual(this) ? false : this.supported == other.supported;
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ClientCacheStatusPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      return result * 59 + (this.supported ? 79 : 97);
   }

   @Override
   public String toString() {
      return "ClientCacheStatusPacket(supported=" + this.supported + ")";
   }
}
