package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class SetTitlePacket implements BedrockPacket {
   private SetTitlePacket.Type type;
   private String text;
   private int fadeInTime;
   private int stayTime;
   private int fadeOutTime;
   private String xuid;
   private String platformOnlineId;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SET_TITLE;
   }

   public SetTitlePacket.Type getType() {
      return this.type;
   }

   public String getText() {
      return this.text;
   }

   public int getFadeInTime() {
      return this.fadeInTime;
   }

   public int getStayTime() {
      return this.stayTime;
   }

   public int getFadeOutTime() {
      return this.fadeOutTime;
   }

   public String getXuid() {
      return this.xuid;
   }

   public String getPlatformOnlineId() {
      return this.platformOnlineId;
   }

   public void setType(SetTitlePacket.Type type) {
      this.type = type;
   }

   public void setText(String text) {
      this.text = text;
   }

   public void setFadeInTime(int fadeInTime) {
      this.fadeInTime = fadeInTime;
   }

   public void setStayTime(int stayTime) {
      this.stayTime = stayTime;
   }

   public void setFadeOutTime(int fadeOutTime) {
      this.fadeOutTime = fadeOutTime;
   }

   public void setXuid(String xuid) {
      this.xuid = xuid;
   }

   public void setPlatformOnlineId(String platformOnlineId) {
      this.platformOnlineId = platformOnlineId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SetTitlePacket)) {
         return false;
      }

      SetTitlePacket other = (SetTitlePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.fadeInTime != other.fadeInTime) {
         return false;
      }

      if (this.stayTime != other.stayTime) {
         return false;
      }

      if (this.fadeOutTime != other.fadeOutTime) {
         return false;
      }

      Object this$type = this.type;
      Object other$type = other.type;
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$text = this.text;
         Object other$text = other.text;
         if (this$text == null ? other$text == null : this$text.equals(other$text)) {
            Object this$xuid = this.xuid;
            Object other$xuid = other.xuid;
            if (this$xuid == null ? other$xuid == null : this$xuid.equals(other$xuid)) {
               Object this$platformOnlineId = this.platformOnlineId;
               Object other$platformOnlineId = other.platformOnlineId;
               return this$platformOnlineId == null ? other$platformOnlineId == null : this$platformOnlineId.equals(other$platformOnlineId);
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
      return other instanceof SetTitlePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.fadeInTime;
      result = result * 59 + this.stayTime;
      result = result * 59 + this.fadeOutTime;
      Object $type = this.type;
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $text = this.text;
      result = result * 59 + ($text == null ? 43 : $text.hashCode());
      Object $xuid = this.xuid;
      result = result * 59 + ($xuid == null ? 43 : $xuid.hashCode());
      Object $platformOnlineId = this.platformOnlineId;
      return result * 59 + ($platformOnlineId == null ? 43 : $platformOnlineId.hashCode());
   }

   @Override
   public String toString() {
      return "SetTitlePacket(type="
         + this.type
         + ", text="
         + this.text
         + ", fadeInTime="
         + this.fadeInTime
         + ", stayTime="
         + this.stayTime
         + ", fadeOutTime="
         + this.fadeOutTime
         + ", xuid="
         + this.xuid
         + ", platformOnlineId="
         + this.platformOnlineId
         + ")";
   }

   public enum Type {
      CLEAR,
      RESET,
      TITLE,
      SUBTITLE,
      ACTIONBAR,
      TIMES,
      TITLE_JSON,
      SUBTITLE_JSON,
      ACTIONBAR_JSON;
   }
}
