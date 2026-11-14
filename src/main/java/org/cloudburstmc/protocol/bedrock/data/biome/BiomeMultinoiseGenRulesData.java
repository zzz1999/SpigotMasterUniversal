package org.cloudburstmc.protocol.bedrock.data.biome;

public final class BiomeMultinoiseGenRulesData {
   private final float temperature;
   private final float humidity;
   private final float altitude;
   private final float weirdness;
   private final float weight;

   public BiomeMultinoiseGenRulesData(final float temperature, final float humidity, final float altitude, final float weirdness, final float weight) {
      this.temperature = temperature;
      this.humidity = humidity;
      this.altitude = altitude;
      this.weirdness = weirdness;
      this.weight = weight;
   }

   public float getTemperature() {
      return this.temperature;
   }

   public float getHumidity() {
      return this.humidity;
   }

   public float getAltitude() {
      return this.altitude;
   }

   public float getWeirdness() {
      return this.weirdness;
   }

   public float getWeight() {
      return this.weight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof BiomeMultinoiseGenRulesData)) {
         return false;
      } else {
         BiomeMultinoiseGenRulesData other = (BiomeMultinoiseGenRulesData)o;
         if (Float.compare(this.getTemperature(), other.getTemperature()) != 0) {
            return false;
         } else if (Float.compare(this.getHumidity(), other.getHumidity()) != 0) {
            return false;
         } else if (Float.compare(this.getAltitude(), other.getAltitude()) != 0) {
            return false;
         } else {
            return Float.compare(this.getWeirdness(), other.getWeirdness()) != 0 ? false : Float.compare(this.getWeight(), other.getWeight()) == 0;
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + Float.floatToIntBits(this.getTemperature());
      result = result * 59 + Float.floatToIntBits(this.getHumidity());
      result = result * 59 + Float.floatToIntBits(this.getAltitude());
      result = result * 59 + Float.floatToIntBits(this.getWeirdness());
      return result * 59 + Float.floatToIntBits(this.getWeight());
   }

   @Override
   public String toString() {
      return "BiomeMultinoiseGenRulesData(temperature="
         + this.getTemperature()
         + ", humidity="
         + this.getHumidity()
         + ", altitude="
         + this.getAltitude()
         + ", weirdness="
         + this.getWeirdness()
         + ", weight="
         + this.getWeight()
         + ")";
   }
}
