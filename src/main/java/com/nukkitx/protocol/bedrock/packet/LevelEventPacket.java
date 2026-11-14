package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.LevelEventType;
import com.nukkitx.protocol.common.PacketSignal;
import org.cloudburstmc.math.vector.Vector3f;

public class LevelEventPacket implements BedrockPacket {
   private LevelEventType type;
   private Vector3f position;
   private int data;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.LEVEL_EVENT;
   }

   public LevelEventType getType() {
      return this.type;
   }

   public Vector3f getPosition() {
      return this.position;
   }

   public int getData() {
      return this.data;
   }

   public void setType(LevelEventType type) {
      this.type = type;
   }

   public void setPosition(Vector3f position) {
      this.position = position;
   }

   public void setData(int data) {
      this.data = data;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof LevelEventPacket)) {
         return false;
      } else {
         LevelEventPacket other = (LevelEventPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.data != other.data) {
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

   protected boolean canEqual(Object other) {
      return other instanceof LevelEventPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.data;
      Object $type = this.type;
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $position = this.position;
      return result * 59 + ($position == null ? 43 : $position.hashCode());
   }

   @Override
   public String toString() {
      return "LevelEventPacket(type=" + this.type + ", position=" + this.position + ", data=" + this.data + ")";
   }
}
