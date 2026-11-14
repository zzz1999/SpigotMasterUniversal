package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class DebugInfoPacket implements BedrockPacket {
   private long uniqueEntityId;
   private String data;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.DEBUG_INFO;
   }

   public long getUniqueEntityId() {
      return this.uniqueEntityId;
   }

   public String getData() {
      return this.data;
   }

   public void setUniqueEntityId(long uniqueEntityId) {
      this.uniqueEntityId = uniqueEntityId;
   }

   public void setData(String data) {
      this.data = data;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DebugInfoPacket)) {
         return false;
      }

      DebugInfoPacket other = (DebugInfoPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.uniqueEntityId != other.uniqueEntityId) {
         return false;
      }

      Object this$data = this.data;
      Object other$data = other.data;
      return this$data == null ? other$data == null : this$data.equals(other$data);
   }

   protected boolean canEqual(Object other) {
      return other instanceof DebugInfoPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $uniqueEntityId = this.uniqueEntityId;
      result = result * 59 + (int)($uniqueEntityId >>> 32 ^ $uniqueEntityId);
      Object $data = this.data;
      return result * 59 + ($data == null ? 43 : $data.hashCode());
   }

   @Override
   public String toString() {
      return "DebugInfoPacket(uniqueEntityId=" + this.uniqueEntityId + ", data=" + this.data + ")";
   }
}
