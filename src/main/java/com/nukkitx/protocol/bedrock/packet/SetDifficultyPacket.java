package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class SetDifficultyPacket implements BedrockPacket {
   private int difficulty;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SET_DIFFICULTY;
   }

   public int getDifficulty() {
      return this.difficulty;
   }

   public void setDifficulty(int difficulty) {
      this.difficulty = difficulty;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SetDifficultyPacket)) {
         return false;
      }

      SetDifficultyPacket other = (SetDifficultyPacket)o;
      return !other.canEqual(this) ? false : this.difficulty == other.difficulty;
   }

   protected boolean canEqual(Object other) {
      return other instanceof SetDifficultyPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      return result * 59 + this.difficulty;
   }

   @Override
   public String toString() {
      return "SetDifficultyPacket(difficulty=" + this.difficulty + ")";
   }
}
