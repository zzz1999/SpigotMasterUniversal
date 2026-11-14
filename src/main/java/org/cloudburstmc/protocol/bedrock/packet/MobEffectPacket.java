package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class MobEffectPacket implements BedrockPacket {
   private long runtimeEntityId;
   private MobEffectPacket.Event event;
   private int effectId;
   private int amplifier;
   private boolean particles;
   private int duration;
   private long tick;
   private boolean ambient;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.MOB_EFFECT;
   }

   public MobEffectPacket clone() {
      try {
         return (MobEffectPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public MobEffectPacket.Event getEvent() {
      return this.event;
   }

   public int getEffectId() {
      return this.effectId;
   }

   public int getAmplifier() {
      return this.amplifier;
   }

   public boolean isParticles() {
      return this.particles;
   }

   public int getDuration() {
      return this.duration;
   }

   public long getTick() {
      return this.tick;
   }

   public boolean isAmbient() {
      return this.ambient;
   }

   public void setRuntimeEntityId(final long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setEvent(final MobEffectPacket.Event event) {
      this.event = event;
   }

   public void setEffectId(final int effectId) {
      this.effectId = effectId;
   }

   public void setAmplifier(final int amplifier) {
      this.amplifier = amplifier;
   }

   public void setParticles(final boolean particles) {
      this.particles = particles;
   }

   public void setDuration(final int duration) {
      this.duration = duration;
   }

   public void setTick(final long tick) {
      this.tick = tick;
   }

   public void setAmbient(final boolean ambient) {
      this.ambient = ambient;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MobEffectPacket)) {
         return false;
      }

      MobEffectPacket other = (MobEffectPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.runtimeEntityId != other.runtimeEntityId) {
         return false;
      }

      if (this.effectId != other.effectId) {
         return false;
      }

      if (this.amplifier != other.amplifier) {
         return false;
      }

      if (this.particles != other.particles) {
         return false;
      }

      if (this.duration != other.duration) {
         return false;
      }

      if (this.tick != other.tick) {
         return false;
      }

      if (this.ambient != other.ambient) {
         return false;
      }

      Object this$event = this.event;
      Object other$event = other.event;
      return this$event == null ? other$event == null : this$event.equals(other$event);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MobEffectPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      result = result * 59 + this.effectId;
      result = result * 59 + this.amplifier;
      result = result * 59 + (this.particles ? 79 : 97);
      result = result * 59 + this.duration;
      long $tick = this.tick;
      result = result * 59 + (int)($tick >>> 32 ^ $tick);
      result = result * 59 + (this.ambient ? 79 : 97);
      Object $event = this.event;
      return result * 59 + ($event == null ? 43 : $event.hashCode());
   }

   @Override
   public String toString() {
      return "MobEffectPacket(runtimeEntityId="
         + this.runtimeEntityId
         + ", event="
         + this.event
         + ", effectId="
         + this.effectId
         + ", amplifier="
         + this.amplifier
         + ", particles="
         + this.particles
         + ", duration="
         + this.duration
         + ", tick="
         + this.tick
         + ", ambient="
         + this.ambient
         + ")";
   }

   public enum Event {
      NONE,
      ADD,
      MODIFY,
      REMOVE;
   }
}
