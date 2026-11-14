package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.math.vector.Vector2f;
import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.protocol.bedrock.data.PredictionType;
import org.cloudburstmc.protocol.common.PacketSignal;

public class CorrectPlayerMovePredictionPacket implements BedrockPacket {
   private Vector3f position;
   private Vector3f delta;
   private boolean onGround;
   private long tick;
   private PredictionType predictionType = PredictionType.PLAYER;
   private Vector2f vehicleRotation;
   private Float vehicleAngularVelocity;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CORRECT_PLAYER_MOVE_PREDICTION;
   }

   public CorrectPlayerMovePredictionPacket clone() {
      try {
         return (CorrectPlayerMovePredictionPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public Vector3f getPosition() {
      return this.position;
   }

   public Vector3f getDelta() {
      return this.delta;
   }

   public boolean isOnGround() {
      return this.onGround;
   }

   public long getTick() {
      return this.tick;
   }

   public PredictionType getPredictionType() {
      return this.predictionType;
   }

   public Vector2f getVehicleRotation() {
      return this.vehicleRotation;
   }

   public Float getVehicleAngularVelocity() {
      return this.vehicleAngularVelocity;
   }

   public void setPosition(final Vector3f position) {
      this.position = position;
   }

   public void setDelta(final Vector3f delta) {
      this.delta = delta;
   }

   public void setOnGround(final boolean onGround) {
      this.onGround = onGround;
   }

   public void setTick(final long tick) {
      this.tick = tick;
   }

   public void setPredictionType(final PredictionType predictionType) {
      this.predictionType = predictionType;
   }

   public void setVehicleRotation(final Vector2f vehicleRotation) {
      this.vehicleRotation = vehicleRotation;
   }

   public void setVehicleAngularVelocity(final Float vehicleAngularVelocity) {
      this.vehicleAngularVelocity = vehicleAngularVelocity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CorrectPlayerMovePredictionPacket)) {
         return false;
      }

      CorrectPlayerMovePredictionPacket other = (CorrectPlayerMovePredictionPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.onGround != other.onGround) {
         return false;
      }

      if (this.tick != other.tick) {
         return false;
      }

      Object this$vehicleAngularVelocity = this.vehicleAngularVelocity;
      Object other$vehicleAngularVelocity = other.vehicleAngularVelocity;
      if (this$vehicleAngularVelocity == null ? other$vehicleAngularVelocity == null : this$vehicleAngularVelocity.equals(other$vehicleAngularVelocity)) {
         Object this$position = this.position;
         Object other$position = other.position;
         if (this$position == null ? other$position == null : this$position.equals(other$position)) {
            Object this$delta = this.delta;
            Object other$delta = other.delta;
            if (this$delta == null ? other$delta == null : this$delta.equals(other$delta)) {
               Object this$predictionType = this.predictionType;
               Object other$predictionType = other.predictionType;
               if (this$predictionType == null ? other$predictionType == null : this$predictionType.equals(other$predictionType)) {
                  Object this$vehicleRotation = this.vehicleRotation;
                  Object other$vehicleRotation = other.vehicleRotation;
                  return this$vehicleRotation == null ? other$vehicleRotation == null : this$vehicleRotation.equals(other$vehicleRotation);
               } else {
                  return false;
               }
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
      return other instanceof CorrectPlayerMovePredictionPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.onGround ? 79 : 97);
      long $tick = this.tick;
      result = result * 59 + (int)($tick >>> 32 ^ $tick);
      Object $vehicleAngularVelocity = this.vehicleAngularVelocity;
      result = result * 59 + ($vehicleAngularVelocity == null ? 43 : $vehicleAngularVelocity.hashCode());
      Object $position = this.position;
      result = result * 59 + ($position == null ? 43 : $position.hashCode());
      Object $delta = this.delta;
      result = result * 59 + ($delta == null ? 43 : $delta.hashCode());
      Object $predictionType = this.predictionType;
      result = result * 59 + ($predictionType == null ? 43 : $predictionType.hashCode());
      Object $vehicleRotation = this.vehicleRotation;
      return result * 59 + ($vehicleRotation == null ? 43 : $vehicleRotation.hashCode());
   }

   @Override
   public String toString() {
      return "CorrectPlayerMovePredictionPacket(position="
         + this.position
         + ", delta="
         + this.delta
         + ", onGround="
         + this.onGround
         + ", tick="
         + this.tick
         + ", predictionType="
         + this.predictionType
         + ", vehicleRotation="
         + this.vehicleRotation
         + ", vehicleAngularVelocity="
         + this.vehicleAngularVelocity
         + ")";
   }
}
