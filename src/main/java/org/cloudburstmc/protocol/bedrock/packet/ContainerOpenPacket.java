package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.math.vector.Vector3i;
import org.cloudburstmc.protocol.bedrock.data.inventory.ContainerType;
import org.cloudburstmc.protocol.common.PacketSignal;

public class ContainerOpenPacket implements BedrockPacket {
   private byte id;
   private ContainerType type;
   private Vector3i blockPosition;
   private long uniqueEntityId = -1L;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CONTAINER_OPEN;
   }

   public ContainerOpenPacket clone() {
      try {
         return (ContainerOpenPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public byte getId() {
      return this.id;
   }

   public ContainerType getType() {
      return this.type;
   }

   public Vector3i getBlockPosition() {
      return this.blockPosition;
   }

   public long getUniqueEntityId() {
      return this.uniqueEntityId;
   }

   public void setId(final byte id) {
      this.id = id;
   }

   public void setType(final ContainerType type) {
      this.type = type;
   }

   public void setBlockPosition(final Vector3i blockPosition) {
      this.blockPosition = blockPosition;
   }

   public void setUniqueEntityId(final long uniqueEntityId) {
      this.uniqueEntityId = uniqueEntityId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ContainerOpenPacket)) {
         return false;
      } else {
         ContainerOpenPacket other = (ContainerOpenPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.id != other.id) {
            return false;
         } else if (this.uniqueEntityId != other.uniqueEntityId) {
            return false;
         } else {
            Object this$type = this.type;
            Object other$type = other.type;
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$blockPosition = this.blockPosition;
               Object other$blockPosition = other.blockPosition;
               return this$blockPosition == null ? other$blockPosition == null : this$blockPosition.equals(other$blockPosition);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContainerOpenPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.id;
      long $uniqueEntityId = this.uniqueEntityId;
      result = result * 59 + (int)($uniqueEntityId >>> 32 ^ $uniqueEntityId);
      Object $type = this.type;
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $blockPosition = this.blockPosition;
      return result * 59 + ($blockPosition == null ? 43 : $blockPosition.hashCode());
   }

   @Override
   public String toString() {
      return "ContainerOpenPacket(id="
         + this.id
         + ", type="
         + this.type
         + ", blockPosition="
         + this.blockPosition
         + ", uniqueEntityId="
         + this.uniqueEntityId
         + ")";
   }
}
