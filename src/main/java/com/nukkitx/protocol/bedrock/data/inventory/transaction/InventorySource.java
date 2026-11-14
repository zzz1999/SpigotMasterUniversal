package com.nukkitx.protocol.bedrock.data.inventory.transaction;

import com.nukkitx.protocol.common.util.Preconditions;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class InventorySource {
   private static final InventorySource CREATIVE_SOURCE = new InventorySource(InventorySource.Type.CREATIVE, -1, InventorySource.Flag.NONE);
   private static final InventorySource GLOBAL_SOURCE = new InventorySource(InventorySource.Type.GLOBAL, -1, InventorySource.Flag.NONE);
   private static final InventorySource INVALID_SOURCE = new InventorySource(InventorySource.Type.INVALID, -1, InventorySource.Flag.NONE);
   private final InventorySource.Type type;
   private final int containerId;
   private final InventorySource.Flag flag;

   public static InventorySource fromContainerWindowId(int containerId) {
      Preconditions.checkNotNull(containerId, "containerId");
      return new InventorySource(InventorySource.Type.CONTAINER, containerId, InventorySource.Flag.NONE);
   }

   public static InventorySource fromCreativeInventory() {
      return CREATIVE_SOURCE;
   }

   public static InventorySource fromGlobalInventory() {
      return GLOBAL_SOURCE;
   }

   public static InventorySource fromInvalid() {
      return INVALID_SOURCE;
   }

   public static InventorySource fromNonImplementedTodo(int containerId) {
      Preconditions.checkNotNull(containerId, "containerId");
      return new InventorySource(InventorySource.Type.NON_IMPLEMENTED_TODO, containerId, InventorySource.Flag.NONE);
   }

   public static InventorySource fromUntrackedInteractionUI(int containerId) {
      Preconditions.checkNotNull(containerId, "containerId");
      return new InventorySource(InventorySource.Type.UNTRACKED_INTERACTION_UI, containerId, InventorySource.Flag.NONE);
   }

   public static InventorySource fromWorldInteraction(InventorySource.@NonNull Flag flag) {
      Preconditions.checkNotNull(flag, "flag");
      return new InventorySource(InventorySource.Type.WORLD_INTERACTION, -1, flag);
   }

   public InventorySource.Type getType() {
      return this.type;
   }

   public int getContainerId() {
      return this.containerId;
   }

   public InventorySource.Flag getFlag() {
      return this.flag;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof InventorySource)) {
         return false;
      } else {
         InventorySource other = (InventorySource)o;
         if (this.getContainerId() != other.getContainerId()) {
            return false;
         } else {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$flag = this.getFlag();
               Object other$flag = other.getFlag();
               return this$flag == null ? other$flag == null : this$flag.equals(other$flag);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getContainerId();
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $flag = this.getFlag();
      return result * 59 + ($flag == null ? 43 : $flag.hashCode());
   }

   @Override
   public String toString() {
      return "InventorySource(type=" + this.getType() + ", containerId=" + this.getContainerId() + ", flag=" + this.getFlag() + ")";
   }

   private InventorySource(InventorySource.Type type, int containerId, InventorySource.Flag flag) {
      this.type = type;
      this.containerId = containerId;
      this.flag = flag;
   }

   public enum Flag {
      DROP_ITEM,
      PICKUP_ITEM,
      NONE;
   }

   public enum Type {
      INVALID(-1),
      CONTAINER(0),
      GLOBAL(1),
      WORLD_INTERACTION(2),
      CREATIVE(3),
      UNTRACKED_INTERACTION_UI(100),
      NON_IMPLEMENTED_TODO(99999);

      private static final Int2ObjectMap<InventorySource.Type> BY_ID = new Int2ObjectOpenHashMap<>(6);
      private final int id;

      Type(int id) {
         this.id = id;
      }

      public static InventorySource.Type byId(int id) {
         InventorySource.Type type = BY_ID.get(id);
         return type == null ? INVALID : type;
      }

      public int id() {
         return this.id;
      }

      static {
         for (InventorySource.Type type : values()) {
            BY_ID.put(type.id, type);
         }
      }
   }
}
