package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class ToastRequestPacket implements BedrockPacket {
   private CharSequence title;
   private CharSequence content;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.TOAST_REQUEST;
   }

   public ToastRequestPacket clone() {
      try {
         return (ToastRequestPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public String getTitle() {
      return this.getTitle(String.class);
   }

   public <T extends CharSequence> T getTitle(Class<T> type) {
      return type.cast(this.title);
   }

   public String getContent() {
      return this.getContent(String.class);
   }

   public <T extends CharSequence> T getContent(Class<T> type) {
      return type.cast(this.content);
   }

   public void setTitle(final CharSequence title) {
      this.title = title;
   }

   public void setContent(final CharSequence content) {
      this.content = content;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ToastRequestPacket)) {
         return false;
      } else {
         ToastRequestPacket other = (ToastRequestPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$title = this.title;
            Object other$title = other.title;
            if (this$title == null ? other$title == null : this$title.equals(other$title)) {
               Object this$content = this.content;
               Object other$content = other.content;
               return this$content == null ? other$content == null : this$content.equals(other$content);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ToastRequestPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $title = this.title;
      result = result * 59 + ($title == null ? 43 : $title.hashCode());
      Object $content = this.content;
      return result * 59 + ($content == null ? 43 : $content.hashCode());
   }

   @Override
   public String toString() {
      return "ToastRequestPacket(title=" + this.title + ", content=" + this.content + ")";
   }
}
