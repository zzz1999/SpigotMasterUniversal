package org.cloudburstmc.protocol.bedrock.data.biome;

public final class BiomeClimateData {
   private final float temperature;
   private final float downfall;
   private final float redSporeDensity;
   private final float blueSporeDensity;
   private final float ashDensity;
   private final float whiteAshDensity;
   private final float snowAccumulationMin;
   private final float snowAccumulationMax;

   public BiomeClimateData(
      final float temperature,
      final float downfall,
      final float redSporeDensity,
      final float blueSporeDensity,
      final float ashDensity,
      final float whiteAshDensity,
      final float snowAccumulationMin,
      final float snowAccumulationMax
   ) {
      this.temperature = temperature;
      this.downfall = downfall;
      this.redSporeDensity = redSporeDensity;
      this.blueSporeDensity = blueSporeDensity;
      this.ashDensity = ashDensity;
      this.whiteAshDensity = whiteAshDensity;
      this.snowAccumulationMin = snowAccumulationMin;
      this.snowAccumulationMax = snowAccumulationMax;
   }

   public float getTemperature() {
      return this.temperature;
   }

   public float getDownfall() {
      return this.downfall;
   }

   public float getRedSporeDensity() {
      return this.redSporeDensity;
   }

   public float getBlueSporeDensity() {
      return this.blueSporeDensity;
   }

   public float getAshDensity() {
      return this.ashDensity;
   }

   public float getWhiteAshDensity() {
      return this.whiteAshDensity;
   }

   public float getSnowAccumulationMin() {
      return this.snowAccumulationMin;
   }

   public float getSnowAccumulationMax() {
      return this.snowAccumulationMax;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof BiomeClimateData)) {
         return false;
      } else {
         BiomeClimateData other = (BiomeClimateData)o;
         if (Float.compare(this.getTemperature(), other.getTemperature()) != 0) {
            return false;
         } else if (Float.compare(this.getDownfall(), other.getDownfall()) != 0) {
            return false;
         } else if (Float.compare(this.getRedSporeDensity(), other.getRedSporeDensity()) != 0) {
            return false;
         } else if (Float.compare(this.getBlueSporeDensity(), other.getBlueSporeDensity()) != 0) {
            return false;
         } else if (Float.compare(this.getAshDensity(), other.getAshDensity()) != 0) {
            return false;
         } else if (Float.compare(this.getWhiteAshDensity(), other.getWhiteAshDensity()) != 0) {
            return false;
         } else {
            return Float.compare(this.getSnowAccumulationMin(), other.getSnowAccumulationMin()) != 0
               ? false
               : Float.compare(this.getSnowAccumulationMax(), other.getSnowAccumulationMax()) == 0;
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + Float.floatToIntBits(this.getTemperature());
      result = result * 59 + Float.floatToIntBits(this.getDownfall());
      result = result * 59 + Float.floatToIntBits(this.getRedSporeDensity());
      result = result * 59 + Float.floatToIntBits(this.getBlueSporeDensity());
      result = result * 59 + Float.floatToIntBits(this.getAshDensity());
      result = result * 59 + Float.floatToIntBits(this.getWhiteAshDensity());
      result = result * 59 + Float.floatToIntBits(this.getSnowAccumulationMin());
      return result * 59 + Float.floatToIntBits(this.getSnowAccumulationMax());
   }

   @Override
   public String toString() {
      return "BiomeClimateData(temperature="
         + this.getTemperature()
         + ", downfall="
         + this.getDownfall()
         + ", redSporeDensity="
         + this.getRedSporeDensity()
         + ", blueSporeDensity="
         + this.getBlueSporeDensity()
         + ", ashDensity="
         + this.getAshDensity()
         + ", whiteAshDensity="
         + this.getWhiteAshDensity()
         + ", snowAccumulationMin="
         + this.getSnowAccumulationMin()
         + ", snowAccumulationMax="
         + this.getSnowAccumulationMax()
         + ")";
   }
}
