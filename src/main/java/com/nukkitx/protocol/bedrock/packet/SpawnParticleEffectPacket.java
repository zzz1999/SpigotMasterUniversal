package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;
import java.util.Optional;
import org.cloudburstmc.math.vector.Vector3f;

public class SpawnParticleEffectPacket implements BedrockPacket {
   private int dimensionId;
   private long uniqueEntityId = -1L;
   private Vector3f position;
   private String identifier;
   private Optional<String> molangVariablesJson;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SPAWN_PARTICLE_EFFECT;
   }

   public int getDimensionId() {
      return this.dimensionId;
   }

   public long getUniqueEntityId() {
      return this.uniqueEntityId;
   }

   public Vector3f getPosition() {
      return this.position;
   }

   public String getIdentifier() {
      return this.identifier;
   }

   public Optional<String> getMolangVariablesJson() {
      return this.molangVariablesJson;
   }

   public void setDimensionId(int dimensionId) {
      this.dimensionId = dimensionId;
   }

   public void setUniqueEntityId(long uniqueEntityId) {
      this.uniqueEntityId = uniqueEntityId;
   }

   public void setPosition(Vector3f position) {
      this.position = position;
   }

   public void setIdentifier(String identifier) {
      this.identifier = identifier;
   }

   public void setMolangVariablesJson(Optional<String> molangVariablesJson) {
      this.molangVariablesJson = molangVariablesJson;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SpawnParticleEffectPacket)) {
         return false;
      }

      SpawnParticleEffectPacket other = (SpawnParticleEffectPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.dimensionId != other.dimensionId) {
         return false;
      }

      if (this.uniqueEntityId != other.uniqueEntityId) {
         return false;
      }

      Object this$position = this.position;
      Object other$position = other.position;
      if (this$position == null ? other$position == null : this$position.equals(other$position)) {
         Object this$identifier = this.identifier;
         Object other$identifier = other.identifier;
         if (this$identifier == null ? other$identifier == null : this$identifier.equals(other$identifier)) {
            Object this$molangVariablesJson = this.molangVariablesJson;
            Object other$molangVariablesJson = other.molangVariablesJson;
            return this$molangVariablesJson == null ? other$molangVariablesJson == null : this$molangVariablesJson.equals(other$molangVariablesJson);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof SpawnParticleEffectPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.dimensionId;
      long $uniqueEntityId = this.uniqueEntityId;
      result = result * 59 + (int)($uniqueEntityId >>> 32 ^ $uniqueEntityId);
      Object $position = this.position;
      result = result * 59 + ($position == null ? 43 : $position.hashCode());
      Object $identifier = this.identifier;
      result = result * 59 + ($identifier == null ? 43 : $identifier.hashCode());
      Object $molangVariablesJson = this.molangVariablesJson;
      return result * 59 + ($molangVariablesJson == null ? 43 : $molangVariablesJson.hashCode());
   }

   @Override
   public String toString() {
      return "SpawnParticleEffectPacket(dimensionId="
         + this.dimensionId
         + ", uniqueEntityId="
         + this.uniqueEntityId
         + ", position="
         + this.position
         + ", identifier="
         + this.identifier
         + ", molangVariablesJson="
         + this.molangVariablesJson
         + ")";
   }
}
