package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class ScriptMessagePacket implements BedrockPacket {
   private String channel;
   private String message;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SCRIPT_MESSAGE;
   }

   public String getChannel() {
      return this.channel;
   }

   public String getMessage() {
      return this.message;
   }

   public void setChannel(String channel) {
      this.channel = channel;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ScriptMessagePacket)) {
         return false;
      } else {
         ScriptMessagePacket other = (ScriptMessagePacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$channel = this.channel;
            Object other$channel = other.channel;
            if (this$channel == null ? other$channel == null : this$channel.equals(other$channel)) {
               Object this$message = this.message;
               Object other$message = other.message;
               return this$message == null ? other$message == null : this$message.equals(other$message);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof ScriptMessagePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $channel = this.channel;
      result = result * 59 + ($channel == null ? 43 : $channel.hashCode());
      Object $message = this.message;
      return result * 59 + ($message == null ? 43 : $message.hashCode());
   }

   @Override
   public String toString() {
      return "ScriptMessagePacket(channel=" + this.channel + ", message=" + this.message + ")";
   }
}
