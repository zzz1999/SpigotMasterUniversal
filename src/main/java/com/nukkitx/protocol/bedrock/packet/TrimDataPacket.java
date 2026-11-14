package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.TrimMaterial;
import com.nukkitx.protocol.bedrock.data.TrimPattern;
import com.nukkitx.protocol.common.PacketSignal;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;

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

   public List<TrimPattern> getPatterns() {
      return this.patterns;
   }

   public List<TrimMaterial> getMaterials() {
      return this.materials;
   }

   @Override
   public boolean equals(Object o) {
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

   protected boolean canEqual(Object other) {
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
