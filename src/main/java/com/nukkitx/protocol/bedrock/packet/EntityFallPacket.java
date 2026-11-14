package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class EntityFallPacket implements BedrockPacket {
   private long runtimeEntityId;
   private float fallDistance;
   private boolean inVoid;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.ENTITY_FALL;
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public float getFallDistance() {
      return this.fallDistance;
   }

   public boolean isInVoid() {
      return this.inVoid;
   }

   public void setRuntimeEntityId(long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setFallDistance(float fallDistance) {
      this.fallDistance = fallDistance;
   }

   public void setInVoid(boolean inVoid) {
      this.inVoid = inVoid;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof EntityFallPacket)) {
         return false;
      } else {
         EntityFallPacket other = (EntityFallPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.runtimeEntityId != other.runtimeEntityId) {
            return false;
         } else {
            return Float.compare(this.fallDistance, other.fallDistance) != 0 ? false : this.inVoid == other.inVoid;
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof EntityFallPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      result = result * 59 + Float.floatToIntBits(this.fallDistance);
      return result * 59 + (this.inVoid ? 79 : 97);
   }

   @Override
   public String toString() {
      return "EntityFallPacket(runtimeEntityId=" + this.runtimeEntityId + ", fallDistance=" + this.fallDistance + ", inVoid=" + this.inVoid + ")";
   }
}
