package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.inventory.ItemData;
import com.nukkitx.protocol.common.PacketSignal;
import java.util.Arrays;

public class CreativeContentPacket implements BedrockPacket {
   private ItemData[] contents;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CREATIVE_CONTENT;
   }

   public ItemData[] getContents() {
      return this.contents;
   }

   public void setContents(ItemData[] contents) {
      this.contents = contents;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CreativeContentPacket)) {
         return false;
      }

      CreativeContentPacket other = (CreativeContentPacket)o;
      return !other.canEqual(this) ? false : Arrays.deepEquals(this.contents, other.contents);
   }

   protected boolean canEqual(Object other) {
      return other instanceof CreativeContentPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      return result * 59 + Arrays.deepHashCode(this.contents);
   }

   @Override
   public String toString() {
      return "CreativeContentPacket(contents=" + Arrays.deepToString(this.contents) + ")";
   }
}
