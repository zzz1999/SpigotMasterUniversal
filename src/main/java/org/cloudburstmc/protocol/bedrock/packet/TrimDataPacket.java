package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.cloudburstmc.protocol.bedrock.data.TrimMaterial;
import org.cloudburstmc.protocol.bedrock.data.TrimPattern;
import org.cloudburstmc.protocol.common.PacketSignal;

public class TrimDataPacket implements BedrockPacket {
   private final List<TrimPattern> patterns = new ObjectArrayList<>();
   private final List<TrimMaterial> materials = new ObjectArrayList<>();

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.TRIM_DATA;
   }

   public TrimDataPacket clone() {
      try {
         return (TrimDataPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public List<TrimPattern> getPatterns() {
      return this.patterns;
   }

   public List<TrimMaterial> getMaterials() {
      return this.materials;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TrimDataPacket)) {
         return false;
      } else {
         TrimDataPacket other = (TrimDataPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$patterns = this.patterns;
            Object other$patterns = other.patterns;
            if (this$patterns == null ? other$patterns == null : this$patterns.equals(other$patterns)) {
               Object this$materials = this.materials;
               Object other$materials = other.materials;
               return this$materials == null ? other$materials == null : this$materials.equals(other$materials);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TrimDataPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $patterns = this.patterns;
      result = result * 59 + ($patterns == null ? 43 : $patterns.hashCode());
      Object $materials = this.materials;
      return result * 59 + ($materials == null ? 43 : $materials.hashCode());
   }

   @Override
   public String toString() {
      return "TrimDataPacket(patterns=" + this.patterns + ", materials=" + this.materials + ")";
   }
}
