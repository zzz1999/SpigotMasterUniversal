package org.cloudburstmc.protocol.bedrock.data.debugshape;

import java.awt.Color;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.cloudburstmc.math.vector.Vector3f;

public final class DebugArrow extends DebugShape {
   private final @Nullable Vector3f arrowEndPosition;
   private final @Nullable Float arrowHeadLength;
   private final @Nullable Float arrowHeadRadius;
   private final @Nullable Integer arrowHeadSegments;

   public DebugArrow(
      long id,
      int dimension,
      @Nullable Vector3f position,
      @Nullable Float scale,
      @Nullable Vector3f rotation,
      @Nullable Float totalTimeLeft,
      @Nullable Color color,
      @Nullable Vector3f arrowEndPosition,
      @Nullable Float arrowHeadLength,
      @Nullable Float arrowHeadRadius,
      @Nullable Integer arrowHeadSegments
   ) {
      super(id, dimension, position, scale, rotation, totalTimeLeft, color);
      this.arrowEndPosition = arrowEndPosition;
      this.arrowHeadLength = arrowHeadLength;
      this.arrowHeadRadius = arrowHeadRadius;
      this.arrowHeadSegments = arrowHeadSegments;
   }

   @Override
   public DebugShape.Type getType() {
      return DebugShape.Type.ARROW;
   }

   public @Nullable Vector3f getArrowEndPosition() {
      return this.arrowEndPosition;
   }

   public @Nullable Float getArrowHeadLength() {
      return this.arrowHeadLength;
   }

   public @Nullable Float getArrowHeadRadius() {
      return this.arrowHeadRadius;
   }

   public @Nullable Integer getArrowHeadSegments() {
      return this.arrowHeadSegments;
   }

   @Override
   public String toString() {
      return "DebugArrow(arrowEndPosition="
         + this.getArrowEndPosition()
         + ", arrowHeadLength="
         + this.getArrowHeadLength()
         + ", arrowHeadRadius="
         + this.getArrowHeadRadius()
         + ", arrowHeadSegments="
         + this.getArrowHeadSegments()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DebugArrow)) {
         return false;
      }

      DebugArrow other = (DebugArrow)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$arrowHeadLength = this.getArrowHeadLength();
      Object other$arrowHeadLength = other.getArrowHeadLength();
      if (this$arrowHeadLength == null ? other$arrowHeadLength == null : this$arrowHeadLength.equals(other$arrowHeadLength)) {
         Object this$arrowHeadRadius = this.getArrowHeadRadius();
         Object other$arrowHeadRadius = other.getArrowHeadRadius();
         if (this$arrowHeadRadius == null ? other$arrowHeadRadius == null : this$arrowHeadRadius.equals(other$arrowHeadRadius)) {
            Object this$arrowHeadSegments = this.getArrowHeadSegments();
            Object other$arrowHeadSegments = other.getArrowHeadSegments();
            if (this$arrowHeadSegments == null ? other$arrowHeadSegments == null : this$arrowHeadSegments.equals(other$arrowHeadSegments)) {
               Object this$arrowEndPosition = this.getArrowEndPosition();
               Object other$arrowEndPosition = other.getArrowEndPosition();
               return this$arrowEndPosition == null ? other$arrowEndPosition == null : this$arrowEndPosition.equals(other$arrowEndPosition);
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DebugArrow;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $arrowHeadLength = this.getArrowHeadLength();
      result = result * 59 + ($arrowHeadLength == null ? 43 : $arrowHeadLength.hashCode());
      Object $arrowHeadRadius = this.getArrowHeadRadius();
      result = result * 59 + ($arrowHeadRadius == null ? 43 : $arrowHeadRadius.hashCode());
      Object $arrowHeadSegments = this.getArrowHeadSegments();
      result = result * 59 + ($arrowHeadSegments == null ? 43 : $arrowHeadSegments.hashCode());
      Object $arrowEndPosition = this.getArrowEndPosition();
      return result * 59 + ($arrowEndPosition == null ? 43 : $arrowEndPosition.hashCode());
   }
}
