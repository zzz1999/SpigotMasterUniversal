package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;
import org.cloudburstmc.nbt.NbtMap;

public class UpdateBlockPropertiesPacket implements BedrockPacket {
   private NbtMap properties;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.UPDATE_BLOCK_PROPERTIES;
   }

   public NbtMap getProperties() {
      return this.properties;
   }

   public void setProperties(NbtMap properties) {
      this.properties = properties;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UpdateBlockPropertiesPacket)) {
         return false;
      }

      UpdateBlockPropertiesPacket other = (UpdateBlockPropertiesPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$properties = this.properties;
      Object other$properties = other.properties;
      return this$properties == null ? other$properties == null : this$properties.equals(other$properties);
   }

   protected boolean canEqual(Object other) {
      return other instanceof UpdateBlockPropertiesPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $properties = this.properties;
      return result * 59 + ($properties == null ? 43 : $properties.hashCode());
   }

   @Override
   public String toString() {
      return "UpdateBlockPropertiesPacket(properties=" + this.properties + ")";
   }
}
