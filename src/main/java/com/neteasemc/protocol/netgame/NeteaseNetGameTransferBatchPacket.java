package com.neteasemc.protocol.netgame;

import com.neteasemc.protocol.custom.packet.geyserTransferPacket.GeyserTransferPacket;
import com.nukkitx.protocol.bedrock.packet.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.BedrockPacketHandler;
import com.nukkitx.protocol.bedrock.packet.BedrockPacketType;
import com.nukkitx.protocol.common.PacketSignal;
import java.util.ArrayList;

public class NeteaseNetGameTransferBatchPacket implements BedrockPacket {
   private ArrayList<Long> userIds;
   private ArrayList<BedrockPacket> packets;
   private ArrayList<GeyserTransferPacket> transferPackets;

   public NeteaseNetGameTransferBatchPacket() {
   }

   public NeteaseNetGameTransferBatchPacket(ArrayList<Long> userIds, ArrayList<BedrockPacket> packets) {
      this.userIds = userIds;
      this.packets = packets;
   }

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.NE_NETGAME_TYPE;
   }

   public ArrayList<Long> getUserIds() {
      return this.userIds;
   }

   public ArrayList<BedrockPacket> getPackets() {
      return this.packets;
   }

   public ArrayList<GeyserTransferPacket> getTransferPackets() {
      return this.transferPackets;
   }

   public void setUserIds(ArrayList<Long> userIds) {
      this.userIds = userIds;
   }

   public void setPackets(ArrayList<BedrockPacket> packets) {
      this.packets = packets;
   }

   public void setTransferPackets(ArrayList<GeyserTransferPacket> transferPackets) {
      this.transferPackets = transferPackets;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NeteaseNetGameTransferBatchPacket)) {
         return false;
      }

      NeteaseNetGameTransferBatchPacket other = (NeteaseNetGameTransferBatchPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$userIds = this.userIds;
      Object other$userIds = other.userIds;
      if (this$userIds == null ? other$userIds == null : this$userIds.equals(other$userIds)) {
         Object this$packets = this.packets;
         Object other$packets = other.packets;
         if (this$packets == null ? other$packets == null : this$packets.equals(other$packets)) {
            Object this$transferPackets = this.transferPackets;
            Object other$transferPackets = other.transferPackets;
            return this$transferPackets == null ? other$transferPackets == null : this$transferPackets.equals(other$transferPackets);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof NeteaseNetGameTransferBatchPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userIds = this.userIds;
      result = result * 59 + ($userIds == null ? 43 : $userIds.hashCode());
      Object $packets = this.packets;
      result = result * 59 + ($packets == null ? 43 : $packets.hashCode());
      Object $transferPackets = this.transferPackets;
      return result * 59 + ($transferPackets == null ? 43 : $transferPackets.hashCode());
   }

   @Override
   public String toString() {
      return "NeteaseNetGameTransferBatchPacket(userIds=" + this.userIds + ", packets=" + this.packets + ", transferPackets=" + this.transferPackets + ")";
   }
}
