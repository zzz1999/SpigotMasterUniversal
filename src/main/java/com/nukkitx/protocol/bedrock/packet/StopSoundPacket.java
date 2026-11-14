package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class StopSoundPacket implements BedrockPacket {
   private String soundName;
   private boolean stoppingAllSound;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.STOP_SOUND;
   }

   public String getSoundName() {
      return this.soundName;
   }

   public boolean isStoppingAllSound() {
      return this.stoppingAllSound;
   }

   public void setSoundName(String soundName) {
      this.soundName = soundName;
   }

   public void setStoppingAllSound(boolean stoppingAllSound) {
      this.stoppingAllSound = stoppingAllSound;
   }

   @Override
   public boolean equals(Object o) {
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

      Object this$soundName = this.soundName;
      Object other$soundName = other.soundName;
      return this$soundName == null ? other$soundName == null : this$soundName.equals(other$soundName);
   }

   protected boolean canEqual(Object other) {
      return other instanceof StopSoundPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.stoppingAllSound ? 79 : 97);
      Object $soundName = this.soundName;
      return result * 59 + ($soundName == null ? 43 : $soundName.hashCode());
   }

   @Override
   public String toString() {
      return "StopSoundPacket(soundName=" + this.soundName + ", stoppingAllSound=" + this.stoppingAllSound + ")";
   }
}
