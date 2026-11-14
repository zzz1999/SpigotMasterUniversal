package org.cloudburstmc.protocol.bedrock.data.biome;

import org.cloudburstmc.protocol.bedrock.data.definitions.BlockDefinition;

public final class BiomeSurfaceMaterialData {
   private final BlockDefinition topBlock;
   private final BlockDefinition midBlock;
   private final BlockDefinition seaFloorBlock;
   private final BlockDefinition foundationBlock;
   private final BlockDefinition seaBlock;
   private final int seaFloorDepth;

   public BiomeSurfaceMaterialData(
      final BlockDefinition topBlock,
      final BlockDefinition midBlock,
      final BlockDefinition seaFloorBlock,
      final BlockDefinition foundationBlock,
      final BlockDefinition seaBlock,
      final int seaFloorDepth
   ) {
      this.topBlock = topBlock;
      this.midBlock = midBlock;
      this.seaFloorBlock = seaFloorBlock;
      this.foundationBlock = foundationBlock;
      this.seaBlock = seaBlock;
      this.seaFloorDepth = seaFloorDepth;
   }

   public BlockDefinition getTopBlock() {
      return this.topBlock;
   }

   public BlockDefinition getMidBlock() {
      return this.midBlock;
   }

   public BlockDefinition getSeaFloorBlock() {
      return this.seaFloorBlock;
   }

   public BlockDefinition getFoundationBlock() {
      return this.foundationBlock;
   }

   public BlockDefinition getSeaBlock() {
      return this.seaBlock;
   }

   public int getSeaFloorDepth() {
      return this.seaFloorDepth;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BiomeSurfaceMaterialData)) {
         return false;
      }

      BiomeSurfaceMaterialData other = (BiomeSurfaceMaterialData)o;
      if (this.getSeaFloorDepth() != other.getSeaFloorDepth()) {
         return false;
      }

      Object this$topBlock = this.getTopBlock();
      Object other$topBlock = other.getTopBlock();
      if (this$topBlock == null ? other$topBlock == null : this$topBlock.equals(other$topBlock)) {
         Object this$midBlock = this.getMidBlock();
         Object other$midBlock = other.getMidBlock();
         if (this$midBlock == null ? other$midBlock == null : this$midBlock.equals(other$midBlock)) {
            Object this$seaFloorBlock = this.getSeaFloorBlock();
            Object other$seaFloorBlock = other.getSeaFloorBlock();
            if (this$seaFloorBlock == null ? other$seaFloorBlock == null : this$seaFloorBlock.equals(other$seaFloorBlock)) {
               Object this$foundationBlock = this.getFoundationBlock();
               Object other$foundationBlock = other.getFoundationBlock();
               if (this$foundationBlock == null ? other$foundationBlock == null : this$foundationBlock.equals(other$foundationBlock)) {
                  Object this$seaBlock = this.getSeaBlock();
                  Object other$seaBlock = other.getSeaBlock();
                  return this$seaBlock == null ? other$seaBlock == null : this$seaBlock.equals(other$seaBlock);
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

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getSeaFloorDepth();
      Object $topBlock = this.getTopBlock();
      result = result * 59 + ($topBlock == null ? 43 : $topBlock.hashCode());
      Object $midBlock = this.getMidBlock();
      result = result * 59 + ($midBlock == null ? 43 : $midBlock.hashCode());
      Object $seaFloorBlock = this.getSeaFloorBlock();
      result = result * 59 + ($seaFloorBlock == null ? 43 : $seaFloorBlock.hashCode());
      Object $foundationBlock = this.getFoundationBlock();
      result = result * 59 + ($foundationBlock == null ? 43 : $foundationBlock.hashCode());
      Object $seaBlock = this.getSeaBlock();
      return result * 59 + ($seaBlock == null ? 43 : $seaBlock.hashCode());
   }

   @Override
   public String toString() {
      return "BiomeSurfaceMaterialData(topBlock="
         + this.getTopBlock()
         + ", midBlock="
         + this.getMidBlock()
         + ", seaFloorBlock="
         + this.getSeaFloorBlock()
         + ", foundationBlock="
         + this.getFoundationBlock()
         + ", seaBlock="
         + this.getSeaBlock()
         + ", seaFloorDepth="
         + this.getSeaFloorDepth()
         + ")";
   }
}
