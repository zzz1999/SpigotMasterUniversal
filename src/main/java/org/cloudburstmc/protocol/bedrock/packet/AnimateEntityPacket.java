package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongList;
import org.cloudburstmc.protocol.common.PacketSignal;

public class AnimateEntityPacket implements BedrockPacket {
   private String animation;
   private String nextState;
   private String stopExpression;
   private int stopExpressionVersion;
   private String controller;
   private float blendOutTime;
   private final LongList runtimeEntityIds = new LongArrayList();

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.ANIMATE_ENTITY;
   }

   public AnimateEntityPacket clone() {
      try {
         return (AnimateEntityPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public String getAnimation() {
      return this.animation;
   }

   public String getNextState() {
      return this.nextState;
   }

   public String getStopExpression() {
      return this.stopExpression;
   }

   public int getStopExpressionVersion() {
      return this.stopExpressionVersion;
   }

   public String getController() {
      return this.controller;
   }

   public float getBlendOutTime() {
      return this.blendOutTime;
   }

   public LongList getRuntimeEntityIds() {
      return this.runtimeEntityIds;
   }

   public void setAnimation(final String animation) {
      this.animation = animation;
   }

   public void setNextState(final String nextState) {
      this.nextState = nextState;
   }

   public void setStopExpression(final String stopExpression) {
      this.stopExpression = stopExpression;
   }

   public void setStopExpressionVersion(final int stopExpressionVersion) {
      this.stopExpressionVersion = stopExpressionVersion;
   }

   public void setController(final String controller) {
      this.controller = controller;
   }

   public void setBlendOutTime(final float blendOutTime) {
      this.blendOutTime = blendOutTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AnimateEntityPacket)) {
         return false;
      }

      AnimateEntityPacket other = (AnimateEntityPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.stopExpressionVersion != other.stopExpressionVersion) {
         return false;
      }

      if (Float.compare(this.blendOutTime, other.blendOutTime) != 0) {
         return false;
      }

      Object this$animation = this.animation;
      Object other$animation = other.animation;
      if (this$animation == null ? other$animation == null : this$animation.equals(other$animation)) {
         Object this$nextState = this.nextState;
         Object other$nextState = other.nextState;
         if (this$nextState == null ? other$nextState == null : this$nextState.equals(other$nextState)) {
            Object this$stopExpression = this.stopExpression;
            Object other$stopExpression = other.stopExpression;
            if (this$stopExpression == null ? other$stopExpression == null : this$stopExpression.equals(other$stopExpression)) {
               Object this$controller = this.controller;
               Object other$controller = other.controller;
               if (this$controller == null ? other$controller == null : this$controller.equals(other$controller)) {
                  Object this$runtimeEntityIds = this.runtimeEntityIds;
                  Object other$runtimeEntityIds = other.runtimeEntityIds;
                  return this$runtimeEntityIds == null ? other$runtimeEntityIds == null : this$runtimeEntityIds.equals(other$runtimeEntityIds);
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
      return other instanceof AnimateEntityPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.stopExpressionVersion;
      result = result * 59 + Float.floatToIntBits(this.blendOutTime);
      Object $animation = this.animation;
      result = result * 59 + ($animation == null ? 43 : $animation.hashCode());
      Object $nextState = this.nextState;
      result = result * 59 + ($nextState == null ? 43 : $nextState.hashCode());
      Object $stopExpression = this.stopExpression;
      result = result * 59 + ($stopExpression == null ? 43 : $stopExpression.hashCode());
      Object $controller = this.controller;
      result = result * 59 + ($controller == null ? 43 : $controller.hashCode());
      Object $runtimeEntityIds = this.runtimeEntityIds;
      return result * 59 + ($runtimeEntityIds == null ? 43 : $runtimeEntityIds.hashCode());
   }

   @Override
   public String toString() {
      return "AnimateEntityPacket(animation="
         + this.animation
         + ", nextState="
         + this.nextState
         + ", stopExpression="
         + this.stopExpression
         + ", stopExpressionVersion="
         + this.stopExpressionVersion
         + ", controller="
         + this.controller
         + ", blendOutTime="
         + this.blendOutTime
         + ", runtimeEntityIds="
         + this.runtimeEntityIds
         + ")";
   }
}
