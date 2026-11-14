package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.protocol.bedrock.data.entity.EntityDataMap;
import org.cloudburstmc.protocol.bedrock.data.inventory.ItemData;
import org.cloudburstmc.protocol.common.PacketSignal;

public class AddItemEntityPacket implements BedrockPacket {
   private EntityDataMap metadata = new EntityDataMap();
   private long uniqueEntityId;
   private long runtimeEntityId;
   private ItemData itemInHand;
   private Vector3f position;
   private Vector3f motion;
   private boolean fromFishing;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.ADD_ITEM_ENTITY;
   }

   public AddItemEntityPacket clone() {
      try {
         return (AddItemEntityPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public EntityDataMap getMetadata() {
      return this.metadata;
   }

   public long getUniqueEntityId() {
      return this.uniqueEntityId;
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public ItemData getItemInHand() {
      return this.itemInHand;
   }

   public Vector3f getPosition() {
      return this.position;
   }

   public Vector3f getMotion() {
      return this.motion;
   }

   public boolean isFromFishing() {
      return this.fromFishing;
   }

   public void setMetadata(final EntityDataMap metadata) {
      this.metadata = metadata;
   }

   public void setUniqueEntityId(final long uniqueEntityId) {
      this.uniqueEntityId = uniqueEntityId;
   }

   public void setRuntimeEntityId(final long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setItemInHand(final ItemData itemInHand) {
      this.itemInHand = itemInHand;
   }

   public void setPosition(final Vector3f position) {
      this.position = position;
   }

   public void setMotion(final Vector3f motion) {
      this.motion = motion;
   }

   public void setFromFishing(final boolean fromFishing) {
      this.fromFishing = fromFishing;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AddItemEntityPacket)) {
         return false;
      }

      AddItemEntityPacket other = (AddItemEntityPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.uniqueEntityId != other.uniqueEntityId) {
         return false;
      }

      if (this.runtimeEntityId != other.runtimeEntityId) {
         return false;
      }

      if (this.fromFishing != other.fromFishing) {
         return false;
      }

      Object this$metadata = this.metadata;
      Object other$metadata = other.metadata;
      if (this$metadata == null ? other$metadata == null : this$metadata.equals(other$metadata)) {
         Object this$itemInHand = this.itemInHand;
         Object other$itemInHand = other.itemInHand;
         if (this$itemInHand == null ? other$itemInHand == null : this$itemInHand.equals(other$itemInHand)) {
            Object this$position = this.position;
            Object other$position = other.position;
            if (this$position == null ? other$position == null : this$position.equals(other$position)) {
               Object this$motion = this.motion;
               Object other$motion = other.motion;
               return this$motion == null ? other$motion == null : this$motion.equals(other$motion);
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
      return other instanceof AddItemEntityPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $uniqueEntityId = this.uniqueEntityId;
      result = result * 59 + (int)($uniqueEntityId >>> 32 ^ $uniqueEntityId);
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      result = result * 59 + (this.fromFishing ? 79 : 97);
      Object $metadata = this.metadata;
      result = result * 59 + ($metadata == null ? 43 : $metadata.hashCode());
      Object $itemInHand = this.itemInHand;
      result = result * 59 + ($itemInHand == null ? 43 : $itemInHand.hashCode());
      Object $position = this.position;
      result = result * 59 + ($position == null ? 43 : $position.hashCode());
      Object $motion = this.motion;
      return result * 59 + ($motion == null ? 43 : $motion.hashCode());
   }

   @Override
   public String toString() {
      return "AddItemEntityPacket(metadata="
         + this.metadata
         + ", uniqueEntityId="
         + this.uniqueEntityId
         + ", runtimeEntityId="
         + this.runtimeEntityId
         + ", itemInHand="
         + this.itemInHand
         + ", position="
         + this.position
         + ", motion="
         + this.motion
         + ", fromFishing="
         + this.fromFishing
         + ")";
   }
}
