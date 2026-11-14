package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongList;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Arrays;
import java.util.List;
import org.cloudburstmc.math.vector.Vector3i;
import org.cloudburstmc.protocol.bedrock.data.MapDecoration;
import org.cloudburstmc.protocol.bedrock.data.MapTrackedObject;
import org.cloudburstmc.protocol.common.PacketSignal;

public class ClientboundMapItemDataPacket implements BedrockPacket {
   private final LongList trackedEntityIds = new LongArrayList();
   private final List<MapTrackedObject> trackedObjects = new ObjectArrayList<>();
   private final List<MapDecoration> decorations = new ObjectArrayList<>();
   private long uniqueMapId;
   private int dimensionId;
   private boolean locked;
   private Vector3i origin;
   private int scale;
   private int height;
   private int width;
   private int xOffset;
   private int yOffset;
   private int[] colors;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CLIENTBOUND_MAP_ITEM_DATA;
   }

   public ClientboundMapItemDataPacket clone() {
      try {
         return (ClientboundMapItemDataPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public LongList getTrackedEntityIds() {
      return this.trackedEntityIds;
   }

   public List<MapTrackedObject> getTrackedObjects() {
      return this.trackedObjects;
   }

   public List<MapDecoration> getDecorations() {
      return this.decorations;
   }

   public long getUniqueMapId() {
      return this.uniqueMapId;
   }

   public int getDimensionId() {
      return this.dimensionId;
   }

   public boolean isLocked() {
      return this.locked;
   }

   public Vector3i getOrigin() {
      return this.origin;
   }

   public int getScale() {
      return this.scale;
   }

   public int getHeight() {
      return this.height;
   }

   public int getWidth() {
      return this.width;
   }

   public int getXOffset() {
      return this.xOffset;
   }

   public int getYOffset() {
      return this.yOffset;
   }

   public int[] getColors() {
      return this.colors;
   }

   public void setUniqueMapId(final long uniqueMapId) {
      this.uniqueMapId = uniqueMapId;
   }

   public void setDimensionId(final int dimensionId) {
      this.dimensionId = dimensionId;
   }

   public void setLocked(final boolean locked) {
      this.locked = locked;
   }

   public void setOrigin(final Vector3i origin) {
      this.origin = origin;
   }

   public void setScale(final int scale) {
      this.scale = scale;
   }

   public void setHeight(final int height) {
      this.height = height;
   }

   public void setWidth(final int width) {
      this.width = width;
   }

   public void setXOffset(final int xOffset) {
      this.xOffset = xOffset;
   }

   public void setYOffset(final int yOffset) {
      this.yOffset = yOffset;
   }

   public void setColors(final int[] colors) {
      this.colors = colors;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ClientboundMapItemDataPacket)) {
         return false;
      }

      ClientboundMapItemDataPacket other = (ClientboundMapItemDataPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.uniqueMapId != other.uniqueMapId) {
         return false;
      }

      if (this.dimensionId != other.dimensionId) {
         return false;
      }

      if (this.locked != other.locked) {
         return false;
      }

      if (this.scale != other.scale) {
         return false;
      }

      if (this.height != other.height) {
         return false;
      }

      if (this.width != other.width) {
         return false;
      }

      if (this.xOffset != other.xOffset) {
         return false;
      }

      if (this.yOffset != other.yOffset) {
         return false;
      }

      Object this$trackedEntityIds = this.trackedEntityIds;
      Object other$trackedEntityIds = other.trackedEntityIds;
      if (this$trackedEntityIds == null ? other$trackedEntityIds == null : this$trackedEntityIds.equals(other$trackedEntityIds)) {
         Object this$trackedObjects = this.trackedObjects;
         Object other$trackedObjects = other.trackedObjects;
         if (this$trackedObjects == null ? other$trackedObjects == null : this$trackedObjects.equals(other$trackedObjects)) {
            Object this$decorations = this.decorations;
            Object other$decorations = other.decorations;
            if (this$decorations == null ? other$decorations == null : this$decorations.equals(other$decorations)) {
               Object this$origin = this.origin;
               Object other$origin = other.origin;
               return (this$origin == null ? other$origin == null : this$origin.equals(other$origin)) ? Arrays.equals(this.colors, other.colors) : false;
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
      return other instanceof ClientboundMapItemDataPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $uniqueMapId = this.uniqueMapId;
      result = result * 59 + (int)($uniqueMapId >>> 32 ^ $uniqueMapId);
      result = result * 59 + this.dimensionId;
      result = result * 59 + (this.locked ? 79 : 97);
      result = result * 59 + this.scale;
      result = result * 59 + this.height;
      result = result * 59 + this.width;
      result = result * 59 + this.xOffset;
      result = result * 59 + this.yOffset;
      Object $trackedEntityIds = this.trackedEntityIds;
      result = result * 59 + ($trackedEntityIds == null ? 43 : $trackedEntityIds.hashCode());
      Object $trackedObjects = this.trackedObjects;
      result = result * 59 + ($trackedObjects == null ? 43 : $trackedObjects.hashCode());
      Object $decorations = this.decorations;
      result = result * 59 + ($decorations == null ? 43 : $decorations.hashCode());
      Object $origin = this.origin;
      result = result * 59 + ($origin == null ? 43 : $origin.hashCode());
      return result * 59 + Arrays.hashCode(this.colors);
   }

   @Override
   public String toString() {
      return "ClientboundMapItemDataPacket(trackedEntityIds="
         + this.trackedEntityIds
         + ", trackedObjects="
         + this.trackedObjects
         + ", decorations="
         + this.decorations
         + ", uniqueMapId="
         + this.uniqueMapId
         + ", dimensionId="
         + this.dimensionId
         + ", locked="
         + this.locked
         + ", origin="
         + this.origin
         + ", scale="
         + this.scale
         + ", height="
         + this.height
         + ", width="
         + this.width
         + ", xOffset="
         + this.xOffset
         + ", yOffset="
         + this.yOffset
         + ", colors="
         + Arrays.toString(this.colors)
         + ")";
   }
}
