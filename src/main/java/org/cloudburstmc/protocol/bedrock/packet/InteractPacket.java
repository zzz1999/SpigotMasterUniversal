package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.protocol.common.PacketSignal;

public class InteractPacket implements BedrockPacket {
   private InteractPacket.Action action;
   private long runtimeEntityId;
   private Vector3f mousePosition;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.INTERACT;
   }

   public InteractPacket clone() {
      try {
         return (InteractPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public InteractPacket.Action getAction() {
      return this.action;
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public Vector3f getMousePosition() {
      return this.mousePosition;
   }

   public void setAction(final InteractPacket.Action action) {
      this.action = action;
   }

   public void setRuntimeEntityId(final long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setMousePosition(final Vector3f mousePosition) {
      this.mousePosition = mousePosition;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof InteractPacket)) {
         return false;
      } else {
         InteractPacket other = (InteractPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.runtimeEntityId != other.runtimeEntityId) {
            return false;
         } else {
            Object this$action = this.action;
            Object other$action = other.action;
            if (this$action == null ? other$action == null : this$action.equals(other$action)) {
               Object this$mousePosition = this.mousePosition;
               Object other$mousePosition = other.mousePosition;
               return this$mousePosition == null ? other$mousePosition == null : this$mousePosition.equals(other$mousePosition);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InteractPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      Object $action = this.action;
      result = result * 59 + ($action == null ? 43 : $action.hashCode());
      Object $mousePosition = this.mousePosition;
      return result * 59 + ($mousePosition == null ? 43 : $mousePosition.hashCode());
   }

   @Override
   public String toString() {
      return "InteractPacket(action=" + this.action + ", runtimeEntityId=" + this.runtimeEntityId + ", mousePosition=" + this.mousePosition + ")";
   }

   public enum Action {
      NONE,
      INTERACT,
      DAMAGE,
      LEAVE_VEHICLE,
      MOUSEOVER,
      NPC_OPEN,
      OPEN_INVENTORY;
   }
}
