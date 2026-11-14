package org.cloudburstmc.protocol.bedrock.data.biome;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.cloudburstmc.protocol.common.util.index.Indexable;
import org.cloudburstmc.protocol.common.util.index.Unindexed;

public final class BiomeConsolidatedFeatureData {
   private final BiomeScatterParamData scatter;
   private final transient Indexable<String> feature;
   private final transient Indexable<String> identifier;
   private final transient Indexable<String> pass;
   private final boolean internalUse;

   @JsonCreator
   public BiomeConsolidatedFeatureData(BiomeScatterParamData scatter, String feature, String identifier, String pass, boolean internalUse) {
      this.scatter = scatter;
      this.feature = new Unindexed<>(feature);
      this.identifier = new Unindexed<>(identifier);
      this.pass = new Unindexed<>(pass);
      this.internalUse = internalUse;
   }

   public String getFeature() {
      return this.feature.get();
   }

   public String getIdentifier() {
      return this.identifier.get();
   }

   public String getPass() {
      return this.pass.get();
   }

   public BiomeScatterParamData getScatter() {
      return this.scatter;
   }

   public boolean isInternalUse() {
      return this.internalUse;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BiomeConsolidatedFeatureData)) {
         return false;
      }

      BiomeConsolidatedFeatureData other = (BiomeConsolidatedFeatureData)o;
      if (this.isInternalUse() != other.isInternalUse()) {
         return false;
      }

      Object this$scatter = this.getScatter();
      Object other$scatter = other.getScatter();
      return this$scatter == null ? other$scatter == null : this$scatter.equals(other$scatter);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isInternalUse() ? 79 : 97);
      Object $scatter = this.getScatter();
      return result * 59 + ($scatter == null ? 43 : $scatter.hashCode());
   }

   @Override
   public String toString() {
      return "BiomeConsolidatedFeatureData(scatter="
         + this.getScatter()
         + ", feature="
         + this.getFeature()
         + ", identifier="
         + this.getIdentifier()
         + ", pass="
         + this.getPass()
         + ", internalUse="
         + this.isInternalUse()
         + ")";
   }

   @Deprecated
   public BiomeConsolidatedFeatureData(
      final BiomeScatterParamData scatter,
      final Indexable<String> feature,
      final Indexable<String> identifier,
      final Indexable<String> pass,
      final boolean internalUse
   ) {
      this.scatter = scatter;
      this.feature = feature;
      this.identifier = identifier;
      this.pass = pass;
      this.internalUse = internalUse;
   }
}
