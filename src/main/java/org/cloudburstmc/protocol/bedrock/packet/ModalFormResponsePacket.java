package org.cloudburstmc.protocol.bedrock.packet;

import java.util.Optional;
import org.cloudburstmc.protocol.bedrock.data.ModalFormCancelReason;
import org.cloudburstmc.protocol.common.PacketSignal;

public class ModalFormResponsePacket implements BedrockPacket {
   private int formId;
   private String formData;
   private Optional<ModalFormCancelReason> cancelReason;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.MODAL_FORM_RESPONSE;
   }

   public ModalFormResponsePacket clone() {
      try {
         return (ModalFormResponsePacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public int getFormId() {
      return this.formId;
   }

   public String getFormData() {
      return this.formData;
   }

   public Optional<ModalFormCancelReason> getCancelReason() {
      return this.cancelReason;
   }

   public void setFormId(final int formId) {
      this.formId = formId;
   }

   public void setFormData(final String formData) {
      this.formData = formData;
   }

   public void setCancelReason(final Optional<ModalFormCancelReason> cancelReason) {
      this.cancelReason = cancelReason;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ModalFormResponsePacket)) {
         return false;
      } else {
         ModalFormResponsePacket other = (ModalFormResponsePacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.formId != other.formId) {
            return false;
         } else {
            Object this$formData = this.formData;
            Object other$formData = other.formData;
            if (this$formData == null ? other$formData == null : this$formData.equals(other$formData)) {
               Object this$cancelReason = this.cancelReason;
               Object other$cancelReason = other.cancelReason;
               return this$cancelReason == null ? other$cancelReason == null : this$cancelReason.equals(other$cancelReason);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ModalFormResponsePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.formId;
      Object $formData = this.formData;
      result = result * 59 + ($formData == null ? 43 : $formData.hashCode());
      Object $cancelReason = this.cancelReason;
      return result * 59 + ($cancelReason == null ? 43 : $cancelReason.hashCode());
   }

   @Override
   public String toString() {
      return "ModalFormResponsePacket(formId=" + this.formId + ", formData=" + this.formData + ", cancelReason=" + this.cancelReason + ")";
   }
}
