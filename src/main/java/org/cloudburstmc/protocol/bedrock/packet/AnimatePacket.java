package org.cloudburstmc.protocol.bedrock.packet;

import java.util.HashMap;
import org.cloudburstmc.protocol.common.PacketSignal;

public class AnimatePacket implements BedrockPacket {
   /** @deprecated */
   private float rowingTime;
   private AnimatePacket.Action action;
   private long runtimeEntityId;
   private float data;
   private AnimatePacket.SwingSource swingSource = AnimatePacket.SwingSource.NONE;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.ANIMATE;
   }

   public AnimatePacket clone() {
      try {
         return (AnimatePacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   @Deprecated
   public float getRowingTime() {
      return this.rowingTime;
   }

   public AnimatePacket.Action getAction() {
      return this.action;
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public float getData() {
      return this.data;
   }

   public AnimatePacket.SwingSource getSwingSource() {
      return this.swingSource;
   }

   @Deprecated
   public void setRowingTime(final float rowingTime) {
      this.rowingTime = rowingTime;
   }

   public void setAction(final AnimatePacket.Action action) {
      this.action = action;
   }

   public void setRuntimeEntityId(final long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setData(final float data) {
      this.data = data;
   }

   public void setSwingSource(final AnimatePacket.SwingSource swingSource) {
      this.swingSource = swingSource;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AnimatePacket)) {
         return false;
      } else {
         AnimatePacket other = (AnimatePacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (Float.compare(this.rowingTime, other.rowingTime) != 0) {
            return false;
         } else if (this.runtimeEntityId != other.runtimeEntityId) {
            return false;
         } else if (Float.compare(this.data, other.data) != 0) {
            return false;
         } else {
            Object this$action = this.action;
            Object other$action = other.action;
            if (this$action == null ? other$action == null : this$action.equals(other$action)) {
               Object this$swingSource = this.swingSource;
               Object other$swingSource = other.swingSource;
               return this$swingSource == null ? other$swingSource == null : this$swingSource.equals(other$swingSource);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AnimatePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + Float.floatToIntBits(this.rowingTime);
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      result = result * 59 + Float.floatToIntBits(this.data);
      Object $action = this.action;
      result = result * 59 + ($action == null ? 43 : $action.hashCode());
      Object $swingSource = this.swingSource;
      return result * 59 + ($swingSource == null ? 43 : $swingSource.hashCode());
   }

   @Override
   public String toString() {
      return "AnimatePacket(rowingTime="
         + this.rowingTime
         + ", action="
         + this.action
         + ", runtimeEntityId="
         + this.runtimeEntityId
         + ", data="
         + this.data
         + ", swingSource="
         + this.swingSource
         + ")";
   }

   public enum Action {
      NO_ACTION,
      SWING_ARM,
      WAKE_UP,
      CRITICAL_HIT,
      MAGIC_CRITICAL_HIT,
      /** @deprecated */
      ROW_RIGHT,
      /** @deprecated */
      ROW_LEFT;
   }

   public enum SwingSource {
      NONE("none"),
      BUILD("build"),
      MINE("mine"),
      INTERACT("interact"),
      ATTACK("attack"),
      USE_ITEM("useitem"),
      THROW_ITEM("throwitem"),
      DROP_ITEM("dropitem"),
      EVENT("event");

      private static final HashMap<String, AnimatePacket.SwingSource> BY_NAME = new HashMap<>();
      private final String name;

      SwingSource(String name) {
         this.name = name;
      }

      public static AnimatePacket.SwingSource from(String name) {
         return BY_NAME.get(name);
      }

      public String getName() {
         return this.name;
      }

      static {
         for (AnimatePacket.SwingSource value : values()) {
            BY_NAME.put(value.name, value);
         }
      }
   }
}
