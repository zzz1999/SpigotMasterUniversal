package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.math.vector.Vector3i;
import org.cloudburstmc.protocol.bedrock.data.PlayerActionType;
import org.cloudburstmc.protocol.common.PacketSignal;

public class PlayerActionPacket implements BedrockPacket {
   private long runtimeEntityId;
   private PlayerActionType action;
   private Vector3i blockPosition;
   private Vector3i resultPosition;
   private int face;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.PLAYER_ACTION;
   }

   public PlayerActionPacket clone() {
      try {
         return (PlayerActionPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public PlayerActionType getAction() {
      return this.action;
   }

   public Vector3i getBlockPosition() {
      return this.blockPosition;
   }

   public Vector3i getResultPosition() {
      return this.resultPosition;
   }

   public int getFace() {
      return this.face;
   }

   public void setRuntimeEntityId(final long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setAction(final PlayerActionType action) {
      this.action = action;
   }

   public void setBlockPosition(final Vector3i blockPosition) {
      this.blockPosition = blockPosition;
   }

   public void setResultPosition(final Vector3i resultPosition) {
      this.resultPosition = resultPosition;
   }

   public void setFace(final int face) {
      this.face = face;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlayerActionPacket)) {
         return false;
      }

      PlayerActionPacket other = (PlayerActionPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.runtimeEntityId != other.runtimeEntityId) {
         return false;
      }

      if (this.face != other.face) {
         return false;
      }

      Object this$action = this.action;
      Object other$action = other.action;
      if (this$action == null ? other$action == null : this$action.equals(other$action)) {
         Object this$blockPosition = this.blockPosition;
         Object other$blockPosition = other.blockPosition;
         if (this$blockPosition == null ? other$blockPosition == null : this$blockPosition.equals(other$blockPosition)) {
            Object this$resultPosition = this.resultPosition;
            Object other$resultPosition = other.resultPosition;
            return this$resultPosition == null ? other$resultPosition == null : this$resultPosition.equals(other$resultPosition);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PlayerActionPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      result = result * 59 + this.face;
      Object $action = this.action;
      result = result * 59 + ($action == null ? 43 : $action.hashCode());
      Object $blockPosition = this.blockPosition;
      result = result * 59 + ($blockPosition == null ? 43 : $blockPosition.hashCode());
      Object $resultPosition = this.resultPosition;
      return result * 59 + ($resultPosition == null ? 43 : $resultPosition.hashCode());
   }

   @Override
   public String toString() {
      return "PlayerActionPacket(runtimeEntityId="
         + this.runtimeEntityId
         + ", action="
         + this.action
         + ", blockPosition="
         + this.blockPosition
         + ", resultPosition="
         + this.resultPosition
         + ", face="
         + this.face
         + ")";
   }
}
