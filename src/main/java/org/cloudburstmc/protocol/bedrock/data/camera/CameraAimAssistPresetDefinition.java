package org.cloudburstmc.protocol.bedrock.data.camera;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;

public class CameraAimAssistPresetDefinition {
   private String identifier;
   /** @deprecated */
   private String categories;
   /** @deprecated */
   private final List<String> exclusionList = new ObjectArrayList<>();
   private final List<String> blockExclusionList = new ObjectArrayList<>();
   private final List<String> blockTagExclusionList = new ObjectArrayList<>();
   private final List<String> entityExclusionList = new ObjectArrayList<>();
   private final List<String> liquidTargetingList = new ObjectArrayList<>();
   private final List<CameraAimAssistItemSettings> itemSettings = new ObjectArrayList<>();
   private String defaultItemSettings;
   private String handSettings;

   public String getIdentifier() {
      return this.identifier;
   }

   @Deprecated
   public String getCategories() {
      return this.categories;
   }

   @Deprecated
   public List<String> getExclusionList() {
      return this.exclusionList;
   }

   public List<String> getBlockExclusionList() {
      return this.blockExclusionList;
   }

   public List<String> getBlockTagExclusionList() {
      return this.blockTagExclusionList;
   }

   public List<String> getEntityExclusionList() {
      return this.entityExclusionList;
   }

   public List<String> getLiquidTargetingList() {
      return this.liquidTargetingList;
   }

   public List<CameraAimAssistItemSettings> getItemSettings() {
      return this.itemSettings;
   }

   public String getDefaultItemSettings() {
      return this.defaultItemSettings;
   }

   public String getHandSettings() {
      return this.handSettings;
   }

   public void setIdentifier(final String identifier) {
      this.identifier = identifier;
   }

   @Deprecated
   public void setCategories(final String categories) {
      this.categories = categories;
   }

   public void setDefaultItemSettings(final String defaultItemSettings) {
      this.defaultItemSettings = defaultItemSettings;
   }

   public void setHandSettings(final String handSettings) {
      this.handSettings = handSettings;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CameraAimAssistPresetDefinition)) {
         return false;
      }

      CameraAimAssistPresetDefinition other = (CameraAimAssistPresetDefinition)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$identifier = this.getIdentifier();
      Object other$identifier = other.getIdentifier();
      if (this$identifier == null ? other$identifier == null : this$identifier.equals(other$identifier)) {
         Object this$categories = this.getCategories();
         Object other$categories = other.getCategories();
         if (this$categories == null ? other$categories == null : this$categories.equals(other$categories)) {
            Object this$exclusionList = this.getExclusionList();
            Object other$exclusionList = other.getExclusionList();
            if (this$exclusionList == null ? other$exclusionList == null : this$exclusionList.equals(other$exclusionList)) {
               Object this$blockExclusionList = this.getBlockExclusionList();
               Object other$blockExclusionList = other.getBlockExclusionList();
               if (this$blockExclusionList == null ? other$blockExclusionList == null : this$blockExclusionList.equals(other$blockExclusionList)) {
                  Object this$blockTagExclusionList = this.getBlockTagExclusionList();
                  Object other$blockTagExclusionList = other.getBlockTagExclusionList();
                  if (this$blockTagExclusionList == null ? other$blockTagExclusionList == null : this$blockTagExclusionList.equals(other$blockTagExclusionList)
                     )
                   {
                     Object this$entityExclusionList = this.getEntityExclusionList();
                     Object other$entityExclusionList = other.getEntityExclusionList();
                     if (this$entityExclusionList == null ? other$entityExclusionList == null : this$entityExclusionList.equals(other$entityExclusionList)) {
                        Object this$liquidTargetingList = this.getLiquidTargetingList();
                        Object other$liquidTargetingList = other.getLiquidTargetingList();
                        if (this$liquidTargetingList == null ? other$liquidTargetingList == null : this$liquidTargetingList.equals(other$liquidTargetingList)) {
                           Object this$itemSettings = this.getItemSettings();
                           Object other$itemSettings = other.getItemSettings();
                           if (this$itemSettings == null ? other$itemSettings == null : this$itemSettings.equals(other$itemSettings)) {
                              Object this$defaultItemSettings = this.getDefaultItemSettings();
                              Object other$defaultItemSettings = other.getDefaultItemSettings();
                              if (this$defaultItemSettings == null
                                 ? other$defaultItemSettings == null
                                 : this$defaultItemSettings.equals(other$defaultItemSettings)) {
                                 Object this$handSettings = this.getHandSettings();
                                 Object other$handSettings = other.getHandSettings();
                                 return this$handSettings == null ? other$handSettings == null : this$handSettings.equals(other$handSettings);
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof CameraAimAssistPresetDefinition;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $identifier = this.getIdentifier();
      result = result * 59 + ($identifier == null ? 43 : $identifier.hashCode());
      Object $categories = this.getCategories();
      result = result * 59 + ($categories == null ? 43 : $categories.hashCode());
      Object $exclusionList = this.getExclusionList();
      result = result * 59 + ($exclusionList == null ? 43 : $exclusionList.hashCode());
      Object $blockExclusionList = this.getBlockExclusionList();
      result = result * 59 + ($blockExclusionList == null ? 43 : $blockExclusionList.hashCode());
      Object $blockTagExclusionList = this.getBlockTagExclusionList();
      result = result * 59 + ($blockTagExclusionList == null ? 43 : $blockTagExclusionList.hashCode());
      Object $entityExclusionList = this.getEntityExclusionList();
      result = result * 59 + ($entityExclusionList == null ? 43 : $entityExclusionList.hashCode());
      Object $liquidTargetingList = this.getLiquidTargetingList();
      result = result * 59 + ($liquidTargetingList == null ? 43 : $liquidTargetingList.hashCode());
      Object $itemSettings = this.getItemSettings();
      result = result * 59 + ($itemSettings == null ? 43 : $itemSettings.hashCode());
      Object $defaultItemSettings = this.getDefaultItemSettings();
      result = result * 59 + ($defaultItemSettings == null ? 43 : $defaultItemSettings.hashCode());
      Object $handSettings = this.getHandSettings();
      return result * 59 + ($handSettings == null ? 43 : $handSettings.hashCode());
   }

   @Override
   public String toString() {
      return "CameraAimAssistPresetDefinition(identifier="
         + this.getIdentifier()
         + ", categories="
         + this.getCategories()
         + ", exclusionList="
         + this.getExclusionList()
         + ", blockExclusionList="
         + this.getBlockExclusionList()
         + ", blockTagExclusionList="
         + this.getBlockTagExclusionList()
         + ", entityExclusionList="
         + this.getEntityExclusionList()
         + ", liquidTargetingList="
         + this.getLiquidTargetingList()
         + ", itemSettings="
         + this.getItemSettings()
         + ", defaultItemSettings="
         + this.getDefaultItemSettings()
         + ", handSettings="
         + this.getHandSettings()
         + ")";
   }
}
