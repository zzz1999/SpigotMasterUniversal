package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;
import org.cloudburstmc.math.vector.Vector3f;

public class AddHangingEntityPacket implements BedrockPacket {
   private long uniqueEntityId;
   private long runtimeEntityId;
   private Vector3f position;
   private int direction;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.ADD_HANGING_ENTITY;
   }

   public long getUniqueEntityId() {
      return this.uniqueEntityId;
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public Vector3f getPosition() {
      return this.position;
   }

   public int getDirection() {
      return this.direction;
   }

   public void setUniqueEntityId(long uniqueEntityId) {
      this.uniqueEntityId = uniqueEntityId;
   }

   public void setRuntimeEntityId(long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setPosition(Vector3f position) {
      this.position = position;
   }

   public void setDirection(int direction) {
      this.direction = direction;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AddHangingEntityPacket)) {
         return false;
      }

      AddHangingEntityPacket other = (AddHangingEntityPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.uniqueEntityId != other.uniqueEntityId) {
         return false;
      }

      if (this.runtimeEntityId != other.runtimeEntityId) {
         return false;
      }

      if (this.direction != other.direction) {
         return false;
      }

      Object this$position = this.position;
      Object other$position = other.position;
      return this$position == null ? other$position == null : this$position.equals(other$position);
   }

   protected boolean canEqual(Object other) {
      return other instanceof AddHangingEntityPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $uniqueEntityId = this.uniqueEntityId;
      result = result * 59 + (int)($uniqueEntityId >>> 32 ^ $uniqueEntityId);
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      result = result * 59 + this.direction;
      Object $position = this.position;
      return result * 59 + ($position == null ? 43 : $position.hashCode());
   }

   @Override
   public String toString() {
      return "AddHangingEntityPacket(uniqueEntityId="
         + this.uniqueEntityId
         + ", runtimeEntityId="
         + this.runtimeEntityId
         + ", position="
         + this.position
         + ", direction="
         + this.direction
         + ")";
   }
}
