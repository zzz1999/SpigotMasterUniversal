package org.cloudburstmc.protocol.bedrock.data.biome;

import java.util.List;

public final class BiomeReplacementData {
   private final int biome;
   private final int dimension;
   private final List<Short> targetBiomes;
   private final float amount;
   private final float noiseFrequencyScale;
   private final int replacementIndex;

   public BiomeReplacementData(
      final int biome, final int dimension, final List<Short> targetBiomes, final float amount, final float noiseFrequencyScale, final int replacementIndex
   ) {
      this.biome = biome;
      this.dimension = dimension;
      this.targetBiomes = targetBiomes;
      this.amount = amount;
      this.noiseFrequencyScale = noiseFrequencyScale;
      this.replacementIndex = replacementIndex;
   }

   public int getBiome() {
      return this.biome;
   }

   public int getDimension() {
      return this.dimension;
   }

   public List<Short> getTargetBiomes() {
      return this.targetBiomes;
   }

   public float getAmount() {
      return this.amount;
   }

   public float getNoiseFrequencyScale() {
      return this.noiseFrequencyScale;
   }

   public int getReplacementIndex() {
      return this.replacementIndex;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BiomeReplacementData)) {
         return false;
      }

      BiomeReplacementData other = (BiomeReplacementData)o;
      if (this.getBiome() != other.getBiome()) {
         return false;
      }

      if (this.getDimension() != other.getDimension()) {
         return false;
      }

      if (Float.compare(this.getAmount(), other.getAmount()) != 0) {
         return false;
      }

      if (Float.compare(this.getNoiseFrequencyScale(), other.getNoiseFrequencyScale()) != 0) {
         return false;
      }

      if (this.getReplacementIndex() != other.getReplacementIndex()) {
         return false;
      }

      Object this$targetBiomes = this.getTargetBiomes();
      Object other$targetBiomes = other.getTargetBiomes();
      return this$targetBiomes == null ? other$targetBiomes == null : this$targetBiomes.equals(other$targetBiomes);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getBiome();
      result = result * 59 + this.getDimension();
      result = result * 59 + Float.floatToIntBits(this.getAmount());
      result = result * 59 + Float.floatToIntBits(this.getNoiseFrequencyScale());
      result = result * 59 + this.getReplacementIndex();
      Object $targetBiomes = this.getTargetBiomes();
      return result * 59 + ($targetBiomes == null ? 43 : $targetBiomes.hashCode());
   }

   @Override
   public String toString() {
      return "BiomeReplacementData(biome="
         + this.getBiome()
         + ", dimension="
         + this.getDimension()
         + ", targetBiomes="
         + this.getTargetBiomes()
         + ", amount="
         + this.getAmount()
         + ", noiseFrequencyScale="
         + this.getNoiseFrequencyScale()
         + ", replacementIndex="
         + this.getReplacementIndex()
         + ")";
   }
}
