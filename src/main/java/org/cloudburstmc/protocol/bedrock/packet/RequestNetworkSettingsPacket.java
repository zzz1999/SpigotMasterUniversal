package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class RequestNetworkSettingsPacket implements BedrockPacket {
   private int protocolVersion;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.REQUEST_NETWORK_SETTINGS;
   }

   public RequestNetworkSettingsPacket clone() {
      try {
         return (RequestNetworkSettingsPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public int getProtocolVersion() {
      return this.protocolVersion;
   }

   public void setProtocolVersion(final int protocolVersion) {
      this.protocolVersion = protocolVersion;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RequestNetworkSettingsPacket)) {
         return false;
      }

      RequestNetworkSettingsPacket other = (RequestNetworkSettingsPacket)o;
      return !other.canEqual(this) ? false : this.protocolVersion == other.protocolVersion;
   }

   protected boolean canEqual(final Object other) {
      return other instanceof RequestNetworkSettingsPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      return result * 59 + this.protocolVersion;
   }

   @Override
   public String toString() {
      return "RequestNetworkSettingsPacket(protocolVersion=" + this.protocolVersion + ")";
   }
}
