package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.nbt.NbtMap;
import org.cloudburstmc.protocol.common.PacketSignal;

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

   public UpdateBlockPropertiesPacket clone() {
      try {
         return (UpdateBlockPropertiesPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public NbtMap getProperties() {
      return this.properties;
   }

   public void setProperties(final NbtMap properties) {
      this.properties = properties;
   }

   @Override
   public boolean equals(final Object o) {
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

   protected boolean canEqual(final Object other) {
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
