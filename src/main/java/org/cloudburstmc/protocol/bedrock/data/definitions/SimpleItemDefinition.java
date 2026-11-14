package org.cloudburstmc.protocol.bedrock.data.definitions;

import org.cloudburstmc.nbt.NbtMap;
import org.cloudburstmc.protocol.bedrock.data.inventory.ItemVersion;

public class SimpleItemDefinition implements ItemDefinition {
   private final String identifier;
   private final int runtimeId;
   private final ItemVersion version;
   private final boolean componentBased;
   private final NbtMap componentData;

   public SimpleItemDefinition(String identifier, int runtimeId, boolean componentBased) {
      this.identifier = identifier;
      this.runtimeId = runtimeId;
      this.componentBased = componentBased;
      this.version = ItemVersion.LEGACY;
      this.componentData = null;
   }

   @Override
   public String getIdentifier() {
      return this.identifier;
   }

   @Override
   public int getRuntimeId() {
      return this.runtimeId;
   }

   @Override
   public ItemVersion getVersion() {
      return this.version;
   }

   @Override
   public boolean isComponentBased() {
      return this.componentBased;
   }

   @Override
   public NbtMap getComponentData() {
      return this.componentData;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SimpleItemDefinition)) {
         return false;
      }

      SimpleItemDefinition other = (SimpleItemDefinition)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getRuntimeId() != other.getRuntimeId()) {
         return false;
      }

      if (this.isComponentBased() != other.isComponentBased()) {
         return false;
      }

      Object this$identifier = this.getIdentifier();
      Object other$identifier = other.getIdentifier();
      if (this$identifier == null ? other$identifier == null : this$identifier.equals(other$identifier)) {
         Object this$version = this.getVersion();
         Object other$version = other.getVersion();
         if (this$version == null ? other$version == null : this$version.equals(other$version)) {
            Object this$componentData = this.getComponentData();
            Object other$componentData = other.getComponentData();
            return this$componentData == null ? other$componentData == null : this$componentData.equals(other$componentData);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SimpleItemDefinition;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getRuntimeId();
      result = result * 59 + (this.isComponentBased() ? 79 : 97);
      Object $identifier = this.getIdentifier();
      result = result * 59 + ($identifier == null ? 43 : $identifier.hashCode());
      Object $version = this.getVersion();
      result = result * 59 + ($version == null ? 43 : $version.hashCode());
      Object $componentData = this.getComponentData();
      return result * 59 + ($componentData == null ? 43 : $componentData.hashCode());
   }

   @Override
   public String toString() {
      return "SimpleItemDefinition(identifier="
         + this.getIdentifier()
         + ", runtimeId="
         + this.getRuntimeId()
         + ", version="
         + this.getVersion()
         + ", componentBased="
         + this.isComponentBased()
         + ", componentData="
         + this.getComponentData()
         + ")";
   }

   public SimpleItemDefinition(
      final String identifier, final int runtimeId, final ItemVersion version, final boolean componentBased, final NbtMap componentData
   ) {
      this.identifier = identifier;
      this.runtimeId = runtimeId;
      this.version = version;
      this.componentBased = componentBased;
      this.componentData = componentData;
   }
}
