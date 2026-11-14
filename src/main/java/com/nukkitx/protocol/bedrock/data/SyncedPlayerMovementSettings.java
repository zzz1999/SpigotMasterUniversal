package com.nukkitx.protocol.bedrock.data;

public class SyncedPlayerMovementSettings {
   private AuthoritativeMovementMode movementMode;
   private int rewindHistorySize;
   boolean serverAuthoritativeBlockBreaking;

   public AuthoritativeMovementMode getMovementMode() {
      return this.movementMode;
   }

   public int getRewindHistorySize() {
      return this.rewindHistorySize;
   }

   public boolean isServerAuthoritativeBlockBreaking() {
      return this.serverAuthoritativeBlockBreaking;
   }

   public void setMovementMode(AuthoritativeMovementMode movementMode) {
      this.movementMode = movementMode;
   }

   public void setRewindHistorySize(int rewindHistorySize) {
      this.rewindHistorySize = rewindHistorySize;
   }

   public void setServerAuthoritativeBlockBreaking(boolean serverAuthoritativeBlockBreaking) {
      this.serverAuthoritativeBlockBreaking = serverAuthoritativeBlockBreaking;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SyncedPlayerMovementSettings)) {
         return false;
      }

      SyncedPlayerMovementSettings other = (SyncedPlayerMovementSettings)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getRewindHistorySize() != other.getRewindHistorySize()) {
         return false;
      }

      if (this.isServerAuthoritativeBlockBreaking() != other.isServerAuthoritativeBlockBreaking()) {
         return false;
      }

      Object this$movementMode = this.getMovementMode();
      Object other$movementMode = other.getMovementMode();
      return this$movementMode == null ? other$movementMode == null : this$movementMode.equals(other$movementMode);
   }

   protected boolean canEqual(Object other) {
      return other instanceof SyncedPlayerMovementSettings;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getRewindHistorySize();
      result = result * 59 + (this.isServerAuthoritativeBlockBreaking() ? 79 : 97);
      Object $movementMode = this.getMovementMode();
      return result * 59 + ($movementMode == null ? 43 : $movementMode.hashCode());
   }

   @Override
   public String toString() {
      return "SyncedPlayerMovementSettings(movementMode="
         + this.getMovementMode()
         + ", rewindHistorySize="
         + this.getRewindHistorySize()
         + ", serverAuthoritativeBlockBreaking="
         + this.isServerAuthoritativeBlockBreaking()
         + ")";
   }
}
