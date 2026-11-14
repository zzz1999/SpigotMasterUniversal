package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.util.Set;
import org.cloudburstmc.protocol.bedrock.data.HudElement;
import org.cloudburstmc.protocol.bedrock.data.HudVisibility;
import org.cloudburstmc.protocol.common.PacketSignal;

public class SetHudPacket implements BedrockPacket {
   private final Set<HudElement> elements = new ObjectOpenHashSet<>();
   private HudVisibility visibility;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SET_HUD;
   }

   public SetHudPacket clone() {
      try {
         return (SetHudPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public Set<HudElement> getElements() {
      return this.elements;
   }

   public HudVisibility getVisibility() {
      return this.visibility;
   }

   public void setVisibility(final HudVisibility visibility) {
      this.visibility = visibility;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SetHudPacket)) {
         return false;
      } else {
         SetHudPacket other = (SetHudPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$elements = this.elements;
            Object other$elements = other.elements;
            if (this$elements == null ? other$elements == null : this$elements.equals(other$elements)) {
               Object this$visibility = this.visibility;
               Object other$visibility = other.visibility;
               return this$visibility == null ? other$visibility == null : this$visibility.equals(other$visibility);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SetHudPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $elements = this.elements;
      result = result * 59 + ($elements == null ? 43 : $elements.hashCode());
      Object $visibility = this.visibility;
      return result * 59 + ($visibility == null ? 43 : $visibility.hashCode());
   }

   @Override
   public String toString() {
      return "SetHudPacket(elements=" + this.elements + ", visibility=" + this.visibility + ")";
   }
}
