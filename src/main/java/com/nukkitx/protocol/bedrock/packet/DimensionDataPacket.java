package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.definitions.DimensionDefinition;
import com.nukkitx.protocol.common.PacketSignal;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;

public class DimensionDataPacket implements BedrockPacket {
   private final List<DimensionDefinition> definitions = new ObjectArrayList<>();

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.DIMENSION_DATA;
   }

   public List<DimensionDefinition> getDefinitions() {
      return this.definitions;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DimensionDataPacket)) {
         return false;
      }

      DimensionDataPacket other = (DimensionDataPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$definitions = this.definitions;
      Object other$definitions = other.definitions;
      return this$definitions == null ? other$definitions == null : this$definitions.equals(other$definitions);
   }

   protected boolean canEqual(Object other) {
      return other instanceof DimensionDataPacket;
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
      return "DimensionDataPacket(definitions=" + this.definitions + ")";
   }
}
