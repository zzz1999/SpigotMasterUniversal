package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

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

   public FilterTextPacket clone() {
      try {
         return (FilterTextPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public String getText() {
      return this.text;
   }

   public boolean isFromServer() {
      return this.fromServer;
   }

   public void setText(final String text) {
      this.text = text;
   }

   public void setFromServer(final boolean fromServer) {
      this.fromServer = fromServer;
   }

   @Override
   public boolean equals(final Object o) {
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

   protected boolean canEqual(final Object other) {
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
