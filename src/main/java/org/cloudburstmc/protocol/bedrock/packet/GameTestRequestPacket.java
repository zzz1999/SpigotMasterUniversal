package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.math.vector.Vector3i;
import org.cloudburstmc.protocol.common.PacketSignal;

public class GameTestRequestPacket implements BedrockPacket {
   private int maxTestsPerBatch;
   private int repeatCount;
   private int rotation;
   private boolean stoppingOnFailure;
   private Vector3i testPos;
   private int testsPerRow;
   private String testName;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.GAME_TEST_REQUEST;
   }

   public GameTestRequestPacket clone() {
      try {
         return (GameTestRequestPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public int getMaxTestsPerBatch() {
      return this.maxTestsPerBatch;
   }

   public int getRepeatCount() {
      return this.repeatCount;
   }

   public int getRotation() {
      return this.rotation;
   }

   public boolean isStoppingOnFailure() {
      return this.stoppingOnFailure;
   }

   public Vector3i getTestPos() {
      return this.testPos;
   }

   public int getTestsPerRow() {
      return this.testsPerRow;
   }

   public String getTestName() {
      return this.testName;
   }

   public void setMaxTestsPerBatch(final int maxTestsPerBatch) {
      this.maxTestsPerBatch = maxTestsPerBatch;
   }

   public void setRepeatCount(final int repeatCount) {
      this.repeatCount = repeatCount;
   }

   public void setRotation(final int rotation) {
      this.rotation = rotation;
   }

   public void setStoppingOnFailure(final boolean stoppingOnFailure) {
      this.stoppingOnFailure = stoppingOnFailure;
   }

   public void setTestPos(final Vector3i testPos) {
      this.testPos = testPos;
   }

   public void setTestsPerRow(final int testsPerRow) {
      this.testsPerRow = testsPerRow;
   }

   public void setTestName(final String testName) {
      this.testName = testName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof GameTestRequestPacket)) {
         return false;
      } else {
         GameTestRequestPacket other = (GameTestRequestPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.maxTestsPerBatch != other.maxTestsPerBatch) {
            return false;
         } else if (this.repeatCount != other.repeatCount) {
            return false;
         } else if (this.rotation != other.rotation) {
            return false;
         } else if (this.stoppingOnFailure != other.stoppingOnFailure) {
            return false;
         } else if (this.testsPerRow != other.testsPerRow) {
            return false;
         } else {
            Object this$testPos = this.testPos;
            Object other$testPos = other.testPos;
            if (this$testPos == null ? other$testPos == null : this$testPos.equals(other$testPos)) {
               Object this$testName = this.testName;
               Object other$testName = other.testName;
               return this$testName == null ? other$testName == null : this$testName.equals(other$testName);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof GameTestRequestPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.maxTestsPerBatch;
      result = result * 59 + this.repeatCount;
      result = result * 59 + this.rotation;
      result = result * 59 + (this.stoppingOnFailure ? 79 : 97);
      result = result * 59 + this.testsPerRow;
      Object $testPos = this.testPos;
      result = result * 59 + ($testPos == null ? 43 : $testPos.hashCode());
      Object $testName = this.testName;
      return result * 59 + ($testName == null ? 43 : $testName.hashCode());
   }

   @Override
   public String toString() {
      return "GameTestRequestPacket(maxTestsPerBatch="
         + this.maxTestsPerBatch
         + ", repeatCount="
         + this.repeatCount
         + ", rotation="
         + this.rotation
         + ", stoppingOnFailure="
         + this.stoppingOnFailure
         + ", testPos="
         + this.testPos
         + ", testsPerRow="
         + this.testsPerRow
         + ", testName="
         + this.testName
         + ")";
   }
}
