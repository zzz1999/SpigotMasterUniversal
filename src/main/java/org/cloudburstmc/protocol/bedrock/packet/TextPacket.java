package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.cloudburstmc.protocol.common.PacketSignal;

public class TextPacket implements BedrockPacket {
   private TextPacket.Type type;
   private String sourceName;
   private CharSequence message;
   private List<String> parameters = new ObjectArrayList<>();
   private boolean needsTranslation;
   private String xuid;
   private String platformChatId = "";
   private CharSequence filteredMessage = "";

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.TEXT;
   }

   public TextPacket clone() {
      try {
         return (TextPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public String getMessage() {
      return this.getMessage(String.class);
   }

   public <T extends CharSequence> T getMessage(Class<T> type) {
      return type.cast(this.message);
   }

   public String getFilteredMessage() {
      return this.getFilteredMessage(String.class);
   }

   public <T extends CharSequence> T getFilteredMessage(Class<T> type) {
      return type.cast(this.filteredMessage);
   }

   public TextPacket.Type getType() {
      return this.type;
   }

   public String getSourceName() {
      return this.sourceName;
   }

   public List<String> getParameters() {
      return this.parameters;
   }

   public boolean isNeedsTranslation() {
      return this.needsTranslation;
   }

   public String getXuid() {
      return this.xuid;
   }

   public String getPlatformChatId() {
      return this.platformChatId;
   }

   public void setType(final TextPacket.Type type) {
      this.type = type;
   }

   public void setSourceName(final String sourceName) {
      this.sourceName = sourceName;
   }

   public void setMessage(final CharSequence message) {
      this.message = message;
   }

   public void setParameters(final List<String> parameters) {
      this.parameters = parameters;
   }

   public void setNeedsTranslation(final boolean needsTranslation) {
      this.needsTranslation = needsTranslation;
   }

   public void setXuid(final String xuid) {
      this.xuid = xuid;
   }

   public void setPlatformChatId(final String platformChatId) {
      this.platformChatId = platformChatId;
   }

   public void setFilteredMessage(final CharSequence filteredMessage) {
      this.filteredMessage = filteredMessage;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TextPacket)) {
         return false;
      }

      TextPacket other = (TextPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.needsTranslation != other.needsTranslation) {
         return false;
      }

      Object this$type = this.type;
      Object other$type = other.type;
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$sourceName = this.sourceName;
         Object other$sourceName = other.sourceName;
         if (this$sourceName == null ? other$sourceName == null : this$sourceName.equals(other$sourceName)) {
            Object this$message = this.message;
            Object other$message = other.message;
            if (this$message == null ? other$message == null : this$message.equals(other$message)) {
               Object this$parameters = this.parameters;
               Object other$parameters = other.parameters;
               if (this$parameters == null ? other$parameters == null : this$parameters.equals(other$parameters)) {
                  Object this$xuid = this.xuid;
                  Object other$xuid = other.xuid;
                  if (this$xuid == null ? other$xuid == null : this$xuid.equals(other$xuid)) {
                     Object this$platformChatId = this.platformChatId;
                     Object other$platformChatId = other.platformChatId;
                     if (this$platformChatId == null ? other$platformChatId == null : this$platformChatId.equals(other$platformChatId)) {
                        Object this$filteredMessage = this.filteredMessage;
                        Object other$filteredMessage = other.filteredMessage;
                        return this$filteredMessage == null ? other$filteredMessage == null : this$filteredMessage.equals(other$filteredMessage);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TextPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.needsTranslation ? 79 : 97);
      Object $type = this.type;
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $sourceName = this.sourceName;
      result = result * 59 + ($sourceName == null ? 43 : $sourceName.hashCode());
      Object $message = this.message;
      result = result * 59 + ($message == null ? 43 : $message.hashCode());
      Object $parameters = this.parameters;
      result = result * 59 + ($parameters == null ? 43 : $parameters.hashCode());
      Object $xuid = this.xuid;
      result = result * 59 + ($xuid == null ? 43 : $xuid.hashCode());
      Object $platformChatId = this.platformChatId;
      result = result * 59 + ($platformChatId == null ? 43 : $platformChatId.hashCode());
      Object $filteredMessage = this.filteredMessage;
      return result * 59 + ($filteredMessage == null ? 43 : $filteredMessage.hashCode());
   }

   @Override
   public String toString() {
      return "TextPacket(type="
         + this.type
         + ", sourceName="
         + this.sourceName
         + ", message="
         + this.message
         + ", parameters="
         + this.parameters
         + ", needsTranslation="
         + this.needsTranslation
         + ", xuid="
         + this.xuid
         + ", platformChatId="
         + this.platformChatId
         + ", filteredMessage="
         + this.filteredMessage
         + ")";
   }

   public enum Type {
      RAW,
      CHAT,
      TRANSLATION,
      POPUP,
      JUKEBOX_POPUP,
      TIP,
      SYSTEM,
      WHISPER,
      ANNOUNCEMENT,
      WHISPER_JSON,
      JSON,
      ANNOUNCEMENT_JSON;
   }
}
