package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class TransferPacket implements BedrockPacket {
   private String address;
   private int port;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.TRANSFER;
   }

   public String getAddress() {
      return this.address;
   }

   public int getPort() {
      return this.port;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public void setPort(int port) {
      this.port = port;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TransferPacket)) {
         return false;
      }

      TransferPacket other = (TransferPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.port != other.port) {
         return false;
      }

      Object this$address = this.address;
      Object other$address = other.address;
      return this$address == null ? other$address == null : this$address.equals(other$address);
   }

   protected boolean canEqual(Object other) {
      return other instanceof TransferPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.port;
      Object $address = this.address;
      return result * 59 + ($address == null ? 43 : $address.hashCode());
   }

   @Override
   public String toString() {
      return "TransferPacket(address=" + this.address + ", port=" + this.port + ")";
   }
}
