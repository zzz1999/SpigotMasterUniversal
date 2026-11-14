package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.command.CommandEnumData;
import org.cloudburstmc.protocol.bedrock.data.command.SoftEnumUpdateType;
import org.cloudburstmc.protocol.common.PacketSignal;

public class UpdateSoftEnumPacket implements BedrockPacket {
   private CommandEnumData softEnum;
   private SoftEnumUpdateType type;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.UPDATE_SOFT_ENUM;
   }

   public UpdateSoftEnumPacket clone() {
      try {
         return (UpdateSoftEnumPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public CommandEnumData getSoftEnum() {
      return this.softEnum;
   }

   public SoftEnumUpdateType getType() {
      return this.type;
   }

   public void setSoftEnum(final CommandEnumData softEnum) {
      this.softEnum = softEnum;
   }

   public void setType(final SoftEnumUpdateType type) {
      this.type = type;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof UpdateSoftEnumPacket)) {
         return false;
      } else {
         UpdateSoftEnumPacket other = (UpdateSoftEnumPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$softEnum = this.softEnum;
            Object other$softEnum = other.softEnum;
            if (this$softEnum == null ? other$softEnum == null : this$softEnum.equals(other$softEnum)) {
               Object this$type = this.type;
               Object other$type = other.type;
               return this$type == null ? other$type == null : this$type.equals(other$type);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof UpdateSoftEnumPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $softEnum = this.softEnum;
      result = result * 59 + ($softEnum == null ? 43 : $softEnum.hashCode());
      Object $type = this.type;
      return result * 59 + ($type == null ? 43 : $type.hashCode());
   }

   @Override
   public String toString() {
      return "UpdateSoftEnumPacket(softEnum=" + this.softEnum + ", type=" + this.type + ")";
   }
}
