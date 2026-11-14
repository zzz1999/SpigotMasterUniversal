package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.StoreOfferRedirectType;
import com.nukkitx.protocol.common.PacketSignal;

public class ShowStoreOfferPacket implements BedrockPacket {
   private String offerId;
   @Deprecated
   private boolean shownToAll;
   private StoreOfferRedirectType redirectType;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SHOW_STORE_OFFER;
   }

   public String getOfferId() {
      return this.offerId;
   }

   @Deprecated
   public boolean isShownToAll() {
      return this.shownToAll;
   }

   public StoreOfferRedirectType getRedirectType() {
      return this.redirectType;
   }

   public void setOfferId(String offerId) {
      this.offerId = offerId;
   }

   @Deprecated
   public void setShownToAll(boolean shownToAll) {
      this.shownToAll = shownToAll;
   }

   public void setRedirectType(StoreOfferRedirectType redirectType) {
      this.redirectType = redirectType;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ShowStoreOfferPacket)) {
         return false;
      } else {
         ShowStoreOfferPacket other = (ShowStoreOfferPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.shownToAll != other.shownToAll) {
            return false;
         } else {
            Object this$offerId = this.offerId;
            Object other$offerId = other.offerId;
            if (this$offerId == null ? other$offerId == null : this$offerId.equals(other$offerId)) {
               Object this$redirectType = this.redirectType;
               Object other$redirectType = other.redirectType;
               return this$redirectType == null ? other$redirectType == null : this$redirectType.equals(other$redirectType);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof ShowStoreOfferPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.shownToAll ? 79 : 97);
      Object $offerId = this.offerId;
      result = result * 59 + ($offerId == null ? 43 : $offerId.hashCode());
      Object $redirectType = this.redirectType;
      return result * 59 + ($redirectType == null ? 43 : $redirectType.hashCode());
   }

   @Override
   public String toString() {
      return "ShowStoreOfferPacket(offerId=" + this.offerId + ", shownToAll=" + this.shownToAll + ", redirectType=" + this.redirectType + ")";
   }
}
