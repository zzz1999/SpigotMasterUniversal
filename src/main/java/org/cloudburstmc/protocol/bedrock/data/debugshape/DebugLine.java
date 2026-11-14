package org.cloudburstmc.protocol.bedrock.data.debugshape;

import java.awt.Color;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.cloudburstmc.math.vector.Vector3f;

public final class DebugLine extends DebugShape {
   private final Vector3f lineEndPosition;

   public DebugLine(
      long id,
      int dimension,
      @Nullable Vector3f position,
      @Nullable Float scale,
      @Nullable Vector3f rotation,
      @Nullable Float totalTimeLeft,
      @Nullable Color color,
      Vector3f lineEndPosition
   ) {
      super(id, dimension, position, scale, rotation, totalTimeLeft, color);
      this.lineEndPosition = lineEndPosition;
   }

   @Override
   public DebugShape.Type getType() {
      return DebugShape.Type.LINE;
   }

   public Vector3f getLineEndPosition() {
      return this.lineEndPosition;
   }

   @Override
   public String toString() {
      return "DebugLine(lineEndPosition=" + this.getLineEndPosition() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DebugLine)) {
         return false;
      }

      DebugLine other = (DebugLine)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$lineEndPosition = this.getLineEndPosition();
      Object other$lineEndPosition = other.getLineEndPosition();
      return this$lineEndPosition == null ? other$lineEndPosition == null : this$lineEndPosition.equals(other$lineEndPosition);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DebugLine;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $lineEndPosition = this.getLineEndPosition();
      return result * 59 + ($lineEndPosition == null ? 43 : $lineEndPosition.hashCode());
   }
}
