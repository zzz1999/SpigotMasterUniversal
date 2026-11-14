package com.nukkitx.protocol.bedrock.data.entity;

public final class EntityLinkData {
   private final long from;
   private final long to;
   private final EntityLinkData.Type type;
   private final boolean immediate;
   private final boolean riderInitiated;

   @Deprecated
   public EntityLinkData(long from, long to, EntityLinkData.Type type, boolean immediate) {
      this(from, to, type, immediate, false);
   }

   public long getFrom() {
      return this.from;
   }

   public long getTo() {
      return this.to;
   }

   public EntityLinkData.Type getType() {
      return this.type;
   }

   public boolean isImmediate() {
      return this.immediate;
   }

   public boolean isRiderInitiated() {
      return this.riderInitiated;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EntityLinkData)) {
         return false;
      }

      EntityLinkData other = (EntityLinkData)o;
      if (this.getFrom() != other.getFrom()) {
         return false;
      }

      if (this.getTo() != other.getTo()) {
         return false;
      }

      if (this.isImmediate() != other.isImmediate()) {
         return false;
      }

      if (this.isRiderInitiated() != other.isRiderInitiated()) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      return this$type == null ? other$type == null : this$type.equals(other$type);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $from = this.getFrom();
      result = result * 59 + (int)($from >>> 32 ^ $from);
      long $to = this.getTo();
      result = result * 59 + (int)($to >>> 32 ^ $to);
      result = result * 59 + (this.isImmediate() ? 79 : 97);
      result = result * 59 + (this.isRiderInitiated() ? 79 : 97);
      Object $type = this.getType();
      return result * 59 + ($type == null ? 43 : $type.hashCode());
   }

   @Override
   public String toString() {
      return "EntityLinkData(from="
         + this.getFrom()
         + ", to="
         + this.getTo()
         + ", type="
         + this.getType()
         + ", immediate="
         + this.isImmediate()
         + ", riderInitiated="
         + this.isRiderInitiated()
         + ")";
   }

   public EntityLinkData(long from, long to, EntityLinkData.Type type, boolean immediate, boolean riderInitiated) {
      this.from = from;
      this.to = to;
      this.type = type;
      this.immediate = immediate;
      this.riderInitiated = riderInitiated;
   }

   public enum Type {
      REMOVE,
      RIDER,
      PASSENGER;

      private static final EntityLinkData.Type[] VALUES = values();

      public static EntityLinkData.Type byId(int id) {
         if (id >= 0 && id < VALUES.length) {
            return VALUES[id];
         } else {
            throw new UnsupportedOperationException("Unknown EntityLinkData.Type ID: " + id);
         }
      }
   }
}
