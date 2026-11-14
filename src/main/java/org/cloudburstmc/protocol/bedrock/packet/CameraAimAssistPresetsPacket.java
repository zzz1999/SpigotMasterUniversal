package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.cloudburstmc.protocol.bedrock.data.camera.CameraAimAssistCategories;
import org.cloudburstmc.protocol.bedrock.data.camera.CameraAimAssistCategory;
import org.cloudburstmc.protocol.bedrock.data.camera.CameraAimAssistOperation;
import org.cloudburstmc.protocol.bedrock.data.camera.CameraAimAssistPresetDefinition;
import org.cloudburstmc.protocol.common.PacketSignal;

public class CameraAimAssistPresetsPacket implements BedrockPacket {
   /** @deprecated */
   private final List<CameraAimAssistCategories> categories = new ObjectArrayList<>();
   private final List<CameraAimAssistCategory> categoryDefinitions = new ObjectArrayList<>();
   private final List<CameraAimAssistPresetDefinition> presets = new ObjectArrayList<>();
   private CameraAimAssistOperation operation;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CAMERA_AIM_ASSIST_PRESETS;
   }

   public CameraAimAssistPresetsPacket clone() {
      try {
         return (CameraAimAssistPresetsPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   @Deprecated
   public List<CameraAimAssistCategories> getCategories() {
      return this.categories;
   }

   public List<CameraAimAssistCategory> getCategoryDefinitions() {
      return this.categoryDefinitions;
   }

   public List<CameraAimAssistPresetDefinition> getPresets() {
      return this.presets;
   }

   public CameraAimAssistOperation getOperation() {
      return this.operation;
   }

   public void setOperation(final CameraAimAssistOperation operation) {
      this.operation = operation;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CameraAimAssistPresetsPacket)) {
         return false;
      }

      CameraAimAssistPresetsPacket other = (CameraAimAssistPresetsPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$categories = this.categories;
      Object other$categories = other.categories;
      if (this$categories == null ? other$categories == null : this$categories.equals(other$categories)) {
         Object this$categoryDefinitions = this.categoryDefinitions;
         Object other$categoryDefinitions = other.categoryDefinitions;
         if (this$categoryDefinitions == null ? other$categoryDefinitions == null : this$categoryDefinitions.equals(other$categoryDefinitions)) {
            Object this$presets = this.presets;
            Object other$presets = other.presets;
            if (this$presets == null ? other$presets == null : this$presets.equals(other$presets)) {
               Object this$operation = this.operation;
               Object other$operation = other.operation;
               return this$operation == null ? other$operation == null : this$operation.equals(other$operation);
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

   protected boolean canEqual(final Object other) {
      return other instanceof CameraAimAssistPresetsPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $categories = this.categories;
      result = result * 59 + ($categories == null ? 43 : $categories.hashCode());
      Object $categoryDefinitions = this.categoryDefinitions;
      result = result * 59 + ($categoryDefinitions == null ? 43 : $categoryDefinitions.hashCode());
      Object $presets = this.presets;
      result = result * 59 + ($presets == null ? 43 : $presets.hashCode());
      Object $operation = this.operation;
      return result * 59 + ($operation == null ? 43 : $operation.hashCode());
   }

   @Override
   public String toString() {
      return "CameraAimAssistPresetsPacket(categories="
         + this.categories
         + ", categoryDefinitions="
         + this.categoryDefinitions
         + ", presets="
         + this.presets
         + ", operation="
         + this.operation
         + ")";
   }
}
