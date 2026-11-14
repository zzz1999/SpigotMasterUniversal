package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.math.vector.Vector3i;

public class ExplodePacket implements BedrockPacket {
   private final List<Vector3i> records = new ObjectArrayList<>();
   private Vector3f position;
   private float radius;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.EXPLODE;
   }

   public List<Vector3i> getRecords() {
      return this.records;
   }

   public Vector3f getPosition() {
      return this.position;
   }

   public float getRadius() {
      return this.radius;
   }

   public void setPosition(Vector3f position) {
      this.position = position;
   }

   public void setRadius(float radius) {
      this.radius = radius;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ExplodePacket)) {
         return false;
      } else {
         ExplodePacket other = (ExplodePacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (Float.compare(this.radius, other.radius) != 0) {
            return false;
         } else {
            Object this$records = this.records;
            Object other$records = other.records;
            if (this$records == null ? other$records == null : this$records.equals(other$records)) {
               Object this$position = this.position;
               Object other$position = other.position;
               return this$position == null ? other$position == null : this$position.equals(other$position);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof ExplodePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + Float.floatToIntBits(this.radius);
      Object $records = this.records;
      result = result * 59 + ($records == null ? 43 : $records.hashCode());
      Object $position = this.position;
      return result * 59 + ($position == null ? 43 : $position.hashCode());
   }

   @Override
   public String toString() {
      return "ExplodePacket(records=" + this.records + ", position=" + this.position + ", radius=" + this.radius + ")";
   }
}
