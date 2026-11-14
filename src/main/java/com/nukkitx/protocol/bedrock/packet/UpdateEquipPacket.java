package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;
import org.cloudburstmc.nbt.NbtMap;

public class UpdateEquipPacket implements BedrockPacket {
   private short windowId;
   private short windowType;
   private int size;
   private long uniqueEntityId;
   private NbtMap tag;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.UPDATE_EQUIP;
   }

   public short getWindowId() {
      return this.windowId;
   }

   public short getWindowType() {
      return this.windowType;
   }

   public int getSize() {
      return this.size;
   }

   public long getUniqueEntityId() {
      return this.uniqueEntityId;
   }

   public NbtMap getTag() {
      return this.tag;
   }

   public void setWindowId(short windowId) {
      this.windowId = windowId;
   }

   public void setWindowType(short windowType) {
      this.windowType = windowType;
   }

   public void setSize(int size) {
      this.size = size;
   }

   public void setUniqueEntityId(long uniqueEntityId) {
      this.uniqueEntityId = uniqueEntityId;
   }

   public void setTag(NbtMap tag) {
      this.tag = tag;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UpdateEquipPacket)) {
         return false;
      }

      UpdateEquipPacket other = (UpdateEquipPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.windowId != other.windowId) {
         return false;
      }

      if (this.windowType != other.windowType) {
         return false;
      }

      if (this.size != other.size) {
         return false;
      }

      if (this.uniqueEntityId != other.uniqueEntityId) {
         return false;
      }

      Object this$tag = this.tag;
      Object other$tag = other.tag;
      return this$tag == null ? other$tag == null : this$tag.equals(other$tag);
   }

   protected boolean canEqual(Object other) {
      return other instanceof UpdateEquipPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.windowId;
      result = result * 59 + this.windowType;
      result = result * 59 + this.size;
      long $uniqueEntityId = this.uniqueEntityId;
      result = result * 59 + (int)($uniqueEntityId >>> 32 ^ $uniqueEntityId);
      Object $tag = this.tag;
      return result * 59 + ($tag == null ? 43 : $tag.hashCode());
   }

   @Override
   public String toString() {
      return "UpdateEquipPacket(windowId="
         + this.windowId
         + ", windowType="
         + this.windowType
         + ", size="
         + this.size
         + ", uniqueEntityId="
         + this.uniqueEntityId
         + ", tag="
         + this.tag
         + ")";
   }
}
