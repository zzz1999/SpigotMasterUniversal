package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.CodeBuilderCategoryType;
import com.nukkitx.protocol.bedrock.data.CodeBuilderOperationType;
import com.nukkitx.protocol.common.PacketSignal;

public class CodeBuilderSourcePacket implements BedrockPacket {
   private CodeBuilderOperationType operation;
   private CodeBuilderCategoryType category;
   private String value;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CODE_BUILDER_SOURCE;
   }

   public CodeBuilderOperationType getOperation() {
      return this.operation;
   }

   public CodeBuilderCategoryType getCategory() {
      return this.category;
   }

   public String getValue() {
      return this.value;
   }

   public void setOperation(CodeBuilderOperationType operation) {
      this.operation = operation;
   }

   public void setCategory(CodeBuilderCategoryType category) {
      this.category = category;
   }

   public void setValue(String value) {
      this.value = value;
   }

   @Override
   public boolean equals(Object o) {
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
            return this$value == null ? other$value == null : this$value.equals(other$value);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(Object other) {
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
      return result * 59 + ($value == null ? 43 : $value.hashCode());
   }

   @Override
   public String toString() {
      return "CodeBuilderSourcePacket(operation=" + this.operation + ", category=" + this.category + ", value=" + this.value + ")";
   }
}
