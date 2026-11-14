package com.neteasemc.protocol.netgame;

import com.neteasemc.protocol.netgame.subpacket.SubPacket;
import com.nukkitx.protocol.bedrock.annotation.NoEncryption;
import com.nukkitx.protocol.bedrock.packet.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.BedrockPacketHandler;
import com.nukkitx.protocol.bedrock.packet.BedrockPacketType;
import com.nukkitx.protocol.common.PacketSignal;

@NoEncryption
public class NetworkGamePacket implements BedrockPacket {
   SubPacket subPacket;

   public NetworkGamePacket() {
   }

   public NetworkGamePacket(SubPacket packet) {
      this.subPacket = packet;
   }

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.NETWORK_GAME_PACKET;
   }

   public SubPacket getSubPacket() {
      return this.subPacket;
   }

   public void setSubPacket(SubPacket subPacket) {
      this.subPacket = subPacket;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NetworkGamePacket)) {
         return false;
      }

      NetworkGamePacket other = (NetworkGamePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$subPacket = this.subPacket;
      Object other$subPacket = other.subPacket;
      return this$subPacket == null ? other$subPacket == null : this$subPacket.equals(other$subPacket);
   }

   protected boolean canEqual(Object other) {
      return other instanceof NetworkGamePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $subPacket = this.subPacket;
      return result * 59 + ($subPacket == null ? 43 : $subPacket.hashCode());
   }

   @Override
   public String toString() {
      return "NetworkGamePacket(subPacket=" + this.subPacket + ")";
   }
}
