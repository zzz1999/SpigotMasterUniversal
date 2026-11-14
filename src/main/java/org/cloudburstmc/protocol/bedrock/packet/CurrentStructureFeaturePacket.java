package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class CurrentStructureFeaturePacket implements BedrockPacket {
   private String currentStructureFeature;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CURRENT_STRUCTURE_FEATURE;
   }

   public CurrentStructureFeaturePacket clone() {
      try {
         return (CurrentStructureFeaturePacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public String getCurrentStructureFeature() {
      return this.currentStructureFeature;
   }

   public void setCurrentStructureFeature(final String currentStructureFeature) {
      this.currentStructureFeature = currentStructureFeature;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CurrentStructureFeaturePacket)) {
         return false;
      }

      CurrentStructureFeaturePacket other = (CurrentStructureFeaturePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$currentStructureFeature = this.currentStructureFeature;
      Object other$currentStructureFeature = other.currentStructureFeature;
      return this$currentStructureFeature == null ? other$currentStructureFeature == null : this$currentStructureFeature.equals(other$currentStructureFeature);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CurrentStructureFeaturePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $currentStructureFeature = this.currentStructureFeature;
      return result * 59 + ($currentStructureFeature == null ? 43 : $currentStructureFeature.hashCode());
   }

   @Override
   public String toString() {
      return "CurrentStructureFeaturePacket(currentStructureFeature=" + this.currentStructureFeature + ")";
   }
}
