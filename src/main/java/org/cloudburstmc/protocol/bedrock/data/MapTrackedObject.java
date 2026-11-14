package org.cloudburstmc.protocol.bedrock.data;

import org.cloudburstmc.math.vector.Vector3i;

public class MapTrackedObject {
   private final MapTrackedObject.Type type;
   private long entityId;
   private Vector3i position;

   public MapTrackedObject(long entityId) {
      this.type = MapTrackedObject.Type.ENTITY;
      this.entityId = entityId;
   }

   public MapTrackedObject(Vector3i position) {
      this.type = MapTrackedObject.Type.BLOCK;
      this.position = position;
   }

   public MapTrackedObject.Type getType() {
      return this.type;
   }

   public long getEntityId() {
      return this.entityId;
   }

   public Vector3i getPosition() {
      return this.position;
   }

   @Override
   public String toString() {
      return "MapTrackedObject(type=" + this.getType() + ", entityId=" + this.getEntityId() + ", position=" + this.getPosition() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MapTrackedObject)) {
         return false;
      } else {
         MapTrackedObject other = (MapTrackedObject)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.getEntityId() != other.getEntityId()) {
            return false;
         } else {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$position = this.getPosition();
               Object other$position = other.getPosition();
               return this$position == null ? other$position == null : this$position.equals(other$position);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MapTrackedObject;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $entityId = this.getEntityId();
      result = result * 59 + (int)($entityId >>> 32 ^ $entityId);
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $position = this.getPosition();
      return result * 59 + ($position == null ? 43 : $position.hashCode());
   }

   public enum Type {
      ENTITY,
      BLOCK;
   }
}
