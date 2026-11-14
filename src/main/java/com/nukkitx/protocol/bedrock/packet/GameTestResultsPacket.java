package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class GameTestResultsPacket implements BedrockPacket {
   private boolean successful;
   private String error;
   private String testName;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.GAME_TEST_RESULTS;
   }

   public boolean isSuccessful() {
      return this.successful;
   }

   public String getError() {
      return this.error;
   }

   public String getTestName() {
      return this.testName;
   }

   public void setSuccessful(boolean successful) {
      this.successful = successful;
   }

   public void setError(String error) {
      this.error = error;
   }

   public void setTestName(String testName) {
      this.testName = testName;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof GameTestResultsPacket)) {
         return false;
      } else {
         GameTestResultsPacket other = (GameTestResultsPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.successful != other.successful) {
            return false;
         } else {
            Object this$error = this.error;
            Object other$error = other.error;
            if (this$error == null ? other$error == null : this$error.equals(other$error)) {
               Object this$testName = this.testName;
               Object other$testName = other.testName;
               return this$testName == null ? other$testName == null : this$testName.equals(other$testName);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof GameTestResultsPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.successful ? 79 : 97);
      Object $error = this.error;
      result = result * 59 + ($error == null ? 43 : $error.hashCode());
      Object $testName = this.testName;
      return result * 59 + ($testName == null ? 43 : $testName.hashCode());
   }

   @Override
   public String toString() {
      return "GameTestResultsPacket(successful=" + this.successful + ", error=" + this.error + ", testName=" + this.testName + ")";
   }
}
