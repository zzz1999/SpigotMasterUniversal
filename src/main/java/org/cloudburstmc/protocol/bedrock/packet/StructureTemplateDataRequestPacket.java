package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.math.vector.Vector3i;
import org.cloudburstmc.protocol.bedrock.data.structure.StructureSettings;
import org.cloudburstmc.protocol.bedrock.data.structure.StructureTemplateRequestOperation;
import org.cloudburstmc.protocol.common.PacketSignal;

public class StructureTemplateDataRequestPacket implements BedrockPacket {
   private String name;
   private Vector3i position;
   private StructureSettings settings;
   private StructureTemplateRequestOperation operation;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.STRUCTURE_TEMPLATE_DATA_EXPORT_REQUEST;
   }

   public StructureTemplateDataRequestPacket clone() {
      try {
         return (StructureTemplateDataRequestPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public String getName() {
      return this.name;
   }

   public Vector3i getPosition() {
      return this.position;
   }

   public StructureSettings getSettings() {
      return this.settings;
   }

   public StructureTemplateRequestOperation getOperation() {
      return this.operation;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setPosition(final Vector3i position) {
      this.position = position;
   }

   public void setSettings(final StructureSettings settings) {
      this.settings = settings;
   }

   public void setOperation(final StructureTemplateRequestOperation operation) {
      this.operation = operation;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StructureTemplateDataRequestPacket)) {
         return false;
      }

      StructureTemplateDataRequestPacket other = (StructureTemplateDataRequestPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$name = this.name;
      Object other$name = other.name;
      if (this$name == null ? other$name == null : this$name.equals(other$name)) {
         Object this$position = this.position;
         Object other$position = other.position;
         if (this$position == null ? other$position == null : this$position.equals(other$position)) {
            Object this$settings = this.settings;
            Object other$settings = other.settings;
            if (this$settings == null ? other$settings == null : this$settings.equals(other$settings)) {
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
      return other instanceof StructureTemplateDataRequestPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $name = this.name;
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $position = this.position;
      result = result * 59 + ($position == null ? 43 : $position.hashCode());
      Object $settings = this.settings;
      result = result * 59 + ($settings == null ? 43 : $settings.hashCode());
      Object $operation = this.operation;
      return result * 59 + ($operation == null ? 43 : $operation.hashCode());
   }

   @Override
   public String toString() {
      return "StructureTemplateDataRequestPacket(name="
         + this.name
         + ", position="
         + this.position
         + ", settings="
         + this.settings
         + ", operation="
         + this.operation
         + ")";
   }
}
