package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class FilterTextPacket implements BedrockPacket {
   private String text;
   private boolean fromServer;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.FILTER_TEXT;
   }

   public String getText() {
      return this.text;
   }

   public boolean isFromServer() {
      return this.fromServer;
   }

   public void setText(String text) {
      this.text = text;
   }

   public void setFromServer(boolean fromServer) {
      this.fromServer = fromServer;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FilterTextPacket)) {
         return false;
      }

      FilterTextPacket other = (FilterTextPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.fromServer != other.fromServer) {
         return false;
      }

      Object this$text = this.text;
      Object other$text = other.text;
      return this$text == null ? other$text == null : this$text.equals(other$text);
   }

   protected boolean canEqual(Object other) {
      return other instanceof FilterTextPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.fromServer ? 79 : 97);
      Object $text = this.text;
      return result * 59 + ($text == null ? 43 : $text.hashCode());
   }

   @Override
   public String toString() {
      return "FilterTextPacket(text=" + this.text + ", fromServer=" + this.fromServer + ")";
   }
}
