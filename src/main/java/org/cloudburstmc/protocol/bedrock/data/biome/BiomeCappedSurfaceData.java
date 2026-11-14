package org.cloudburstmc.protocol.bedrock.data.biome;

import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.cloudburstmc.protocol.bedrock.data.definitions.BlockDefinition;

public final class BiomeCappedSurfaceData {
   private final List<BlockDefinition> floorBlocks;
   private final List<BlockDefinition> ceilingBlocks;
   private final @Nullable BlockDefinition seaBlock;
   private final @Nullable BlockDefinition foundationBlock;
   private final @Nullable BlockDefinition beachBlock;

   public BiomeCappedSurfaceData(
      final List<BlockDefinition> floorBlocks,
      final List<BlockDefinition> ceilingBlocks,
      final @Nullable BlockDefinition seaBlock,
      final @Nullable BlockDefinition foundationBlock,
      final @Nullable BlockDefinition beachBlock
   ) {
      this.floorBlocks = floorBlocks;
      this.ceilingBlocks = ceilingBlocks;
      this.seaBlock = seaBlock;
      this.foundationBlock = foundationBlock;
      this.beachBlock = beachBlock;
   }

   public List<BlockDefinition> getFloorBlocks() {
      return this.floorBlocks;
   }

   public List<BlockDefinition> getCeilingBlocks() {
      return this.ceilingBlocks;
   }

   public @Nullable BlockDefinition getSeaBlock() {
      return this.seaBlock;
   }

   public @Nullable BlockDefinition getFoundationBlock() {
      return this.foundationBlock;
   }

   public @Nullable BlockDefinition getBeachBlock() {
      return this.beachBlock;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BiomeCappedSurfaceData)) {
         return false;
      }

      BiomeCappedSurfaceData other = (BiomeCappedSurfaceData)o;
      Object this$floorBlocks = this.getFloorBlocks();
      Object other$floorBlocks = other.getFloorBlocks();
      if (this$floorBlocks == null ? other$floorBlocks == null : this$floorBlocks.equals(other$floorBlocks)) {
         Object this$ceilingBlocks = this.getCeilingBlocks();
         Object other$ceilingBlocks = other.getCeilingBlocks();
         if (this$ceilingBlocks == null ? other$ceilingBlocks == null : this$ceilingBlocks.equals(other$ceilingBlocks)) {
            Object this$seaBlock = this.getSeaBlock();
            Object other$seaBlock = other.getSeaBlock();
            if (this$seaBlock == null ? other$seaBlock == null : this$seaBlock.equals(other$seaBlock)) {
               Object this$foundationBlock = this.getFoundationBlock();
               Object other$foundationBlock = other.getFoundationBlock();
               if (this$foundationBlock == null ? other$foundationBlock == null : this$foundationBlock.equals(other$foundationBlock)) {
                  Object this$beachBlock = this.getBeachBlock();
                  Object other$beachBlock = other.getBeachBlock();
                  return this$beachBlock == null ? other$beachBlock == null : this$beachBlock.equals(other$beachBlock);
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
      Object $floorBlocks = this.getFloorBlocks();
      result = result * 59 + ($floorBlocks == null ? 43 : $floorBlocks.hashCode());
      Object $ceilingBlocks = this.getCeilingBlocks();
      result = result * 59 + ($ceilingBlocks == null ? 43 : $ceilingBlocks.hashCode());
      Object $seaBlock = this.getSeaBlock();
      result = result * 59 + ($seaBlock == null ? 43 : $seaBlock.hashCode());
      Object $foundationBlock = this.getFoundationBlock();
      result = result * 59 + ($foundationBlock == null ? 43 : $foundationBlock.hashCode());
      Object $beachBlock = this.getBeachBlock();
      return result * 59 + ($beachBlock == null ? 43 : $beachBlock.hashCode());
   }

   @Override
   public String toString() {
      return "BiomeCappedSurfaceData(floorBlocks="
         + this.getFloorBlocks()
         + ", ceilingBlocks="
         + this.getCeilingBlocks()
         + ", seaBlock="
         + this.getSeaBlock()
         + ", foundationBlock="
         + this.getFoundationBlock()
         + ", beachBlock="
         + this.getBeachBlock()
         + ")";
   }
}
