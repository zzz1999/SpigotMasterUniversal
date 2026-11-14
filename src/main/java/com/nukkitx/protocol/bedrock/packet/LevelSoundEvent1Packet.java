package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.SoundEvent;
import com.nukkitx.protocol.common.PacketSignal;
import org.cloudburstmc.math.vector.Vector3f;

public class LevelSoundEvent1Packet implements BedrockPacket {
   private SoundEvent sound;
   private Vector3f position;
   private int extraData;
   private int pitch;
   private boolean babySound;
   private boolean relativeVolumeDisabled;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.LEVEL_SOUND_EVENT_1;
   }

   public SoundEvent getSound() {
      return this.sound;
   }

   public Vector3f getPosition() {
      return this.position;
   }

   public int getExtraData() {
      return this.extraData;
   }

   public int getPitch() {
      return this.pitch;
   }

   public boolean isBabySound() {
      return this.babySound;
   }

   public boolean isRelativeVolumeDisabled() {
      return this.relativeVolumeDisabled;
   }

   public void setSound(SoundEvent sound) {
      this.sound = sound;
   }

   public void setPosition(Vector3f position) {
      this.position = position;
   }

   public void setExtraData(int extraData) {
      this.extraData = extraData;
   }

   public void setPitch(int pitch) {
      this.pitch = pitch;
   }

   public void setBabySound(boolean babySound) {
      this.babySound = babySound;
   }

   public void setRelativeVolumeDisabled(boolean relativeVolumeDisabled) {
      this.relativeVolumeDisabled = relativeVolumeDisabled;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof LevelSoundEvent1Packet)) {
         return false;
      } else {
         LevelSoundEvent1Packet other = (LevelSoundEvent1Packet)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.extraData != other.extraData) {
            return false;
         } else if (this.pitch != other.pitch) {
            return false;
         } else if (this.babySound != other.babySound) {
            return false;
         } else if (this.relativeVolumeDisabled != other.relativeVolumeDisabled) {
            return false;
         } else {
            Object this$sound = this.sound;
            Object other$sound = other.sound;
            if (this$sound == null ? other$sound == null : this$sound.equals(other$sound)) {
               Object this$position = this.position;
               Object other$position = other.position;
               return this$position == null ? other$position == null : this$position.equals(other$position);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof LevelSoundEvent1Packet;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.extraData;
      result = result * 59 + this.pitch;
      result = result * 59 + (this.babySound ? 79 : 97);
      result = result * 59 + (this.relativeVolumeDisabled ? 79 : 97);
      Object $sound = this.sound;
      result = result * 59 + ($sound == null ? 43 : $sound.hashCode());
      Object $position = this.position;
      return result * 59 + ($position == null ? 43 : $position.hashCode());
   }

   @Override
   public String toString() {
      return "LevelSoundEvent1Packet(sound="
         + this.sound
         + ", position="
         + this.position
         + ", extraData="
         + this.extraData
         + ", pitch="
         + this.pitch
         + ", babySound="
         + this.babySound
         + ", relativeVolumeDisabled="
         + this.relativeVolumeDisabled
         + ")";
   }
}
