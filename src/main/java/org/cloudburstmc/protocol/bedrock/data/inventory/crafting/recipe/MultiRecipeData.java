package org.cloudburstmc.protocol.bedrock.data.inventory.crafting.recipe;

import java.util.UUID;
import org.cloudburstmc.protocol.bedrock.data.inventory.crafting.CraftingDataType;

public class MultiRecipeData implements UniqueCraftingData {
   private final UUID uuid;
   private final int netId;

   @Override
   public CraftingDataType getType() {
      return CraftingDataType.MULTI;
   }

   public static MultiRecipeData of(UUID uuid, int netId) {
      return new MultiRecipeData(uuid, netId);
   }

   @Override
   public UUID getUuid() {
      return this.uuid;
   }

   @Override
   public int getNetId() {
      return this.netId;
   }

   @Override
   public String toString() {
      return "MultiRecipeData(uuid=" + this.getUuid() + ", netId=" + this.getNetId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MultiRecipeData)) {
         return false;
      }

      MultiRecipeData other = (MultiRecipeData)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getNetId() != other.getNetId()) {
         return false;
      }

      Object this$uuid = this.getUuid();
      Object other$uuid = other.getUuid();
      return this$uuid == null ? other$uuid == null : this$uuid.equals(other$uuid);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MultiRecipeData;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getNetId();
      Object $uuid = this.getUuid();
      return result * 59 + ($uuid == null ? 43 : $uuid.hashCode());
   }

   private MultiRecipeData(final UUID uuid, final int netId) {
      this.uuid = uuid;
      this.netId = netId;
   }
}
