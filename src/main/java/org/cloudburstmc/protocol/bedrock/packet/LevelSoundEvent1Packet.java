package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.protocol.bedrock.data.SoundEvent;
import org.cloudburstmc.protocol.common.PacketSignal;

@Deprecated
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

   public LevelSoundEvent1Packet clone() {
      try {
         return (LevelSoundEvent1Packet)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
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

   public void setSound(final SoundEvent sound) {
      this.sound = sound;
   }

   public void setPosition(final Vector3f position) {
      this.position = position;
   }

   public void setExtraData(final int extraData) {
      this.extraData = extraData;
   }

   public void setPitch(final int pitch) {
      this.pitch = pitch;
   }

   public void setBabySound(final boolean babySound) {
      this.babySound = babySound;
   }

   public void setRelativeVolumeDisabled(final boolean relativeVolumeDisabled) {
      this.relativeVolumeDisabled = relativeVolumeDisabled;
   }

   @Override
   public boolean equals(final Object o) {
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

   protected boolean canEqual(final Object other) {
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
