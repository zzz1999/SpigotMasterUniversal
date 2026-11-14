package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;
import org.cloudburstmc.math.vector.Vector3i;

public class BlockEventPacket implements BedrockPacket {
   private Vector3i blockPosition;
   private int eventType;
   private int eventData;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.BLOCK_EVENT;
   }

   public Vector3i getBlockPosition() {
      return this.blockPosition;
   }

   public int getEventType() {
      return this.eventType;
   }

   public int getEventData() {
      return this.eventData;
   }

   public void setBlockPosition(Vector3i blockPosition) {
      this.blockPosition = blockPosition;
   }

   public void setEventType(int eventType) {
      this.eventType = eventType;
   }

   public void setEventData(int eventData) {
      this.eventData = eventData;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BlockEventPacket)) {
         return false;
      }

      BlockEventPacket other = (BlockEventPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.eventType != other.eventType) {
         return false;
      }

      if (this.eventData != other.eventData) {
         return false;
      }

      Object this$blockPosition = this.blockPosition;
      Object other$blockPosition = other.blockPosition;
      return this$blockPosition == null ? other$blockPosition == null : this$blockPosition.equals(other$blockPosition);
   }

   protected boolean canEqual(Object other) {
      return other instanceof BlockEventPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.eventType;
      result = result * 59 + this.eventData;
      Object $blockPosition = this.blockPosition;
      return result * 59 + ($blockPosition == null ? 43 : $blockPosition.hashCode());
   }

   @Override
   public String toString() {
      return "BlockEventPacket(blockPosition=" + this.blockPosition + ", eventType=" + this.eventType + ", eventData=" + this.eventData + ")";
   }
}
