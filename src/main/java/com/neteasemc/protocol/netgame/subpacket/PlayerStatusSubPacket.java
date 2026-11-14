package com.neteasemc.protocol.netgame.subpacket;

import com.nukkitx.protocol.bedrock.codec.BedrockCodecHelper;
import com.nukkitx.protocol.common.PacketSignal;
import io.netty.buffer.ByteBuf;

public class PlayerStatusSubPacket implements SubPacket {
   long mNeteaseId;
   PlayerStatusSubPacket.NeteaseNetGamePlayerStatus mStatus;
   String mMessage;
   int mRequestId;

   public PlayerStatusSubPacket() {
   }

   public PlayerStatusSubPacket(long neteaseId, PlayerStatusSubPacket.NeteaseNetGamePlayerStatus status, String message) {
      this.mNeteaseId = neteaseId;
      this.mStatus = status;
      this.mMessage = message;
   }

   @Override
   public int getNetgamePacketId() {
      return 5;
   }

   @Override
   public void doWrite(ByteBuf buffer, BedrockCodecHelper helper) {
      buffer.writeIntLE((int)this.mNeteaseId);
      buffer.writeByte(this.mStatus.ordinal());
      helper.writeString(buffer, this.mMessage);
      buffer.writeIntLE(this.mRequestId);
   }

   @Override
   public void doRead(ByteBuf buffer, BedrockCodecHelper helper) {
      this.mNeteaseId = buffer.readUnsignedIntLE();
      this.mStatus = PlayerStatusSubPacket.NeteaseNetGamePlayerStatus.values()[buffer.readByte()];
      this.mMessage = helper.readString(buffer);
      this.mRequestId = buffer.readIntLE();
   }

   @Override
   public PacketSignal handle(SubPacketHandler handler) {
      return handler.handle(this);
   }

   public String getMMessage() {
      return this.mMessage;
   }

   public int getMRequestId() {
      return this.mRequestId;
   }

   public void setMMessage(String mMessage) {
      this.mMessage = mMessage;
   }

   public void setMRequestId(int mRequestId) {
      this.mRequestId = mRequestId;
   }

   @Override
   public String toString() {
      return "PlayerStatusSubPacket(mNeteaseId="
         + this.getMNeteaseId()
         + ", mStatus="
         + this.getMStatus()
         + ", mMessage="
         + this.getMMessage()
         + ", mRequestId="
         + this.getMRequestId()
         + ")";
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof PlayerStatusSubPacket)) {
         return false;
      } else {
         PlayerStatusSubPacket other = (PlayerStatusSubPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.mNeteaseId != other.mNeteaseId) {
            return false;
         } else if (this.mRequestId != other.mRequestId) {
            return false;
         } else {
            Object this$mStatus = this.mStatus;
            Object other$mStatus = other.mStatus;
            if (this$mStatus == null ? other$mStatus == null : this$mStatus.equals(other$mStatus)) {
               Object this$mMessage = this.mMessage;
               Object other$mMessage = other.mMessage;
               return this$mMessage == null ? other$mMessage == null : this$mMessage.equals(other$mMessage);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof PlayerStatusSubPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $mNeteaseId = this.mNeteaseId;
      result = result * 59 + (int)($mNeteaseId >>> 32 ^ $mNeteaseId);
      result = result * 59 + this.mRequestId;
      Object $mStatus = this.mStatus;
      result = result * 59 + ($mStatus == null ? 43 : $mStatus.hashCode());
      Object $mMessage = this.mMessage;
      return result * 59 + ($mMessage == null ? 43 : $mMessage.hashCode());
   }

   public long getMNeteaseId() {
      return this.mNeteaseId;
   }

   public void setMNeteaseId(long mNeteaseId) {
      this.mNeteaseId = mNeteaseId;
   }

   public PlayerStatusSubPacket.NeteaseNetGamePlayerStatus getMStatus() {
      return this.mStatus;
   }

   public void setMStatus(PlayerStatusSubPacket.NeteaseNetGamePlayerStatus mStatus) {
      this.mStatus = mStatus;
   }

   public enum NeteaseNetGamePlayerStatus {
      None,
      LoginSuccess,
      NoAvailableLobby,
      TransferSuccess,
      LoginRecSuccess,
      LoginRecFail,
      NoAvailableProxy,
      ServerClosing,
      CustomMessage;
   }
}
