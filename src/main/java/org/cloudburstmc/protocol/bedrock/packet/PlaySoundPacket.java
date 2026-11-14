package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.protocol.common.PacketSignal;

public class PlaySoundPacket implements BedrockPacket {
   private String sound;
   private Vector3f position;
   private float volume;
   private float pitch;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.PLAY_SOUND;
   }

   public PlaySoundPacket clone() {
      try {
         return (PlaySoundPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public String getSound() {
      return this.sound;
   }

   public Vector3f getPosition() {
      return this.position;
   }

   public float getVolume() {
      return this.volume;
   }

   public float getPitch() {
      return this.pitch;
   }

   public void setSound(final String sound) {
      this.sound = sound;
   }

   public void setPosition(final Vector3f position) {
      this.position = position;
   }

   public void setVolume(final float volume) {
      this.volume = volume;
   }

   public void setPitch(final float pitch) {
      this.pitch = pitch;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof PlaySoundPacket)) {
         return false;
      } else {
         PlaySoundPacket other = (PlaySoundPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (Float.compare(this.volume, other.volume) != 0) {
            return false;
         } else if (Float.compare(this.pitch, other.pitch) != 0) {
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
      return other instanceof PlaySoundPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + Float.floatToIntBits(this.volume);
      result = result * 59 + Float.floatToIntBits(this.pitch);
      Object $sound = this.sound;
      result = result * 59 + ($sound == null ? 43 : $sound.hashCode());
      Object $position = this.position;
      return result * 59 + ($position == null ? 43 : $position.hashCode());
   }

   @Override
   public String toString() {
      return "PlaySoundPacket(sound=" + this.sound + ", position=" + this.position + ", volume=" + this.volume + ", pitch=" + this.pitch + ")";
   }
}
