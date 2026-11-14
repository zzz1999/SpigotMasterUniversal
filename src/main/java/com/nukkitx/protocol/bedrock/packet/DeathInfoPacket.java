package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;

public class DeathInfoPacket implements BedrockPacket {
   private String causeAttackName;
   private final List<String> messageList = new ObjectArrayList<>();

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.DEATH_INFO;
   }

   public String getCauseAttackName() {
      return this.causeAttackName;
   }

   public List<String> getMessageList() {
      return this.messageList;
   }

   public void setCauseAttackName(String causeAttackName) {
      this.causeAttackName = causeAttackName;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof DeathInfoPacket)) {
         return false;
      } else {
         DeathInfoPacket other = (DeathInfoPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$causeAttackName = this.causeAttackName;
            Object other$causeAttackName = other.causeAttackName;
            if (this$causeAttackName == null ? other$causeAttackName == null : this$causeAttackName.equals(other$causeAttackName)) {
               Object this$messageList = this.messageList;
               Object other$messageList = other.messageList;
               return this$messageList == null ? other$messageList == null : this$messageList.equals(other$messageList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof DeathInfoPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $causeAttackName = this.causeAttackName;
      result = result * 59 + ($causeAttackName == null ? 43 : $causeAttackName.hashCode());
      Object $messageList = this.messageList;
      return result * 59 + ($messageList == null ? 43 : $messageList.hashCode());
   }

   @Override
   public String toString() {
      return "DeathInfoPacket(causeAttackName=" + this.causeAttackName + ", messageList=" + this.messageList + ")";
   }
}
