package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

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

   public TickSyncPacket clone() {
      try {
         return (TickSyncPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public long getRequestTimestamp() {
      return this.requestTimestamp;
   }

   public long getResponseTimestamp() {
      return this.responseTimestamp;
   }

   public void setRequestTimestamp(final long requestTimestamp) {
      this.requestTimestamp = requestTimestamp;
   }

   public void setResponseTimestamp(final long responseTimestamp) {
      this.responseTimestamp = responseTimestamp;
   }

   @Override
   public boolean equals(final Object o) {
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

   protected boolean canEqual(final Object other) {
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
