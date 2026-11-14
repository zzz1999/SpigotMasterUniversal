package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.definitions.FeatureDefinition;
import com.nukkitx.protocol.common.PacketSignal;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;

public class FeatureRegistryPacket implements BedrockPacket {
   private final List<FeatureDefinition> features = new ObjectArrayList<>();

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.FEATURE_REGISTRY;
   }

   public List<FeatureDefinition> getFeatures() {
      return this.features;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FeatureRegistryPacket)) {
         return false;
      }

      FeatureRegistryPacket other = (FeatureRegistryPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$features = this.features;
      Object other$features = other.features;
      return this$features == null ? other$features == null : this$features.equals(other$features);
   }

   protected boolean canEqual(Object other) {
      return other instanceof FeatureRegistryPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $features = this.features;
      return result * 59 + ($features == null ? 43 : $features.hashCode());
   }

   @Override
   public String toString() {
      return "FeatureRegistryPacket(features=" + this.features + ")";
   }
}
