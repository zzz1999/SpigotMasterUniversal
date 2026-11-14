package org.cloudburstmc.protocol.bedrock.data.camera;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.ArrayList;
import java.util.List;

public class CameraAimAssistCategory {
   private String name;
   private List<CameraAimAssistPriority> entityPriorities = new ObjectArrayList<>();
   private List<CameraAimAssistPriority> blockPriorities = new ArrayList<>();
   private List<CameraAimAssistPriority> blockTagPriorities = new ArrayList<>();
   private Integer entityDefaultPriorities;
   private Integer blockDefaultPriorities;

   public String getName() {
      return this.name;
   }

   public List<CameraAimAssistPriority> getEntityPriorities() {
      return this.entityPriorities;
   }

   public List<CameraAimAssistPriority> getBlockPriorities() {
      return this.blockPriorities;
   }

   public List<CameraAimAssistPriority> getBlockTagPriorities() {
      return this.blockTagPriorities;
   }

   public Integer getEntityDefaultPriorities() {
      return this.entityDefaultPriorities;
   }

   public Integer getBlockDefaultPriorities() {
      return this.blockDefaultPriorities;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setEntityPriorities(final List<CameraAimAssistPriority> entityPriorities) {
      this.entityPriorities = entityPriorities;
   }

   public void setBlockPriorities(final List<CameraAimAssistPriority> blockPriorities) {
      this.blockPriorities = blockPriorities;
   }

   public void setBlockTagPriorities(final List<CameraAimAssistPriority> blockTagPriorities) {
      this.blockTagPriorities = blockTagPriorities;
   }

   public void setEntityDefaultPriorities(final Integer entityDefaultPriorities) {
      this.entityDefaultPriorities = entityDefaultPriorities;
   }

   public void setBlockDefaultPriorities(final Integer blockDefaultPriorities) {
      this.blockDefaultPriorities = blockDefaultPriorities;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CameraAimAssistCategory)) {
         return false;
      }

      CameraAimAssistCategory other = (CameraAimAssistCategory)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$entityDefaultPriorities = this.getEntityDefaultPriorities();
      Object other$entityDefaultPriorities = other.getEntityDefaultPriorities();
      if (this$entityDefaultPriorities == null ? other$entityDefaultPriorities == null : this$entityDefaultPriorities.equals(other$entityDefaultPriorities)) {
         Object this$blockDefaultPriorities = this.getBlockDefaultPriorities();
         Object other$blockDefaultPriorities = other.getBlockDefaultPriorities();
         if (this$blockDefaultPriorities == null ? other$blockDefaultPriorities == null : this$blockDefaultPriorities.equals(other$blockDefaultPriorities)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$entityPriorities = this.getEntityPriorities();
               Object other$entityPriorities = other.getEntityPriorities();
               if (this$entityPriorities == null ? other$entityPriorities == null : this$entityPriorities.equals(other$entityPriorities)) {
                  Object this$blockPriorities = this.getBlockPriorities();
                  Object other$blockPriorities = other.getBlockPriorities();
                  if (this$blockPriorities == null ? other$blockPriorities == null : this$blockPriorities.equals(other$blockPriorities)) {
                     Object this$blockTagPriorities = this.getBlockTagPriorities();
                     Object other$blockTagPriorities = other.getBlockTagPriorities();
                     return this$blockTagPriorities == null ? other$blockTagPriorities == null : this$blockTagPriorities.equals(other$blockTagPriorities);
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
      return other instanceof CameraAimAssistCategory;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $entityDefaultPriorities = this.getEntityDefaultPriorities();
      result = result * 59 + ($entityDefaultPriorities == null ? 43 : $entityDefaultPriorities.hashCode());
      Object $blockDefaultPriorities = this.getBlockDefaultPriorities();
      result = result * 59 + ($blockDefaultPriorities == null ? 43 : $blockDefaultPriorities.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $entityPriorities = this.getEntityPriorities();
      result = result * 59 + ($entityPriorities == null ? 43 : $entityPriorities.hashCode());
      Object $blockPriorities = this.getBlockPriorities();
      result = result * 59 + ($blockPriorities == null ? 43 : $blockPriorities.hashCode());
      Object $blockTagPriorities = this.getBlockTagPriorities();
      return result * 59 + ($blockTagPriorities == null ? 43 : $blockTagPriorities.hashCode());
   }

   @Override
   public String toString() {
      return "CameraAimAssistCategory(name="
         + this.getName()
         + ", entityPriorities="
         + this.getEntityPriorities()
         + ", blockPriorities="
         + this.getBlockPriorities()
         + ", blockTagPriorities="
         + this.getBlockTagPriorities()
         + ", entityDefaultPriorities="
         + this.getEntityDefaultPriorities()
         + ", blockDefaultPriorities="
         + this.getBlockDefaultPriorities()
         + ")";
   }
}
