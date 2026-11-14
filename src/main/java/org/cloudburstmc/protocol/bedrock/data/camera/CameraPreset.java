package org.cloudburstmc.protocol.bedrock.data.camera;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.cloudburstmc.math.vector.Vector2f;
import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.protocol.bedrock.data.ControlScheme;
import org.cloudburstmc.protocol.common.util.OptionalBoolean;

public class CameraPreset {
   private String identifier;
   private String parentPreset;
   private Vector3f pos;
   private Float yaw;
   private Float pitch;
   private Vector2f viewOffset;
   private Float radius;
   private Float minYawLimit;
   private Float maxYawLimit;
   private CameraAudioListener listener;
   private OptionalBoolean playEffect;
   private Float rotationSpeed;
   private OptionalBoolean snapToTarget;
   private Vector3f entityOffset;
   private Vector2f horizontalRotationLimit;
   private Vector2f verticalRotationLimit;
   private OptionalBoolean continueTargeting;
   /** @deprecated */
   private OptionalBoolean alignTargetAndCameraForward;
   private Float blockListeningRadius;
   private CameraAimAssistPreset aimAssistPreset;
   private @Nullable ControlScheme controlScheme;

   private static String $default$parentPreset() {
      return "";
   }

   private static OptionalBoolean $default$playEffect() {
      return OptionalBoolean.empty();
   }

   private static OptionalBoolean $default$snapToTarget() {
      return OptionalBoolean.empty();
   }

   private static OptionalBoolean $default$continueTargeting() {
      return OptionalBoolean.empty();
   }

   private static OptionalBoolean $default$alignTargetAndCameraForward() {
      return OptionalBoolean.empty();
   }

   public static CameraPreset.CameraPresetBuilder builder() {
      return new CameraPreset.CameraPresetBuilder();
   }

   public String getIdentifier() {
      return this.identifier;
   }

   public String getParentPreset() {
      return this.parentPreset;
   }

   public Vector3f getPos() {
      return this.pos;
   }

   public Float getYaw() {
      return this.yaw;
   }

   public Float getPitch() {
      return this.pitch;
   }

   public Vector2f getViewOffset() {
      return this.viewOffset;
   }

   public Float getRadius() {
      return this.radius;
   }

   public Float getMinYawLimit() {
      return this.minYawLimit;
   }

   public Float getMaxYawLimit() {
      return this.maxYawLimit;
   }

   public CameraAudioListener getListener() {
      return this.listener;
   }

   public OptionalBoolean getPlayEffect() {
      return this.playEffect;
   }

   public Float getRotationSpeed() {
      return this.rotationSpeed;
   }

   public OptionalBoolean getSnapToTarget() {
      return this.snapToTarget;
   }

   public Vector3f getEntityOffset() {
      return this.entityOffset;
   }

   public Vector2f getHorizontalRotationLimit() {
      return this.horizontalRotationLimit;
   }

   public Vector2f getVerticalRotationLimit() {
      return this.verticalRotationLimit;
   }

   public OptionalBoolean getContinueTargeting() {
      return this.continueTargeting;
   }

   @Deprecated
   public OptionalBoolean getAlignTargetAndCameraForward() {
      return this.alignTargetAndCameraForward;
   }

   public Float getBlockListeningRadius() {
      return this.blockListeningRadius;
   }

   public CameraAimAssistPreset getAimAssistPreset() {
      return this.aimAssistPreset;
   }

   public @Nullable ControlScheme getControlScheme() {
      return this.controlScheme;
   }

   public void setIdentifier(final String identifier) {
      this.identifier = identifier;
   }

   public void setParentPreset(final String parentPreset) {
      this.parentPreset = parentPreset;
   }

   public void setPos(final Vector3f pos) {
      this.pos = pos;
   }

   public void setYaw(final Float yaw) {
      this.yaw = yaw;
   }

   public void setPitch(final Float pitch) {
      this.pitch = pitch;
   }

   public void setViewOffset(final Vector2f viewOffset) {
      this.viewOffset = viewOffset;
   }

   public void setRadius(final Float radius) {
      this.radius = radius;
   }

   public void setMinYawLimit(final Float minYawLimit) {
      this.minYawLimit = minYawLimit;
   }

   public void setMaxYawLimit(final Float maxYawLimit) {
      this.maxYawLimit = maxYawLimit;
   }

