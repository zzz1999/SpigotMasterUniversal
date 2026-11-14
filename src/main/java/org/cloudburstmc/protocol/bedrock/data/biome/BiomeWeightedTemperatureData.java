package org.cloudburstmc.protocol.bedrock.data.biome;

public final class BiomeWeightedTemperatureData {
   private final BiomeTemperatureCategory temperature;
   private final long weight;

   public BiomeWeightedTemperatureData(final BiomeTemperatureCategory temperature, final long weight) {
      this.temperature = temperature;
      this.weight = weight;
   }

   public BiomeTemperatureCategory getTemperature() {
      return this.temperature;
   }

   public long getWeight() {
      return this.weight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BiomeWeightedTemperatureData)) {
         return false;
      }

      BiomeWeightedTemperatureData other = (BiomeWeightedTemperatureData)o;
      if (this.getWeight() != other.getWeight()) {
         return false;
      }

      Object this$temperature = this.getTemperature();
      Object other$temperature = other.getTemperature();
      return this$temperature == null ? other$temperature == null : this$temperature.equals(other$temperature);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $weight = this.getWeight();
      result = result * 59 + (int)($weight >>> 32 ^ $weight);
      Object $temperature = this.getTemperature();
      return result * 59 + ($temperature == null ? 43 : $temperature.hashCode());
   }

   @Override
   public String toString() {
      return "BiomeWeightedTemperatureData(temperature=" + this.getTemperature() + ", weight=" + this.getWeight() + ")";
   }
}
