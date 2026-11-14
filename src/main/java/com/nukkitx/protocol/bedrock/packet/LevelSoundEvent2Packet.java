package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.SoundEvent;
import com.nukkitx.protocol.common.PacketSignal;
import org.cloudburstmc.math.vector.Vector3f;

public class LevelSoundEvent2Packet implements BedrockPacket {
   private SoundEvent sound;
   private Vector3f position;
   private int extraData;
   private String identifier;
   private boolean babySound;
   private boolean relativeVolumeDisabled;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.LEVEL_SOUND_EVENT_2;
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

   public String getIdentifier() {
      return this.identifier;
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

   public void setIdentifier(String identifier) {
      this.identifier = identifier;
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
      }

      if (!(o instanceof LevelSoundEvent2Packet)) {
         return false;
      }

      LevelSoundEvent2Packet other = (LevelSoundEvent2Packet)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.extraData != other.extraData) {
         return false;
      }

      if (this.babySound != other.babySound) {
         return false;
      }

      if (this.relativeVolumeDisabled != other.relativeVolumeDisabled) {
         return false;
      }

      Object this$sound = this.sound;
      Object other$sound = other.sound;
      if (this$sound == null ? other$sound == null : this$sound.equals(other$sound)) {
         Object this$position = this.position;
         Object other$position = other.position;
         if (this$position == null ? other$position == null : this$position.equals(other$position)) {
            Object this$identifier = this.identifier;
            Object other$identifier = other.identifier;
            return this$identifier == null ? other$identifier == null : this$identifier.equals(other$identifier);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof LevelSoundEvent2Packet;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.extraData;
      result = result * 59 + (this.babySound ? 79 : 97);
      result = result * 59 + (this.relativeVolumeDisabled ? 79 : 97);
      Object $sound = this.sound;
      result = result * 59 + ($sound == null ? 43 : $sound.hashCode());
      Object $position = this.position;
      result = result * 59 + ($position == null ? 43 : $position.hashCode());
      Object $identifier = this.identifier;
      return result * 59 + ($identifier == null ? 43 : $identifier.hashCode());
   }

   @Override
   public String toString() {
      return "LevelSoundEvent2Packet(sound="
         + this.sound
         + ", position="
         + this.position
         + ", extraData="
         + this.extraData
         + ", identifier="
         + this.identifier
         + ", babySound="
         + this.babySound
         + ", relativeVolumeDisabled="
         + this.relativeVolumeDisabled
         + ")";
   }
}
