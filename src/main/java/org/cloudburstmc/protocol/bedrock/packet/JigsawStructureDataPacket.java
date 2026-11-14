package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.nbt.NbtMap;
import org.cloudburstmc.protocol.common.PacketSignal;

public class JigsawStructureDataPacket implements BedrockPacket {
   private NbtMap jigsawStructureDataTag;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.JIGSAW_STRUCTURE_DATA;
   }

   public JigsawStructureDataPacket clone() {
      try {
         return (JigsawStructureDataPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public NbtMap getJigsawStructureDataTag() {
      return this.jigsawStructureDataTag;
   }

   public void setJigsawStructureDataTag(final NbtMap jigsawStructureDataTag) {
      this.jigsawStructureDataTag = jigsawStructureDataTag;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof JigsawStructureDataPacket)) {
         return false;
      }

      JigsawStructureDataPacket other = (JigsawStructureDataPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$jigsawStructureDataTag = this.jigsawStructureDataTag;
      Object other$jigsawStructureDataTag = other.jigsawStructureDataTag;
      return this$jigsawStructureDataTag == null ? other$jigsawStructureDataTag == null : this$jigsawStructureDataTag.equals(other$jigsawStructureDataTag);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof JigsawStructureDataPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $jigsawStructureDataTag = this.jigsawStructureDataTag;
      return result * 59 + ($jigsawStructureDataTag == null ? 43 : $jigsawStructureDataTag.hashCode());
   }

   @Override
   public String toString() {
      return "JigsawStructureDataPacket(jigsawStructureDataTag=" + this.jigsawStructureDataTag + ")";
   }
}
