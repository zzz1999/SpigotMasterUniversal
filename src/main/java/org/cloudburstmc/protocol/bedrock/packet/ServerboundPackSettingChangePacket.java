package org.cloudburstmc.protocol.bedrock.packet;

import java.util.UUID;
import org.cloudburstmc.protocol.common.PacketSignal;

public class ServerboundPackSettingChangePacket implements BedrockPacket {
   private UUID packId;
   private String packSettingName;
   private Object packSettingValue;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SERVERBOUND_PACK_SETTING_CHANGE;
   }

   public ServerboundPackSettingChangePacket clone() {
      try {
         return (ServerboundPackSettingChangePacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public UUID getPackId() {
      return this.packId;
   }

   public String getPackSettingName() {
      return this.packSettingName;
   }

   public Object getPackSettingValue() {
      return this.packSettingValue;
   }

   public void setPackId(final UUID packId) {
      this.packId = packId;
   }

   public void setPackSettingName(final String packSettingName) {
      this.packSettingName = packSettingName;
   }

   public void setPackSettingValue(final Object packSettingValue) {
      this.packSettingValue = packSettingValue;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ServerboundPackSettingChangePacket)) {
         return false;
      }

      ServerboundPackSettingChangePacket other = (ServerboundPackSettingChangePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$packId = this.packId;
      Object other$packId = other.packId;
      if (this$packId == null ? other$packId == null : this$packId.equals(other$packId)) {
         Object this$packSettingName = this.packSettingName;
         Object other$packSettingName = other.packSettingName;
         if (this$packSettingName == null ? other$packSettingName == null : this$packSettingName.equals(other$packSettingName)) {
            Object this$packSettingValue = this.packSettingValue;
            Object other$packSettingValue = other.packSettingValue;
            return this$packSettingValue == null ? other$packSettingValue == null : this$packSettingValue.equals(other$packSettingValue);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ServerboundPackSettingChangePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $packId = this.packId;
      result = result * 59 + ($packId == null ? 43 : $packId.hashCode());
      Object $packSettingName = this.packSettingName;
      result = result * 59 + ($packSettingName == null ? 43 : $packSettingName.hashCode());
      Object $packSettingValue = this.packSettingValue;
      return result * 59 + ($packSettingValue == null ? 43 : $packSettingValue.hashCode());
   }

   @Override
   public String toString() {
      return "ServerboundPackSettingChangePacket(packId="
         + this.packId
         + ", packSettingName="
         + this.packSettingName
         + ", packSettingValue="
         + this.packSettingValue
         + ")";
   }
}