   public void setListener(final CameraAudioListener listener) {
      this.listener = listener;
   }

   public void setPlayEffect(final OptionalBoolean playEffect) {
      this.playEffect = playEffect;
   }

   public void setRotationSpeed(final Float rotationSpeed) {
      this.rotationSpeed = rotationSpeed;
   }

   public void setSnapToTarget(final OptionalBoolean snapToTarget) {
      this.snapToTarget = snapToTarget;
   }

   public void setEntityOffset(final Vector3f entityOffset) {
      this.entityOffset = entityOffset;
   }

   public void setHorizontalRotationLimit(final Vector2f horizontalRotationLimit) {
      this.horizontalRotationLimit = horizontalRotationLimit;
   }

   public void setVerticalRotationLimit(final Vector2f verticalRotationLimit) {
      this.verticalRotationLimit = verticalRotationLimit;
   }

   public void setContinueTargeting(final OptionalBoolean continueTargeting) {
      this.continueTargeting = continueTargeting;
   }

   @Deprecated
   public void setAlignTargetAndCameraForward(final OptionalBoolean alignTargetAndCameraForward) {
      this.alignTargetAndCameraForward = alignTargetAndCameraForward;
   }

   public void setBlockListeningRadius(final Float blockListeningRadius) {
      this.blockListeningRadius = blockListeningRadius;
   }

   public void setAimAssistPreset(final CameraAimAssistPreset aimAssistPreset) {
      this.aimAssistPreset = aimAssistPreset;
   }

