package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class NetworkStackLatencyPacket implements BedrockPacket {
   private long timestamp;
   private boolean fromServer;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.NETWORK_STACK_LATENCY;
   }

   public NetworkStackLatencyPacket clone() {
      try {
         return (NetworkStackLatencyPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public long getTimestamp() {
      return this.timestamp;
   }

   public boolean isFromServer() {
      return this.fromServer;
   }

   public void setTimestamp(final long timestamp) {
      this.timestamp = timestamp;
   }

   public void setFromServer(final boolean fromServer) {
      this.fromServer = fromServer;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof NetworkStackLatencyPacket)) {
         return false;
      } else {
         NetworkStackLatencyPacket other = (NetworkStackLatencyPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            return this.timestamp != other.timestamp ? false : this.fromServer == other.fromServer;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof NetworkStackLatencyPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $timestamp = this.timestamp;
      result = result * 59 + (int)($timestamp >>> 32 ^ $timestamp);
      return result * 59 + (this.fromServer ? 79 : 97);
   }

   @Override
   public String toString() {
      return "NetworkStackLatencyPacket(timestamp=" + this.timestamp + ", fromServer=" + this.fromServer + ")";
   }
}
