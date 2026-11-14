package org.cloudburstmc.protocol.bedrock.data.biome;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.cloudburstmc.protocol.bedrock.data.ExpressionOp;
import org.cloudburstmc.protocol.common.util.index.Indexable;
import org.cloudburstmc.protocol.common.util.index.Unindexed;

public final class BiomeElementData {
   private final float noiseFrequencyScale;
   private final float noiseLowerBound;
   private final float noiseUpperBound;
   private final ExpressionOp heightMinType;
   private final transient Indexable<String> heightMin;
   private final ExpressionOp heightMaxType;
   private final transient Indexable<String> heightMax;
   private final BiomeSurfaceMaterialData adjustedMaterials;

   @JsonCreator
   public BiomeElementData(
      float noiseFrequencyScale,
      float noiseLowerBound,
      float noiseUpperBound,
      ExpressionOp heightMinType,
      String heightMin,
      ExpressionOp heightMaxType,
      String heightMax,
      BiomeSurfaceMaterialData adjustedMaterials
   ) {
      this.noiseFrequencyScale = noiseFrequencyScale;
      this.noiseLowerBound = noiseLowerBound;
      this.noiseUpperBound = noiseUpperBound;
      this.heightMinType = heightMinType;
      this.heightMin = new Unindexed<>(heightMin);
      this.heightMaxType = heightMaxType;
      this.heightMax = new Unindexed<>(heightMax);
      this.adjustedMaterials = adjustedMaterials;
   }

   public String getHeightMin() {
      return this.heightMin.get();
   }

   public String getHeightMax() {
      return this.heightMax.get();
   }

   public float getNoiseFrequencyScale() {
      return this.noiseFrequencyScale;
   }

   public float getNoiseLowerBound() {
      return this.noiseLowerBound;
   }

   public float getNoiseUpperBound() {
      return this.noiseUpperBound;
   }

   public ExpressionOp getHeightMinType() {
      return this.heightMinType;
   }

   public ExpressionOp getHeightMaxType() {
      return this.heightMaxType;
   }

   public BiomeSurfaceMaterialData getAdjustedMaterials() {
      return this.adjustedMaterials;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BiomeElementData)) {
         return false;
      }

      BiomeElementData other = (BiomeElementData)o;
      if (Float.compare(this.getNoiseFrequencyScale(), other.getNoiseFrequencyScale()) != 0) {
         return false;
      }

      if (Float.compare(this.getNoiseLowerBound(), other.getNoiseLowerBound()) != 0) {
         return false;
      }

      if (Float.compare(this.getNoiseUpperBound(), other.getNoiseUpperBound()) != 0) {
         return false;
      }

      Object this$heightMinType = this.getHeightMinType();
      Object other$heightMinType = other.getHeightMinType();
      if (this$heightMinType == null ? other$heightMinType == null : this$heightMinType.equals(other$heightMinType)) {
         Object this$heightMaxType = this.getHeightMaxType();
         Object other$heightMaxType = other.getHeightMaxType();
         if (this$heightMaxType == null ? other$heightMaxType == null : this$heightMaxType.equals(other$heightMaxType)) {
            Object this$adjustedMaterials = this.getAdjustedMaterials();
            Object other$adjustedMaterials = other.getAdjustedMaterials();
            return this$adjustedMaterials == null ? other$adjustedMaterials == null : this$adjustedMaterials.equals(other$adjustedMaterials);
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
      result = result * 59 + Float.floatToIntBits(this.getNoiseFrequencyScale());
      result = result * 59 + Float.floatToIntBits(this.getNoiseLowerBound());
      result = result * 59 + Float.floatToIntBits(this.getNoiseUpperBound());
      Object $heightMinType = this.getHeightMinType();
      result = result * 59 + ($heightMinType == null ? 43 : $heightMinType.hashCode());
      Object $heightMaxType = this.getHeightMaxType();
      result = result * 59 + ($heightMaxType == null ? 43 : $heightMaxType.hashCode());
      Object $adjustedMaterials = this.getAdjustedMaterials();
      return result * 59 + ($adjustedMaterials == null ? 43 : $adjustedMaterials.hashCode());
   }

   @Override
   public String toString() {
      return "BiomeElementData(noiseFrequencyScale="
         + this.getNoiseFrequencyScale()
         + ", noiseLowerBound="
         + this.getNoiseLowerBound()
         + ", noiseUpperBound="
         + this.getNoiseUpperBound()
         + ", heightMinType="
         + this.getHeightMinType()
         + ", heightMin="
         + this.getHeightMin()
         + ", heightMaxType="
         + this.getHeightMaxType()
         + ", heightMax="
         + this.getHeightMax()
         + ", adjustedMaterials="
         + this.getAdjustedMaterials()
         + ")";
   }

   @Deprecated
   public BiomeElementData(
      final float noiseFrequencyScale,
      final float noiseLowerBound,
      final float noiseUpperBound,
      final ExpressionOp heightMinType,
      final Indexable<String> heightMin,
      final ExpressionOp heightMaxType,
      final Indexable<String> heightMax,
      final BiomeSurfaceMaterialData adjustedMaterials
   ) {
      this.noiseFrequencyScale = noiseFrequencyScale;
      this.noiseLowerBound = noiseLowerBound;
      this.noiseUpperBound = noiseUpperBound;
      this.heightMinType = heightMinType;
      this.heightMin = heightMin;
      this.heightMaxType = heightMaxType;
      this.heightMax = heightMax;
      this.adjustedMaterials = adjustedMaterials;
   }
}
