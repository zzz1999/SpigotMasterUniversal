package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class BossEventPacket implements BedrockPacket {
   private long bossUniqueEntityId;
   private BossEventPacket.Action action;
   private long playerUniqueEntityId;
   private CharSequence title;
   private CharSequence filteredTitle = "";
   private float healthPercentage;
   private int darkenSky;
   private int color;
   private int overlay;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.BOSS_EVENT;
   }

   public BossEventPacket clone() {
      try {
         return (BossEventPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public String getTitle() {
      return this.getTitle(String.class);
   }

   public <T extends CharSequence> T getTitle(Class<T> type) {
      return type.cast(this.title);
   }

   public String getFilteredTitle() {
      return this.getFilteredTitle(String.class);
   }

   public <T extends CharSequence> T getFilteredTitle(Class<T> type) {
      return type.cast(this.filteredTitle);
   }

   public long getBossUniqueEntityId() {
      return this.bossUniqueEntityId;
   }

   public BossEventPacket.Action getAction() {
      return this.action;
   }

   public long getPlayerUniqueEntityId() {
      return this.playerUniqueEntityId;
   }

   public float getHealthPercentage() {
      return this.healthPercentage;
   }

   public int getDarkenSky() {
      return this.darkenSky;
   }

   public int getColor() {
      return this.color;
   }

   public int getOverlay() {
      return this.overlay;
   }

   public void setBossUniqueEntityId(final long bossUniqueEntityId) {
      this.bossUniqueEntityId = bossUniqueEntityId;
   }

   public void setAction(final BossEventPacket.Action action) {
      this.action = action;
   }

   public void setPlayerUniqueEntityId(final long playerUniqueEntityId) {
      this.playerUniqueEntityId = playerUniqueEntityId;
   }

   public void setTitle(final CharSequence title) {
      this.title = title;
   }

   public void setFilteredTitle(final CharSequence filteredTitle) {
      this.filteredTitle = filteredTitle;
   }

   public void setHealthPercentage(final float healthPercentage) {
      this.healthPercentage = healthPercentage;
   }

   public void setDarkenSky(final int darkenSky) {
      this.darkenSky = darkenSky;
   }

   public void setColor(final int color) {
      this.color = color;
   }

   public void setOverlay(final int overlay) {
      this.overlay = overlay;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BossEventPacket)) {
         return false;
      }

      BossEventPacket other = (BossEventPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.bossUniqueEntityId != other.bossUniqueEntityId) {
         return false;
      }

      if (this.playerUniqueEntityId != other.playerUniqueEntityId) {
         return false;
      }

      if (Float.compare(this.healthPercentage, other.healthPercentage) != 0) {
         return false;
      }

      if (this.darkenSky != other.darkenSky) {
         return false;
      }

      if (this.color != other.color) {
         return false;
      }

      if (this.overlay != other.overlay) {
         return false;
      }

      Object this$action = this.action;
      Object other$action = other.action;
      if (this$action == null ? other$action == null : this$action.equals(other$action)) {
         Object this$title = this.title;
         Object other$title = other.title;
         if (this$title == null ? other$title == null : this$title.equals(other$title)) {
            Object this$filteredTitle = this.filteredTitle;
            Object other$filteredTitle = other.filteredTitle;
            return this$filteredTitle == null ? other$filteredTitle == null : this$filteredTitle.equals(other$filteredTitle);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BossEventPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $bossUniqueEntityId = this.bossUniqueEntityId;
      result = result * 59 + (int)($bossUniqueEntityId >>> 32 ^ $bossUniqueEntityId);
      long $playerUniqueEntityId = this.playerUniqueEntityId;
      result = result * 59 + (int)($playerUniqueEntityId >>> 32 ^ $playerUniqueEntityId);
      result = result * 59 + Float.floatToIntBits(this.healthPercentage);
      result = result * 59 + this.darkenSky;
      result = result * 59 + this.color;
      result = result * 59 + this.overlay;
      Object $action = this.action;
      result = result * 59 + ($action == null ? 43 : $action.hashCode());
      Object $title = this.title;
      result = result * 59 + ($title == null ? 43 : $title.hashCode());
      Object $filteredTitle = this.filteredTitle;
      return result * 59 + ($filteredTitle == null ? 43 : $filteredTitle.hashCode());
   }

   @Override
   public String toString() {
      return "BossEventPacket(bossUniqueEntityId="
         + this.bossUniqueEntityId
         + ", action="
         + this.action
         + ", playerUniqueEntityId="
         + this.playerUniqueEntityId
         + ", title="
         + this.title
         + ", filteredTitle="
         + this.filteredTitle
         + ", healthPercentage="
         + this.healthPercentage
         + ", darkenSky="
         + this.darkenSky
         + ", color="
         + this.color
         + ", overlay="
         + this.overlay
         + ")";
   }

   public enum Action {
      CREATE,
      REGISTER_PLAYER,
      REMOVE,
      UNREGISTER_PLAYER,
      UPDATE_PERCENTAGE,
      UPDATE_NAME,
      UPDATE_PROPERTIES,
      UPDATE_STYLE,
      QUERY;
   }
}
