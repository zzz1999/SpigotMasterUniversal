package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.nbt.NbtMap;
import org.cloudburstmc.protocol.bedrock.data.biome.BiomeDefinitions;
import org.cloudburstmc.protocol.common.PacketSignal;

public class BiomeDefinitionListPacket implements BedrockPacket {
   /** @deprecated */
   private NbtMap definitions;
   private BiomeDefinitions biomes;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.BIOME_DEFINITIONS_LIST;
   }

   public BiomeDefinitionListPacket clone() {
      try {
         return (BiomeDefinitionListPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   @Deprecated
   public NbtMap getDefinitions() {
      return this.definitions;
   }

   public BiomeDefinitions getBiomes() {
      return this.biomes;
   }

   @Deprecated
   public void setDefinitions(final NbtMap definitions) {
      this.definitions = definitions;
   }

   public void setBiomes(final BiomeDefinitions biomes) {
      this.biomes = biomes;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof BiomeDefinitionListPacket)) {
         return false;
      } else {
         BiomeDefinitionListPacket other = (BiomeDefinitionListPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$definitions = this.definitions;
            Object other$definitions = other.definitions;
            if (this$definitions == null ? other$definitions == null : this$definitions.equals(other$definitions)) {
               Object this$biomes = this.biomes;
               Object other$biomes = other.biomes;
               return this$biomes == null ? other$biomes == null : this$biomes.equals(other$biomes);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BiomeDefinitionListPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $definitions = this.definitions;
      result = result * 59 + ($definitions == null ? 43 : $definitions.hashCode());
      Object $biomes = this.biomes;
      return result * 59 + ($biomes == null ? 43 : $biomes.hashCode());
   }

   @Override
   public String toString() {
      return "BiomeDefinitionListPacket(definitions=" + this.definitions + ", biomes=" + this.biomes + ")";
   }
}
