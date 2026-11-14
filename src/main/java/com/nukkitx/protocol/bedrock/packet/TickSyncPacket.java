package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class TickSyncPacket implements BedrockPacket {
   private long requestTimestamp;
   private long responseTimestamp;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.TICK_SYNC;
   }

   public long getRequestTimestamp() {
      return this.requestTimestamp;
   }

   public long getResponseTimestamp() {
      return this.responseTimestamp;
   }

   public void setRequestTimestamp(long requestTimestamp) {
      this.requestTimestamp = requestTimestamp;
   }

   public void setResponseTimestamp(long responseTimestamp) {
      this.responseTimestamp = responseTimestamp;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TickSyncPacket)) {
         return false;
      } else {
         TickSyncPacket other = (TickSyncPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            return this.requestTimestamp != other.requestTimestamp ? false : this.responseTimestamp == other.responseTimestamp;
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof TickSyncPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $requestTimestamp = this.requestTimestamp;
      result = result * 59 + (int)($requestTimestamp >>> 32 ^ $requestTimestamp);
      long $responseTimestamp = this.responseTimestamp;
      return result * 59 + (int)($responseTimestamp >>> 32 ^ $responseTimestamp);
   }

   @Override
   public String toString() {
      return "TickSyncPacket(requestTimestamp=" + this.requestTimestamp + ", responseTimestamp=" + this.responseTimestamp + ")";
   }
}
