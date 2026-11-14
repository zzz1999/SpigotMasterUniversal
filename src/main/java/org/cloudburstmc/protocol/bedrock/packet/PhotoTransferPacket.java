package org.cloudburstmc.protocol.bedrock.packet;

import java.util.Arrays;
import org.cloudburstmc.protocol.bedrock.data.PhotoType;
import org.cloudburstmc.protocol.common.PacketSignal;

public class PhotoTransferPacket implements BedrockPacket {
   private String name;
   private byte[] data;
   private String bookId;
   private PhotoType photoType;
   private PhotoType sourceType;
   private long ownerId;
   private String newPhotoName;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.PHOTO_TRANSFER;
   }

   public PhotoTransferPacket clone() {
      try {
         return (PhotoTransferPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public String getName() {
      return this.name;
   }

   public byte[] getData() {
      return this.data;
   }

   public String getBookId() {
      return this.bookId;
   }

   public PhotoType getPhotoType() {
      return this.photoType;
   }

   public PhotoType getSourceType() {
      return this.sourceType;
   }

   public long getOwnerId() {
      return this.ownerId;
   }

   public String getNewPhotoName() {
      return this.newPhotoName;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setData(final byte[] data) {
      this.data = data;
   }

   public void setBookId(final String bookId) {
      this.bookId = bookId;
   }

   public void setPhotoType(final PhotoType photoType) {
      this.photoType = photoType;
   }

   public void setSourceType(final PhotoType sourceType) {
      this.sourceType = sourceType;
   }

   public void setOwnerId(final long ownerId) {
      this.ownerId = ownerId;
   }

   public void setNewPhotoName(final String newPhotoName) {
      this.newPhotoName = newPhotoName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PhotoTransferPacket)) {
         return false;
      }

      PhotoTransferPacket other = (PhotoTransferPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.ownerId != other.ownerId) {
         return false;
      }

      Object this$name = this.name;
      Object other$name = other.name;
      if (this$name == null ? other$name == null : this$name.equals(other$name)) {
         if (!Arrays.equals(this.data, other.data)) {
            return false;
         }

         Object this$bookId = this.bookId;
         Object other$bookId = other.bookId;
         if (this$bookId == null ? other$bookId == null : this$bookId.equals(other$bookId)) {
            Object this$photoType = this.photoType;
            Object other$photoType = other.photoType;
            if (this$photoType == null ? other$photoType == null : this$photoType.equals(other$photoType)) {
               Object this$sourceType = this.sourceType;
               Object other$sourceType = other.sourceType;
               if (this$sourceType == null ? other$sourceType == null : this$sourceType.equals(other$sourceType)) {
                  Object this$newPhotoName = this.newPhotoName;
                  Object other$newPhotoName = other.newPhotoName;
                  return this$newPhotoName == null ? other$newPhotoName == null : this$newPhotoName.equals(other$newPhotoName);
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PhotoTransferPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $ownerId = this.ownerId;
      result = result * 59 + (int)($ownerId >>> 32 ^ $ownerId);
      Object $name = this.name;
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      result = result * 59 + Arrays.hashCode(this.data);
      Object $bookId = this.bookId;
      result = result * 59 + ($bookId == null ? 43 : $bookId.hashCode());
      Object $photoType = this.photoType;
      result = result * 59 + ($photoType == null ? 43 : $photoType.hashCode());
      Object $sourceType = this.sourceType;
      result = result * 59 + ($sourceType == null ? 43 : $sourceType.hashCode());
      Object $newPhotoName = this.newPhotoName;
      return result * 59 + ($newPhotoName == null ? 43 : $newPhotoName.hashCode());
   }

   @Override
   public String toString() {
      return "PhotoTransferPacket(name="
         + this.name
         + ", data="
         + Arrays.toString(this.data)
         + ", bookId="
         + this.bookId
         + ", photoType="
         + this.photoType
         + ", sourceType="
         + this.sourceType
         + ", ownerId="
         + this.ownerId
         + ", newPhotoName="
         + this.newPhotoName
         + ")";
   }
}
