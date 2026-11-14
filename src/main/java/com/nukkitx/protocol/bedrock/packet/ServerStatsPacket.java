package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

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

   public float getServerTime() {
      return this.serverTime;
   }

   public float getNetworkTime() {
      return this.networkTime;
   }

   public void setServerTime(float serverTime) {
      this.serverTime = serverTime;
   }

   public void setNetworkTime(float networkTime) {
      this.networkTime = networkTime;
   }

   @Override
   public boolean equals(Object o) {
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

   protected boolean canEqual(Object other) {
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
