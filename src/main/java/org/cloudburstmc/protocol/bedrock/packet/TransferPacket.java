package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class TransferPacket implements BedrockPacket {
   private String address;
   private int port;
   private boolean reloadWorld;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.TRANSFER;
   }

   public TransferPacket clone() {
      try {
         return (TransferPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public String getAddress() {
      return this.address;
   }

   public int getPort() {
      return this.port;
   }

   public boolean isReloadWorld() {
      return this.reloadWorld;
   }

   public void setAddress(final String address) {
      this.address = address;
   }

   public void setPort(final int port) {
      this.port = port;
   }

   public void setReloadWorld(final boolean reloadWorld) {
      this.reloadWorld = reloadWorld;
   }

   @Override
   public boolean equals(final Object o) {
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

      if (this.reloadWorld != other.reloadWorld) {
         return false;
      }

      Object this$address = this.address;
      Object other$address = other.address;
      return this$address == null ? other$address == null : this$address.equals(other$address);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TransferPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.port;
      result = result * 59 + (this.reloadWorld ? 79 : 97);
      Object $address = this.address;
      return result * 59 + ($address == null ? 43 : $address.hashCode());
   }

   @Override
   public String toString() {
      return "TransferPacket(address=" + this.address + ", port=" + this.port + ", reloadWorld=" + this.reloadWorld + ")";
   }
}
