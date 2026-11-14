package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.map.MapPixel;
import com.nukkitx.protocol.common.PacketSignal;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;

public class MapInfoRequestPacket implements BedrockPacket {
   private long uniqueMapId;
   private final List<MapPixel> pixels = new ObjectArrayList<>();

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.MAP_INFO_REQUEST;
   }

   public long getUniqueMapId() {
      return this.uniqueMapId;
   }

   public List<MapPixel> getPixels() {
      return this.pixels;
   }

   public void setUniqueMapId(long uniqueMapId) {
      this.uniqueMapId = uniqueMapId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MapInfoRequestPacket)) {
         return false;
      }

      MapInfoRequestPacket other = (MapInfoRequestPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.uniqueMapId != other.uniqueMapId) {
         return false;
      }

      Object this$pixels = this.pixels;
      Object other$pixels = other.pixels;
      return this$pixels == null ? other$pixels == null : this$pixels.equals(other$pixels);
   }

   protected boolean canEqual(Object other) {
      return other instanceof MapInfoRequestPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $uniqueMapId = this.uniqueMapId;
      result = result * 59 + (int)($uniqueMapId >>> 32 ^ $uniqueMapId);
      Object $pixels = this.pixels;
      return result * 59 + ($pixels == null ? 43 : $pixels.hashCode());
   }

   @Override
   public String toString() {
      return "MapInfoRequestPacket(uniqueMapId=" + this.uniqueMapId + ", pixels=" + this.pixels + ")";
   }
}
