package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;
import org.cloudburstmc.nbt.NbtMap;

public class AvailableEntityIdentifiersPacket implements BedrockPacket {
   private NbtMap identifiers;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.AVAILABLE_ENTITY_IDENTIFIERS;
   }

   public NbtMap getIdentifiers() {
      return this.identifiers;
   }

   public void setIdentifiers(NbtMap identifiers) {
      this.identifiers = identifiers;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AvailableEntityIdentifiersPacket)) {
         return false;
      }

      AvailableEntityIdentifiersPacket other = (AvailableEntityIdentifiersPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$identifiers = this.identifiers;
      Object other$identifiers = other.identifiers;
      return this$identifiers == null ? other$identifiers == null : this$identifiers.equals(other$identifiers);
   }

   protected boolean canEqual(Object other) {
      return other instanceof AvailableEntityIdentifiersPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $identifiers = this.identifiers;
      return result * 59 + ($identifiers == null ? 43 : $identifiers.hashCode());
   }

   @Override
   public String toString() {
      return "AvailableEntityIdentifiersPacket(identifiers=" + this.identifiers + ")";
   }
}
