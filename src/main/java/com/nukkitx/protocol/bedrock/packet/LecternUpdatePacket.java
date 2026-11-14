package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;
import org.cloudburstmc.math.vector.Vector3i;

public class LecternUpdatePacket implements BedrockPacket {
   private int page;
   private int totalPages;
   private Vector3i blockPosition;
   @Deprecated
   private boolean droppingBook;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.LECTERN_UPDATE;
   }

   public int getPage() {
      return this.page;
   }

   public int getTotalPages() {
      return this.totalPages;
   }

   public Vector3i getBlockPosition() {
      return this.blockPosition;
   }

   @Deprecated
   public boolean isDroppingBook() {
      return this.droppingBook;
   }

   public void setPage(int page) {
      this.page = page;
   }

   public void setTotalPages(int totalPages) {
      this.totalPages = totalPages;
   }

   public void setBlockPosition(Vector3i blockPosition) {
      this.blockPosition = blockPosition;
   }

   @Deprecated
   public void setDroppingBook(boolean droppingBook) {
      this.droppingBook = droppingBook;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LecternUpdatePacket)) {
         return false;
      }

      LecternUpdatePacket other = (LecternUpdatePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.page != other.page) {
         return false;
      }

      if (this.totalPages != other.totalPages) {
         return false;
      }

      if (this.droppingBook != other.droppingBook) {
         return false;
      }

      Object this$blockPosition = this.blockPosition;
      Object other$blockPosition = other.blockPosition;
      return this$blockPosition == null ? other$blockPosition == null : this$blockPosition.equals(other$blockPosition);
   }

   protected boolean canEqual(Object other) {
      return other instanceof LecternUpdatePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.page;
      result = result * 59 + this.totalPages;
      result = result * 59 + (this.droppingBook ? 79 : 97);
      Object $blockPosition = this.blockPosition;
      return result * 59 + ($blockPosition == null ? 43 : $blockPosition.hashCode());
   }

   @Override
   public String toString() {
      return "LecternUpdatePacket(page="
         + this.page
         + ", totalPages="
         + this.totalPages
         + ", blockPosition="
         + this.blockPosition
         + ", droppingBook="
         + this.droppingBook
         + ")";
   }
}
