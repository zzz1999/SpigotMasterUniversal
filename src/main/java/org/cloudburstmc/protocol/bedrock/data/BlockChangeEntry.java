package org.cloudburstmc.protocol.bedrock.data;

import org.cloudburstmc.math.vector.Vector3i;
import org.cloudburstmc.protocol.bedrock.data.definitions.BlockDefinition;

public final class BlockChangeEntry {
   private final Vector3i position;
   private final BlockDefinition definition;
   private final int updateFlags;
   private final long messageEntityId;
   private final BlockChangeEntry.MessageType messageType;

   public BlockChangeEntry(
      final Vector3i position,
      final BlockDefinition definition,
      final int updateFlags,
      final long messageEntityId,
      final BlockChangeEntry.MessageType messageType
   ) {
      this.position = position;
      this.definition = definition;
      this.updateFlags = updateFlags;
      this.messageEntityId = messageEntityId;
      this.messageType = messageType;
   }

   public Vector3i getPosition() {
      return this.position;
   }

   public BlockDefinition getDefinition() {
      return this.definition;
   }

   public int getUpdateFlags() {
      return this.updateFlags;
   }

   public long getMessageEntityId() {
      return this.messageEntityId;
   }

   public BlockChangeEntry.MessageType getMessageType() {
      return this.messageType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BlockChangeEntry)) {
         return false;
      }

      BlockChangeEntry other = (BlockChangeEntry)o;
      if (this.getUpdateFlags() != other.getUpdateFlags()) {
         return false;
      }

      if (this.getMessageEntityId() != other.getMessageEntityId()) {
         return false;
      }

      Object this$position = this.getPosition();
      Object other$position = other.getPosition();
      if (this$position == null ? other$position == null : this$position.equals(other$position)) {
         Object this$definition = this.getDefinition();
         Object other$definition = other.getDefinition();
         if (this$definition == null ? other$definition == null : this$definition.equals(other$definition)) {
            Object this$messageType = this.getMessageType();
            Object other$messageType = other.getMessageType();
            return this$messageType == null ? other$messageType == null : this$messageType.equals(other$messageType);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getUpdateFlags();
      long $messageEntityId = this.getMessageEntityId();
      result = result * 59 + (int)($messageEntityId >>> 32 ^ $messageEntityId);
      Object $position = this.getPosition();
      result = result * 59 + ($position == null ? 43 : $position.hashCode());
      Object $definition = this.getDefinition();
      result = result * 59 + ($definition == null ? 43 : $definition.hashCode());
      Object $messageType = this.getMessageType();
      return result * 59 + ($messageType == null ? 43 : $messageType.hashCode());
   }

   @Override
   public String toString() {
      return "BlockChangeEntry(position="
         + this.getPosition()
         + ", definition="
         + this.getDefinition()
         + ", updateFlags="
         + this.getUpdateFlags()
         + ", messageEntityId="
         + this.getMessageEntityId()
         + ", messageType="
         + this.getMessageType()
         + ")";
   }

   public enum MessageType {
      NONE,
      CREATE,
      DESTROY;
   }
}
