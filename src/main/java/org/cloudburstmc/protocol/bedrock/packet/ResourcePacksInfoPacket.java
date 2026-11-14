package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.UUID;
import org.cloudburstmc.protocol.common.PacketSignal;

public class ResourcePacksInfoPacket implements BedrockPacket {
   /** @deprecated */
   private final List<ResourcePacksInfoPacket.Entry> behaviorPackInfos = new ObjectArrayList<>();
   private final List<ResourcePacksInfoPacket.Entry> resourcePackInfos = new ObjectArrayList<>();
   private boolean forcedToAccept;
   private boolean hasAddonPacks;
   private boolean scriptingEnabled;
   /** @deprecated */
   private boolean forcingServerPacksEnabled;
   private UUID worldTemplateId;
   private String worldTemplateVersion;
   private boolean vibrantVisualsForceDisabled;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.RESOURCE_PACKS_INFO;
   }

   public ResourcePacksInfoPacket clone() {
      try {
         return (ResourcePacksInfoPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   @Deprecated
   public List<ResourcePacksInfoPacket.Entry> getBehaviorPackInfos() {
      return this.behaviorPackInfos;
   }

   public List<ResourcePacksInfoPacket.Entry> getResourcePackInfos() {
      return this.resourcePackInfos;
   }

   public boolean isForcedToAccept() {
      return this.forcedToAccept;
   }

   public boolean isHasAddonPacks() {
      return this.hasAddonPacks;
   }

   public boolean isScriptingEnabled() {
      return this.scriptingEnabled;
   }

   @Deprecated
   public boolean isForcingServerPacksEnabled() {
      return this.forcingServerPacksEnabled;
   }

   public UUID getWorldTemplateId() {
      return this.worldTemplateId;
   }

   public String getWorldTemplateVersion() {
      return this.worldTemplateVersion;
   }

   public boolean isVibrantVisualsForceDisabled() {
      return this.vibrantVisualsForceDisabled;
   }

   public void setForcedToAccept(final boolean forcedToAccept) {
      this.forcedToAccept = forcedToAccept;
   }

   public void setHasAddonPacks(final boolean hasAddonPacks) {
      this.hasAddonPacks = hasAddonPacks;
   }

   public void setScriptingEnabled(final boolean scriptingEnabled) {
      this.scriptingEnabled = scriptingEnabled;
   }

   @Deprecated
   public void setForcingServerPacksEnabled(final boolean forcingServerPacksEnabled) {
      this.forcingServerPacksEnabled = forcingServerPacksEnabled;
   }

   public void setWorldTemplateId(final UUID worldTemplateId) {
      this.worldTemplateId = worldTemplateId;
   }

   public void setWorldTemplateVersion(final String worldTemplateVersion) {
      this.worldTemplateVersion = worldTemplateVersion;
   }

   public void setVibrantVisualsForceDisabled(final boolean vibrantVisualsForceDisabled) {
      this.vibrantVisualsForceDisabled = vibrantVisualsForceDisabled;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ResourcePacksInfoPacket)) {
         return false;
      }

      ResourcePacksInfoPacket other = (ResourcePacksInfoPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.forcedToAccept != other.forcedToAccept) {
         return false;
      }

      if (this.hasAddonPacks != other.hasAddonPacks) {
         return false;
      }

      if (this.scriptingEnabled != other.scriptingEnabled) {
         return false;
      }

      if (this.forcingServerPacksEnabled != other.forcingServerPacksEnabled) {
         return false;
      }

      if (this.vibrantVisualsForceDisabled != other.vibrantVisualsForceDisabled) {
         return false;
      }

      Object this$behaviorPackInfos = this.behaviorPackInfos;
      Object other$behaviorPackInfos = other.behaviorPackInfos;
      if (this$behaviorPackInfos == null ? other$behaviorPackInfos == null : this$behaviorPackInfos.equals(other$behaviorPackInfos)) {
         Object this$resourcePackInfos = this.resourcePackInfos;
         Object other$resourcePackInfos = other.resourcePackInfos;
         if (this$resourcePackInfos == null ? other$resourcePackInfos == null : this$resourcePackInfos.equals(other$resourcePackInfos)) {
            Object this$worldTemplateId = this.worldTemplateId;
            Object other$worldTemplateId = other.worldTemplateId;
            if (this$worldTemplateId == null ? other$worldTemplateId == null : this$worldTemplateId.equals(other$worldTemplateId)) {
               Object this$worldTemplateVersion = this.worldTemplateVersion;
               Object other$worldTemplateVersion = other.worldTemplateVersion;
               return this$worldTemplateVersion == null ? other$worldTemplateVersion == null : this$worldTemplateVersion.equals(other$worldTemplateVersion);
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
      return other instanceof ResourcePacksInfoPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.forcedToAccept ? 79 : 97);
      result = result * 59 + (this.hasAddonPacks ? 79 : 97);
      result = result * 59 + (this.scriptingEnabled ? 79 : 97);
      result = result * 59 + (this.forcingServerPacksEnabled ? 79 : 97);
      result = result * 59 + (this.vibrantVisualsForceDisabled ? 79 : 97);
      Object $behaviorPackInfos = this.behaviorPackInfos;
      result = result * 59 + ($behaviorPackInfos == null ? 43 : $behaviorPackInfos.hashCode());
      Object $resourcePackInfos = this.resourcePackInfos;
      result = result * 59 + ($resourcePackInfos == null ? 43 : $resourcePackInfos.hashCode());
      Object $worldTemplateId = this.worldTemplateId;
      result = result * 59 + ($worldTemplateId == null ? 43 : $worldTemplateId.hashCode());
      Object $worldTemplateVersion = this.worldTemplateVersion;
      return result * 59 + ($worldTemplateVersion == null ? 43 : $worldTemplateVersion.hashCode());
   }

   @Override
   public String toString() {
      return "ResourcePacksInfoPacket(behaviorPackInfos="
         + this.behaviorPackInfos
         + ", resourcePackInfos="
         + this.resourcePackInfos
         + ", forcedToAccept="
         + this.forcedToAccept
         + ", hasAddonPacks="
         + this.hasAddonPacks
         + ", scriptingEnabled="
         + this.scriptingEnabled
         + ", forcingServerPacksEnabled="
         + this.forcingServerPacksEnabled
         + ", worldTemplateId="
         + this.worldTemplateId
         + ", worldTemplateVersion="
         + this.worldTemplateVersion
         + ", vibrantVisualsForceDisabled="
         + this.vibrantVisualsForceDisabled
         + ")";
   }

   public static class Entry {
      private UUID packId;
      private String packVersion;
      private long packSize;
      private String contentKey;
      private String subPackName;
      private String contentId;
      private boolean scripting;
      private boolean raytracingCapable;
      private boolean addonPack;
      private String cdnUrl;

      public UUID getPackId() {
         return this.packId;
      }

      public String getPackVersion() {
         return this.packVersion;
      }

      public long getPackSize() {
         return this.packSize;
      }

      public String getContentKey() {
         return this.contentKey;
      }

      public String getSubPackName() {
         return this.subPackName;
      }

      public String getContentId() {
         return this.contentId;
      }

      public boolean isScripting() {
         return this.scripting;
      }

      public boolean isRaytracingCapable() {
         return this.raytracingCapable;
      }

      public boolean isAddonPack() {
         return this.addonPack;
      }

      public String getCdnUrl() {
         return this.cdnUrl;
      }

      public void setPackId(final UUID packId) {
         this.packId = packId;
      }

      public void setPackVersion(final String packVersion) {
         this.packVersion = packVersion;
      }

      public void setPackSize(final long packSize) {
         this.packSize = packSize;
      }

      public void setContentKey(final String contentKey) {
         this.contentKey = contentKey;
      }

      public void setSubPackName(final String subPackName) {
         this.subPackName = subPackName;
      }

      public void setContentId(final String contentId) {
         this.contentId = contentId;
      }

      public void setScripting(final boolean scripting) {
         this.scripting = scripting;
      }

      public void setRaytracingCapable(final boolean raytracingCapable) {
         this.raytracingCapable = raytracingCapable;
      }

      public void setAddonPack(final boolean addonPack) {
         this.addonPack = addonPack;
      }

      public void setCdnUrl(final String cdnUrl) {
         this.cdnUrl = cdnUrl;
      }

      @Override
      public boolean equals(final Object o) {
         if (o == this) {
            return true;
         }

         if (!(o instanceof ResourcePacksInfoPacket.Entry)) {
            return false;
         }

         ResourcePacksInfoPacket.Entry other = (ResourcePacksInfoPacket.Entry)o;
         if (!other.canEqual(this)) {
            return false;
         }

         if (this.getPackSize() != other.getPackSize()) {
            return false;
         }

         if (this.isScripting() != other.isScripting()) {
            return false;
         }

         if (this.isRaytracingCapable() != other.isRaytracingCapable()) {
            return false;
         }

         if (this.isAddonPack() != other.isAddonPack()) {
            return false;
         }

         Object this$packId = this.getPackId();
         Object other$packId = other.getPackId();
         if (this$packId == null ? other$packId == null : this$packId.equals(other$packId)) {
            Object this$packVersion = this.getPackVersion();
            Object other$packVersion = other.getPackVersion();
            if (this$packVersion == null ? other$packVersion == null : this$packVersion.equals(other$packVersion)) {
               Object this$contentKey = this.getContentKey();
               Object other$contentKey = other.getContentKey();
               if (this$contentKey == null ? other$contentKey == null : this$contentKey.equals(other$contentKey)) {
                  Object this$subPackName = this.getSubPackName();
                  Object other$subPackName = other.getSubPackName();
                  if (this$subPackName == null ? other$subPackName == null : this$subPackName.equals(other$subPackName)) {
                     Object this$contentId = this.getContentId();
                     Object other$contentId = other.getContentId();
                     if (this$contentId == null ? other$contentId == null : this$contentId.equals(other$contentId)) {
                        Object this$cdnUrl = this.getCdnUrl();
                        Object other$cdnUrl = other.getCdnUrl();
                        return this$cdnUrl == null ? other$cdnUrl == null : this$cdnUrl.equals(other$cdnUrl);
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
         return other instanceof ResourcePacksInfoPacket.Entry;
      }

      @Override
      public int hashCode() {
         int PRIME = 59;
         int result = 1;
         long $packSize = this.getPackSize();
         result = result * 59 + (int)($packSize >>> 32 ^ $packSize);
         result = result * 59 + (this.isScripting() ? 79 : 97);
         result = result * 59 + (this.isRaytracingCapable() ? 79 : 97);
         result = result * 59 + (this.isAddonPack() ? 79 : 97);
         Object $packId = this.getPackId();
         result = result * 59 + ($packId == null ? 43 : $packId.hashCode());
         Object $packVersion = this.getPackVersion();
         result = result * 59 + ($packVersion == null ? 43 : $packVersion.hashCode());
         Object $contentKey = this.getContentKey();
         result = result * 59 + ($contentKey == null ? 43 : $contentKey.hashCode());
         Object $subPackName = this.getSubPackName();
         result = result * 59 + ($subPackName == null ? 43 : $subPackName.hashCode());
         Object $contentId = this.getContentId();
         result = result * 59 + ($contentId == null ? 43 : $contentId.hashCode());
         Object $cdnUrl = this.getCdnUrl();
         return result * 59 + ($cdnUrl == null ? 43 : $cdnUrl.hashCode());
      }

      @Override
      public String toString() {
         return "ResourcePacksInfoPacket.Entry(packId="
            + this.getPackId()
            + ", packVersion="
            + this.getPackVersion()
            + ", packSize="
            + this.getPackSize()
            + ", contentKey="
            + this.getContentKey()
            + ", subPackName="
            + this.getSubPackName()
            + ", contentId="
            + this.getContentId()
            + ", scripting="
            + this.isScripting()
            + ", raytracingCapable="
            + this.isRaytracingCapable()
            + ", addonPack="
            + this.isAddonPack()
            + ", cdnUrl="
            + this.getCdnUrl()
            + ")";
      }

      public Entry(
         final UUID packId,
         final String packVersion,
         final long packSize,
         final String contentKey,
         final String subPackName,
         final String contentId,
         final boolean scripting,
         final boolean raytracingCapable,
         final boolean addonPack,
         final String cdnUrl
      ) {
         this.packId = packId;
         this.packVersion = packVersion;
         this.packSize = packSize;
         this.contentKey = contentKey;
         this.subPackName = subPackName;
         this.contentId = contentId;
         this.scripting = scripting;
         this.raytracingCapable = raytracingCapable;
         this.addonPack = addonPack;
         this.cdnUrl = cdnUrl;
      }
   }
}
