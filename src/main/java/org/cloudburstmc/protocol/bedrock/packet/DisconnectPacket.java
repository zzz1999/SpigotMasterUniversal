package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.DisconnectFailReason;
import org.cloudburstmc.protocol.common.PacketSignal;

public class DisconnectPacket implements BedrockPacket {
   private DisconnectFailReason reason = DisconnectFailReason.UNKNOWN;
   private boolean messageSkipped;
   private CharSequence kickMessage;
   private CharSequence filteredMessage = "";

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.DISCONNECT;
   }

   public DisconnectPacket clone() {
      try {
         return (DisconnectPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public String getKickMessage() {
      return this.getKickMessage(String.class);
   }

   public <T extends CharSequence> T getKickMessage(Class<T> type) {
      return type.cast(this.kickMessage);
   }

   public String getFilteredMessage() {
      return this.getFilteredMessage(String.class);
   }

   public <T extends CharSequence> T getFilteredMessage(Class<T> type) {
      return type.cast(this.filteredMessage);
   }

   public DisconnectFailReason getReason() {
      return this.reason;
   }

   public boolean isMessageSkipped() {
      return this.messageSkipped;
   }

   public void setReason(final DisconnectFailReason reason) {
      this.reason = reason;
   }

   public void setMessageSkipped(final boolean messageSkipped) {
      this.messageSkipped = messageSkipped;
   }

   public void setKickMessage(final CharSequence kickMessage) {
      this.kickMessage = kickMessage;
   }

   public void setFilteredMessage(final CharSequence filteredMessage) {
      this.filteredMessage = filteredMessage;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DisconnectPacket)) {
         return false;
      }

      DisconnectPacket other = (DisconnectPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.messageSkipped != other.messageSkipped) {
         return false;
      }

      Object this$reason = this.reason;
      Object other$reason = other.reason;
      if (this$reason == null ? other$reason == null : this$reason.equals(other$reason)) {
         Object this$kickMessage = this.kickMessage;
         Object other$kickMessage = other.kickMessage;
         if (this$kickMessage == null ? other$kickMessage == null : this$kickMessage.equals(other$kickMessage)) {
            Object this$filteredMessage = this.filteredMessage;
            Object other$filteredMessage = other.filteredMessage;
            return this$filteredMessage == null ? other$filteredMessage == null : this$filteredMessage.equals(other$filteredMessage);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DisconnectPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.messageSkipped ? 79 : 97);
      Object $reason = this.reason;
      result = result * 59 + ($reason == null ? 43 : $reason.hashCode());
      Object $kickMessage = this.kickMessage;
      result = result * 59 + ($kickMessage == null ? 43 : $kickMessage.hashCode());
      Object $filteredMessage = this.filteredMessage;
      return result * 59 + ($filteredMessage == null ? 43 : $filteredMessage.hashCode());
   }

   @Override
   public String toString() {
      return "DisconnectPacket(reason="
         + this.reason
         + ", messageSkipped="
         + this.messageSkipped
         + ", kickMessage="
         + this.kickMessage
         + ", filteredMessage="
         + this.filteredMessage
         + ")";
   }
}
