package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class ServerSettingsResponsePacket implements BedrockPacket {
   private int formId;
   private String formData;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SERVER_SETTINGS_RESPONSE;
   }

   public int getFormId() {
      return this.formId;
   }

   public String getFormData() {
      return this.formData;
   }

   public void setFormId(int formId) {
      this.formId = formId;
   }

   public void setFormData(String formData) {
      this.formData = formData;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ServerSettingsResponsePacket)) {
         return false;
      }

      ServerSettingsResponsePacket other = (ServerSettingsResponsePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.formId != other.formId) {
         return false;
      }

      Object this$formData = this.formData;
      Object other$formData = other.formData;
      return this$formData == null ? other$formData == null : this$formData.equals(other$formData);
   }

   protected boolean canEqual(Object other) {
      return other instanceof ServerSettingsResponsePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.formId;
      Object $formData = this.formData;
      return result * 59 + ($formData == null ? 43 : $formData.hashCode());
   }

   @Override
   public String toString() {
      return "ServerSettingsResponsePacket(formId=" + this.formId + ", formData=" + this.formData + ")";
   }
}
