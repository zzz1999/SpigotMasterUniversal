package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.protocol.common.PacketSignal;

public class RespawnPacket implements BedrockPacket {
   private Vector3f position;
   private RespawnPacket.State state;
   private long runtimeEntityId;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.RESPAWN;
   }

   public RespawnPacket clone() {
      try {
         return (RespawnPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public Vector3f getPosition() {
      return this.position;
   }

   public RespawnPacket.State getState() {
      return this.state;
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public void setPosition(final Vector3f position) {
      this.position = position;
   }

   public void setState(final RespawnPacket.State state) {
      this.state = state;
   }

   public void setRuntimeEntityId(final long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof RespawnPacket)) {
         return false;
      } else {
         RespawnPacket other = (RespawnPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.runtimeEntityId != other.runtimeEntityId) {
            return false;
         } else {
            Object this$position = this.position;
            Object other$position = other.position;
            if (this$position == null ? other$position == null : this$position.equals(other$position)) {
               Object this$state = this.state;
               Object other$state = other.state;
               return this$state == null ? other$state == null : this$state.equals(other$state);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof RespawnPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      Object $position = this.position;
      result = result * 59 + ($position == null ? 43 : $position.hashCode());
      Object $state = this.state;
      return result * 59 + ($state == null ? 43 : $state.hashCode());
   }

   @Override
   public String toString() {
      return "RespawnPacket(position=" + this.position + ", state=" + this.state + ", runtimeEntityId=" + this.runtimeEntityId + ")";
   }

   public enum State {
      SERVER_SEARCHING,
      SERVER_READY,
      CLIENT_READY;
   }
}
