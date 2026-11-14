package org.cloudburstmc.protocol.bedrock.data.biome;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.List;
import org.cloudburstmc.protocol.bedrock.data.CoordinateEvaluationOrder;
import org.cloudburstmc.protocol.bedrock.data.ExpressionOp;
import org.cloudburstmc.protocol.common.util.index.Indexable;
import org.cloudburstmc.protocol.common.util.index.Unindexed;

public final class BiomeScatterParamData {
   private final List<BiomeCoordinateData> coordinates;
   private final CoordinateEvaluationOrder evalOrder;
   private final ExpressionOp chancePercentType;
   private final transient Indexable<String> chancePercent;
   private final int chanceNumerator;
   private final int changeDenominator;
   private final ExpressionOp iterationsType;
   private final transient Indexable<String> iterations;

   @JsonCreator
   public BiomeScatterParamData(
      List<BiomeCoordinateData> coordinates,
      CoordinateEvaluationOrder evalOrder,
      ExpressionOp chancePercentType,
      String chancePercent,
      int chanceNumerator,
      int changeDenominator,
      ExpressionOp iterationsType,
      String iterations
   ) {
      this.coordinates = coordinates;
      this.evalOrder = evalOrder;
      this.chancePercentType = chancePercentType;
      this.chancePercent = new Unindexed<>(chancePercent);
      this.chanceNumerator = chanceNumerator;
      this.changeDenominator = changeDenominator;
      this.iterationsType = iterationsType;
      this.iterations = new Unindexed<>(iterations);
   }

   public String getChancePercent() {
      return this.chancePercent.get();
   }

   public String getIterations() {
      return this.iterations.get();
   }

   public List<BiomeCoordinateData> getCoordinates() {
      return this.coordinates;
   }

   public CoordinateEvaluationOrder getEvalOrder() {
      return this.evalOrder;
   }

   public ExpressionOp getChancePercentType() {
      return this.chancePercentType;
   }

   public int getChanceNumerator() {
      return this.chanceNumerator;
   }

   public int getChangeDenominator() {
      return this.changeDenominator;
   }

   public ExpressionOp getIterationsType() {
      return this.iterationsType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BiomeScatterParamData)) {
         return false;
      }

      BiomeScatterParamData other = (BiomeScatterParamData)o;
      if (this.getChanceNumerator() != other.getChanceNumerator()) {
         return false;
      }

      if (this.getChangeDenominator() != other.getChangeDenominator()) {
         return false;
      }

      Object this$coordinates = this.getCoordinates();
      Object other$coordinates = other.getCoordinates();
      if (this$coordinates == null ? other$coordinates == null : this$coordinates.equals(other$coordinates)) {
         Object this$evalOrder = this.getEvalOrder();
         Object other$evalOrder = other.getEvalOrder();
         if (this$evalOrder == null ? other$evalOrder == null : this$evalOrder.equals(other$evalOrder)) {
            Object this$chancePercentType = this.getChancePercentType();
            Object other$chancePercentType = other.getChancePercentType();
            if (this$chancePercentType == null ? other$chancePercentType == null : this$chancePercentType.equals(other$chancePercentType)) {
               Object this$iterationsType = this.getIterationsType();
               Object other$iterationsType = other.getIterationsType();
               return this$iterationsType == null ? other$iterationsType == null : this$iterationsType.equals(other$iterationsType);
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
      result = result * 59 + this.getChanceNumerator();
      result = result * 59 + this.getChangeDenominator();
      Object $coordinates = this.getCoordinates();
      result = result * 59 + ($coordinates == null ? 43 : $coordinates.hashCode());
      Object $evalOrder = this.getEvalOrder();
      result = result * 59 + ($evalOrder == null ? 43 : $evalOrder.hashCode());
      Object $chancePercentType = this.getChancePercentType();
      result = result * 59 + ($chancePercentType == null ? 43 : $chancePercentType.hashCode());
      Object $iterationsType = this.getIterationsType();
      return result * 59 + ($iterationsType == null ? 43 : $iterationsType.hashCode());
   }

   @Override
   public String toString() {
      return "BiomeScatterParamData(coordinates="
         + this.getCoordinates()
         + ", evalOrder="
         + this.getEvalOrder()
         + ", chancePercentType="
         + this.getChancePercentType()
         + ", chancePercent="
         + this.getChancePercent()
         + ", chanceNumerator="
         + this.getChanceNumerator()
         + ", changeDenominator="
         + this.getChangeDenominator()
         + ", iterationsType="
         + this.getIterationsType()
         + ", iterations="
         + this.getIterations()
         + ")";
   }

   @Deprecated
   public BiomeScatterParamData(
      final List<BiomeCoordinateData> coordinates,
      final CoordinateEvaluationOrder evalOrder,
      final ExpressionOp chancePercentType,
      final Indexable<String> chancePercent,
      final int chanceNumerator,
      final int changeDenominator,
      final ExpressionOp iterationsType,
      final Indexable<String> iterations
   ) {
      this.coordinates = coordinates;
      this.evalOrder = evalOrder;
      this.chancePercentType = chancePercentType;
      this.chancePercent = chancePercent;
      this.chanceNumerator = chanceNumerator;
      this.changeDenominator = changeDenominator;
      this.iterationsType = iterationsType;
      this.iterations = iterations;
   }
}
