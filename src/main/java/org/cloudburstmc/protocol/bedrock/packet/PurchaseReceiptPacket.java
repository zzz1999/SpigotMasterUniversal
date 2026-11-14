package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.cloudburstmc.protocol.common.PacketSignal;

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

   public PurchaseReceiptPacket clone() {
      try {
         return (PurchaseReceiptPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public List<String> getReceipts() {
      return this.receipts;
   }

   @Override
   public boolean equals(final Object o) {
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

   protected boolean canEqual(final Object other) {
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
