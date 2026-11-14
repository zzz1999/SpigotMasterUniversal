package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;

public class UnlockedRecipesPacket implements BedrockPacket {
   private UnlockedRecipesPacket.ActionType action;
   private final List<String> unlockedRecipes = new ObjectArrayList<>();

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.UNLOCKED_RECIPES;
   }

   public UnlockedRecipesPacket.ActionType getAction() {
      return this.action;
   }

   public List<String> getUnlockedRecipes() {
      return this.unlockedRecipes;
   }

   public void setAction(UnlockedRecipesPacket.ActionType action) {
      this.action = action;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof UnlockedRecipesPacket)) {
         return false;
      } else {
         UnlockedRecipesPacket other = (UnlockedRecipesPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$action = this.action;
            Object other$action = other.action;
            if (this$action == null ? other$action == null : this$action.equals(other$action)) {
               Object this$unlockedRecipes = this.unlockedRecipes;
               Object other$unlockedRecipes = other.unlockedRecipes;
               return this$unlockedRecipes == null ? other$unlockedRecipes == null : this$unlockedRecipes.equals(other$unlockedRecipes);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof UnlockedRecipesPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $action = this.action;
      result = result * 59 + ($action == null ? 43 : $action.hashCode());
      Object $unlockedRecipes = this.unlockedRecipes;
      return result * 59 + ($unlockedRecipes == null ? 43 : $unlockedRecipes.hashCode());
   }

   @Override
   public String toString() {
      return "UnlockedRecipesPacket(action=" + this.action + ", unlockedRecipes=" + this.unlockedRecipes + ")";
   }

   public enum ActionType {
      EMPTY,
      INITIALLY_UNLOCKED,
      NEWLY_UNLOCKED,
      REMOVE_UNLOCKED,
      REMOVE_ALL;
   }
}
