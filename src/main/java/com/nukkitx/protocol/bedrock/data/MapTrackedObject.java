package com.nukkitx.protocol.bedrock.data;

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

   public enum Type {
      ENTITY,
      BLOCK;
   }
}
