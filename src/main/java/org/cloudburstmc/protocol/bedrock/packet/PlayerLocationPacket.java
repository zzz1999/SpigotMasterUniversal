package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.protocol.common.PacketSignal;

public class PlayerLocationPacket implements BedrockPacket {
   private PlayerLocationPacket.Type type;
   private long targetEntityId;
   private Vector3f position;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.PLAYER_LOCATION;
   }

   @Override
   public BedrockPacket clone() {
      try {
         return (PlayerLocationPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public PlayerLocationPacket.Type getType() {
      return this.type;
   }

   public long getTargetEntityId() {
      return this.targetEntityId;
   }

   public Vector3f getPosition() {
      return this.position;
   }

   public void setType(final PlayerLocationPacket.Type type) {
      this.type = type;
   }

   public void setTargetEntityId(final long targetEntityId) {
      this.targetEntityId = targetEntityId;
   }

   public void setPosition(final Vector3f position) {
      this.position = position;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof PlayerLocationPacket)) {
         return false;
      } else {
         PlayerLocationPacket other = (PlayerLocationPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.targetEntityId != other.targetEntityId) {
            return false;
         } else {
            Object this$type = this.type;
            Object other$type = other.type;
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
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
      return other instanceof PlayerLocationPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $targetEntityId = this.targetEntityId;
      result = result * 59 + (int)($targetEntityId >>> 32 ^ $targetEntityId);
      Object $type = this.type;
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $position = this.position;
      return result * 59 + ($position == null ? 43 : $position.hashCode());
   }

   @Override
   public String toString() {
      return "PlayerLocationPacket(type=" + this.type + ", targetEntityId=" + this.targetEntityId + ", position=" + this.position + ")";
   }

   public enum Type {
      COORDINATES,
      HIDE;
   }
}
