package org.cloudburstmc.protocol.bedrock.data.debugshape;

import java.awt.Color;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.cloudburstmc.math.vector.Vector3f;

public final class DebugCircle extends DebugShape {
   private final Integer segments;

   public DebugCircle(
      long id,
      int dimension,
      @Nullable Vector3f position,
      @Nullable Float scale,
      @Nullable Vector3f rotation,
      @Nullable Float totalTimeLeft,
      @Nullable Color color,
      Integer segments
   ) {
      super(id, dimension, position, scale, rotation, totalTimeLeft, color);
      this.segments = segments;
   }

   @Override
   public DebugShape.Type getType() {
      return DebugShape.Type.CIRCLE;
   }

   public Integer getSegments() {
      return this.segments;
   }

   @Override
   public String toString() {
      return "DebugCircle(segments=" + this.getSegments() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DebugCircle)) {
         return false;
      }

      DebugCircle other = (DebugCircle)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$segments = this.getSegments();
      Object other$segments = other.getSegments();
      return this$segments == null ? other$segments == null : this$segments.equals(other$segments);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DebugCircle;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $segments = this.getSegments();
      return result * 59 + ($segments == null ? 43 : $segments.hashCode());
   }
}
