package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.math.vector.Vector3i;
import org.cloudburstmc.protocol.common.PacketSignal;

public class BlockPickRequestPacket implements BedrockPacket {
   private Vector3i blockPosition;
   private boolean addUserData;
   private int hotbarSlot;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.BLOCK_PICK_REQUEST;
   }

   public BlockPickRequestPacket clone() {
      try {
         return (BlockPickRequestPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public Vector3i getBlockPosition() {
      return this.blockPosition;
   }

   public boolean isAddUserData() {
      return this.addUserData;
   }

   public int getHotbarSlot() {
      return this.hotbarSlot;
   }

   public void setBlockPosition(final Vector3i blockPosition) {
      this.blockPosition = blockPosition;
   }

   public void setAddUserData(final boolean addUserData) {
      this.addUserData = addUserData;
   }

   public void setHotbarSlot(final int hotbarSlot) {
      this.hotbarSlot = hotbarSlot;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BlockPickRequestPacket)) {
         return false;
      }

      BlockPickRequestPacket other = (BlockPickRequestPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.addUserData != other.addUserData) {
         return false;
      }

      if (this.hotbarSlot != other.hotbarSlot) {
         return false;
      }

      Object this$blockPosition = this.blockPosition;
      Object other$blockPosition = other.blockPosition;
      return this$blockPosition == null ? other$blockPosition == null : this$blockPosition.equals(other$blockPosition);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BlockPickRequestPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.addUserData ? 79 : 97);
      result = result * 59 + this.hotbarSlot;
      Object $blockPosition = this.blockPosition;
      return result * 59 + ($blockPosition == null ? 43 : $blockPosition.hashCode());
   }

   @Override
   public String toString() {
      return "BlockPickRequestPacket(blockPosition=" + this.blockPosition + ", addUserData=" + this.addUserData + ", hotbarSlot=" + this.hotbarSlot + ")";
   }
}
