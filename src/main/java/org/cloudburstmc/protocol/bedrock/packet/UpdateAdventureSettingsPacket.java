package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class UpdateAdventureSettingsPacket implements BedrockPacket {
   private boolean noPvM;
   private boolean noMvP;
   private boolean immutableWorld;
   private boolean showNameTags;
   private boolean autoJump;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.UPDATE_ADVENTURE_SETTINGS;
   }

   public UpdateAdventureSettingsPacket clone() {
      try {
         return (UpdateAdventureSettingsPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public boolean isNoPvM() {
      return this.noPvM;
   }

   public boolean isNoMvP() {
      return this.noMvP;
   }

   public boolean isImmutableWorld() {
      return this.immutableWorld;
   }

   public boolean isShowNameTags() {
      return this.showNameTags;
   }

   public boolean isAutoJump() {
      return this.autoJump;
   }

   public void setNoPvM(final boolean noPvM) {
      this.noPvM = noPvM;
   }

   public void setNoMvP(final boolean noMvP) {
      this.noMvP = noMvP;
   }

   public void setImmutableWorld(final boolean immutableWorld) {
      this.immutableWorld = immutableWorld;
   }

   public void setShowNameTags(final boolean showNameTags) {
      this.showNameTags = showNameTags;
   }

   public void setAutoJump(final boolean autoJump) {
      this.autoJump = autoJump;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof UpdateAdventureSettingsPacket)) {
         return false;
      } else {
         UpdateAdventureSettingsPacket other = (UpdateAdventureSettingsPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.noPvM != other.noPvM) {
            return false;
         } else if (this.noMvP != other.noMvP) {
            return false;
         } else if (this.immutableWorld != other.immutableWorld) {
            return false;
         } else {
            return this.showNameTags != other.showNameTags ? false : this.autoJump == other.autoJump;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof UpdateAdventureSettingsPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.noPvM ? 79 : 97);
      result = result * 59 + (this.noMvP ? 79 : 97);
      result = result * 59 + (this.immutableWorld ? 79 : 97);
      result = result * 59 + (this.showNameTags ? 79 : 97);
      return result * 59 + (this.autoJump ? 79 : 97);
   }

   @Override
   public String toString() {
      return "UpdateAdventureSettingsPacket(noPvM="
         + this.noPvM
         + ", noMvP="
         + this.noMvP
         + ", immutableWorld="
         + this.immutableWorld
         + ", showNameTags="
         + this.showNameTags
         + ", autoJump="
         + this.autoJump
         + ")";
   }
}
