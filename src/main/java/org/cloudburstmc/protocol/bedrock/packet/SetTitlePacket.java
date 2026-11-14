package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class SetTitlePacket implements BedrockPacket {
   private SetTitlePacket.Type type;
   private CharSequence text;
   private int fadeInTime;
   private int stayTime;
   private int fadeOutTime;
   private String xuid;
   private String platformOnlineId;
   private CharSequence filteredTitleText = "";

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SET_TITLE;
   }

   public SetTitlePacket clone() {
      try {
         return (SetTitlePacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public String getText() {
      return this.getText(String.class);
   }

   public <T extends CharSequence> T getText(Class<T> type) {
      return type.cast(this.text);
   }

   public String getFilteredTitleText() {
      return this.getFilteredTitleText(String.class);
   }

   public <T extends CharSequence> T getFilteredTitleText(Class<T> type) {
      return type.cast(this.filteredTitleText);
   }

   public SetTitlePacket.Type getType() {
      return this.type;
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

   public void setType(final SetTitlePacket.Type type) {
      this.type = type;
   }

   public void setText(final CharSequence text) {
      this.text = text;
   }

   public void setFadeInTime(final int fadeInTime) {
      this.fadeInTime = fadeInTime;
   }

   public void setStayTime(final int stayTime) {
      this.stayTime = stayTime;
   }

   public void setFadeOutTime(final int fadeOutTime) {
      this.fadeOutTime = fadeOutTime;
   }

   public void setXuid(final String xuid) {
      this.xuid = xuid;
   }

   public void setPlatformOnlineId(final String platformOnlineId) {
      this.platformOnlineId = platformOnlineId;
   }

   public void setFilteredTitleText(final CharSequence filteredTitleText) {
      this.filteredTitleText = filteredTitleText;
   }

   @Override
   public boolean equals(final Object o) {
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
               if (this$platformOnlineId == null ? other$platformOnlineId == null : this$platformOnlineId.equals(other$platformOnlineId)) {
                  Object this$filteredTitleText = this.filteredTitleText;
                  Object other$filteredTitleText = other.filteredTitleText;
                  return this$filteredTitleText == null ? other$filteredTitleText == null : this$filteredTitleText.equals(other$filteredTitleText);
               } else {
                  return false;
               }
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

   protected boolean canEqual(final Object other) {
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
      result = result * 59 + ($platformOnlineId == null ? 43 : $platformOnlineId.hashCode());
      Object $filteredTitleText = this.filteredTitleText;
      return result * 59 + ($filteredTitleText == null ? 43 : $filteredTitleText.hashCode());
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
         + ", filteredTitleText="
         + this.filteredTitleText
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
