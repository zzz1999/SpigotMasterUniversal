package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.entity.EntityDataMap;
import org.cloudburstmc.protocol.bedrock.data.entity.EntityProperties;
import org.cloudburstmc.protocol.common.PacketSignal;

public class SetEntityDataPacket implements BedrockPacket {
   private EntityDataMap metadata = new EntityDataMap();
   private long runtimeEntityId;
   private long tick;
   private EntityProperties properties = new EntityProperties();

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SET_ENTITY_DATA;
   }

   public SetEntityDataPacket clone() {
      try {
         return (SetEntityDataPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public EntityDataMap getMetadata() {
      return this.metadata;
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public long getTick() {
      return this.tick;
   }

   public EntityProperties getProperties() {
      return this.properties;
   }

   public void setMetadata(final EntityDataMap metadata) {
      this.metadata = metadata;
   }

   public void setRuntimeEntityId(final long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setTick(final long tick) {
      this.tick = tick;
   }

   public void setProperties(final EntityProperties properties) {
      this.properties = properties;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SetEntityDataPacket)) {
         return false;
      } else {
         SetEntityDataPacket other = (SetEntityDataPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.runtimeEntityId != other.runtimeEntityId) {
            return false;
         } else if (this.tick != other.tick) {
            return false;
         } else {
            Object this$metadata = this.metadata;
            Object other$metadata = other.metadata;
            if (this$metadata == null ? other$metadata == null : this$metadata.equals(other$metadata)) {
               Object this$properties = this.properties;
               Object other$properties = other.properties;
               return this$properties == null ? other$properties == null : this$properties.equals(other$properties);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SetEntityDataPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      long $tick = this.tick;
      result = result * 59 + (int)($tick >>> 32 ^ $tick);
      Object $metadata = this.metadata;
      result = result * 59 + ($metadata == null ? 43 : $metadata.hashCode());
      Object $properties = this.properties;
      return result * 59 + ($properties == null ? 43 : $properties.hashCode());
   }

   @Override
   public String toString() {
      return "SetEntityDataPacket(metadata="
         + this.metadata
         + ", runtimeEntityId="
         + this.runtimeEntityId
         + ", tick="
         + this.tick
         + ", properties="
         + this.properties
         + ")";
   }
}
