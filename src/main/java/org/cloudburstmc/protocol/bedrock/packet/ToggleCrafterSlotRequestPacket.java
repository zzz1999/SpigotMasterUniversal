package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.math.vector.Vector3i;
import org.cloudburstmc.protocol.common.PacketSignal;

public class ToggleCrafterSlotRequestPacket implements BedrockPacket {
   private Vector3i blockPosition;
   private byte slot;
   private boolean disabled;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.TOGGLE_CRAFTER_SLOT_REQUEST;
   }

   public ToggleCrafterSlotRequestPacket clone() {
      try {
         return (ToggleCrafterSlotRequestPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public Vector3i getBlockPosition() {
      return this.blockPosition;
   }

   public byte getSlot() {
      return this.slot;
   }

   public boolean isDisabled() {
      return this.disabled;
   }

   public void setBlockPosition(final Vector3i blockPosition) {
      this.blockPosition = blockPosition;
   }

   public void setSlot(final byte slot) {
      this.slot = slot;
   }

   public void setDisabled(final boolean disabled) {
      this.disabled = disabled;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ToggleCrafterSlotRequestPacket)) {
         return false;
      }

      ToggleCrafterSlotRequestPacket other = (ToggleCrafterSlotRequestPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.slot != other.slot) {
         return false;
      }

      if (this.disabled != other.disabled) {
         return false;
      }

      Object this$blockPosition = this.blockPosition;
      Object other$blockPosition = other.blockPosition;
      return this$blockPosition == null ? other$blockPosition == null : this$blockPosition.equals(other$blockPosition);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ToggleCrafterSlotRequestPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.slot;
      result = result * 59 + (this.disabled ? 79 : 97);
      Object $blockPosition = this.blockPosition;
      return result * 59 + ($blockPosition == null ? 43 : $blockPosition.hashCode());
   }

   @Override
   public String toString() {
      return "ToggleCrafterSlotRequestPacket(blockPosition=" + this.blockPosition + ", slot=" + this.slot + ", disabled=" + this.disabled + ")";
   }
}