   public void setControlScheme(final @Nullable ControlScheme controlScheme) {
      this.controlScheme = controlScheme;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CameraPreset)) {
         return false;
      }

      CameraPreset other = (CameraPreset)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$yaw = this.getYaw();
      Object other$yaw = other.getYaw();
      if (this$yaw == null ? other$yaw == null : this$yaw.equals(other$yaw)) {
         Object this$pitch = this.getPitch();
         Object other$pitch = other.getPitch();
         if (this$pitch == null ? other$pitch == null : this$pitch.equals(other$pitch)) {
            Object this$radius = this.getRadius();
            Object other$radius = other.getRadius();
            if (this$radius == null ? other$radius == null : this$radius.equals(other$radius)) {
               Object this$minYawLimit = this.getMinYawLimit();
               Object other$minYawLimit = other.getMinYawLimit();
               if (this$minYawLimit == null ? other$minYawLimit == null : this$minYawLimit.equals(other$minYawLimit)) {
                  Object this$maxYawLimit = this.getMaxYawLimit();
                  Object other$maxYawLimit = other.getMaxYawLimit();
                  if (this$maxYawLimit == null ? other$maxYawLimit == null : this$maxYawLimit.equals(other$maxYawLimit)) {
                     Object this$rotationSpeed = this.getRotationSpeed();
                     Object other$rotationSpeed = other.getRotationSpeed();
                     if (this$rotationSpeed == null ? other$rotationSpeed == null : this$rotationSpeed.equals(other$rotationSpeed)) {
                        Object this$blockListeningRadius = this.getBlockListeningRadius();
                        Object other$blockListeningRadius = other.getBlockListeningRadius();
                        if (this$blockListeningRadius == null
                           ? other$blockListeningRadius == null
                           : this$blockListeningRadius.equals(other$blockListeningRadius)) {
                           Object this$identifier = this.getIdentifier();
                           Object other$identifier = other.getIdentifier();
                           if (this$identifier == null ? other$identifier == null : this$identifier.equals(other$identifier)) {
                              Object this$parentPreset = this.getParentPreset();
                              Object other$parentPreset = other.getParentPreset();
                              if (this$parentPreset == null ? other$parentPreset == null : this$parentPreset.equals(other$parentPreset)) {
                                 Object this$pos = this.getPos();
                                 Object other$pos = other.getPos();
                                 if (this$pos == null ? other$pos == null : this$pos.equals(other$pos)) {
                                    Object this$viewOffset = this.getViewOffset();
                                    Object other$viewOffset = other.getViewOffset();
                                    if (this$viewOffset == null ? other$viewOffset == null : this$viewOffset.equals(other$viewOffset)) {
                                       Object this$listener = this.getListener();
                                       Object other$listener = other.getListener();
                                       if (this$listener == null ? other$listener == null : this$listener.equals(other$listener)) {
                                          Object this$playEffect = this.getPlayEffect();
                                          Object other$playEffect = other.getPlayEffect();
                                          if (this$playEffect == null ? other$playEffect == null : this$playEffect.equals(other$playEffect)) {
                                             Object this$snapToTarget = this.getSnapToTarget();
                                             Object other$snapToTarget = other.getSnapToTarget();
                                             if (this$snapToTarget == null ? other$snapToTarget == null : this$snapToTarget.equals(other$snapToTarget)) {
                                                Object this$entityOffset = this.getEntityOffset();
                                                Object other$entityOffset = other.getEntityOffset();
                                                if (this$entityOffset == null ? other$entityOffset == null : this$entityOffset.equals(other$entityOffset)) {
                                                   Object this$horizontalRotationLimit = this.getHorizontalRotationLimit();
                                                   Object other$horizontalRotationLimit = other.getHorizontalRotationLimit();
                                                   if (this$horizontalRotationLimit == null
                                                      ? other$horizontalRotationLimit == null
                                                      : this$horizontalRotationLimit.equals(other$horizontalRotationLimit)) {
                                                      Object this$verticalRotationLimit = this.getVerticalRotationLimit();
                                                      Object other$verticalRotationLimit = other.getVerticalRotationLimit();
                                                      if (this$verticalRotationLimit == null
                                                         ? other$verticalRotationLimit == null
                                                         : this$verticalRotationLimit.equals(other$verticalRotationLimit)) {
                                                         Object this$continueTargeting = this.getContinueTargeting();
                                                         Object other$continueTargeting = other.getContinueTargeting();
                                                         if (this$continueTargeting == null
                                                            ? other$continueTargeting == null
                                                            : this$continueTargeting.equals(other$continueTargeting)) {
                                                            Object this$alignTargetAndCameraForward = this.getAlignTargetAndCameraForward();
                                                            Object other$alignTargetAndCameraForward = other.getAlignTargetAndCameraForward();
                                                            if (this$alignTargetAndCameraForward == null
                                                               ? other$alignTargetAndCameraForward == null
                                                               : this$alignTargetAndCameraForward.equals(other$alignTargetAndCameraForward)) {
                                                               Object this$aimAssistPreset = this.getAimAssistPreset();
                                                               Object other$aimAssistPreset = other.getAimAssistPreset();
                                                               if (this$aimAssistPreset == null
                                                                  ? other$aimAssistPreset == null
                                                                  : this$aimAssistPreset.equals(other$aimAssistPreset)) {
                                                                  Object this$controlScheme = this.getControlScheme();
                                                                  Object other$controlScheme = other.getControlScheme();
                                                                  return this$controlScheme == null
                                                                     ? other$controlScheme == null
                                                                     : this$controlScheme.equals(other$controlScheme);
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
      return other instanceof CameraPreset;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $yaw = this.getYaw();
      result = result * 59 + ($yaw == null ? 43 : $yaw.hashCode());
      Object $pitch = this.getPitch();
      result = result * 59 + ($pitch == null ? 43 : $pitch.hashCode());
      Object $radius = this.getRadius();
      result = result * 59 + ($radius == null ? 43 : $radius.hashCode());
      Object $minYawLimit = this.getMinYawLimit();
      result = result * 59 + ($minYawLimit == null ? 43 : $minYawLimit.hashCode());
      Object $maxYawLimit = this.getMaxYawLimit();
      result = result * 59 + ($maxYawLimit == null ? 43 : $maxYawLimit.hashCode());
      Object $rotationSpeed = this.getRotationSpeed();
      result = result * 59 + ($rotationSpeed == null ? 43 : $rotationSpeed.hashCode());
      Object $blockListeningRadius = this.getBlockListeningRadius();
      result = result * 59 + ($blockListeningRadius == null ? 43 : $blockListeningRadius.hashCode());
      Object $identifier = this.getIdentifier();
      result = result * 59 + ($identifier == null ? 43 : $identifier.hashCode());
      Object $parentPreset = this.getParentPreset();
      result = result * 59 + ($parentPreset == null ? 43 : $parentPreset.hashCode());
      Object $pos = this.getPos();
      result = result * 59 + ($pos == null ? 43 : $pos.hashCode());
      Object $viewOffset = this.getViewOffset();
      result = result * 59 + ($viewOffset == null ? 43 : $viewOffset.hashCode());
      Object $listener = this.getListener();
      result = result * 59 + ($listener == null ? 43 : $listener.hashCode());
      Object $playEffect = this.getPlayEffect();
      result = result * 59 + ($playEffect == null ? 43 : $playEffect.hashCode());
      Object $snapToTarget = this.getSnapToTarget();
      result = result * 59 + ($snapToTarget == null ? 43 : $snapToTarget.hashCode());
      Object $entityOffset = this.getEntityOffset();
      result = result * 59 + ($entityOffset == null ? 43 : $entityOffset.hashCode());
      Object $horizontalRotationLimit = this.getHorizontalRotationLimit();
      result = result * 59 + ($horizontalRotationLimit == null ? 43 : $horizontalRotationLimit.hashCode());
      Object $verticalRotationLimit = this.getVerticalRotationLimit();
      result = result * 59 + ($verticalRotationLimit == null ? 43 : $verticalRotationLimit.hashCode());
      Object $continueTargeting = this.getContinueTargeting();
      result = result * 59 + ($continueTargeting == null ? 43 : $continueTargeting.hashCode());
      Object $alignTargetAndCameraForward = this.getAlignTargetAndCameraForward();
      result = result * 59 + ($alignTargetAndCameraForward == null ? 43 : $alignTargetAndCameraForward.hashCode());
      Object $aimAssistPreset = this.getAimAssistPreset();
      result = result * 59 + ($aimAssistPreset == null ? 43 : $aimAssistPreset.hashCode());
      Object $controlScheme = this.getControlScheme();
      return result * 59 + ($controlScheme == null ? 43 : $controlScheme.hashCode());
   }

   @Override
   public String toString() {
      return "CameraPreset(identifier="
         + this.getIdentifier()
         + ", parentPreset="
         + this.getParentPreset()
         + ", pos="
         + this.getPos()
         + ", yaw="
         + this.getYaw()
         + ", pitch="
         + this.getPitch()
         + ", viewOffset="
         + this.getViewOffset()
         + ", radius="
         + this.getRadius()
         + ", minYawLimit="
         + this.getMinYawLimit()
         + ", maxYawLimit="
         + this.getMaxYawLimit()
         + ", listener="
         + this.getListener()
         + ", playEffect="
         + this.getPlayEffect()
         + ", rotationSpeed="
         + this.getRotationSpeed()
         + ", snapToTarget="
         + this.getSnapToTarget()
         + ", entityOffset="
         + this.getEntityOffset()
         + ", horizontalRotationLimit="
         + this.getHorizontalRotationLimit()
         + ", verticalRotationLimit="
         + this.getVerticalRotationLimit()
         + ", continueTargeting="
         + this.getContinueTargeting()
         + ", alignTargetAndCameraForward="
         + this.getAlignTargetAndCameraForward()
         + ", blockListeningRadius="
         + this.getBlockListeningRadius()
         + ", aimAssistPreset="
         + this.getAimAssistPreset()
         + ", controlScheme="
         + this.getControlScheme()
         + ")";
   }

   public CameraPreset(
      final String identifier,
      final String parentPreset,
      final Vector3f pos,
      final Float yaw,
      final Float pitch,
      final Vector2f viewOffset,
      final Float radius,
      final Float minYawLimit,
      final Float maxYawLimit,
      final CameraAudioListener listener,
      final OptionalBoolean playEffect,
      final Float rotationSpeed,
      final OptionalBoolean snapToTarget,
      final Vector3f entityOffset,
      final Vector2f horizontalRotationLimit,
      final Vector2f verticalRotationLimit,
      final OptionalBoolean continueTargeting,
      final OptionalBoolean alignTargetAndCameraForward,
      final Float blockListeningRadius,
      final CameraAimAssistPreset aimAssistPreset,
      final @Nullable ControlScheme controlScheme
   ) {
      this.identifier = identifier;
      this.parentPreset = parentPreset;
      this.pos = pos;
      this.yaw = yaw;
      this.pitch = pitch;
      this.viewOffset = viewOffset;
      this.radius = radius;
      this.minYawLimit = minYawLimit;
      this.maxYawLimit = maxYawLimit;
      this.listener = listener;
      this.playEffect = playEffect;
      this.rotationSpeed = rotationSpeed;
      this.snapToTarget = snapToTarget;
      this.entityOffset = entityOffset;
      this.horizontalRotationLimit = horizontalRotationLimit;
      this.verticalRotationLimit = verticalRotationLimit;
      this.continueTargeting = continueTargeting;
      this.alignTargetAndCameraForward = alignTargetAndCameraForward;
      this.blockListeningRadius = blockListeningRadius;
      this.aimAssistPreset = aimAssistPreset;
      this.controlScheme = controlScheme;
   }

   public CameraPreset() {
      this.parentPreset = $default$parentPreset();
      this.playEffect = $default$playEffect();
      this.snapToTarget = $default$snapToTarget();
      this.continueTargeting = $default$continueTargeting();
      this.alignTargetAndCameraForward = $default$alignTargetAndCameraForward();
   }

   public static class CameraPresetBuilder {
      private String identifier;
      private boolean parentPreset$set;
      private String parentPreset$value;
      private Vector3f pos;
      private Float yaw;
      private Float pitch;
      private Vector2f viewOffset;
      private Float radius;
      private Float minYawLimit;
      private Float maxYawLimit;
      private CameraAudioListener listener;
      private boolean playEffect$set;
      private OptionalBoolean playEffect$value;
      private Float rotationSpeed;
      private boolean snapToTarget$set;
      private OptionalBoolean snapToTarget$value;
      private Vector3f entityOffset;
      private Vector2f horizontalRotationLimit;
      private Vector2f verticalRotationLimit;
      private boolean continueTargeting$set;
      private OptionalBoolean continueTargeting$value;
      private boolean alignTargetAndCameraForward$set;
      private OptionalBoolean alignTargetAndCameraForward$value;
      private Float blockListeningRadius;
      private CameraAimAssistPreset aimAssistPreset;
      private ControlScheme controlScheme;

      CameraPresetBuilder() {
      }

      public CameraPreset.CameraPresetBuilder identifier(final String identifier) {
         this.identifier = identifier;
         return this;
      }

      public CameraPreset.CameraPresetBuilder parentPreset(final String parentPreset) {
         this.parentPreset$value = parentPreset;
         this.parentPreset$set = true;
         return this;
      }

      public CameraPreset.CameraPresetBuilder pos(final Vector3f pos) {
         this.pos = pos;
         return this;
      }

      public CameraPreset.CameraPresetBuilder yaw(final Float yaw) {
         this.yaw = yaw;
         return this;
      }

      public CameraPreset.CameraPresetBuilder pitch(final Float pitch) {
         this.pitch = pitch;
         return this;
      }

      public CameraPreset.CameraPresetBuilder viewOffset(final Vector2f viewOffset) {
         this.viewOffset = viewOffset;
         return this;
      }

      public CameraPreset.CameraPresetBuilder radius(final Float radius) {
         this.radius = radius;
         return this;
      }

      public CameraPreset.CameraPresetBuilder minYawLimit(final Float minYawLimit) {
         this.minYawLimit = minYawLimit;
         return this;
      }

      public CameraPreset.CameraPresetBuilder maxYawLimit(final Float maxYawLimit) {
         this.maxYawLimit = maxYawLimit;
         return this;
      }

      public CameraPreset.CameraPresetBuilder listener(final CameraAudioListener listener) {
         this.listener = listener;
         return this;
      }

      public CameraPreset.CameraPresetBuilder playEffect(final OptionalBoolean playEffect) {
         this.playEffect$value = playEffect;
         this.playEffect$set = true;
         return this;
      }

      public CameraPreset.CameraPresetBuilder rotationSpeed(final Float rotationSpeed) {
         this.rotationSpeed = rotationSpeed;
         return this;
      }

      public CameraPreset.CameraPresetBuilder snapToTarget(final OptionalBoolean snapToTarget) {
         this.snapToTarget$value = snapToTarget;
         this.snapToTarget$set = true;
         return this;
      }

      public CameraPreset.CameraPresetBuilder entityOffset(final Vector3f entityOffset) {
         this.entityOffset = entityOffset;
         return this;
      }

      public CameraPreset.CameraPresetBuilder horizontalRotationLimit(final Vector2f horizontalRotationLimit) {
         this.horizontalRotationLimit = horizontalRotationLimit;
         return this;
      }

      public CameraPreset.CameraPresetBuilder verticalRotationLimit(final Vector2f verticalRotationLimit) {
         this.verticalRotationLimit = verticalRotationLimit;
         return this;
      }

      public CameraPreset.CameraPresetBuilder continueTargeting(final OptionalBoolean continueTargeting) {
         this.continueTargeting$value = continueTargeting;
         this.continueTargeting$set = true;
         return this;
      }

      @Deprecated
      public CameraPreset.CameraPresetBuilder alignTargetAndCameraForward(final OptionalBoolean alignTargetAndCameraForward) {
         this.alignTargetAndCameraForward$value = alignTargetAndCameraForward;
         this.alignTargetAndCameraForward$set = true;
         return this;
      }

      public CameraPreset.CameraPresetBuilder blockListeningRadius(final Float blockListeningRadius) {
         this.blockListeningRadius = blockListeningRadius;
         return this;
      }

      public CameraPreset.CameraPresetBuilder aimAssistPreset(final CameraAimAssistPreset aimAssistPreset) {
         this.aimAssistPreset = aimAssistPreset;
         return this;
      }

      public CameraPreset.CameraPresetBuilder controlScheme(final @Nullable ControlScheme controlScheme) {
         this.controlScheme = controlScheme;
         return this;
      }

      public CameraPreset build() {
         String parentPreset$value = this.parentPreset$value;
         if (!this.parentPreset$set) {
            parentPreset$value = CameraPreset.$default$parentPreset();
         }

         OptionalBoolean playEffect$value = this.playEffect$value;
         if (!this.playEffect$set) {
            playEffect$value = CameraPreset.$default$playEffect();
         }

         OptionalBoolean snapToTarget$value = this.snapToTarget$value;
         if (!this.snapToTarget$set) {
            snapToTarget$value = CameraPreset.$default$snapToTarget();
         }

         OptionalBoolean continueTargeting$value = this.continueTargeting$value;
         if (!this.continueTargeting$set) {
            continueTargeting$value = CameraPreset.$default$continueTargeting();
         }

         OptionalBoolean alignTargetAndCameraForward$value = this.alignTargetAndCameraForward$value;
         if (!this.alignTargetAndCameraForward$set) {
            alignTargetAndCameraForward$value = CameraPreset.$default$alignTargetAndCameraForward();
         }

         return new CameraPreset(
            this.identifier,
            parentPreset$value,
            this.pos,
            this.yaw,
            this.pitch,
            this.viewOffset,
            this.radius,
            this.minYawLimit,
            this.maxYawLimit,
            this.listener,
            playEffect$value,
            this.rotationSpeed,
            snapToTarget$value,
            this.entityOffset,
            this.horizontalRotationLimit,
            this.verticalRotationLimit,
            continueTargeting$value,
            alignTargetAndCameraForward$value,
            this.blockListeningRadius,
            this.aimAssistPreset,
            this.controlScheme
         );
      }

      @Override
      public String toString() {
         return "CameraPreset.CameraPresetBuilder(identifier="
            + this.identifier
            + ", parentPreset$value="
            + this.parentPreset$value
            + ", pos="
            + this.pos
            + ", yaw="
            + this.yaw
            + ", pitch="
            + this.pitch
            + ", viewOffset="
            + this.viewOffset
            + ", radius="
            + this.radius
            + ", minYawLimit="
            + this.minYawLimit
            + ", maxYawLimit="
            + this.maxYawLimit
            + ", listener="
            + this.listener
            + ", playEffect$value="
            + this.playEffect$value
            + ", rotationSpeed="
            + this.rotationSpeed
            + ", snapToTarget$value="
            + this.snapToTarget$value
            + ", entityOffset="
            + this.entityOffset
            + ", horizontalRotationLimit="
            + this.horizontalRotationLimit
            + ", verticalRotationLimit="
            + this.verticalRotationLimit
            + ", continueTargeting$value="
            + this.continueTargeting$value
            + ", alignTargetAndCameraForward$value="
            + this.alignTargetAndCameraForward$value
            + ", blockListeningRadius="
            + this.blockListeningRadius
            + ", aimAssistPreset="
            + this.aimAssistPreset
            + ", controlScheme="
            + this.controlScheme
            + ")";
      }
   }
}
