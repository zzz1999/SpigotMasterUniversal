package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class AddPaintingPacket extends AddHangingEntityPacket {
   private String motive;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.ADD_PAINTING;
   }

   public AddPaintingPacket clone() {
      return (AddPaintingPacket)super.clone();
   }

   public String getMotive() {
      return this.motive;
   }

   public void setMotive(final String motive) {
      this.motive = motive;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AddPaintingPacket)) {
         return false;
      }

      AddPaintingPacket other = (AddPaintingPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$motive = this.motive;
      Object other$motive = other.motive;
      return this$motive == null ? other$motive == null : this$motive.equals(other$motive);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof AddPaintingPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $motive = this.motive;
      return result * 59 + ($motive == null ? 43 : $motive.hashCode());
   }

   @Override
   public String toString() {
      return "AddPaintingPacket(motive=" + this.motive + ")";
   }
}
