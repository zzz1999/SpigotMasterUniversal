package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.MovementEffectType;
import org.cloudburstmc.protocol.common.PacketSignal;

public class MovementEffectPacket implements BedrockPacket {
   private long entityRuntimeId;
   private MovementEffectType effectType;
   private int duration;
   private long tick;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.MOVEMENT_EFFECT;
   }

   public MovementEffectPacket clone() {
      try {
         return (MovementEffectPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public long getEntityRuntimeId() {
      return this.entityRuntimeId;
   }

   public MovementEffectType getEffectType() {
      return this.effectType;
   }

   public int getDuration() {
      return this.duration;
   }

   public long getTick() {
      return this.tick;
   }

   public void setEntityRuntimeId(final long entityRuntimeId) {
      this.entityRuntimeId = entityRuntimeId;
   }

   public void setEffectType(final MovementEffectType effectType) {
      this.effectType = effectType;
   }

   public void setDuration(final int duration) {
      this.duration = duration;
   }

   public void setTick(final long tick) {
      this.tick = tick;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MovementEffectPacket)) {
         return false;
      }

      MovementEffectPacket other = (MovementEffectPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.entityRuntimeId != other.entityRuntimeId) {
         return false;
      }

      if (this.duration != other.duration) {
         return false;
      }

      if (this.tick != other.tick) {
         return false;
      }

      Object this$effectType = this.effectType;
      Object other$effectType = other.effectType;
      return this$effectType == null ? other$effectType == null : this$effectType.equals(other$effectType);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MovementEffectPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $entityRuntimeId = this.entityRuntimeId;
      result = result * 59 + (int)($entityRuntimeId >>> 32 ^ $entityRuntimeId);
      result = result * 59 + this.duration;
      long $tick = this.tick;
      result = result * 59 + (int)($tick >>> 32 ^ $tick);
      Object $effectType = this.effectType;
      return result * 59 + ($effectType == null ? 43 : $effectType.hashCode());
   }

   @Override
   public String toString() {
      return "MovementEffectPacket(entityRuntimeId="
         + this.entityRuntimeId
         + ", effectType="
         + this.effectType
         + ", duration="
         + this.duration
         + ", tick="
         + this.tick
         + ")";
   }
}
