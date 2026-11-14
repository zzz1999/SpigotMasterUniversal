package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.ControlScheme;
import org.cloudburstmc.protocol.common.PacketSignal;

public class ClientboundControlSchemeSetPacket implements BedrockPacket {
   private ControlScheme scheme;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CLIENTBOUND_CONTROL_SCHEME_SET;
   }

   @Override
   public BedrockPacket clone() {
      try {
         return (ClientboundControlSchemeSetPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public ControlScheme getScheme() {
      return this.scheme;
   }

   public void setScheme(final ControlScheme scheme) {
      this.scheme = scheme;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ClientboundControlSchemeSetPacket)) {
         return false;
      }

      ClientboundControlSchemeSetPacket other = (ClientboundControlSchemeSetPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$scheme = this.scheme;
      Object other$scheme = other.scheme;
      return this$scheme == null ? other$scheme == null : this$scheme.equals(other$scheme);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ClientboundControlSchemeSetPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $scheme = this.scheme;
      return result * 59 + ($scheme == null ? 43 : $scheme.hashCode());
   }

   @Override
   public String toString() {
      return "ClientboundControlSchemeSetPacket(scheme=" + this.scheme + ")";
   }
}
