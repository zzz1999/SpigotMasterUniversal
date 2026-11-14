package com.nukkitx.protocol.bedrock.data.structure;

public final class StructureEditorData {
   private final String name;
   private final String dataField;
   private final boolean includingPlayers;
   private final boolean boundingBoxVisible;
   private final StructureBlockType type;
   private final StructureSettings settings;
   private final StructureRedstoneSaveMode redstoneSaveMode;

   public StructureEditorData(
      String name,
      String dataField,
      boolean includingPlayers,
      boolean boundingBoxVisible,
      StructureBlockType type,
      StructureSettings settings,
      StructureRedstoneSaveMode redstoneSaveMode
   ) {
      this.name = name;
      this.dataField = dataField;
      this.includingPlayers = includingPlayers;
      this.boundingBoxVisible = boundingBoxVisible;
      this.type = type;
      this.settings = settings;
      this.redstoneSaveMode = redstoneSaveMode;
   }

   public String getName() {
      return this.name;
   }

   public String getDataField() {
      return this.dataField;
   }

   public boolean isIncludingPlayers() {
      return this.includingPlayers;
   }

   public boolean isBoundingBoxVisible() {
      return this.boundingBoxVisible;
   }

   public StructureBlockType getType() {
      return this.type;
   }

   public StructureSettings getSettings() {
      return this.settings;
   }

   public StructureRedstoneSaveMode getRedstoneSaveMode() {
      return this.redstoneSaveMode;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StructureEditorData)) {
         return false;
      }

      StructureEditorData other = (StructureEditorData)o;
      if (this.isIncludingPlayers() != other.isIncludingPlayers()) {
         return false;
      }

      if (this.isBoundingBoxVisible() != other.isBoundingBoxVisible()) {
         return false;
      }

      Object this$name = this.getName();
      Object other$name = other.getName();
      if (this$name == null ? other$name == null : this$name.equals(other$name)) {
         Object this$dataField = this.getDataField();
         Object other$dataField = other.getDataField();
         if (this$dataField == null ? other$dataField == null : this$dataField.equals(other$dataField)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$settings = this.getSettings();
               Object other$settings = other.getSettings();
               if (this$settings == null ? other$settings == null : this$settings.equals(other$settings)) {
                  Object this$redstoneSaveMode = this.getRedstoneSaveMode();
                  Object other$redstoneSaveMode = other.getRedstoneSaveMode();
                  return this$redstoneSaveMode == null ? other$redstoneSaveMode == null : this$redstoneSaveMode.equals(other$redstoneSaveMode);
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

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isIncludingPlayers() ? 79 : 97);
      result = result * 59 + (this.isBoundingBoxVisible() ? 79 : 97);
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $dataField = this.getDataField();
      result = result * 59 + ($dataField == null ? 43 : $dataField.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $settings = this.getSettings();
      result = result * 59 + ($settings == null ? 43 : $settings.hashCode());
      Object $redstoneSaveMode = this.getRedstoneSaveMode();
      return result * 59 + ($redstoneSaveMode == null ? 43 : $redstoneSaveMode.hashCode());
   }

   @Override
   public String toString() {
      return "StructureEditorData(name="
         + this.getName()
         + ", dataField="
         + this.getDataField()
         + ", includingPlayers="
         + this.isIncludingPlayers()
         + ", boundingBoxVisible="
         + this.isBoundingBoxVisible()
         + ", type="
         + this.getType()
         + ", settings="
         + this.getSettings()
         + ", redstoneSaveMode="
         + this.getRedstoneSaveMode()
         + ")";
   }
}
