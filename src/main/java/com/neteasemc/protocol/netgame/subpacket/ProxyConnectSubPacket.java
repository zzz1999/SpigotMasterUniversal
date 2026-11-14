package com.neteasemc.protocol.netgame.subpacket;

import com.nukkitx.protocol.bedrock.codec.BedrockCodecHelper;
import com.nukkitx.protocol.common.PacketSignal;
import io.netty.buffer.ByteBuf;

public class ProxyConnectSubPacket implements SubPacket {
   private int mProxyId;
   private int mApolloId;
   private String mApolloKey;

   @Override
   public void doWrite(ByteBuf buffer, BedrockCodecHelper helper) {
      buffer.writeIntLE(this.mProxyId);
      buffer.writeIntLE(this.mApolloId);
      helper.writeString(buffer, this.mApolloKey);
   }

   @Override
   public void doRead(ByteBuf buffer, BedrockCodecHelper helper) {
      this.mProxyId = buffer.readIntLE();
      this.mApolloId = buffer.readIntLE();
      this.mApolloKey = helper.readString(buffer);
   }

   public int getProxyId() {
      return this.mProxyId;
   }

   public int getApolloId() {
      return this.mApolloId;
   }

   public String getApolloKey() {
      return this.mApolloKey;
   }

   @Override
   public int getNetgamePacketId() {
      return 7;
   }

   @Override
   public PacketSignal handle(SubPacketHandler handler) {
      return handler.handle(this);
   }
}
