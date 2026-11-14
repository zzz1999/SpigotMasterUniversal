package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.inventory.LabTableReactionType;
import com.nukkitx.protocol.bedrock.data.inventory.LabTableType;
import com.nukkitx.protocol.common.PacketSignal;
import org.cloudburstmc.math.vector.Vector3i;

public class LabTablePacket implements BedrockPacket {
   private LabTableType type;
   private Vector3i position;
   private LabTableReactionType reactionType;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.LAB_TABLE;
   }

   public LabTableType getType() {
      return this.type;
   }

   public Vector3i getPosition() {
      return this.position;
   }

   public LabTableReactionType getReactionType() {
      return this.reactionType;
   }

   public void setType(LabTableType type) {
      this.type = type;
   }

   public void setPosition(Vector3i position) {
      this.position = position;
   }

   public void setReactionType(LabTableReactionType reactionType) {
      this.reactionType = reactionType;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LabTablePacket)) {
         return false;
      }

      LabTablePacket other = (LabTablePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.type;
      Object other$type = other.type;
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$position = this.position;
         Object other$position = other.position;
         if (this$position == null ? other$position == null : this$position.equals(other$position)) {
            Object this$reactionType = this.reactionType;
            Object other$reactionType = other.reactionType;
            return this$reactionType == null ? other$reactionType == null : this$reactionType.equals(other$reactionType);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof LabTablePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.type;
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $position = this.position;
      result = result * 59 + ($position == null ? 43 : $position.hashCode());
      Object $reactionType = this.reactionType;
      return result * 59 + ($reactionType == null ? 43 : $reactionType.hashCode());
   }

   @Override
   public String toString() {
      return "LabTablePacket(type=" + this.type + ", position=" + this.position + ", reactionType=" + this.reactionType + ")";
   }
}
