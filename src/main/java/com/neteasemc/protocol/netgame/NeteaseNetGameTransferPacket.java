package com.neteasemc.protocol.netgame;

import com.nukkitx.protocol.bedrock.packet.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.BedrockPacketHandler;
import com.nukkitx.protocol.bedrock.packet.BedrockPacketType;
import com.nukkitx.protocol.common.PacketSignal;

public class NeteaseNetGameTransferPacket implements BedrockPacket {
   private long userId;
   private BedrockPacket subPacket;

   public NeteaseNetGameTransferPacket() {
   }

   public NeteaseNetGameTransferPacket(long userId, BedrockPacket packet) {
      this.userId = userId;
      this.subPacket = packet;
   }

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.NE_NETGAME_TYPE;
   }

   public long getUserId() {
      return this.userId;
   }

   public BedrockPacket getSubPacket() {
      return this.subPacket;
   }

   public void setUserId(long userId) {
      this.userId = userId;
   }

   public void setSubPacket(BedrockPacket subPacket) {
      this.subPacket = subPacket;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NeteaseNetGameTransferPacket)) {
         return false;
      }

      NeteaseNetGameTransferPacket other = (NeteaseNetGameTransferPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.userId != other.userId) {
         return false;
      }

      Object this$subPacket = this.subPacket;
      Object other$subPacket = other.subPacket;
      return this$subPacket == null ? other$subPacket == null : this$subPacket.equals(other$subPacket);
   }

   protected boolean canEqual(Object other) {
      return other instanceof NeteaseNetGameTransferPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $userId = this.userId;
      result = result * 59 + (int)($userId >>> 32 ^ $userId);
      Object $subPacket = this.subPacket;
      return result * 59 + ($subPacket == null ? 43 : $subPacket.hashCode());
   }

   @Override
   public String toString() {
      return "NeteaseNetGameTransferPacket(userId=" + this.userId + ", subPacket=" + this.subPacket + ")";
   }
}
