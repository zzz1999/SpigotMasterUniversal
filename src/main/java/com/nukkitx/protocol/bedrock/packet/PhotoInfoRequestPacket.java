package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class PhotoInfoRequestPacket implements BedrockPacket {
   private long photoId;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.PHOTO_INFO_REQUEST;
   }

   public long getPhotoId() {
      return this.photoId;
   }

   public void setPhotoId(long photoId) {
      this.photoId = photoId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PhotoInfoRequestPacket)) {
         return false;
      }

      PhotoInfoRequestPacket other = (PhotoInfoRequestPacket)o;
      return !other.canEqual(this) ? false : this.photoId == other.photoId;
   }

   protected boolean canEqual(Object other) {
      return other instanceof PhotoInfoRequestPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $photoId = this.photoId;
      return result * 59 + (int)($photoId >>> 32 ^ $photoId);
   }

   @Override
   public String toString() {
      return "PhotoInfoRequestPacket(photoId=" + this.photoId + ")";
   }
}
