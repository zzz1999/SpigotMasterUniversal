package org.cloudburstmc.protocol.bedrock.data.biome;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.awt.Color;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.cloudburstmc.protocol.common.util.index.Indexable;
import org.cloudburstmc.protocol.common.util.index.Unindexed;

public final class BiomeDefinitionData {
   private final transient @Nullable Indexable<String> id;
   private final float temperature;
   private final float downfall;
   private final float redSporeDensity;
   private final float blueSporeDensity;
   private final float ashDensity;
   private final float whiteAshDensity;
   private final float foliageSnow;
   private final float depth;
   private final float scale;
   private final Color mapWaterColor;
   private final boolean rain;
   private final transient @Nullable Indexable<List<String>> tags;
   private final @Nullable BiomeDefinitionChunkGenData chunkGenData;

   @JsonCreator
   public BiomeDefinitionData(
      @Nullable String id,
      float temperature,
      float downfall,
      float redSporeDensity,
      float blueSporeDensity,
      float ashDensity,
      float whiteAshDensity,
      float foliageSnow,
      float depth,
      float scale,
      Color mapWaterColor,
      boolean rain,
      @Nullable List<String> tags,
      @Nullable BiomeDefinitionChunkGenData chunkGenData
   ) {
      this(
         id == null ? null : new Unindexed<>(id),
         temperature,
         downfall,
         redSporeDensity,
         blueSporeDensity,
         ashDensity,
         whiteAshDensity,
         foliageSnow,
         depth,
         scale,
         mapWaterColor,
         rain,
         tags == null ? null : new Unindexed<>(tags),
         chunkGenData
      );
   }

   public BiomeDefinitionData(
      @Nullable String id,
      float temperature,
      float downfall,
      float foliageSnow,
      float depth,
      float scale,
      Color mapWaterColor,
      boolean rain,
      @Nullable List<String> tags,
      @Nullable BiomeDefinitionChunkGenData chunkGenData
   ) {
      this(
         id == null ? null : new Unindexed<>(id),
         temperature,
         downfall,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         foliageSnow,
         depth,
         scale,
         mapWaterColor,
         rain,
         tags == null ? null : new Unindexed<>(tags),
         chunkGenData
      );
   }

   public BiomeDefinitionData(
      @Nullable Indexable<String> id,
      float temperature,
      float downfall,
      float foliageSnow,
      float depth,
      float scale,
      Color mapWaterColor,
      boolean rain,
      @Nullable Indexable<List<String>> tags,
      @Nullable BiomeDefinitionChunkGenData chunkGenData
   ) {
      this(id, temperature, downfall, 0.0F, 0.0F, 0.0F, 0.0F, foliageSnow, depth, scale, mapWaterColor, rain, tags, chunkGenData);
   }

   public BiomeDefinitionData(
      @Nullable Indexable<String> id,
      float temperature,
      float downfall,
      float redSporeDensity,
      float blueSporeDensity,
      float ashDensity,
      float whiteAshDensity,
      float depth,
      float scale,
      Color mapWaterColor,
      boolean rain,
      @Nullable Indexable<List<String>> tags,
      @Nullable BiomeDefinitionChunkGenData chunkGenData
   ) {
      this(
         id, temperature, downfall, redSporeDensity, blueSporeDensity, ashDensity, whiteAshDensity, 0.0F, depth, scale, mapWaterColor, rain, tags, chunkGenData
      );
   }

   private BiomeDefinitionData(
      @Nullable Indexable<String> id,
      float temperature,
      float downfall,
      float redSporeDensity,
      float blueSporeDensity,
      float ashDensity,
      float whiteAshDensity,
      float foliageSnow,
      float depth,
      float scale,
      Color mapWaterColor,
      boolean rain,
      @Nullable Indexable<List<String>> tags,
      @Nullable BiomeDefinitionChunkGenData chunkGenData
   ) {
      this.id = id;
      this.temperature = temperature;
      this.downfall = downfall;
      this.redSporeDensity = redSporeDensity;
      this.blueSporeDensity = blueSporeDensity;
      this.ashDensity = ashDensity;
      this.whiteAshDensity = whiteAshDensity;
      this.foliageSnow = foliageSnow;
      this.depth = depth;
      this.scale = scale;
      this.mapWaterColor = mapWaterColor;
      this.rain = rain;
      this.tags = tags;
      this.chunkGenData = chunkGenData;
   }

   public @Nullable String getId() {
      return this.id == null ? null : this.id.get();
   }

   public @Nullable List<String> getTags() {
      return this.tags == null ? null : this.tags.get();
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

   public float getFoliageSnow() {
      return this.foliageSnow;
   }

   public float getDepth() {
      return this.depth;
   }

   public float getScale() {
      return this.scale;
   }

   public Color getMapWaterColor() {
      return this.mapWaterColor;
   }

   public boolean isRain() {
      return this.rain;
   }

   public @Nullable BiomeDefinitionChunkGenData getChunkGenData() {
      return this.chunkGenData;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof BiomeDefinitionData)) {
         return false;
      } else {
         BiomeDefinitionData other = (BiomeDefinitionData)o;
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
         } else if (Float.compare(this.getFoliageSnow(), other.getFoliageSnow()) != 0) {
            return false;
         } else if (Float.compare(this.getDepth(), other.getDepth()) != 0) {
            return false;
         } else if (Float.compare(this.getScale(), other.getScale()) != 0) {
            return false;
         } else if (this.isRain() != other.isRain()) {
            return false;
         } else {
            Object this$mapWaterColor = this.getMapWaterColor();
            Object other$mapWaterColor = other.getMapWaterColor();
            if (this$mapWaterColor == null ? other$mapWaterColor == null : this$mapWaterColor.equals(other$mapWaterColor)) {
               Object this$chunkGenData = this.getChunkGenData();
               Object other$chunkGenData = other.getChunkGenData();
               return this$chunkGenData == null ? other$chunkGenData == null : this$chunkGenData.equals(other$chunkGenData);
            } else {
               return false;
            }
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
      result = result * 59 + Float.floatToIntBits(this.getFoliageSnow());
      result = result * 59 + Float.floatToIntBits(this.getDepth());
      result = result * 59 + Float.floatToIntBits(this.getScale());
      result = result * 59 + (this.isRain() ? 79 : 97);
      Object $mapWaterColor = this.getMapWaterColor();
      result = result * 59 + ($mapWaterColor == null ? 43 : $mapWaterColor.hashCode());
      Object $chunkGenData = this.getChunkGenData();
      return result * 59 + ($chunkGenData == null ? 43 : $chunkGenData.hashCode());
   }

   @Override
   public String toString() {
      return "BiomeDefinitionData(id="
         + this.getId()
         + ", temperature="
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
         + ", foliageSnow="
         + this.getFoliageSnow()
         + ", depth="
         + this.getDepth()
         + ", scale="
         + this.getScale()
         + ", mapWaterColor="
         + this.getMapWaterColor()
         + ", rain="
         + this.isRain()
         + ", tags="
         + this.getTags()
         + ", chunkGenData="
         + this.getChunkGenData()
         + ")";
   }
}
