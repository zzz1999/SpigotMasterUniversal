package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;
import org.cloudburstmc.math.vector.Vector3i;
import org.cloudburstmc.nbt.NbtMap;

public class BlockEntityDataPacket implements BedrockPacket {
   private Vector3i blockPosition;
   private NbtMap data;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.BLOCK_ENTITY_DATA;
   }

   public Vector3i getBlockPosition() {
      return this.blockPosition;
   }

   public NbtMap getData() {
      return this.data;
   }

   public void setBlockPosition(Vector3i blockPosition) {
      this.blockPosition = blockPosition;
   }

   public void setData(NbtMap data) {
      this.data = data;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof BlockEntityDataPacket)) {
         return false;
      } else {
         BlockEntityDataPacket other = (BlockEntityDataPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$blockPosition = this.blockPosition;
            Object other$blockPosition = other.blockPosition;
            if (this$blockPosition == null ? other$blockPosition == null : this$blockPosition.equals(other$blockPosition)) {
               Object this$data = this.data;
               Object other$data = other.data;
               return this$data == null ? other$data == null : this$data.equals(other$data);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof BlockEntityDataPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $blockPosition = this.blockPosition;
      result = result * 59 + ($blockPosition == null ? 43 : $blockPosition.hashCode());
      Object $data = this.data;
      return result * 59 + ($data == null ? 43 : $data.hashCode());
   }

   @Override
   public String toString() {
      return "BlockEntityDataPacket(blockPosition=" + this.blockPosition + ", data=" + this.data + ")";
   }
}
