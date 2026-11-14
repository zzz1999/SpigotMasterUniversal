package org.cloudburstmc.protocol.bedrock.data.debugshape;

import java.awt.Color;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.cloudburstmc.math.vector.Vector3f;

public final class DebugText extends DebugShape {
   private final String text;

   public DebugText(
      long id,
      int dimension,
      @Nullable Vector3f position,
      @Nullable Float scale,
      @Nullable Vector3f rotation,
      @Nullable Float totalTimeLeft,
      @Nullable Color color,
      String text
   ) {
      super(id, dimension, position, scale, rotation, totalTimeLeft, color);
      this.text = text;
   }

   @Override
   public DebugShape.Type getType() {
      return DebugShape.Type.TEXT;
   }

   public String getText() {
      return this.text;
   }

   @Override
   public String toString() {
      return "DebugText(text=" + this.getText() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DebugText)) {
         return false;
      }

      DebugText other = (DebugText)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$text = this.getText();
      Object other$text = other.getText();
      return this$text == null ? other$text == null : this$text.equals(other$text);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DebugText;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $text = this.getText();
      return result * 59 + ($text == null ? 43 : $text.hashCode());
   }
}
