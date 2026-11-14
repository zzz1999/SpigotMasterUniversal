package org.cloudburstmc.protocol.bedrock.data.inventory;

import java.util.Arrays;
import java.util.Objects;
import org.cloudburstmc.nbt.NbtMap;
import org.cloudburstmc.protocol.bedrock.data.definitions.BlockDefinition;
import org.cloudburstmc.protocol.bedrock.data.definitions.ItemDefinition;

final class BaseItemData implements ItemData {
   static final String[] EMPTY_ARRAY = new String[0];
   private ItemDefinition definition;
   private final int damage;
   private final int count;
   private final NbtMap tag;
   private final String[] canPlace;
   private final String[] canBreak;
   private final long blockingTicks;
   private final BlockDefinition blockDefinition;
   private boolean usingNetId;
   private int netId;

   BaseItemData(
      ItemDefinition definition,
      int damage,
      int count,
      NbtMap tag,
      String[] canPlace,
      String[] canBreak,
      long blockingTicks,
      BlockDefinition blockDefinition,
      boolean hasNetId,
      int netId
   ) {
      this.definition = definition;
      this.damage = damage;
      this.count = count;
      this.tag = tag;
      this.canPlace = canPlace == null ? EMPTY_ARRAY : canPlace;
      this.canBreak = canBreak == null ? EMPTY_ARRAY : canBreak;
      this.blockingTicks = blockingTicks;
      this.blockDefinition = blockDefinition;
      this.netId = netId;
      this.usingNetId = hasNetId;
   }

   @Override
   public boolean isValid() {
      return !this.isNull() && this.definition != null && this.definition != ItemDefinition.AIR;
   }

   @Override
   public boolean isNull() {
      return this.count <= 0;
   }

   @Override
   public int hashCode() {
      return Objects.hash(
         this.definition,
         this.damage,
         this.count,
         this.tag,
         Arrays.hashCode(this.canPlace),
         Arrays.hashCode(this.canBreak),
         this.blockingTicks,
         this.blockDefinition
      );
   }

   @Override
   public boolean equals(ItemData other, boolean checkAmount, boolean checkMetadata, boolean checkUserdata) {
      return this.definition == other.getDefinition()
         && (!checkAmount || this.count == other.getCount())
         && (!checkMetadata || this.damage == other.getDamage() && this.blockingTicks == other.getBlockingTicks())
         && (
            !checkUserdata
               || Objects.equals(this.tag, other.getTag())
                  && Arrays.equals(this.canPlace, other.getCanPlace())
                  && Arrays.equals(this.canBreak, other.getCanBreak())
         );
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else {
         return !(obj instanceof ItemData) ? false : this.equals((ItemData)obj, true, true, true);
      }
   }

   @Override
   public ItemDefinition getDefinition() {
      return this.definition;
   }

   @Override
   public int getDamage() {
      return this.damage;
   }

   @Override
   public int getCount() {
      return this.count;
   }

   @Override
   public NbtMap getTag() {
      return this.tag;
   }

   @Override
   public String[] getCanPlace() {
      return this.canPlace;
   }

   @Override
   public String[] getCanBreak() {
      return this.canBreak;
   }

   @Override
   public long getBlockingTicks() {
      return this.blockingTicks;
   }

   @Override
   public BlockDefinition getBlockDefinition() {
      return this.blockDefinition;
   }

   @Override
   public boolean isUsingNetId() {
      return this.usingNetId;
   }

   @Override
   public int getNetId() {
      return this.netId;
   }

   public void setDefinition(final ItemDefinition definition) {
      this.definition = definition;
   }

   public void setUsingNetId(final boolean usingNetId) {
      this.usingNetId = usingNetId;
   }

   @Override
   public void setNetId(final int netId) {
      this.netId = netId;
   }

   @Override
   public String toString() {
      return "BaseItemData(definition="
         + this.getDefinition()
         + ", damage="
         + this.getDamage()
         + ", count="
         + this.getCount()
         + ", tag="
         + this.getTag()
         + ", canPlace="
         + Arrays.deepToString(this.getCanPlace())
         + ", canBreak="
         + Arrays.deepToString(this.getCanBreak())
         + ", blockingTicks="
         + this.getBlockingTicks()
         + ", blockDefinition="
         + this.getBlockDefinition()
         + ", usingNetId="
         + this.isUsingNetId()
         + ", netId="
         + this.getNetId()
         + ")";
   }
}
