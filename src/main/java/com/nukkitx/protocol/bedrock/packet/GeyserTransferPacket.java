package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;
import java.util.Arrays;

public class GeyserTransferPacket implements BedrockPacket {
   private byte[] transferData;

   public GeyserTransferPacket() {
   }

   public GeyserTransferPacket(byte[] data) {
      this.transferData = data;
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.GEYSER_TRANSFER;
   }

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      throw new UnsupportedOperationException("Unimplemented method 'handle'");
   }

   public byte[] getTransferData() {
      return this.transferData;
   }

   public void setTransferData(byte[] transferData) {
      this.transferData = transferData;
   }

   @Override
   public String toString() {
      return "GeyserTransferPacket(transferData=" + Arrays.toString(this.getTransferData()) + ")";
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof GeyserTransferPacket)) {
         return false;
      }

      GeyserTransferPacket other = (GeyserTransferPacket)o;
      return !other.canEqual(this) ? false : Arrays.equals(this.transferData, other.transferData);
   }

   protected boolean canEqual(Object other) {
      return other instanceof GeyserTransferPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      return result * 59 + Arrays.hashCode(this.transferData);
   }
}
