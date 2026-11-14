package com.neteasemc.protocol.netgame.subpacket;

import com.nukkitx.network.VarInts;
import com.nukkitx.protocol.bedrock.codec.BedrockCodecHelper;
import com.nukkitx.protocol.common.PacketSignal;
import io.netty.buffer.ByteBuf;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ReplyStatusSubPacket implements SubPacket {
   ReplyStatusSubPacket.ServerReplyStatus status;
   long version = 0L;
   int networkProtocolVersion = 0;
   Map<String, String> modVersionMap = new HashMap<>();

   @Override
   public int getNetgamePacketId() {
      return 2;
   }

   @Override
   public void doWrite(ByteBuf buffer, BedrockCodecHelper helper) {
      buffer.writeByte(this.status.ordinal());
      buffer.writeIntLE((int)this.version);
      buffer.writeIntLE(this.networkProtocolVersion);
      VarInts.writeUnsignedInt(buffer, this.modVersionMap.size());

      for (Entry<String, String> entry : this.modVersionMap.entrySet()) {
         helper.writeString(buffer, entry.getKey());
         helper.writeString(buffer, entry.getValue());
      }
   }

   @Override
   public void doRead(ByteBuf buffer, BedrockCodecHelper helper) {
      this.status = ReplyStatusSubPacket.ServerReplyStatus.values()[buffer.readByte()];
      this.version = buffer.readUnsignedInt();
      this.networkProtocolVersion = buffer.readIntLE();
      int size = VarInts.readUnsignedInt(buffer);

      for (int i = 0; i < size; i++) {
         this.modVersionMap.put(helper.readString(buffer), helper.readString(buffer));
      }
   }

   @Override
   public PacketSignal handle(SubPacketHandler handler) {
      return handler.handle(this);
   }

   public int getNetworkProtocolVersion() {
      return this.networkProtocolVersion;
   }

   public Map<String, String> getModVersionMap() {
      return this.modVersionMap;
   }

   public void setNetworkProtocolVersion(int networkProtocolVersion) {
      this.networkProtocolVersion = networkProtocolVersion;
   }

   public void setModVersionMap(Map<String, String> modVersionMap) {
      this.modVersionMap = modVersionMap;
   }

   @Override
   public String toString() {
      return "ReplyStatusSubPacket(status="
         + this.getStatus()
         + ", version="
         + this.getVersion()
         + ", networkProtocolVersion="
         + this.getNetworkProtocolVersion()
         + ", modVersionMap="
         + this.getModVersionMap()
         + ")";
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ReplyStatusSubPacket)) {
         return false;
      } else {
         ReplyStatusSubPacket other = (ReplyStatusSubPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.version != other.version) {
            return false;
         } else if (this.networkProtocolVersion != other.networkProtocolVersion) {
            return false;
         } else {
            Object this$status = this.status;
            Object other$status = other.status;
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
               Object this$modVersionMap = this.modVersionMap;
               Object other$modVersionMap = other.modVersionMap;
               return this$modVersionMap == null ? other$modVersionMap == null : this$modVersionMap.equals(other$modVersionMap);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof ReplyStatusSubPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $version = this.version;
      result = result * 59 + (int)($version >>> 32 ^ $version);
      result = result * 59 + this.networkProtocolVersion;
      Object $status = this.status;
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $modVersionMap = this.modVersionMap;
      return result * 59 + ($modVersionMap == null ? 43 : $modVersionMap.hashCode());
   }

   public ReplyStatusSubPacket.ServerReplyStatus getStatus() {
      return this.status;
   }

   public void setStatus(ReplyStatusSubPacket.ServerReplyStatus status) {
      this.status = status;
   }

   public long getVersion() {
      return this.version;
   }

   public void setVersion(long version) {
      this.version = version;
   }

   public enum ServerReplyStatus {
      None,
      Normal,
      Abnormal;
   }
}
