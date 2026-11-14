package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class ServerStatsPacket implements BedrockPacket {
   private float serverTime;
   private float networkTime;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SERVER_STATS;
   }

   public ServerStatsPacket clone() {
      try {
         return (ServerStatsPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public float getServerTime() {
      return this.serverTime;
   }

   public float getNetworkTime() {
      return this.networkTime;
   }

   public void setServerTime(final float serverTime) {
      this.serverTime = serverTime;
   }

   public void setNetworkTime(final float networkTime) {
      this.networkTime = networkTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ServerStatsPacket)) {
         return false;
      } else {
         ServerStatsPacket other = (ServerStatsPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            return Float.compare(this.serverTime, other.serverTime) != 0 ? false : Float.compare(this.networkTime, other.networkTime) == 0;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ServerStatsPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + Float.floatToIntBits(this.serverTime);
      return result * 59 + Float.floatToIntBits(this.networkTime);
   }

   @Override
   public String toString() {
      return "ServerStatsPacket(serverTime=" + this.serverTime + ", networkTime=" + this.networkTime + ")";
   }
}
