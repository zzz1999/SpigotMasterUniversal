package com.nukkitx.protocol.bedrock.data;

import org.cloudburstmc.math.vector.Vector3i;

public class PlayerBlockActionData {
   PlayerActionType action;
   Vector3i blockPosition;
   int face;

   public PlayerActionType getAction() {
      return this.action;
   }

   public Vector3i getBlockPosition() {
      return this.blockPosition;
   }

   public int getFace() {
      return this.face;
   }

   public void setAction(PlayerActionType action) {
      this.action = action;
   }

   public void setBlockPosition(Vector3i blockPosition) {
      this.blockPosition = blockPosition;
   }

   public void setFace(int face) {
      this.face = face;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof PlayerBlockActionData)) {
         return false;
      } else {
         PlayerBlockActionData other = (PlayerBlockActionData)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.getFace() != other.getFace()) {
            return false;
         } else {
            Object this$action = this.getAction();
            Object other$action = other.getAction();
            if (this$action == null ? other$action == null : this$action.equals(other$action)) {
               Object this$blockPosition = this.getBlockPosition();
               Object other$blockPosition = other.getBlockPosition();
               return this$blockPosition == null ? other$blockPosition == null : this$blockPosition.equals(other$blockPosition);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof PlayerBlockActionData;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getFace();
      Object $action = this.getAction();
      result = result * 59 + ($action == null ? 43 : $action.hashCode());
      Object $blockPosition = this.getBlockPosition();
      return result * 59 + ($blockPosition == null ? 43 : $blockPosition.hashCode());
   }

   @Override
   public String toString() {
      return "PlayerBlockActionData(action=" + this.getAction() + ", blockPosition=" + this.getBlockPosition() + ", face=" + this.getFace() + ")";
   }
}
