package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;
import org.cloudburstmc.math.vector.Vector3i;

@Deprecated
public class ItemFrameDropItemPacket implements BedrockPacket {
   private Vector3i blockPosition;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.ITEM_FRAME_DROP_ITEM;
   }

   public Vector3i getBlockPosition() {
      return this.blockPosition;
   }

   public void setBlockPosition(Vector3i blockPosition) {
      this.blockPosition = blockPosition;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ItemFrameDropItemPacket)) {
         return false;
      }

      ItemFrameDropItemPacket other = (ItemFrameDropItemPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$blockPosition = this.blockPosition;
      Object other$blockPosition = other.blockPosition;
      return this$blockPosition == null ? other$blockPosition == null : this$blockPosition.equals(other$blockPosition);
   }

   protected boolean canEqual(Object other) {
      return other instanceof ItemFrameDropItemPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $blockPosition = this.blockPosition;
      return result * 59 + ($blockPosition == null ? 43 : $blockPosition.hashCode());
   }

   @Override
   public String toString() {
      return "ItemFrameDropItemPacket(blockPosition=" + this.blockPosition + ")";
   }
}
