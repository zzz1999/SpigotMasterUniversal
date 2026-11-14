package com.nukkitx.protocol.bedrock.data.map;

public final class MapPixel {
   private final int pixel;
   private final int index;

   public MapPixel(int pixel, int index) {
      this.pixel = pixel;
      this.index = index;
   }

   public int getPixel() {
      return this.pixel;
   }

   public int getIndex() {
      return this.index;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MapPixel)) {
         return false;
      }

      MapPixel other = (MapPixel)o;
      return this.getPixel() != other.getPixel() ? false : this.getIndex() == other.getIndex();
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getPixel();
      return result * 59 + this.getIndex();
   }

   @Override
   public String toString() {
      return "MapPixel(pixel=" + this.getPixel() + ", index=" + this.getIndex() + ")";
   }
}
