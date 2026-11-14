package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;
import java.util.ArrayList;
import java.util.List;

public class SubClientLoginPacket implements BedrockPacket {
   private final List<String> chain = new ArrayList<>();
   private String extra;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SUB_CLIENT_LOGIN;
   }

   public List<String> getChain() {
      return this.chain;
   }

   public String getExtra() {
      return this.extra;
   }

   public void setExtra(String extra) {
      this.extra = extra;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SubClientLoginPacket)) {
         return false;
      } else {
         SubClientLoginPacket other = (SubClientLoginPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$chain = this.chain;
            Object other$chain = other.chain;
            if (this$chain == null ? other$chain == null : this$chain.equals(other$chain)) {
               Object this$extra = this.extra;
               Object other$extra = other.extra;
               return this$extra == null ? other$extra == null : this$extra.equals(other$extra);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof SubClientLoginPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $chain = this.chain;
      result = result * 59 + ($chain == null ? 43 : $chain.hashCode());
      Object $extra = this.extra;
      return result * 59 + ($extra == null ? 43 : $extra.hashCode());
   }

   @Override
   public String toString() {
      return "SubClientLoginPacket(chain=" + this.chain + ", extra=" + this.extra + ")";
   }
}
