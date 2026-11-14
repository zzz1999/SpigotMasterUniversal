package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.awt.Color;
import java.util.List;
import java.util.UUID;
import org.cloudburstmc.protocol.bedrock.data.skin.SerializedSkin;
import org.cloudburstmc.protocol.common.PacketSignal;

public class PlayerListPacket implements BedrockPacket {
   private final List<PlayerListPacket.Entry> entries = new ObjectArrayList<>();
   private PlayerListPacket.Action action;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.PLAYER_LIST;
   }

   public PlayerListPacket clone() {
      try {
         return (PlayerListPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public List<PlayerListPacket.Entry> getEntries() {
      return this.entries;
   }

   public PlayerListPacket.Action getAction() {
      return this.action;
   }

   public void setAction(final PlayerListPacket.Action action) {
      this.action = action;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof PlayerListPacket)) {
         return false;
      } else {
         PlayerListPacket other = (PlayerListPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$entries = this.entries;
            Object other$entries = other.entries;
            if (this$entries == null ? other$entries == null : this$entries.equals(other$entries)) {
               Object this$action = this.action;
               Object other$action = other.action;
               return this$action == null ? other$action == null : this$action.equals(other$action);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PlayerListPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $entries = this.entries;
      result = result * 59 + ($entries == null ? 43 : $entries.hashCode());
      Object $action = this.action;
      return result * 59 + ($action == null ? 43 : $action.hashCode());
   }

   @Override
   public String toString() {
      return "PlayerListPacket(entries=" + this.entries + ", action=" + this.action + ")";
   }

   public enum Action {
      ADD,
      REMOVE;
   }

   public static final class Entry {
      private final UUID uuid;
      private long entityId;
      private CharSequence name;
      private String xuid;
      private String platformChatId;
      private int buildPlatform;
      private SerializedSkin skin;
      private boolean teacher;
      private boolean host;
      private boolean trustedSkin;
      private boolean subClient;
      private Color color;

      public String getName() {
         return this.getName(String.class);
      }

      public <T extends CharSequence> T getName(Class<T> type) {
         return type.cast(this.name);
      }

      public Entry(final UUID uuid) {
         this.uuid = uuid;
      }

      public UUID getUuid() {
         return this.uuid;
      }

      public long getEntityId() {
         return this.entityId;
      }

      public String getXuid() {
         return this.xuid;
      }

      public String getPlatformChatId() {
         return this.platformChatId;
      }

      public int getBuildPlatform() {
         return this.buildPlatform;
      }

      public SerializedSkin getSkin() {
         return this.skin;
      }

      public boolean isTeacher() {
         return this.teacher;
      }

      public boolean isHost() {
         return this.host;
      }

      public boolean isTrustedSkin() {
         return this.trustedSkin;
      }

      public boolean isSubClient() {
         return this.subClient;
      }

      public Color getColor() {
         return this.color;
      }

      public void setEntityId(final long entityId) {
         this.entityId = entityId;
      }

      public void setName(final CharSequence name) {
         this.name = name;
      }

      public void setXuid(final String xuid) {
         this.xuid = xuid;
      }

      public void setPlatformChatId(final String platformChatId) {
         this.platformChatId = platformChatId;
      }

      public void setBuildPlatform(final int buildPlatform) {
         this.buildPlatform = buildPlatform;
      }

      public void setSkin(final SerializedSkin skin) {
         this.skin = skin;
      }

      public void setTeacher(final boolean teacher) {
         this.teacher = teacher;
      }

      public void setHost(final boolean host) {
         this.host = host;
      }

      public void setTrustedSkin(final boolean trustedSkin) {
         this.trustedSkin = trustedSkin;
      }

      public void setSubClient(final boolean subClient) {
         this.subClient = subClient;
      }

      public void setColor(final Color color) {
         this.color = color;
      }

      @Override
      public String toString() {
         return "PlayerListPacket.Entry(uuid="
            + this.uuid
            + ", entityId="
            + this.entityId
            + ", name="
            + this.name
            + ", xuid="
            + this.xuid
            + ", platformChatId="
            + this.platformChatId
            + ", buildPlatform="
            + this.buildPlatform
            + ", skin="
            + this.skin
            + ", teacher="
            + this.teacher
            + ", host="
            + this.host
            + ", trustedSkin="
            + this.trustedSkin
            + ", subClient="
            + this.subClient
            + ", color="
            + this.color
            + ")";
      }

      @Override
      public boolean equals(final Object o) {
         if (o == this) {
            return true;
         }

         if (!(o instanceof PlayerListPacket.Entry)) {
            return false;
         }

         PlayerListPacket.Entry other = (PlayerListPacket.Entry)o;
         if (this.entityId != other.entityId) {
            return false;
         }

         if (this.buildPlatform != other.buildPlatform) {
            return false;
         }

         if (this.teacher != other.teacher) {
            return false;
         }

         if (this.host != other.host) {
            return false;
         }

         if (this.trustedSkin != other.trustedSkin) {
            return false;
         }

         if (this.subClient != other.subClient) {
            return false;
         }

         Object this$uuid = this.uuid;
         Object other$uuid = other.uuid;
         if (this$uuid == null ? other$uuid == null : this$uuid.equals(other$uuid)) {
            Object this$name = this.name;
            Object other$name = other.name;
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$xuid = this.xuid;
               Object other$xuid = other.xuid;
               if (this$xuid == null ? other$xuid == null : this$xuid.equals(other$xuid)) {
                  Object this$platformChatId = this.platformChatId;
                  Object other$platformChatId = other.platformChatId;
                  if (this$platformChatId == null ? other$platformChatId == null : this$platformChatId.equals(other$platformChatId)) {
                     Object this$skin = this.skin;
                     Object other$skin = other.skin;
                     if (this$skin == null ? other$skin == null : this$skin.equals(other$skin)) {
                        Object this$color = this.color;
                        Object other$color = other.color;
                        return this$color == null ? other$color == null : this$color.equals(other$color);
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

      @Override
      public int hashCode() {
         int PRIME = 59;
         int result = 1;
         long $entityId = this.entityId;
         result = result * 59 + (int)($entityId >>> 32 ^ $entityId);
         result = result * 59 + this.buildPlatform;
         result = result * 59 + (this.teacher ? 79 : 97);
         result = result * 59 + (this.host ? 79 : 97);
         result = result * 59 + (this.trustedSkin ? 79 : 97);
         result = result * 59 + (this.subClient ? 79 : 97);
         Object $uuid = this.uuid;
         result = result * 59 + ($uuid == null ? 43 : $uuid.hashCode());
         Object $name = this.name;
         result = result * 59 + ($name == null ? 43 : $name.hashCode());
         Object $xuid = this.xuid;
         result = result * 59 + ($xuid == null ? 43 : $xuid.hashCode());
         Object $platformChatId = this.platformChatId;
         result = result * 59 + ($platformChatId == null ? 43 : $platformChatId.hashCode());
         Object $skin = this.skin;
         result = result * 59 + ($skin == null ? 43 : $skin.hashCode());
         Object $color = this.color;
         return result * 59 + ($color == null ? 43 : $color.hashCode());
      }
   }
}
