package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class StopSoundPacket implements BedrockPacket {
   private String soundName;
   private boolean stoppingAllSound;
   private boolean stopMusicLegacy;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.STOP_SOUND;
   }

   public StopSoundPacket clone() {
      try {
         return (StopSoundPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public String getSoundName() {
      return this.soundName;
   }

   public boolean isStoppingAllSound() {
      return this.stoppingAllSound;
   }

   public boolean isStopMusicLegacy() {
      return this.stopMusicLegacy;
   }

   public void setSoundName(final String soundName) {
      this.soundName = soundName;
   }

   public void setStoppingAllSound(final boolean stoppingAllSound) {
      this.stoppingAllSound = stoppingAllSound;
   }

   public void setStopMusicLegacy(final boolean stopMusicLegacy) {
      this.stopMusicLegacy = stopMusicLegacy;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StopSoundPacket)) {
         return false;
      }

      StopSoundPacket other = (StopSoundPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.stoppingAllSound != other.stoppingAllSound) {
         return false;
      }

      if (this.stopMusicLegacy != other.stopMusicLegacy) {
         return false;
      }

      Object this$soundName = this.soundName;
      Object other$soundName = other.soundName;
      return this$soundName == null ? other$soundName == null : this$soundName.equals(other$soundName);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof StopSoundPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.stoppingAllSound ? 79 : 97);
      result = result * 59 + (this.stopMusicLegacy ? 79 : 97);
      Object $soundName = this.soundName;
      return result * 59 + ($soundName == null ? 43 : $soundName.hashCode());
   }

   @Override
   public String toString() {
      return "StopSoundPacket(soundName=" + this.soundName + ", stoppingAllSound=" + this.stoppingAllSound + ", stopMusicLegacy=" + this.stopMusicLegacy + ")";
   }
}
