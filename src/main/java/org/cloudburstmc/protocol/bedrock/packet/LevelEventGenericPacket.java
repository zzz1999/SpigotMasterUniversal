package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.LevelEventType;
import org.cloudburstmc.protocol.common.PacketSignal;

public class LevelEventGenericPacket implements BedrockPacket {
   private LevelEventType type;
   private Object tag;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.LEVEL_EVENT_GENERIC;
   }

   public LevelEventGenericPacket clone() {
      try {
         return (LevelEventGenericPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public LevelEventType getType() {
      return this.type;
   }

   public Object getTag() {
      return this.tag;
   }

   public void setType(final LevelEventType type) {
      this.type = type;
   }

   public void setTag(final Object tag) {
      this.tag = tag;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof LevelEventGenericPacket)) {
         return false;
      } else {
         LevelEventGenericPacket other = (LevelEventGenericPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$type = this.type;
            Object other$type = other.type;
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$tag = this.tag;
               Object other$tag = other.tag;
               return this$tag == null ? other$tag == null : this$tag.equals(other$tag);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof LevelEventGenericPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.type;
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $tag = this.tag;
      return result * 59 + ($tag == null ? 43 : $tag.hashCode());
   }

   @Override
   public String toString() {
      return "LevelEventGenericPacket(type=" + this.type + ", tag=" + this.tag + ")";
   }
}
