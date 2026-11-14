package org.cloudburstmc.protocol.bedrock.data.debugshape;

import java.awt.Color;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.cloudburstmc.math.vector.Vector3f;

public class DebugShape {
   private final long id;
   private final int dimension;
   private final @Nullable Vector3f position;
   private final @Nullable Float scale;
   private final @Nullable Vector3f rotation;
   private final @Nullable Float totalTimeLeft;
   private final @Nullable Color color;

   public DebugShape(long id) {
      this(id, 0, null, null, null, null, null);
   }

   public DebugShape(long id, int dimension) {
      this(id, dimension, null, null, null, null, null);
   }

   public DebugShape.Type getType() {
      return null;
   }

   public long getId() {
      return this.id;
   }

   public int getDimension() {
      return this.dimension;
   }

   public @Nullable Vector3f getPosition() {
      return this.position;
   }

   public @Nullable Float getScale() {
      return this.scale;
   }

   public @Nullable Vector3f getRotation() {
      return this.rotation;
   }

   public @Nullable Float getTotalTimeLeft() {
      return this.totalTimeLeft;
   }

   public @Nullable Color getColor() {
      return this.color;
   }

   public DebugShape(
      final long id,
      final int dimension,
      final @Nullable Vector3f position,
      final @Nullable Float scale,
      final @Nullable Vector3f rotation,
      final @Nullable Float totalTimeLeft,
      final @Nullable Color color
   ) {
      this.id = id;
      this.dimension = dimension;
      this.position = position;
      this.scale = scale;
      this.rotation = rotation;
      this.totalTimeLeft = totalTimeLeft;
      this.color = color;
   }

   public enum Type {
      LINE,
      BOX,
      SPHERE,
      CIRCLE,
      TEXT,
      ARROW;
   }
}
