package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.EmoteFlag;
import com.nukkitx.protocol.common.PacketSignal;
import java.util.EnumSet;
import java.util.Set;

public class EmotePacket implements BedrockPacket {
   private long runtimeEntityId;
   private String xuid;
   private String platformId;
   private String emoteId;
   private final Set<EmoteFlag> flags = EnumSet.noneOf(EmoteFlag.class);

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.EMOTE;
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public String getXuid() {
      return this.xuid;
   }

   public String getPlatformId() {
      return this.platformId;
   }

   public String getEmoteId() {
      return this.emoteId;
   }

   public Set<EmoteFlag> getFlags() {
      return this.flags;
   }

   public void setRuntimeEntityId(long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setXuid(String xuid) {
      this.xuid = xuid;
   }

   public void setPlatformId(String platformId) {
      this.platformId = platformId;
   }

   public void setEmoteId(String emoteId) {
      this.emoteId = emoteId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EmotePacket)) {
         return false;
      }

      EmotePacket other = (EmotePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.runtimeEntityId != other.runtimeEntityId) {
         return false;
      }

      Object this$xuid = this.xuid;
      Object other$xuid = other.xuid;
      if (this$xuid == null ? other$xuid == null : this$xuid.equals(other$xuid)) {
         Object this$platformId = this.platformId;
         Object other$platformId = other.platformId;
         if (this$platformId == null ? other$platformId == null : this$platformId.equals(other$platformId)) {
            Object this$emoteId = this.emoteId;
            Object other$emoteId = other.emoteId;
            if (this$emoteId == null ? other$emoteId == null : this$emoteId.equals(other$emoteId)) {
               Object this$flags = this.flags;
               Object other$flags = other.flags;
               return this$flags == null ? other$flags == null : this$flags.equals(other$flags);
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof EmotePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      Object $xuid = this.xuid;
      result = result * 59 + ($xuid == null ? 43 : $xuid.hashCode());
      Object $platformId = this.platformId;
      result = result * 59 + ($platformId == null ? 43 : $platformId.hashCode());
      Object $emoteId = this.emoteId;
      result = result * 59 + ($emoteId == null ? 43 : $emoteId.hashCode());
      Object $flags = this.flags;
      return result * 59 + ($flags == null ? 43 : $flags.hashCode());
   }

   @Override
   public String toString() {
      return "EmotePacket(runtimeEntityId="
         + this.runtimeEntityId
         + ", xuid="
         + this.xuid
         + ", platformId="
         + this.platformId
         + ", emoteId="
         + this.emoteId
         + ", flags="
         + this.flags
         + ")";
   }
}
