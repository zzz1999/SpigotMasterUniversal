package org.cloudburstmc.protocol.bedrock.data;

public class EncodingSettings {
   public static final EncodingSettings DEFAULT = builder()
      .maxListSize(1536)
      .maxByteArraySize(1048576)
      .maxNetworkNBTSize(536870912)
      .maxItemNBTSize(102400)
      .maxStringLength(32768)
      .maxGeometryDataSize(524288)
      .maxItemStackTagLength(64)
      .maxInventoryActionsOrRequests(64)
      .build();
   public static final EncodingSettings CLIENT = builder()
      .maxListSize(10240)
      .maxByteArraySize(20971520)
      .maxNetworkNBTSize(10485760)
      .maxItemNBTSize(5242880)
      .maxStringLength(2097152)
      .maxGeometryDataSize(524288)
      .maxItemStackTagLength(64)
      .maxInventoryActionsOrRequests(64)
      .build();
   public static final EncodingSettings SERVER = builder()
      .maxListSize(1024)
      .maxByteArraySize(524288)
      .maxNetworkNBTSize(524288)
      .maxItemNBTSize(102400)
      .maxStringLength(32768)
      .maxGeometryDataSize(262144)
      .maxItemStackTagLength(64)
      .maxInventoryActionsOrRequests(64)
      .build();
   public static final EncodingSettings UNLIMITED = builder()
      .maxListSize(-1)
      .maxByteArraySize(-1)
      .maxNetworkNBTSize(-1)
      .maxItemNBTSize(-1)
      .maxStringLength(-1)
      .maxItemStackTagLength(-1)
      .maxGeometryDataSize(-1)
      .maxInventoryActionsOrRequests(-1)
      .build();
   private final int maxListSize;
   private final int maxByteArraySize;
   private final int maxNetworkNBTSize;
   private final int maxItemNBTSize;
   private final int maxStringLength;
   private final int maxItemStackTagLength;
   private final int maxGeometryDataSize;
   private final int maxInventoryActionsOrRequests;

   EncodingSettings(
      final int maxListSize,
      final int maxByteArraySize,
      final int maxNetworkNBTSize,
      final int maxItemNBTSize,
      final int maxStringLength,
      final int maxItemStackTagLength,
      final int maxGeometryDataSize,
      final int maxInventoryActionsOrRequests
   ) {
      this.maxListSize = maxListSize;
      this.maxByteArraySize = maxByteArraySize;
      this.maxNetworkNBTSize = maxNetworkNBTSize;
      this.maxItemNBTSize = maxItemNBTSize;
      this.maxStringLength = maxStringLength;
      this.maxItemStackTagLength = maxItemStackTagLength;
      this.maxGeometryDataSize = maxGeometryDataSize;
      this.maxInventoryActionsOrRequests = maxInventoryActionsOrRequests;
   }

   public static EncodingSettings.Builder builder() {
      return new EncodingSettings.Builder();
   }

   public EncodingSettings.Builder toBuilder() {
      return new EncodingSettings.Builder()
         .maxListSize(this.maxListSize)
         .maxByteArraySize(this.maxByteArraySize)
         .maxNetworkNBTSize(this.maxNetworkNBTSize)
         .maxItemNBTSize(this.maxItemNBTSize)
         .maxStringLength(this.maxStringLength)
         .maxItemStackTagLength(this.maxItemStackTagLength)
         .maxGeometryDataSize(this.maxGeometryDataSize)
         .maxInventoryActionsOrRequests(this.maxInventoryActionsOrRequests);
   }

   public int maxListSize() {
      return this.maxListSize;
   }

   public int maxByteArraySize() {
      return this.maxByteArraySize;
   }

   public int maxNetworkNBTSize() {
      return this.maxNetworkNBTSize;
   }

   public int maxItemNBTSize() {
      return this.maxItemNBTSize;
   }

   public int maxStringLength() {
      return this.maxStringLength;
   }

   public int maxItemStackTagLength() {
      return this.maxItemStackTagLength;
   }

   public int maxGeometryDataSize() {
      return this.maxGeometryDataSize;
   }

