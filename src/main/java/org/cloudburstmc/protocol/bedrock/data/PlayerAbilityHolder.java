package org.cloudburstmc.protocol.bedrock.data;

import java.util.List;
import org.cloudburstmc.protocol.bedrock.data.command.CommandPermission;

public interface PlayerAbilityHolder {
   long getUniqueEntityId();

   void setUniqueEntityId(long uniqueEntityId);

   PlayerPermission getPlayerPermission();

   void setPlayerPermission(PlayerPermission playerPermission);

   CommandPermission getCommandPermission();

   void setCommandPermission(CommandPermission commandPermission);

   List<AbilityLayer> getAbilityLayers();

   void setAbilityLayers(List<AbilityLayer> layers);
}
