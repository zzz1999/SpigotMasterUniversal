package com.neteasemc.protocol.netgame;

import com.nukkitx.protocol.bedrock.packet.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.BedrockPacketHandler;
import com.nukkitx.protocol.bedrock.packet.BedrockPacketType;
import com.nukkitx.protocol.common.PacketSignal;
import java.util.Arrays;

public class PyRpcPacket implements BedrockPacket {
   byte[] data;
   long msgId;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.PYRPC_PACKET;
   }

   public byte[] getData() {
      return this.data;
   }

   public long getMsgId() {
      return this.msgId;
   }

   public void setData(byte[] data) {
      this.data = data;
   }

   public void setMsgId(long msgId) {
      this.msgId = msgId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof PyRpcPacket)) {
         return false;
      } else {
         PyRpcPacket other = (PyRpcPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            return this.msgId != other.msgId ? false : Arrays.equals(this.data, other.data);
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof PyRpcPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $msgId = this.msgId;
      result = result * 59 + (int)($msgId >>> 32 ^ $msgId);
      return result * 59 + Arrays.hashCode(this.data);
   }

   @Override
   public String toString() {
      return "PyRpcPacket(data=" + Arrays.toString(this.data) + ", msgId=" + this.msgId + ")";
   }
}
