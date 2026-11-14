package com.neteasemc.protocol.netgame.subpacket;

import com.nukkitx.protocol.bedrock.codec.BedrockCodecHelper;
import com.nukkitx.protocol.common.PacketSignal;
import io.netty.buffer.ByteBuf;

public class PingServerRequestSubPacket implements SubPacket {
   @Override
   public void doWrite(ByteBuf buffer, BedrockCodecHelper helper) {
   }

   @Override
   public void doRead(ByteBuf buffer, BedrockCodecHelper helper) {
   }

   @Override
   public int getNetgamePacketId() {
      return 9;
   }

   @Override
   public PacketSignal handle(SubPacketHandler handler) {
      return handler.handle(this);
   }
}
