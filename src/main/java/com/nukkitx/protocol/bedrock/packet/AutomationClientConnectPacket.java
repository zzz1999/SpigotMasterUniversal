package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class AutomationClientConnectPacket implements BedrockPacket {
   private String address;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.AUTOMATION_CLIENT_CONNECT;
   }

   public String getAddress() {
      return this.address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AutomationClientConnectPacket)) {
         return false;
      }

      AutomationClientConnectPacket other = (AutomationClientConnectPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$address = this.address;
      Object other$address = other.address;
      return this$address == null ? other$address == null : this$address.equals(other$address);
   }

   protected boolean canEqual(Object other) {
      return other instanceof AutomationClientConnectPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $address = this.address;
      return result * 59 + ($address == null ? 43 : $address.hashCode());
   }

   @Override
   public String toString() {
      return "AutomationClientConnectPacket(address=" + this.address + ")";
   }
}
