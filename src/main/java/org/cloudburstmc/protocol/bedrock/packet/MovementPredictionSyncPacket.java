package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.util.Set;
import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.protocol.bedrock.data.entity.EntityFlag;
import org.cloudburstmc.protocol.common.PacketSignal;

public class MovementPredictionSyncPacket implements BedrockPacket {
   private long runtimeEntityId;
   private final Set<EntityFlag> flags = new ObjectOpenHashSet<>();
   private Vector3f boundingBox;
   private float speed;
   private float underwaterSpeed;
   private float lavaSpeed;
   private float jumpStrength;
   private float health;
   private float hunger;
   private boolean flying;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.MOVEMENT_PREDICTION_SYNC;
   }

   public MovementPredictionSyncPacket clone() {
      try {
         return (MovementPredictionSyncPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public Set<EntityFlag> getFlags() {
      return this.flags;
   }

   public Vector3f getBoundingBox() {
      return this.boundingBox;
   }

   public float getSpeed() {
      return this.speed;
   }

   public float getUnderwaterSpeed() {
      return this.underwaterSpeed;
   }

   public float getLavaSpeed() {
      return this.lavaSpeed;
   }

   public float getJumpStrength() {
      return this.jumpStrength;
   }

   public float getHealth() {
      return this.health;
   }

   public float getHunger() {
      return this.hunger;
   }

   public boolean isFlying() {
      return this.flying;
   }

   public void setRuntimeEntityId(final long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setBoundingBox(final Vector3f boundingBox) {
      this.boundingBox = boundingBox;
   }

   public void setSpeed(final float speed) {
      this.speed = speed;
   }

   public void setUnderwaterSpeed(final float underwaterSpeed) {
      this.underwaterSpeed = underwaterSpeed;
   }

   public void setLavaSpeed(final float lavaSpeed) {
      this.lavaSpeed = lavaSpeed;
   }

   public void setJumpStrength(final float jumpStrength) {
      this.jumpStrength = jumpStrength;
   }

   public void setHealth(final float health) {
      this.health = health;
   }

   public void setHunger(final float hunger) {
      this.hunger = hunger;
   }

   public void setFlying(final boolean flying) {
      this.flying = flying;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MovementPredictionSyncPacket)) {
         return false;
      } else {
         MovementPredictionSyncPacket other = (MovementPredictionSyncPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.runtimeEntityId != other.runtimeEntityId) {
            return false;
         } else if (Float.compare(this.speed, other.speed) != 0) {
            return false;
         } else if (Float.compare(this.underwaterSpeed, other.underwaterSpeed) != 0) {
            return false;
         } else if (Float.compare(this.lavaSpeed, other.lavaSpeed) != 0) {
            return false;
         } else if (Float.compare(this.jumpStrength, other.jumpStrength) != 0) {
            return false;
         } else if (Float.compare(this.health, other.health) != 0) {
            return false;
         } else if (Float.compare(this.hunger, other.hunger) != 0) {
            return false;
         } else if (this.flying != other.flying) {
            return false;
         } else {
            Object this$flags = this.flags;
            Object other$flags = other.flags;
            if (this$flags == null ? other$flags == null : this$flags.equals(other$flags)) {
               Object this$boundingBox = this.boundingBox;
               Object other$boundingBox = other.boundingBox;
               return this$boundingBox == null ? other$boundingBox == null : this$boundingBox.equals(other$boundingBox);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MovementPredictionSyncPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      result = result * 59 + Float.floatToIntBits(this.speed);
      result = result * 59 + Float.floatToIntBits(this.underwaterSpeed);
      result = result * 59 + Float.floatToIntBits(this.lavaSpeed);
      result = result * 59 + Float.floatToIntBits(this.jumpStrength);
      result = result * 59 + Float.floatToIntBits(this.health);
      result = result * 59 + Float.floatToIntBits(this.hunger);
      result = result * 59 + (this.flying ? 79 : 97);
      Object $flags = this.flags;
      result = result * 59 + ($flags == null ? 43 : $flags.hashCode());
      Object $boundingBox = this.boundingBox;
      return result * 59 + ($boundingBox == null ? 43 : $boundingBox.hashCode());
   }

   @Override
   public String toString() {
      return "MovementPredictionSyncPacket(runtimeEntityId="
         + this.runtimeEntityId
         + ", flags="
         + this.flags
         + ", boundingBox="
         + this.boundingBox
         + ", speed="
         + this.speed
         + ", underwaterSpeed="
         + this.underwaterSpeed
         + ", lavaSpeed="
         + this.lavaSpeed
         + ", jumpStrength="
         + this.jumpStrength
         + ", health="
         + this.health
         + ", hunger="
         + this.hunger
         + ", flying="
         + this.flying
         + ")";
   }
}
