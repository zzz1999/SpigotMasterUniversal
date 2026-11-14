package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.entity.EntityEventType;
import org.cloudburstmc.protocol.common.PacketSignal;

public class EntityEventPacket implements BedrockPacket {
   private long runtimeEntityId;
   private EntityEventType type;
   private int data;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.ENTITY_EVENT;
   }

   public EntityEventPacket clone() {
      try {
         return (EntityEventPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public EntityEventType getType() {
      return this.type;
   }

   public int getData() {
      return this.data;
   }

   public void setRuntimeEntityId(final long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setType(final EntityEventType type) {
      this.type = type;
   }

   public void setData(final int data) {
      this.data = data;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EntityEventPacket)) {
         return false;
      }

      EntityEventPacket other = (EntityEventPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.runtimeEntityId != other.runtimeEntityId) {
         return false;
      }

      if (this.data != other.data) {
         return false;
      }

      Object this$type = this.type;
      Object other$type = other.type;
      return this$type == null ? other$type == null : this$type.equals(other$type);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof EntityEventPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      result = result * 59 + this.data;
      Object $type = this.type;
      return result * 59 + ($type == null ? 43 : $type.hashCode());
   }

   @Override
   public String toString() {
      return "EntityEventPacket(runtimeEntityId=" + this.runtimeEntityId + ", type=" + this.type + ", data=" + this.data + ")";
   }
}
