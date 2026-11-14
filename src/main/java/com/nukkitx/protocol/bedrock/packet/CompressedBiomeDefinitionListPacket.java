package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;
import org.cloudburstmc.nbt.NbtMap;

public class CompressedBiomeDefinitionListPacket implements BedrockPacket {
   private NbtMap definitions;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.COMPRESSED_BIOME_DEFINITIONS_LIST;
   }

   public NbtMap getDefinitions() {
      return this.definitions;
   }

   public void setDefinitions(NbtMap definitions) {
      this.definitions = definitions;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CompressedBiomeDefinitionListPacket)) {
         return false;
      }

      CompressedBiomeDefinitionListPacket other = (CompressedBiomeDefinitionListPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$definitions = this.definitions;
      Object other$definitions = other.definitions;
      return this$definitions == null ? other$definitions == null : this$definitions.equals(other$definitions);
   }

   protected boolean canEqual(Object other) {
      return other instanceof CompressedBiomeDefinitionListPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $definitions = this.definitions;
      return result * 59 + ($definitions == null ? 43 : $definitions.hashCode());
   }

   @Override
   public String toString() {
      return "CompressedBiomeDefinitionListPacket()";
   }
}
