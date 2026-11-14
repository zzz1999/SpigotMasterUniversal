package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;
import org.cloudburstmc.math.vector.Vector3f;

public class SpawnExperienceOrbPacket implements BedrockPacket {
   private Vector3f position;
   private int amount;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SPAWN_EXPERIENCE_ORB;
   }

   public Vector3f getPosition() {
      return this.position;
   }

   public int getAmount() {
      return this.amount;
   }

   public void setPosition(Vector3f position) {
      this.position = position;
   }

   public void setAmount(int amount) {
      this.amount = amount;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SpawnExperienceOrbPacket)) {
         return false;
      }

      SpawnExperienceOrbPacket other = (SpawnExperienceOrbPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.amount != other.amount) {
         return false;
      }

      Object this$position = this.position;
      Object other$position = other.position;
      return this$position == null ? other$position == null : this$position.equals(other$position);
   }

   protected boolean canEqual(Object other) {
      return other instanceof SpawnExperienceOrbPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.amount;
      Object $position = this.position;
      return result * 59 + ($position == null ? 43 : $position.hashCode());
   }

   @Override
   public String toString() {
      return "SpawnExperienceOrbPacket(position=" + this.position + ", amount=" + this.amount + ")";
   }
}
