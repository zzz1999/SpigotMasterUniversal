package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.math.vector.Vector3i;
import org.cloudburstmc.nbt.NbtMap;
import org.cloudburstmc.protocol.common.PacketSignal;

public class AddVolumeEntityPacket implements BedrockPacket {
   private int id;
   private NbtMap data;
   private String engineVersion;
   private String identifier;
   private String instanceName;
   private Vector3i minBounds;
   private Vector3i maxBounds;
   private int dimension;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.ADD_VOLUME_ENTITY;
   }

   public AddVolumeEntityPacket clone() {
      try {
         return (AddVolumeEntityPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public int getId() {
      return this.id;
   }

   public NbtMap getData() {
      return this.data;
   }

   public String getEngineVersion() {
      return this.engineVersion;
   }

   public String getIdentifier() {
      return this.identifier;
   }

   public String getInstanceName() {
      return this.instanceName;
   }

   public Vector3i getMinBounds() {
      return this.minBounds;
   }

   public Vector3i getMaxBounds() {
      return this.maxBounds;
   }

   public int getDimension() {
      return this.dimension;
   }

   public void setId(final int id) {
      this.id = id;
   }

   public void setData(final NbtMap data) {
      this.data = data;
   }

   public void setEngineVersion(final String engineVersion) {
      this.engineVersion = engineVersion;
   }

   public void setIdentifier(final String identifier) {
      this.identifier = identifier;
   }

   public void setInstanceName(final String instanceName) {
      this.instanceName = instanceName;
   }

   public void setMinBounds(final Vector3i minBounds) {
      this.minBounds = minBounds;
   }

   public void setMaxBounds(final Vector3i maxBounds) {
      this.maxBounds = maxBounds;
   }

   public void setDimension(final int dimension) {
      this.dimension = dimension;
   }

   @Override
   public String toString() {
      return "AddVolumeEntityPacket(id="
         + this.getId()
         + ", data="
         + this.getData()
         + ", engineVersion="
         + this.getEngineVersion()
         + ", identifier="
         + this.getIdentifier()
         + ", instanceName="
         + this.getInstanceName()
         + ", minBounds="
         + this.getMinBounds()
         + ", maxBounds="
         + this.getMaxBounds()
         + ", dimension="
         + this.getDimension()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AddVolumeEntityPacket)) {
         return false;
      }

      AddVolumeEntityPacket other = (AddVolumeEntityPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.id != other.id) {
         return false;
      }

      if (this.dimension != other.dimension) {
         return false;
      }

      Object this$data = this.data;
      Object other$data = other.data;
      if (this$data == null ? other$data == null : this$data.equals(other$data)) {
         Object this$engineVersion = this.engineVersion;
         Object other$engineVersion = other.engineVersion;
         if (this$engineVersion == null ? other$engineVersion == null : this$engineVersion.equals(other$engineVersion)) {
            Object this$identifier = this.identifier;
            Object other$identifier = other.identifier;
            if (this$identifier == null ? other$identifier == null : this$identifier.equals(other$identifier)) {
               Object this$instanceName = this.instanceName;
               Object other$instanceName = other.instanceName;
               if (this$instanceName == null ? other$instanceName == null : this$instanceName.equals(other$instanceName)) {
                  Object this$minBounds = this.minBounds;
                  Object other$minBounds = other.minBounds;
                  if (this$minBounds == null ? other$minBounds == null : this$minBounds.equals(other$minBounds)) {
                     Object this$maxBounds = this.maxBounds;
                     Object other$maxBounds = other.maxBounds;
                     return this$maxBounds == null ? other$maxBounds == null : this$maxBounds.equals(other$maxBounds);
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof AddVolumeEntityPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.id;
      result = result * 59 + this.dimension;
      Object $data = this.data;
      result = result * 59 + ($data == null ? 43 : $data.hashCode());
      Object $engineVersion = this.engineVersion;
      result = result * 59 + ($engineVersion == null ? 43 : $engineVersion.hashCode());
      Object $identifier = this.identifier;
      result = result * 59 + ($identifier == null ? 43 : $identifier.hashCode());
      Object $instanceName = this.instanceName;
      result = result * 59 + ($instanceName == null ? 43 : $instanceName.hashCode());
      Object $minBounds = this.minBounds;
      result = result * 59 + ($minBounds == null ? 43 : $minBounds.hashCode());
      Object $maxBounds = this.maxBounds;
      return result * 59 + ($maxBounds == null ? 43 : $maxBounds.hashCode());
   }
}
