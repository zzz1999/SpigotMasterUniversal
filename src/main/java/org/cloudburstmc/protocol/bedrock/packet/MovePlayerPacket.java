package org.cloudburstmc.protocol.bedrock.packet;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.protocol.common.PacketSignal;

public class MovePlayerPacket implements BedrockPacket {
   private long runtimeEntityId;
   private Vector3f position;
   private Vector3f rotation;
   private MovePlayerPacket.Mode mode;
   private boolean onGround;
   private long ridingRuntimeEntityId;
   private MovePlayerPacket.TeleportationCause teleportationCause;
   private int entityType;
   private long tick;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.MOVE_PLAYER;
   }

   public MovePlayerPacket clone() {
      try {
         return (MovePlayerPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public Vector3f getPosition() {
      return this.position;
   }

   public Vector3f getRotation() {
      return this.rotation;
   }

   public MovePlayerPacket.Mode getMode() {
      return this.mode;
   }

   public boolean isOnGround() {
      return this.onGround;
   }

   public long getRidingRuntimeEntityId() {
      return this.ridingRuntimeEntityId;
   }

   public MovePlayerPacket.TeleportationCause getTeleportationCause() {
      return this.teleportationCause;
   }

   public int getEntityType() {
      return this.entityType;
   }

   public long getTick() {
      return this.tick;
   }

   public void setRuntimeEntityId(final long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setPosition(final Vector3f position) {
      this.position = position;
   }

   public void setRotation(final Vector3f rotation) {
      this.rotation = rotation;
   }

   public void setMode(final MovePlayerPacket.Mode mode) {
      this.mode = mode;
   }

   public void setOnGround(final boolean onGround) {
      this.onGround = onGround;
   }

   public void setRidingRuntimeEntityId(final long ridingRuntimeEntityId) {
      this.ridingRuntimeEntityId = ridingRuntimeEntityId;
   }

   public void setTeleportationCause(final MovePlayerPacket.TeleportationCause teleportationCause) {
      this.teleportationCause = teleportationCause;
   }

   public void setEntityType(final int entityType) {
      this.entityType = entityType;
   }

   public void setTick(final long tick) {
      this.tick = tick;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MovePlayerPacket)) {
         return false;
      }

      MovePlayerPacket other = (MovePlayerPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.runtimeEntityId != other.runtimeEntityId) {
         return false;
      }

      if (this.onGround != other.onGround) {
         return false;
      }

      if (this.ridingRuntimeEntityId != other.ridingRuntimeEntityId) {
         return false;
      }

      if (this.entityType != other.entityType) {
         return false;
      }

      if (this.tick != other.tick) {
         return false;
      }

      Object this$position = this.position;
      Object other$position = other.position;
      if (this$position == null ? other$position == null : this$position.equals(other$position)) {
         Object this$rotation = this.rotation;
         Object other$rotation = other.rotation;
         if (this$rotation == null ? other$rotation == null : this$rotation.equals(other$rotation)) {
            Object this$mode = this.mode;
            Object other$mode = other.mode;
            if (this$mode == null ? other$mode == null : this$mode.equals(other$mode)) {
               Object this$teleportationCause = this.teleportationCause;
               Object other$teleportationCause = other.teleportationCause;
               return this$teleportationCause == null ? other$teleportationCause == null : this$teleportationCause.equals(other$teleportationCause);
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MovePlayerPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      result = result * 59 + (this.onGround ? 79 : 97);
      long $ridingRuntimeEntityId = this.ridingRuntimeEntityId;
      result = result * 59 + (int)($ridingRuntimeEntityId >>> 32 ^ $ridingRuntimeEntityId);
      result = result * 59 + this.entityType;
      long $tick = this.tick;
      result = result * 59 + (int)($tick >>> 32 ^ $tick);
      Object $position = this.position;
      result = result * 59 + ($position == null ? 43 : $position.hashCode());
      Object $rotation = this.rotation;
      result = result * 59 + ($rotation == null ? 43 : $rotation.hashCode());
      Object $mode = this.mode;
      result = result * 59 + ($mode == null ? 43 : $mode.hashCode());
      Object $teleportationCause = this.teleportationCause;
      return result * 59 + ($teleportationCause == null ? 43 : $teleportationCause.hashCode());
   }

   @Override
   public String toString() {
      return "MovePlayerPacket(runtimeEntityId="
         + this.runtimeEntityId
         + ", position="
         + this.position
         + ", rotation="
         + this.rotation
         + ", mode="
         + this.mode
         + ", onGround="
         + this.onGround
         + ", ridingRuntimeEntityId="
         + this.ridingRuntimeEntityId
         + ", teleportationCause="
         + this.teleportationCause
         + ", entityType="
         + this.entityType
         + ", tick="
         + this.tick
         + ")";
   }

   public enum Mode {
      NORMAL,
      RESPAWN,
      TELEPORT,
      HEAD_ROTATION;
   }

   public enum TeleportationCause {
      UNKNOWN,
      PROJECTILE,
      CHORUS_FRUIT,
      COMMAND,
      BEHAVIOR;

      private static final InternalLogger log = InternalLoggerFactory.getInstance(MovePlayerPacket.TeleportationCause.class);
      private static final MovePlayerPacket.TeleportationCause[] VALUES = values();

      public static MovePlayerPacket.TeleportationCause byId(int id) {
         if (id >= 0 && id < VALUES.length) {
            return VALUES[id];
         }

         log.debug("Unknown teleportation cause ID: {}", id);
         return UNKNOWN;
      }
   }
}
