package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.protocol.common.PacketSignal;

public class ServerPlayerPostMovePositionPacket implements BedrockPacket {
   private Vector3f position;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SERVER_PLAYER_POST_MOVE_POSITION;
   }

   public ServerPlayerPostMovePositionPacket clone() {
      try {
         return (ServerPlayerPostMovePositionPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError();
      }
   }

   public Vector3f getPosition() {
      return this.position;
   }

   public void setPosition(final Vector3f position) {
      this.position = position;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ServerPlayerPostMovePositionPacket)) {
         return false;
      }

      ServerPlayerPostMovePositionPacket other = (ServerPlayerPostMovePositionPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$position = this.position;
      Object other$position = other.position;
      return this$position == null ? other$position == null : this$position.equals(other$position);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ServerPlayerPostMovePositionPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $position = this.position;
      return result * 59 + ($position == null ? 43 : $position.hashCode());
   }

   @Override
   public String toString() {
      return "ServerPlayerPostMovePositionPacket(position=" + this.position + ")";
   }
}
