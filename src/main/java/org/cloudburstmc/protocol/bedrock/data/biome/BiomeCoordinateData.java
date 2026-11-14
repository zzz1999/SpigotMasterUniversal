package org.cloudburstmc.protocol.bedrock.data.biome;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.cloudburstmc.protocol.bedrock.data.ExpressionOp;
import org.cloudburstmc.protocol.bedrock.data.RandomDistributionType;
import org.cloudburstmc.protocol.common.util.index.Indexable;
import org.cloudburstmc.protocol.common.util.index.Unindexed;

public final class BiomeCoordinateData {
   private final ExpressionOp minValueType;
   private final transient Indexable<String> minValue;
   private final ExpressionOp maxValueType;
   private final transient Indexable<String> maxValue;
   private final long gridOffset;
   private final long gridStepSize;
   private final RandomDistributionType distribution;

   @JsonCreator
   public BiomeCoordinateData(
      ExpressionOp minValueType,
      String minValue,
      ExpressionOp maxValueType,
      String maxValue,
      long gridOffset,
      long gridStepSize,
      RandomDistributionType distribution
   ) {
      this.minValueType = minValueType;
      this.minValue = new Unindexed<>(minValue);
      this.maxValueType = maxValueType;
      this.maxValue = new Unindexed<>(maxValue);
      this.gridOffset = gridOffset;
      this.gridStepSize = gridStepSize;
      this.distribution = distribution;
   }

   public String getMinValue() {
      return this.minValue.get();
   }

   public String getMaxValue() {
      return this.maxValue.get();
   }

   public ExpressionOp getMinValueType() {
      return this.minValueType;
   }

   public ExpressionOp getMaxValueType() {
      return this.maxValueType;
   }

   public long getGridOffset() {
      return this.gridOffset;
   }

   public long getGridStepSize() {
      return this.gridStepSize;
   }

   public RandomDistributionType getDistribution() {
      return this.distribution;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BiomeCoordinateData)) {
         return false;
      }

      BiomeCoordinateData other = (BiomeCoordinateData)o;
      if (this.getGridOffset() != other.getGridOffset()) {
         return false;
      }

      if (this.getGridStepSize() != other.getGridStepSize()) {
         return false;
      }

      Object this$minValueType = this.getMinValueType();
      Object other$minValueType = other.getMinValueType();
      if (this$minValueType == null ? other$minValueType == null : this$minValueType.equals(other$minValueType)) {
         Object this$maxValueType = this.getMaxValueType();
         Object other$maxValueType = other.getMaxValueType();
         if (this$maxValueType == null ? other$maxValueType == null : this$maxValueType.equals(other$maxValueType)) {
            Object this$distribution = this.getDistribution();
            Object other$distribution = other.getDistribution();
            return this$distribution == null ? other$distribution == null : this$distribution.equals(other$distribution);
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
      long $gridOffset = this.getGridOffset();
      result = result * 59 + (int)($gridOffset >>> 32 ^ $gridOffset);
      long $gridStepSize = this.getGridStepSize();
      result = result * 59 + (int)($gridStepSize >>> 32 ^ $gridStepSize);
      Object $minValueType = this.getMinValueType();
      result = result * 59 + ($minValueType == null ? 43 : $minValueType.hashCode());
      Object $maxValueType = this.getMaxValueType();
      result = result * 59 + ($maxValueType == null ? 43 : $maxValueType.hashCode());
      Object $distribution = this.getDistribution();
      return result * 59 + ($distribution == null ? 43 : $distribution.hashCode());
   }

   @Override
   public String toString() {
      return "BiomeCoordinateData(minValueType="
         + this.getMinValueType()
         + ", minValue="
         + this.getMinValue()
         + ", maxValueType="
         + this.getMaxValueType()
         + ", maxValue="
         + this.getMaxValue()
         + ", gridOffset="
         + this.getGridOffset()
         + ", gridStepSize="
         + this.getGridStepSize()
         + ", distribution="
         + this.getDistribution()
         + ")";
   }

   @Deprecated
   public BiomeCoordinateData(
      final ExpressionOp minValueType,
      final Indexable<String> minValue,
      final ExpressionOp maxValueType,
      final Indexable<String> maxValue,
      final long gridOffset,
      final long gridStepSize,
      final RandomDistributionType distribution
   ) {
      this.minValueType = minValueType;
      this.minValue = minValue;
      this.maxValueType = maxValueType;
      this.maxValue = maxValue;
      this.gridOffset = gridOffset;
      this.gridStepSize = gridStepSize;
      this.distribution = distribution;
   }
}
