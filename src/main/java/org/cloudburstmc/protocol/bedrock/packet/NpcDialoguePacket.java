package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class NpcDialoguePacket implements BedrockPacket {
   private long uniqueEntityId;
   private NpcDialoguePacket.Action action;
   private String dialogue;
   private String sceneName;
   private String npcName;
   private String actionJson;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.NPC_DIALOGUE;
   }

   public NpcDialoguePacket clone() {
      try {
         return (NpcDialoguePacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public long getUniqueEntityId() {
      return this.uniqueEntityId;
   }

   public NpcDialoguePacket.Action getAction() {
      return this.action;
   }

   public String getDialogue() {
      return this.dialogue;
   }

   public String getSceneName() {
      return this.sceneName;
   }

   public String getNpcName() {
      return this.npcName;
   }

   public String getActionJson() {
      return this.actionJson;
   }

   public void setUniqueEntityId(final long uniqueEntityId) {
      this.uniqueEntityId = uniqueEntityId;
   }

   public void setAction(final NpcDialoguePacket.Action action) {
      this.action = action;
   }

   public void setDialogue(final String dialogue) {
      this.dialogue = dialogue;
   }

   public void setSceneName(final String sceneName) {
      this.sceneName = sceneName;
   }

   public void setNpcName(final String npcName) {
      this.npcName = npcName;
   }

   public void setActionJson(final String actionJson) {
      this.actionJson = actionJson;
   }

   @Override
   public String toString() {
      return "NpcDialoguePacket(uniqueEntityId="
         + this.getUniqueEntityId()
         + ", action="
         + this.getAction()
         + ", dialogue="
         + this.getDialogue()
         + ", sceneName="
         + this.getSceneName()
         + ", npcName="
         + this.getNpcName()
         + ", actionJson="
         + this.getActionJson()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NpcDialoguePacket)) {
         return false;
      }

      NpcDialoguePacket other = (NpcDialoguePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.uniqueEntityId != other.uniqueEntityId) {
         return false;
      }

      Object this$action = this.action;
      Object other$action = other.action;
      if (this$action == null ? other$action == null : this$action.equals(other$action)) {
         Object this$dialogue = this.dialogue;
         Object other$dialogue = other.dialogue;
         if (this$dialogue == null ? other$dialogue == null : this$dialogue.equals(other$dialogue)) {
            Object this$sceneName = this.sceneName;
            Object other$sceneName = other.sceneName;
            if (this$sceneName == null ? other$sceneName == null : this$sceneName.equals(other$sceneName)) {
               Object this$npcName = this.npcName;
               Object other$npcName = other.npcName;
               if (this$npcName == null ? other$npcName == null : this$npcName.equals(other$npcName)) {
                  Object this$actionJson = this.actionJson;
                  Object other$actionJson = other.actionJson;
                  return this$actionJson == null ? other$actionJson == null : this$actionJson.equals(other$actionJson);
               } else {
                  return false;
               }
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
      return other instanceof NpcDialoguePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $uniqueEntityId = this.uniqueEntityId;
      result = result * 59 + (int)($uniqueEntityId >>> 32 ^ $uniqueEntityId);
      Object $action = this.action;
      result = result * 59 + ($action == null ? 43 : $action.hashCode());
      Object $dialogue = this.dialogue;
      result = result * 59 + ($dialogue == null ? 43 : $dialogue.hashCode());
      Object $sceneName = this.sceneName;
      result = result * 59 + ($sceneName == null ? 43 : $sceneName.hashCode());
      Object $npcName = this.npcName;
      result = result * 59 + ($npcName == null ? 43 : $npcName.hashCode());
      Object $actionJson = this.actionJson;
      return result * 59 + ($actionJson == null ? 43 : $actionJson.hashCode());
   }

   public enum Action {
      OPEN,
      CLOSE;
   }
}
