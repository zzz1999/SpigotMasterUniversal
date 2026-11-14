package org.cloudburstmc.protocol.bedrock.data.debugshape;

import java.awt.Color;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.cloudburstmc.math.vector.Vector3f;

public final class DebugBox extends DebugShape {
   private final Vector3f boxBounds;

   public DebugBox(
      long id,
      int dimension,
      @Nullable Vector3f position,
      @Nullable Float scale,
      @Nullable Vector3f rotation,
      @Nullable Float totalTimeLeft,
      @Nullable Color color,
      Vector3f boxBounds
   ) {
      super(id, dimension, position, scale, rotation, totalTimeLeft, color);
      this.boxBounds = boxBounds;
   }

   @Override
   public DebugShape.Type getType() {
      return DebugShape.Type.BOX;
   }

   public Vector3f getBoxBounds() {
      return this.boxBounds;
   }

   @Override
   public String toString() {
      return "DebugBox(boxBounds=" + this.getBoxBounds() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DebugBox)) {
         return false;
      }

      DebugBox other = (DebugBox)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$boxBounds = this.getBoxBounds();
      Object other$boxBounds = other.getBoxBounds();
      return this$boxBounds == null ? other$boxBounds == null : this$boxBounds.equals(other$boxBounds);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DebugBox;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $boxBounds = this.getBoxBounds();
      return result * 59 + ($boxBounds == null ? 43 : $boxBounds.hashCode());
   }
}
