package org.cloudburstmc.protocol.bedrock.packet;

import java.util.EnumSet;
import java.util.Set;
import org.cloudburstmc.protocol.common.PacketSignal;

public class MoveEntityDeltaPacket implements BedrockPacket {
   private long runtimeEntityId;
   private final Set<MoveEntityDeltaPacket.Flag> flags = EnumSet.noneOf(MoveEntityDeltaPacket.Flag.class);
   private int deltaX;
   private int deltaY;
   private int deltaZ;
   private float x;
   private float y;
   private float z;
   private float pitch;
   private float yaw;
   private float headYaw;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.MOVE_ENTITY_DELTA;
   }

   @Override
   public String toString() {
      return "MoveEntityDeltaPacket(runtimeEntityId="
         + this.runtimeEntityId
         + ", flags="
         + this.flags
         + ", delta=("
         + this.deltaX
         + ", "
         + this.deltaY
         + ", "
         + this.deltaZ
         + "), position=("
         + this.x
         + ", "
         + this.y
         + ", "
         + this.z
         + "), rotation=("
         + this.pitch
         + ", "
         + this.yaw
         + ", "
         + this.headYaw
         + "))";
   }

   public MoveEntityDeltaPacket clone() {
      try {
         return (MoveEntityDeltaPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public Set<MoveEntityDeltaPacket.Flag> getFlags() {
      return this.flags;
   }

   public int getDeltaX() {
      return this.deltaX;
   }

   public int getDeltaY() {
      return this.deltaY;
   }

   public int getDeltaZ() {
      return this.deltaZ;
   }

   public float getX() {
      return this.x;
   }

   public float getY() {
      return this.y;
   }

   public float getZ() {
      return this.z;
   }

   public float getPitch() {
      return this.pitch;
   }

   public float getYaw() {
      return this.yaw;
   }

   public float getHeadYaw() {
      return this.headYaw;
   }

   public void setRuntimeEntityId(final long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setDeltaX(final int deltaX) {
      this.deltaX = deltaX;
   }

   public void setDeltaY(final int deltaY) {
      this.deltaY = deltaY;
   }

   public void setDeltaZ(final int deltaZ) {
      this.deltaZ = deltaZ;
   }

   public void setX(final float x) {
      this.x = x;
   }

   public void setY(final float y) {
      this.y = y;
   }

   public void setZ(final float z) {
      this.z = z;
   }

   public void setPitch(final float pitch) {
      this.pitch = pitch;
   }

   public void setYaw(final float yaw) {
      this.yaw = yaw;
   }

   public void setHeadYaw(final float headYaw) {
      this.headYaw = headYaw;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MoveEntityDeltaPacket)) {
         return false;
      }

      MoveEntityDeltaPacket other = (MoveEntityDeltaPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.runtimeEntityId != other.runtimeEntityId) {
         return false;
      }

      if (this.deltaX != other.deltaX) {
         return false;
      }

      if (this.deltaY != other.deltaY) {
         return false;
      }

      if (this.deltaZ != other.deltaZ) {
         return false;
      }

      if (Float.compare(this.x, other.x) != 0) {
         return false;
      }

      if (Float.compare(this.y, other.y) != 0) {
         return false;
      }

      if (Float.compare(this.z, other.z) != 0) {
         return false;
      }

      if (Float.compare(this.pitch, other.pitch) != 0) {
         return false;
      }

      if (Float.compare(this.yaw, other.yaw) != 0) {
         return false;
      }

      if (Float.compare(this.headYaw, other.headYaw) != 0) {
         return false;
      }

      Object this$flags = this.flags;
      Object other$flags = other.flags;
      return this$flags == null ? other$flags == null : this$flags.equals(other$flags);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MoveEntityDeltaPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      result = result * 59 + this.deltaX;
      result = result * 59 + this.deltaY;
      result = result * 59 + this.deltaZ;
      result = result * 59 + Float.floatToIntBits(this.x);
      result = result * 59 + Float.floatToIntBits(this.y);
      result = result * 59 + Float.floatToIntBits(this.z);
      result = result * 59 + Float.floatToIntBits(this.pitch);
      result = result * 59 + Float.floatToIntBits(this.yaw);
      result = result * 59 + Float.floatToIntBits(this.headYaw);
      Object $flags = this.flags;
      return result * 59 + ($flags == null ? 43 : $flags.hashCode());
   }

   public enum Flag {
      HAS_X,
      HAS_Y,
      HAS_Z,
      HAS_PITCH,
      HAS_YAW,
      HAS_HEAD_YAW,
      ON_GROUND,
      TELEPORTING,
      FORCE_MOVE_LOCAL_ENTITY;
   }
}
