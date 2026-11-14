package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.cloudburstmc.protocol.bedrock.data.definitions.DimensionDefinition;
import org.cloudburstmc.protocol.common.PacketSignal;

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

   public DimensionDataPacket clone() {
      try {
         return (DimensionDataPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public List<DimensionDefinition> getDefinitions() {
      return this.definitions;
   }

   @Override
   public boolean equals(final Object o) {
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

   protected boolean canEqual(final Object other) {
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
