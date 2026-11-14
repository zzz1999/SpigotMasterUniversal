package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.CodeBuilderCategoryType;
import org.cloudburstmc.protocol.bedrock.data.CodeBuilderCodeStatus;
import org.cloudburstmc.protocol.bedrock.data.CodeBuilderOperationType;
import org.cloudburstmc.protocol.common.PacketSignal;

public class CodeBuilderSourcePacket implements BedrockPacket {
   private CodeBuilderOperationType operation;
   private CodeBuilderCategoryType category;
   /** @deprecated */
   private String value;
   private CodeBuilderCodeStatus codeStatus;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CODE_BUILDER_SOURCE;
   }

   public CodeBuilderSourcePacket clone() {
      try {
         return (CodeBuilderSourcePacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public CodeBuilderOperationType getOperation() {
      return this.operation;
   }

   public CodeBuilderCategoryType getCategory() {
      return this.category;
   }

   @Deprecated
   public String getValue() {
      return this.value;
   }

   public CodeBuilderCodeStatus getCodeStatus() {
      return this.codeStatus;
   }

   public void setOperation(final CodeBuilderOperationType operation) {
      this.operation = operation;
   }

   public void setCategory(final CodeBuilderCategoryType category) {
      this.category = category;
   }

   @Deprecated
   public void setValue(final String value) {
      this.value = value;
   }

   public void setCodeStatus(final CodeBuilderCodeStatus codeStatus) {
      this.codeStatus = codeStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CodeBuilderSourcePacket)) {
         return false;
      }

      CodeBuilderSourcePacket other = (CodeBuilderSourcePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$operation = this.operation;
      Object other$operation = other.operation;
      if (this$operation == null ? other$operation == null : this$operation.equals(other$operation)) {
         Object this$category = this.category;
         Object other$category = other.category;
         if (this$category == null ? other$category == null : this$category.equals(other$category)) {
            Object this$value = this.value;
            Object other$value = other.value;
            if (this$value == null ? other$value == null : this$value.equals(other$value)) {
               Object this$codeStatus = this.codeStatus;
               Object other$codeStatus = other.codeStatus;
               return this$codeStatus == null ? other$codeStatus == null : this$codeStatus.equals(other$codeStatus);
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
      return other instanceof CodeBuilderSourcePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $operation = this.operation;
      result = result * 59 + ($operation == null ? 43 : $operation.hashCode());
      Object $category = this.category;
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $value = this.value;
      result = result * 59 + ($value == null ? 43 : $value.hashCode());
      Object $codeStatus = this.codeStatus;
      return result * 59 + ($codeStatus == null ? 43 : $codeStatus.hashCode());
   }

   @Override
   public String toString() {
      return "CodeBuilderSourcePacket(operation="
         + this.operation
         + ", category="
         + this.category
         + ", value="
         + this.value
         + ", codeStatus="
         + this.codeStatus
         + ")";
   }
}
