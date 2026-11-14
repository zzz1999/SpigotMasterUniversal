package org.cloudburstmc.protocol.bedrock.data.biome;

import org.cloudburstmc.protocol.bedrock.data.definitions.BlockDefinition;

public final class BiomeMountainParamsData {
   private final BlockDefinition steepBlock;
   private final boolean northSlopes;
   private final boolean southSlopes;
   private final boolean westSlopes;
   private final boolean eastSlopes;
   private final boolean topSlideEnabled;

   public BiomeMountainParamsData(
      final BlockDefinition steepBlock,
      final boolean northSlopes,
      final boolean southSlopes,
      final boolean westSlopes,
      final boolean eastSlopes,
      final boolean topSlideEnabled
   ) {
      this.steepBlock = steepBlock;
      this.northSlopes = northSlopes;
      this.southSlopes = southSlopes;
      this.westSlopes = westSlopes;
      this.eastSlopes = eastSlopes;
      this.topSlideEnabled = topSlideEnabled;
   }

   public BlockDefinition getSteepBlock() {
      return this.steepBlock;
   }

   public boolean isNorthSlopes() {
      return this.northSlopes;
   }

   public boolean isSouthSlopes() {
      return this.southSlopes;
   }

   public boolean isWestSlopes() {
      return this.westSlopes;
   }

   public boolean isEastSlopes() {
      return this.eastSlopes;
   }

   public boolean isTopSlideEnabled() {
      return this.topSlideEnabled;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BiomeMountainParamsData)) {
         return false;
      }

      BiomeMountainParamsData other = (BiomeMountainParamsData)o;
      if (this.isNorthSlopes() != other.isNorthSlopes()) {
         return false;
      }

      if (this.isSouthSlopes() != other.isSouthSlopes()) {
         return false;
      }

      if (this.isWestSlopes() != other.isWestSlopes()) {
         return false;
      }

      if (this.isEastSlopes() != other.isEastSlopes()) {
         return false;
      }

      if (this.isTopSlideEnabled() != other.isTopSlideEnabled()) {
         return false;
      }

      Object this$steepBlock = this.getSteepBlock();
      Object other$steepBlock = other.getSteepBlock();
      return this$steepBlock == null ? other$steepBlock == null : this$steepBlock.equals(other$steepBlock);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isNorthSlopes() ? 79 : 97);
      result = result * 59 + (this.isSouthSlopes() ? 79 : 97);
      result = result * 59 + (this.isWestSlopes() ? 79 : 97);
      result = result * 59 + (this.isEastSlopes() ? 79 : 97);
      result = result * 59 + (this.isTopSlideEnabled() ? 79 : 97);
      Object $steepBlock = this.getSteepBlock();
      return result * 59 + ($steepBlock == null ? 43 : $steepBlock.hashCode());
   }

   @Override
   public String toString() {
      return "BiomeMountainParamsData(steepBlock="
         + this.getSteepBlock()
         + ", northSlopes="
         + this.isNorthSlopes()
         + ", southSlopes="
         + this.isSouthSlopes()
         + ", westSlopes="
         + this.isWestSlopes()
         + ", eastSlopes="
         + this.isEastSlopes()
         + ", topSlideEnabled="
         + this.isTopSlideEnabled()
         + ")";
   }
}
