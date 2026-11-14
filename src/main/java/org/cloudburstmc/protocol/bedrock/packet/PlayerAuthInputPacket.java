package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import org.cloudburstmc.math.vector.Vector2f;
import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.protocol.bedrock.data.ClientPlayMode;
import org.cloudburstmc.protocol.bedrock.data.InputInteractionModel;
import org.cloudburstmc.protocol.bedrock.data.InputMode;
import org.cloudburstmc.protocol.bedrock.data.PlayerAuthInputData;
import org.cloudburstmc.protocol.bedrock.data.PlayerBlockActionData;
import org.cloudburstmc.protocol.bedrock.data.inventory.itemstack.request.ItemStackRequest;
import org.cloudburstmc.protocol.bedrock.data.inventory.transaction.ItemUseTransaction;
import org.cloudburstmc.protocol.common.PacketSignal;

public class PlayerAuthInputPacket implements BedrockPacket {
   private Vector3f rotation;
   private Vector3f position;
   private Vector2f motion;
   private final Set<PlayerAuthInputData> inputData = EnumSet.noneOf(PlayerAuthInputData.class);
   private InputMode inputMode;
   private ClientPlayMode playMode;
   /** @deprecated */
   private Vector3f vrGazeDirection;
   private long tick;
   private Vector3f delta;
   private ItemUseTransaction itemUseTransaction;
   private ItemStackRequest itemStackRequest;
   private final List<PlayerBlockActionData> playerActions = new ObjectArrayList<>();
   private InputInteractionModel inputInteractionModel;
   private Vector2f interactRotation;
   private Vector2f analogMoveVector;
   private long predictedVehicle;
   private Vector2f vehicleRotation;
   private Vector3f cameraOrientation;
   private Vector2f rawMoveVector;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.PLAYER_AUTH_INPUT;
   }

   public PlayerAuthInputPacket clone() {
      try {
         return (PlayerAuthInputPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public Vector3f getRotation() {
      return this.rotation;
   }

   public Vector3f getPosition() {
      return this.position;
   }

   public Vector2f getMotion() {
      return this.motion;
   }

   public Set<PlayerAuthInputData> getInputData() {
      return this.inputData;
   }

   public InputMode getInputMode() {
      return this.inputMode;
   }

   public ClientPlayMode getPlayMode() {
      return this.playMode;
   }

   @Deprecated
   public Vector3f getVrGazeDirection() {
      return this.vrGazeDirection;
   }

   public long getTick() {
      return this.tick;
   }

   public Vector3f getDelta() {
      return this.delta;
   }

   public ItemUseTransaction getItemUseTransaction() {
      return this.itemUseTransaction;
   }

   public ItemStackRequest getItemStackRequest() {
      return this.itemStackRequest;
   }

   public List<PlayerBlockActionData> getPlayerActions() {
      return this.playerActions;
   }

   public InputInteractionModel getInputInteractionModel() {
      return this.inputInteractionModel;
   }

   public Vector2f getInteractRotation() {
      return this.interactRotation;
   }

   public Vector2f getAnalogMoveVector() {
      return this.analogMoveVector;
   }

   public long getPredictedVehicle() {
      return this.predictedVehicle;
   }

   public Vector2f getVehicleRotation() {
      return this.vehicleRotation;
   }

   public Vector3f getCameraOrientation() {
      return this.cameraOrientation;
   }

   public Vector2f getRawMoveVector() {
      return this.rawMoveVector;
   }

   public void setRotation(final Vector3f rotation) {
      this.rotation = rotation;
   }

   public void setPosition(final Vector3f position) {
      this.position = position;
   }

   public void setMotion(final Vector2f motion) {
      this.motion = motion;
   }

   public void setInputMode(final InputMode inputMode) {
      this.inputMode = inputMode;
   }

   public void setPlayMode(final ClientPlayMode playMode) {
      this.playMode = playMode;
   }

   @Deprecated
   public void setVrGazeDirection(final Vector3f vrGazeDirection) {
      this.vrGazeDirection = vrGazeDirection;
   }

   public void setTick(final long tick) {
      this.tick = tick;
   }

   public void setDelta(final Vector3f delta) {
      this.delta = delta;
   }

   public void setItemUseTransaction(final ItemUseTransaction itemUseTransaction) {
      this.itemUseTransaction = itemUseTransaction;
   }

   public void setItemStackRequest(final ItemStackRequest itemStackRequest) {
      this.itemStackRequest = itemStackRequest;
   }

   public void setInputInteractionModel(final InputInteractionModel inputInteractionModel) {
      this.inputInteractionModel = inputInteractionModel;
   }

   public void setInteractRotation(final Vector2f interactRotation) {
      this.interactRotation = interactRotation;
   }

   public void setAnalogMoveVector(final Vector2f analogMoveVector) {
      this.analogMoveVector = analogMoveVector;
   }

   public void setPredictedVehicle(final long predictedVehicle) {
      this.predictedVehicle = predictedVehicle;
   }

   public void setVehicleRotation(final Vector2f vehicleRotation) {
      this.vehicleRotation = vehicleRotation;
   }

   public void setCameraOrientation(final Vector3f cameraOrientation) {
      this.cameraOrientation = cameraOrientation;
   }

   public void setRawMoveVector(final Vector2f rawMoveVector) {
      this.rawMoveVector = rawMoveVector;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlayerAuthInputPacket)) {
         return false;
      }

      PlayerAuthInputPacket other = (PlayerAuthInputPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.tick != other.tick) {
         return false;
      }

      if (this.predictedVehicle != other.predictedVehicle) {
         return false;
      }

      Object this$rotation = this.rotation;
      Object other$rotation = other.rotation;
      if (this$rotation == null ? other$rotation == null : this$rotation.equals(other$rotation)) {
         Object this$position = this.position;
         Object other$position = other.position;
         if (this$position == null ? other$position == null : this$position.equals(other$position)) {
            Object this$motion = this.motion;
            Object other$motion = other.motion;
            if (this$motion == null ? other$motion == null : this$motion.equals(other$motion)) {
               Object this$inputData = this.inputData;
               Object other$inputData = other.inputData;
               if (this$inputData == null ? other$inputData == null : this$inputData.equals(other$inputData)) {
                  Object this$inputMode = this.inputMode;
                  Object other$inputMode = other.inputMode;
                  if (this$inputMode == null ? other$inputMode == null : this$inputMode.equals(other$inputMode)) {
                     Object this$playMode = this.playMode;
                     Object other$playMode = other.playMode;
                     if (this$playMode == null ? other$playMode == null : this$playMode.equals(other$playMode)) {
                        Object this$vrGazeDirection = this.vrGazeDirection;
                        Object other$vrGazeDirection = other.vrGazeDirection;
                        if (this$vrGazeDirection == null ? other$vrGazeDirection == null : this$vrGazeDirection.equals(other$vrGazeDirection)) {
                           Object this$delta = this.delta;
                           Object other$delta = other.delta;
                           if (this$delta == null ? other$delta == null : this$delta.equals(other$delta)) {
                              Object this$itemUseTransaction = this.itemUseTransaction;
                              Object other$itemUseTransaction = other.itemUseTransaction;
                              if (this$itemUseTransaction == null ? other$itemUseTransaction == null : this$itemUseTransaction.equals(other$itemUseTransaction)
                                 )
                               {
                                 Object this$itemStackRequest = this.itemStackRequest;
                                 Object other$itemStackRequest = other.itemStackRequest;
                                 if (this$itemStackRequest == null ? other$itemStackRequest == null : this$itemStackRequest.equals(other$itemStackRequest)) {
                                    Object this$playerActions = this.playerActions;
                                    Object other$playerActions = other.playerActions;
                                    if (this$playerActions == null ? other$playerActions == null : this$playerActions.equals(other$playerActions)) {
                                       Object this$inputInteractionModel = this.inputInteractionModel;
                                       Object other$inputInteractionModel = other.inputInteractionModel;
                                       if (this$inputInteractionModel == null
                                          ? other$inputInteractionModel == null
                                          : this$inputInteractionModel.equals(other$inputInteractionModel)) {
                                          Object this$interactRotation = this.interactRotation;
                                          Object other$interactRotation = other.interactRotation;
                                          if (this$interactRotation == null
                                             ? other$interactRotation == null
                                             : this$interactRotation.equals(other$interactRotation)) {
                                             Object this$analogMoveVector = this.analogMoveVector;
                                             Object other$analogMoveVector = other.analogMoveVector;
                                             if (this$analogMoveVector == null
                                                ? other$analogMoveVector == null
                                                : this$analogMoveVector.equals(other$analogMoveVector)) {
                                                Object this$vehicleRotation = this.vehicleRotation;
                                                Object other$vehicleRotation = other.vehicleRotation;
                                                if (this$vehicleRotation == null
                                                   ? other$vehicleRotation == null
                                                   : this$vehicleRotation.equals(other$vehicleRotation)) {
                                                   Object this$cameraOrientation = this.cameraOrientation;
                                                   Object other$cameraOrientation = other.cameraOrientation;
                                                   if (this$cameraOrientation == null
                                                      ? other$cameraOrientation == null
                                                      : this$cameraOrientation.equals(other$cameraOrientation)) {
                                                      Object this$rawMoveVector = this.rawMoveVector;
                                                      Object other$rawMoveVector = other.rawMoveVector;
                                                      return this$rawMoveVector == null
                                                         ? other$rawMoveVector == null
                                                         : this$rawMoveVector.equals(other$rawMoveVector);
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
      return other instanceof PlayerAuthInputPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $tick = this.tick;
      result = result * 59 + (int)($tick >>> 32 ^ $tick);
      long $predictedVehicle = this.predictedVehicle;
      result = result * 59 + (int)($predictedVehicle >>> 32 ^ $predictedVehicle);
      Object $rotation = this.rotation;
      result = result * 59 + ($rotation == null ? 43 : $rotation.hashCode());
      Object $position = this.position;
      result = result * 59 + ($position == null ? 43 : $position.hashCode());
      Object $motion = this.motion;
      result = result * 59 + ($motion == null ? 43 : $motion.hashCode());
      Object $inputData = this.inputData;
      result = result * 59 + ($inputData == null ? 43 : $inputData.hashCode());
      Object $inputMode = this.inputMode;
      result = result * 59 + ($inputMode == null ? 43 : $inputMode.hashCode());
      Object $playMode = this.playMode;
      result = result * 59 + ($playMode == null ? 43 : $playMode.hashCode());
      Object $vrGazeDirection = this.vrGazeDirection;
      result = result * 59 + ($vrGazeDirection == null ? 43 : $vrGazeDirection.hashCode());
      Object $delta = this.delta;
      result = result * 59 + ($delta == null ? 43 : $delta.hashCode());
      Object $itemUseTransaction = this.itemUseTransaction;
      result = result * 59 + ($itemUseTransaction == null ? 43 : $itemUseTransaction.hashCode());
      Object $itemStackRequest = this.itemStackRequest;
      result = result * 59 + ($itemStackRequest == null ? 43 : $itemStackRequest.hashCode());
      Object $playerActions = this.playerActions;
      result = result * 59 + ($playerActions == null ? 43 : $playerActions.hashCode());
      Object $inputInteractionModel = this.inputInteractionModel;
      result = result * 59 + ($inputInteractionModel == null ? 43 : $inputInteractionModel.hashCode());
      Object $interactRotation = this.interactRotation;
      result = result * 59 + ($interactRotation == null ? 43 : $interactRotation.hashCode());
      Object $analogMoveVector = this.analogMoveVector;
      result = result * 59 + ($analogMoveVector == null ? 43 : $analogMoveVector.hashCode());
      Object $vehicleRotation = this.vehicleRotation;
      result = result * 59 + ($vehicleRotation == null ? 43 : $vehicleRotation.hashCode());
      Object $cameraOrientation = this.cameraOrientation;
      result = result * 59 + ($cameraOrientation == null ? 43 : $cameraOrientation.hashCode());
      Object $rawMoveVector = this.rawMoveVector;
      return result * 59 + ($rawMoveVector == null ? 43 : $rawMoveVector.hashCode());
   }

   @Override
   public String toString() {
      return "PlayerAuthInputPacket(rotation="
         + this.rotation
         + ", position="
         + this.position
         + ", motion="
         + this.motion
         + ", inputData="
         + this.inputData
         + ", inputMode="
         + this.inputMode
         + ", playMode="
         + this.playMode
         + ", vrGazeDirection="
         + this.vrGazeDirection
         + ", tick="
         + this.tick
         + ", delta="
         + this.delta
         + ", itemUseTransaction="
         + this.itemUseTransaction
         + ", itemStackRequest="
         + this.itemStackRequest
         + ", playerActions="
         + this.playerActions
         + ", inputInteractionModel="
         + this.inputInteractionModel
         + ", interactRotation="
         + this.interactRotation
         + ", analogMoveVector="
         + this.analogMoveVector
         + ", predictedVehicle="
         + this.predictedVehicle
         + ", vehicleRotation="
         + this.vehicleRotation
         + ", cameraOrientation="
         + this.cameraOrientation
         + ", rawMoveVector="
         + this.rawMoveVector
         + ")";
   }
}
