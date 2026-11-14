package com.neteasemc.protocol.netgame.subpacket;

import com.nukkitx.protocol.bedrock.codec.BedrockCodecHelper;
import com.nukkitx.protocol.common.PacketSignal;
import io.netty.buffer.ByteBuf;

public class MasterCommandSubPacket implements SubPacket {
   private int uniqueId;
   private boolean needReturn;
   private String command;
   private int typeOrChangedId;

   @Override
   public int getNetgamePacketId() {
      return 13;
   }

   @Override
   public void doWrite(ByteBuf buffer, BedrockCodecHelper helper) {
      buffer.writeIntLE(this.uniqueId);
      buffer.writeBoolean(this.needReturn);
      helper.writeString(buffer, this.command);
      buffer.writeIntLE(this.typeOrChangedId);
   }

   @Override
   public void doRead(ByteBuf buffer, BedrockCodecHelper helper) {
      this.uniqueId = buffer.readIntLE();
      this.needReturn = buffer.readBoolean();
      this.command = helper.readString(buffer);
      this.typeOrChangedId = buffer.readIntLE();
   }

   @Override
   public PacketSignal handle(SubPacketHandler handler) {
      return handler.handle(this);
   }

   public int getUniqueId() {
      return this.uniqueId;
   }

   public boolean isNeedReturn() {
      return this.needReturn;
   }

   public String getCommand() {
      return this.command;
   }

   public int getTypeOrChangedId() {
      return this.typeOrChangedId;
   }

   public void setUniqueId(int uniqueId) {
      this.uniqueId = uniqueId;
   }

   public void setNeedReturn(boolean needReturn) {
      this.needReturn = needReturn;
   }

   public void setCommand(String command) {
      this.command = command;
   }

   public void setTypeOrChangedId(int typeOrChangedId) {
      this.typeOrChangedId = typeOrChangedId;
   }

   @Override
   public String toString() {
      return "MasterCommandSubPacket(uniqueId="
         + this.getUniqueId()
         + ", needReturn="
         + this.isNeedReturn()
         + ", command="
         + this.getCommand()
         + ", typeOrChangedId="
         + this.getTypeOrChangedId()
         + ")";
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MasterCommandSubPacket)) {
         return false;
      }

      MasterCommandSubPacket other = (MasterCommandSubPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.uniqueId != other.uniqueId) {
         return false;
      }

      if (this.needReturn != other.needReturn) {
         return false;
      }

      if (this.typeOrChangedId != other.typeOrChangedId) {
         return false;
      }

      Object this$command = this.command;
      Object other$command = other.command;
      return this$command == null ? other$command == null : this$command.equals(other$command);
   }

   protected boolean canEqual(Object other) {
      return other instanceof MasterCommandSubPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.uniqueId;
      result = result * 59 + (this.needReturn ? 79 : 97);
      result = result * 59 + this.typeOrChangedId;
      Object $command = this.command;
      return result * 59 + ($command == null ? 43 : $command.hashCode());
   }
}
