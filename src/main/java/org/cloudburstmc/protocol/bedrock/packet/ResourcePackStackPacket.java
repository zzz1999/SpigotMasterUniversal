package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.cloudburstmc.protocol.bedrock.data.ExperimentData;
import org.cloudburstmc.protocol.common.PacketSignal;

public class ResourcePackStackPacket implements BedrockPacket {
   private boolean forcedToAccept;
   private final List<ResourcePackStackPacket.Entry> behaviorPacks = new ObjectArrayList<>();
   private final List<ResourcePackStackPacket.Entry> resourcePacks = new ObjectArrayList<>();
   private String gameVersion;
   private final List<ExperimentData> experiments = new ObjectArrayList<>();
   private boolean experimentsPreviouslyToggled;
   private boolean hasEditorPacks;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.RESOURCE_PACK_STACK;
   }

   public ResourcePackStackPacket clone() {
      try {
         return (ResourcePackStackPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public boolean isForcedToAccept() {
      return this.forcedToAccept;
   }

   public List<ResourcePackStackPacket.Entry> getBehaviorPacks() {
      return this.behaviorPacks;
   }

   public List<ResourcePackStackPacket.Entry> getResourcePacks() {
      return this.resourcePacks;
   }

   public String getGameVersion() {
      return this.gameVersion;
   }

   public List<ExperimentData> getExperiments() {
      return this.experiments;
   }

   public boolean isExperimentsPreviouslyToggled() {
      return this.experimentsPreviouslyToggled;
   }

   public boolean isHasEditorPacks() {
      return this.hasEditorPacks;
   }

   public void setForcedToAccept(final boolean forcedToAccept) {
      this.forcedToAccept = forcedToAccept;
   }

   public void setGameVersion(final String gameVersion) {
      this.gameVersion = gameVersion;
   }

   public void setExperimentsPreviouslyToggled(final boolean experimentsPreviouslyToggled) {
      this.experimentsPreviouslyToggled = experimentsPreviouslyToggled;
   }

   public void setHasEditorPacks(final boolean hasEditorPacks) {
      this.hasEditorPacks = hasEditorPacks;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ResourcePackStackPacket)) {
         return false;
      }

      ResourcePackStackPacket other = (ResourcePackStackPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.forcedToAccept != other.forcedToAccept) {
         return false;
      }

      if (this.experimentsPreviouslyToggled != other.experimentsPreviouslyToggled) {
         return false;
      }

      if (this.hasEditorPacks != other.hasEditorPacks) {
         return false;
      }

      Object this$behaviorPacks = this.behaviorPacks;
      Object other$behaviorPacks = other.behaviorPacks;
      if (this$behaviorPacks == null ? other$behaviorPacks == null : this$behaviorPacks.equals(other$behaviorPacks)) {
         Object this$resourcePacks = this.resourcePacks;
         Object other$resourcePacks = other.resourcePacks;
         if (this$resourcePacks == null ? other$resourcePacks == null : this$resourcePacks.equals(other$resourcePacks)) {
            Object this$gameVersion = this.gameVersion;
            Object other$gameVersion = other.gameVersion;
            if (this$gameVersion == null ? other$gameVersion == null : this$gameVersion.equals(other$gameVersion)) {
               Object this$experiments = this.experiments;
               Object other$experiments = other.experiments;
               return this$experiments == null ? other$experiments == null : this$experiments.equals(other$experiments);
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
      return other instanceof ResourcePackStackPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.forcedToAccept ? 79 : 97);
      result = result * 59 + (this.experimentsPreviouslyToggled ? 79 : 97);
      result = result * 59 + (this.hasEditorPacks ? 79 : 97);
      Object $behaviorPacks = this.behaviorPacks;
      result = result * 59 + ($behaviorPacks == null ? 43 : $behaviorPacks.hashCode());
      Object $resourcePacks = this.resourcePacks;
      result = result * 59 + ($resourcePacks == null ? 43 : $resourcePacks.hashCode());
      Object $gameVersion = this.gameVersion;
      result = result * 59 + ($gameVersion == null ? 43 : $gameVersion.hashCode());
      Object $experiments = this.experiments;
      return result * 59 + ($experiments == null ? 43 : $experiments.hashCode());
   }

   @Override
   public String toString() {
      return "ResourcePackStackPacket(forcedToAccept="
         + this.forcedToAccept
         + ", behaviorPacks="
         + this.behaviorPacks
         + ", resourcePacks="
         + this.resourcePacks
         + ", gameVersion="
         + this.gameVersion
         + ", experiments="
         + this.experiments
         + ", experimentsPreviouslyToggled="
         + this.experimentsPreviouslyToggled
         + ", hasEditorPacks="
         + this.hasEditorPacks
         + ")";
   }

   public static final class Entry {
      private final String packId;
      private final String packVersion;
      private final String subPackName;

      public Entry(final String packId, final String packVersion, final String subPackName) {
         this.packId = packId;
         this.packVersion = packVersion;
         this.subPackName = subPackName;
      }

      public String getPackId() {
         return this.packId;
      }

      public String getPackVersion() {
         return this.packVersion;
      }

      public String getSubPackName() {
         return this.subPackName;
      }

      @Override
      public boolean equals(final Object o) {
         if (o == this) {
            return true;
         }

         if (!(o instanceof ResourcePackStackPacket.Entry)) {
            return false;
         }

         ResourcePackStackPacket.Entry other = (ResourcePackStackPacket.Entry)o;
         Object this$packId = this.getPackId();
         Object other$packId = other.getPackId();
         if (this$packId == null ? other$packId == null : this$packId.equals(other$packId)) {
            Object this$packVersion = this.getPackVersion();
            Object other$packVersion = other.getPackVersion();
            if (this$packVersion == null ? other$packVersion == null : this$packVersion.equals(other$packVersion)) {
               Object this$subPackName = this.getSubPackName();
               Object other$subPackName = other.getSubPackName();
               return this$subPackName == null ? other$subPackName == null : this$subPackName.equals(other$subPackName);
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
         Object $packId = this.getPackId();
         result = result * 59 + ($packId == null ? 43 : $packId.hashCode());
         Object $packVersion = this.getPackVersion();
         result = result * 59 + ($packVersion == null ? 43 : $packVersion.hashCode());
         Object $subPackName = this.getSubPackName();
         return result * 59 + ($subPackName == null ? 43 : $subPackName.hashCode());
      }

      @Override
      public String toString() {
         return "ResourcePackStackPacket.Entry(packId="
            + this.getPackId()
            + ", packVersion="
            + this.getPackVersion()
            + ", subPackName="
            + this.getSubPackName()
            + ")";
      }
   }
}
