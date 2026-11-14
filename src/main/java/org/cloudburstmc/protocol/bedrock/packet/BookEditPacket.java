package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class BookEditPacket implements BedrockPacket {
   private BookEditPacket.Action action;
   private int inventorySlot;
   private int pageNumber;
   private int secondaryPageNumber;
   private CharSequence text;
   private String photoName;
   private CharSequence title;
   private CharSequence author;
   private String xuid;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.BOOK_EDIT;
   }

   public BookEditPacket clone() {
      try {
         return (BookEditPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public String getText() {
      return this.getText(String.class);
   }

   public <T extends CharSequence> T getText(Class<T> type) {
      return type.cast(this.text);
   }

   public String getTitle() {
      return this.getTitle(String.class);
   }

   public <T extends CharSequence> T getTitle(Class<T> type) {
      return type.cast(this.title);
   }

   public String getAuthor() {
      return this.getAuthor(String.class);
   }

   public <T extends CharSequence> T getAuthor(Class<T> type) {
      return type.cast(this.author);
   }

   public BookEditPacket.Action getAction() {
      return this.action;
   }

   public int getInventorySlot() {
      return this.inventorySlot;
   }

   public int getPageNumber() {
      return this.pageNumber;
   }

   public int getSecondaryPageNumber() {
      return this.secondaryPageNumber;
   }

   public String getPhotoName() {
      return this.photoName;
   }

   public String getXuid() {
      return this.xuid;
   }

   public void setAction(final BookEditPacket.Action action) {
      this.action = action;
   }

   public void setInventorySlot(final int inventorySlot) {
      this.inventorySlot = inventorySlot;
   }

   public void setPageNumber(final int pageNumber) {
      this.pageNumber = pageNumber;
   }

   public void setSecondaryPageNumber(final int secondaryPageNumber) {
      this.secondaryPageNumber = secondaryPageNumber;
   }

   public void setText(final CharSequence text) {
      this.text = text;
   }

   public void setPhotoName(final String photoName) {
      this.photoName = photoName;
   }

   public void setTitle(final CharSequence title) {
      this.title = title;
   }

   public void setAuthor(final CharSequence author) {
      this.author = author;
   }

   public void setXuid(final String xuid) {
      this.xuid = xuid;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BookEditPacket)) {
         return false;
      }

      BookEditPacket other = (BookEditPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.inventorySlot != other.inventorySlot) {
         return false;
      }

      if (this.pageNumber != other.pageNumber) {
         return false;
      }

      if (this.secondaryPageNumber != other.secondaryPageNumber) {
         return false;
      }

      Object this$action = this.action;
      Object other$action = other.action;
      if (this$action == null ? other$action == null : this$action.equals(other$action)) {
         Object this$text = this.text;
         Object other$text = other.text;
         if (this$text == null ? other$text == null : this$text.equals(other$text)) {
            Object this$photoName = this.photoName;
            Object other$photoName = other.photoName;
            if (this$photoName == null ? other$photoName == null : this$photoName.equals(other$photoName)) {
               Object this$title = this.title;
               Object other$title = other.title;
               if (this$title == null ? other$title == null : this$title.equals(other$title)) {
                  Object this$author = this.author;
                  Object other$author = other.author;
                  if (this$author == null ? other$author == null : this$author.equals(other$author)) {
                     Object this$xuid = this.xuid;
                     Object other$xuid = other.xuid;
                     return this$xuid == null ? other$xuid == null : this$xuid.equals(other$xuid);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BookEditPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.inventorySlot;
      result = result * 59 + this.pageNumber;
      result = result * 59 + this.secondaryPageNumber;
      Object $action = this.action;
      result = result * 59 + ($action == null ? 43 : $action.hashCode());
      Object $text = this.text;
      result = result * 59 + ($text == null ? 43 : $text.hashCode());
      Object $photoName = this.photoName;
      result = result * 59 + ($photoName == null ? 43 : $photoName.hashCode());
      Object $title = this.title;
      result = result * 59 + ($title == null ? 43 : $title.hashCode());
      Object $author = this.author;
      result = result * 59 + ($author == null ? 43 : $author.hashCode());
      Object $xuid = this.xuid;
      return result * 59 + ($xuid == null ? 43 : $xuid.hashCode());
   }

   @Override
   public String toString() {
      return "BookEditPacket(action="
         + this.action
         + ", inventorySlot="
         + this.inventorySlot
         + ", pageNumber="
         + this.pageNumber
         + ", secondaryPageNumber="
         + this.secondaryPageNumber
         + ", text="
         + this.text
         + ", photoName="
         + this.photoName
         + ", title="
         + this.title
         + ", author="
         + this.author
         + ", xuid="
         + this.xuid
         + ")";
   }

   public enum Action {
      REPLACE_PAGE,
      ADD_PAGE,
      DELETE_PAGE,
      SWAP_PAGES,
      SIGN_BOOK;
   }
}