   public int maxInventoryActionsOrRequests() {
      return this.maxInventoryActionsOrRequests;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof EncodingSettings)) {
         return false;
      } else {
         EncodingSettings other = (EncodingSettings)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.maxListSize() != other.maxListSize()) {
            return false;
         } else if (this.maxByteArraySize() != other.maxByteArraySize()) {
            return false;
         } else if (this.maxNetworkNBTSize() != other.maxNetworkNBTSize()) {
            return false;
         } else if (this.maxItemNBTSize() != other.maxItemNBTSize()) {
            return false;
         } else if (this.maxStringLength() != other.maxStringLength()) {
            return false;
         } else if (this.maxItemStackTagLength() != other.maxItemStackTagLength()) {
            return false;
         } else {
            return this.maxGeometryDataSize() != other.maxGeometryDataSize()
               ? false
               : this.maxInventoryActionsOrRequests() == other.maxInventoryActionsOrRequests();
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof EncodingSettings;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.maxListSize();
      result = result * 59 + this.maxByteArraySize();
      result = result * 59 + this.maxNetworkNBTSize();
      result = result * 59 + this.maxItemNBTSize();
      result = result * 59 + this.maxStringLength();
      result = result * 59 + this.maxItemStackTagLength();
      result = result * 59 + this.maxGeometryDataSize();
      return result * 59 + this.maxInventoryActionsOrRequests();
   }

   @Override
   public String toString() {
      return "EncodingSettings(maxListSize="
         + this.maxListSize()
         + ", maxByteArraySize="
         + this.maxByteArraySize()
         + ", maxNetworkNBTSize="
         + this.maxNetworkNBTSize()
         + ", maxItemNBTSize="
         + this.maxItemNBTSize()
         + ", maxStringLength="
         + this.maxStringLength()
         + ", maxItemStackTagLength="
         + this.maxItemStackTagLength()
         + ", maxGeometryDataSize="
         + this.maxGeometryDataSize()
         + ", maxInventoryActionsOrRequests="
         + this.maxInventoryActionsOrRequests()
         + ")";
   }

   public static class Builder {
      private int maxListSize;
      private int maxByteArraySize;
      private int maxNetworkNBTSize;
      private int maxItemNBTSize;
      private int maxStringLength;
      private int maxItemStackTagLength;
      private int maxGeometryDataSize;
      private int maxInventoryActionsOrRequests;

      Builder() {
      }

      public EncodingSettings.Builder maxListSize(final int maxListSize) {
         this.maxListSize = maxListSize;
         return this;
      }

      public EncodingSettings.Builder maxByteArraySize(final int maxByteArraySize) {
         this.maxByteArraySize = maxByteArraySize;
         return this;
      }

      public EncodingSettings.Builder maxNetworkNBTSize(final int maxNetworkNBTSize) {
         this.maxNetworkNBTSize = maxNetworkNBTSize;
         return this;
      }

      public EncodingSettings.Builder maxItemNBTSize(final int maxItemNBTSize) {
         this.maxItemNBTSize = maxItemNBTSize;
         return this;
      }

      public EncodingSettings.Builder maxStringLength(final int maxStringLength) {
         this.maxStringLength = maxStringLength;
         return this;
      }

      public EncodingSettings.Builder maxItemStackTagLength(final int maxItemStackTagLength) {
         this.maxItemStackTagLength = maxItemStackTagLength;
         return this;
      }

      public EncodingSettings.Builder maxGeometryDataSize(final int maxGeometryDataSize) {
         this.maxGeometryDataSize = maxGeometryDataSize;
         return this;
      }

      public EncodingSettings.Builder maxInventoryActionsOrRequests(final int maxInventoryActionsOrRequests) {
         this.maxInventoryActionsOrRequests = maxInventoryActionsOrRequests;
         return this;
      }

      public EncodingSettings build() {
         return new EncodingSettings(
            this.maxListSize,
            this.maxByteArraySize,
            this.maxNetworkNBTSize,
            this.maxItemNBTSize,
            this.maxStringLength,
            this.maxItemStackTagLength,
            this.maxGeometryDataSize,
            this.maxInventoryActionsOrRequests
         );
      }

      @Override
      public String toString() {
         return "EncodingSettings.Builder(maxListSize="
            + this.maxListSize
            + ", maxByteArraySize="
            + this.maxByteArraySize
            + ", maxNetworkNBTSize="
            + this.maxNetworkNBTSize
            + ", maxItemNBTSize="
            + this.maxItemNBTSize
            + ", maxStringLength="
            + this.maxStringLength
            + ", maxItemStackTagLength="
            + this.maxItemStackTagLength
            + ", maxGeometryDataSize="
            + this.maxGeometryDataSize
            + ", maxInventoryActionsOrRequests="
            + this.maxInventoryActionsOrRequests
            + ")";
      }
   }
}
