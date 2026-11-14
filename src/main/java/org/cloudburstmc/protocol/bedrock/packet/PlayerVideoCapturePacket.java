package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class PlayerVideoCapturePacket implements BedrockPacket {
   private PlayerVideoCapturePacket.Action action;
   private int frameRate;
   private String filePrefix;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.PLAYER_VIDEO_CAPTURE;
   }

   @Override
   public BedrockPacket clone() {
      try {
         return (PlayerVideoCapturePacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public PlayerVideoCapturePacket.Action getAction() {
      return this.action;
   }

   public int getFrameRate() {
      return this.frameRate;
   }

   public String getFilePrefix() {
      return this.filePrefix;
   }

   public void setAction(final PlayerVideoCapturePacket.Action action) {
      this.action = action;
   }

   public void setFrameRate(final int frameRate) {
      this.frameRate = frameRate;
   }

   public void setFilePrefix(final String filePrefix) {
      this.filePrefix = filePrefix;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof PlayerVideoCapturePacket)) {
         return false;
      } else {
         PlayerVideoCapturePacket other = (PlayerVideoCapturePacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.frameRate != other.frameRate) {
            return false;
         } else {
            Object this$action = this.action;
            Object other$action = other.action;
            if (this$action == null ? other$action == null : this$action.equals(other$action)) {
               Object this$filePrefix = this.filePrefix;
               Object other$filePrefix = other.filePrefix;
               return this$filePrefix == null ? other$filePrefix == null : this$filePrefix.equals(other$filePrefix);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PlayerVideoCapturePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.frameRate;
      Object $action = this.action;
      result = result * 59 + ($action == null ? 43 : $action.hashCode());
      Object $filePrefix = this.filePrefix;
      return result * 59 + ($filePrefix == null ? 43 : $filePrefix.hashCode());
   }

   @Override
   public String toString() {
      return "PlayerVideoCapturePacket(action=" + this.action + ", frameRate=" + this.frameRate + ", filePrefix=" + this.filePrefix + ")";
   }

   public enum Action {
      STOP_VIDEO_CAPTURE,
      START_VIDEO_CAPTURE,
      UNKNOWN;
   }
}
