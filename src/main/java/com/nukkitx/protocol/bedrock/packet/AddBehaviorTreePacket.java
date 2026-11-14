package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class AddBehaviorTreePacket implements BedrockPacket {
   private String behaviorTreeJson;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.ADD_BEHAVIOR_TREE;
   }

   public String getBehaviorTreeJson() {
      return this.behaviorTreeJson;
   }

   public void setBehaviorTreeJson(String behaviorTreeJson) {
      this.behaviorTreeJson = behaviorTreeJson;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AddBehaviorTreePacket)) {
         return false;
      }

      AddBehaviorTreePacket other = (AddBehaviorTreePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$behaviorTreeJson = this.behaviorTreeJson;
      Object other$behaviorTreeJson = other.behaviorTreeJson;
      return this$behaviorTreeJson == null ? other$behaviorTreeJson == null : this$behaviorTreeJson.equals(other$behaviorTreeJson);
   }

   protected boolean canEqual(Object other) {
      return other instanceof AddBehaviorTreePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $behaviorTreeJson = this.behaviorTreeJson;
      return result * 59 + ($behaviorTreeJson == null ? 43 : $behaviorTreeJson.hashCode());
   }

   @Override
   public String toString() {
      return "AddBehaviorTreePacket(behaviorTreeJson=" + this.behaviorTreeJson + ")";
   }
}
