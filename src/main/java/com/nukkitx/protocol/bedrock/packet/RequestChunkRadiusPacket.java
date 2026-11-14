package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class RequestChunkRadiusPacket implements BedrockPacket {
   private int radius;
   private int maxRadius;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.REQUEST_CHUNK_RADIUS;
   }

   public int getRadius() {
      return this.radius;
   }

   public int getMaxRadius() {
      return this.maxRadius;
   }

   public void setRadius(int radius) {
      this.radius = radius;
   }

   public void setMaxRadius(int maxRadius) {
      this.maxRadius = maxRadius;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof RequestChunkRadiusPacket)) {
         return false;
      } else {
         RequestChunkRadiusPacket other = (RequestChunkRadiusPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            return this.radius != other.radius ? false : this.maxRadius == other.maxRadius;
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof RequestChunkRadiusPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.radius;
      return result * 59 + this.maxRadius;
   }

   @Override
   public String toString() {
      return "RequestChunkRadiusPacket(radius=" + this.radius + ", maxRadius=" + this.maxRadius + ")";
   }
}
