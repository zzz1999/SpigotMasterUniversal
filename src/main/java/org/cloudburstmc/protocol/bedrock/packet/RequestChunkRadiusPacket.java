package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

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

   public RequestChunkRadiusPacket clone() {
      try {
         return (RequestChunkRadiusPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public int getRadius() {
      return this.radius;
   }

   public int getMaxRadius() {
      return this.maxRadius;
   }

   public void setRadius(final int radius) {
      this.radius = radius;
   }

   public void setMaxRadius(final int maxRadius) {
      this.maxRadius = maxRadius;
   }

   @Override
   public boolean equals(final Object o) {
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

   protected boolean canEqual(final Object other) {
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
