package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;

public class PurchaseReceiptPacket implements BedrockPacket {
   private final List<String> receipts = new ObjectArrayList<>();

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.PURCHASE_RECEIPT;
   }

   public List<String> getReceipts() {
      return this.receipts;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PurchaseReceiptPacket)) {
         return false;
      }

      PurchaseReceiptPacket other = (PurchaseReceiptPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$receipts = this.receipts;
      Object other$receipts = other.receipts;
      return this$receipts == null ? other$receipts == null : this$receipts.equals(other$receipts);
   }

   protected boolean canEqual(Object other) {
      return other instanceof PurchaseReceiptPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $receipts = this.receipts;
      return result * 59 + ($receipts == null ? 43 : $receipts.hashCode());
   }

   @Override
   public String toString() {
      return "PurchaseReceiptPacket(receipts=" + this.receipts + ")";
   }
}
