package com.neteasemc.protocol.custom.packet.geyserTransferPacket;

import com.neteasemc.protocol.custom.GeyserBasePacket;
import com.neteasemc.protocol.custom.GeyserBasePacketHandler;
import com.neteasemc.protocol.custom.GeyserPacketType;
import com.nukkitx.network.VarInts;
import com.nukkitx.protocol.common.PacketSignal;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import java.util.Arrays;
import org.bukkit.entity.Player;

public class GeyserTransferPacket extends GeyserBasePacket {
   byte[] transferData;

   public GeyserTransferPacket() {
   }

   public GeyserTransferPacket(int packetId, byte[] data) {
      int header = 0;
      header |= packetId & 1023;
      header |= 0;
      header |= 0;
      int dataLen = data.length;
      int payloadLen = dataLen + 4;
      ByteBuf buf = ByteBufAllocator.DEFAULT.heapBuffer(payloadLen);
      VarInts.writeUnsignedInt(buf, header);
      buf.writeBytes(data, 0, dataLen);
      int finalLen = buf.readableBytes();
      this.transferData = new byte[finalLen];
      buf.readBytes(this.transferData, 0, finalLen);
      buf.release();
   }

   @Override
   public GeyserPacketType getPacketType() {
      return GeyserPacketType.TRANSFER;
   }

   @Override
   public PacketSignal handle(GeyserBasePacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public PacketSignal handle(GeyserBasePacketHandler handler, Player player) {
      return handler.handle(this, player);
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof GeyserTransferPacket)) {
         return false;
      }

      GeyserTransferPacket other = (GeyserTransferPacket)o;
      return !other.canEqual(this) ? false : Arrays.equals(this.transferData, other.transferData);
   }

   @Override
   protected boolean canEqual(Object other) {
      return other instanceof GeyserTransferPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      return result * 59 + Arrays.hashCode(this.transferData);
   }

   @Override
   public String toString() {
      return "GeyserTransferPacket(transferData=" + Arrays.toString(this.getTransferData()) + ")";
   }

   public byte[] getTransferData() {
      return this.transferData;
   }

   public void setTransferData(byte[] transferData) {
      this.transferData = transferData;
   }
}
