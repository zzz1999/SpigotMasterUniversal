package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.UUID;
import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.protocol.bedrock.data.AbilityLayer;
import org.cloudburstmc.protocol.bedrock.data.GameType;
import org.cloudburstmc.protocol.bedrock.data.PlayerAbilityHolder;
import org.cloudburstmc.protocol.bedrock.data.PlayerPermission;
import org.cloudburstmc.protocol.bedrock.data.command.CommandPermission;
import org.cloudburstmc.protocol.bedrock.data.entity.EntityDataMap;
import org.cloudburstmc.protocol.bedrock.data.entity.EntityLinkData;
import org.cloudburstmc.protocol.bedrock.data.entity.EntityProperties;
import org.cloudburstmc.protocol.bedrock.data.inventory.ItemData;
import org.cloudburstmc.protocol.common.PacketSignal;

public class AddPlayerPacket implements BedrockPacket, PlayerAbilityHolder {
   private EntityDataMap metadata = new EntityDataMap();
   private List<EntityLinkData> entityLinks = new ObjectArrayList<>();
   private UUID uuid;
   private String username;
   private long uniqueEntityId;
   private long runtimeEntityId;
   private String platformChatId;
   private Vector3f position;
   private Vector3f motion;
   private Vector3f rotation;
   private ItemData hand;
   private AdventureSettingsPacket adventureSettings = new AdventureSettingsPacket();
   private String deviceId;
   private int buildPlatform;
   private GameType gameType;
   private List<AbilityLayer> abilityLayers = new ObjectArrayList<>();
   private final EntityProperties properties = new EntityProperties();

   @Override
   public void setUniqueEntityId(long uniqueEntityId) {
      this.uniqueEntityId = uniqueEntityId;
      this.adventureSettings.setUniqueEntityId(uniqueEntityId);
   }

   @Override
   public PlayerPermission getPlayerPermission() {
      return this.adventureSettings.getPlayerPermission();
   }

   @Override
   public void setPlayerPermission(PlayerPermission playerPermission) {
      this.adventureSettings.setPlayerPermission(playerPermission);
   }

   @Override
   public CommandPermission getCommandPermission() {
      return this.adventureSettings.getCommandPermission();
   }

   @Override
   public void setCommandPermission(CommandPermission commandPermission) {
      this.adventureSettings.setCommandPermission(commandPermission);
   }

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.ADD_PLAYER;
   }

   public AddPlayerPacket clone() {
      try {
         return (AddPlayerPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public EntityDataMap getMetadata() {
      return this.metadata;
   }

   public List<EntityLinkData> getEntityLinks() {
      return this.entityLinks;
   }

   public UUID getUuid() {
      return this.uuid;
   }

   public String getUsername() {
      return this.username;
   }

   @Override
   public long getUniqueEntityId() {
      return this.uniqueEntityId;
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public String getPlatformChatId() {
      return this.platformChatId;
   }

   public Vector3f getPosition() {
      return this.position;
   }

   public Vector3f getMotion() {
      return this.motion;
   }

   public Vector3f getRotation() {
      return this.rotation;
   }

   public ItemData getHand() {
      return this.hand;
   }

   public AdventureSettingsPacket getAdventureSettings() {
      return this.adventureSettings;
   }

   public String getDeviceId() {
      return this.deviceId;
   }

   public int getBuildPlatform() {
      return this.buildPlatform;
   }

   public GameType getGameType() {
      return this.gameType;
   }

   @Override
   public List<AbilityLayer> getAbilityLayers() {
      return this.abilityLayers;
   }

   public EntityProperties getProperties() {
      return this.properties;
   }

   public void setMetadata(final EntityDataMap metadata) {
      this.metadata = metadata;
   }

   public void setEntityLinks(final List<EntityLinkData> entityLinks) {
      this.entityLinks = entityLinks;
   }

   public void setUuid(final UUID uuid) {
      this.uuid = uuid;
   }

   public void setUsername(final String username) {
      this.username = username;
   }

   public void setRuntimeEntityId(final long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setPlatformChatId(final String platformChatId) {
      this.platformChatId = platformChatId;
   }

   public void setPosition(final Vector3f position) {
      this.position = position;
   }

   public void setMotion(final Vector3f motion) {
      this.motion = motion;
   }

   public void setRotation(final Vector3f rotation) {
      this.rotation = rotation;
   }

   public void setHand(final ItemData hand) {
      this.hand = hand;
   }

   public void setAdventureSettings(final AdventureSettingsPacket adventureSettings) {
      this.adventureSettings = adventureSettings;
   }

   public void setDeviceId(final String deviceId) {
      this.deviceId = deviceId;
   }

   public void setBuildPlatform(final int buildPlatform) {
      this.buildPlatform = buildPlatform;
   }

   public void setGameType(final GameType gameType) {
      this.gameType = gameType;
   }

   @Override
   public void setAbilityLayers(final List<AbilityLayer> abilityLayers) {
      this.abilityLayers = abilityLayers;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AddPlayerPacket)) {
         return false;
      }

      AddPlayerPacket other = (AddPlayerPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.uniqueEntityId != other.uniqueEntityId) {
         return false;
      }

      if (this.runtimeEntityId != other.runtimeEntityId) {
         return false;
      }

      if (this.buildPlatform != other.buildPlatform) {
         return false;
      }

      Object this$metadata = this.metadata;
      Object other$metadata = other.metadata;
      if (this$metadata == null ? other$metadata == null : this$metadata.equals(other$metadata)) {
         Object this$entityLinks = this.entityLinks;
         Object other$entityLinks = other.entityLinks;
         if (this$entityLinks == null ? other$entityLinks == null : this$entityLinks.equals(other$entityLinks)) {
            Object this$uuid = this.uuid;
            Object other$uuid = other.uuid;
            if (this$uuid == null ? other$uuid == null : this$uuid.equals(other$uuid)) {
               Object this$username = this.username;
               Object other$username = other.username;
               if (this$username == null ? other$username == null : this$username.equals(other$username)) {
                  Object this$platformChatId = this.platformChatId;
                  Object other$platformChatId = other.platformChatId;
                  if (this$platformChatId == null ? other$platformChatId == null : this$platformChatId.equals(other$platformChatId)) {
                     Object this$position = this.position;
                     Object other$position = other.position;
                     if (this$position == null ? other$position == null : this$position.equals(other$position)) {
                        Object this$motion = this.motion;
                        Object other$motion = other.motion;
                        if (this$motion == null ? other$motion == null : this$motion.equals(other$motion)) {
                           Object this$rotation = this.rotation;
                           Object other$rotation = other.rotation;
                           if (this$rotation == null ? other$rotation == null : this$rotation.equals(other$rotation)) {
                              Object this$hand = this.hand;
                              Object other$hand = other.hand;
                              if (this$hand == null ? other$hand == null : this$hand.equals(other$hand)) {
                                 Object this$adventureSettings = this.adventureSettings;
                                 Object other$adventureSettings = other.adventureSettings;
                                 if (this$adventureSettings == null ? other$adventureSettings == null : this$adventureSettings.equals(other$adventureSettings)) {
                                    Object this$deviceId = this.deviceId;
                                    Object other$deviceId = other.deviceId;
                                    if (this$deviceId == null ? other$deviceId == null : this$deviceId.equals(other$deviceId)) {
                                       Object this$gameType = this.gameType;
                                       Object other$gameType = other.gameType;
                                       if (this$gameType == null ? other$gameType == null : this$gameType.equals(other$gameType)) {
                                          Object this$abilityLayers = this.abilityLayers;
                                          Object other$abilityLayers = other.abilityLayers;
                                          if (this$abilityLayers == null ? other$abilityLayers == null : this$abilityLayers.equals(other$abilityLayers)) {
                                             Object this$properties = this.properties;
                                             Object other$properties = other.properties;
                                             return this$properties == null ? other$properties == null : this$properties.equals(other$properties);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AddPlayerPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $uniqueEntityId = this.uniqueEntityId;
      result = result * 59 + (int)($uniqueEntityId >>> 32 ^ $uniqueEntityId);
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      result = result * 59 + this.buildPlatform;
      Object $metadata = this.metadata;
      result = result * 59 + ($metadata == null ? 43 : $metadata.hashCode());
      Object $entityLinks = this.entityLinks;
      result = result * 59 + ($entityLinks == null ? 43 : $entityLinks.hashCode());
      Object $uuid = this.uuid;
      result = result * 59 + ($uuid == null ? 43 : $uuid.hashCode());
      Object $username = this.username;
      result = result * 59 + ($username == null ? 43 : $username.hashCode());
      Object $platformChatId = this.platformChatId;
      result = result * 59 + ($platformChatId == null ? 43 : $platformChatId.hashCode());
      Object $position = this.position;
      result = result * 59 + ($position == null ? 43 : $position.hashCode());
      Object $motion = this.motion;
      result = result * 59 + ($motion == null ? 43 : $motion.hashCode());
      Object $rotation = this.rotation;
      result = result * 59 + ($rotation == null ? 43 : $rotation.hashCode());
      Object $hand = this.hand;
      result = result * 59 + ($hand == null ? 43 : $hand.hashCode());
      Object $adventureSettings = this.adventureSettings;
      result = result * 59 + ($adventureSettings == null ? 43 : $adventureSettings.hashCode());
      Object $deviceId = this.deviceId;
      result = result * 59 + ($deviceId == null ? 43 : $deviceId.hashCode());
      Object $gameType = this.gameType;
      result = result * 59 + ($gameType == null ? 43 : $gameType.hashCode());
      Object $abilityLayers = this.abilityLayers;
      result = result * 59 + ($abilityLayers == null ? 43 : $abilityLayers.hashCode());
      Object $properties = this.properties;
      return result * 59 + ($properties == null ? 43 : $properties.hashCode());
   }

   @Override
   public String toString() {
      return "AddPlayerPacket(metadata="
         + this.metadata
         + ", entityLinks="
         + this.entityLinks
         + ", uuid="
         + this.uuid
         + ", username="
         + this.username
         + ", uniqueEntityId="
         + this.uniqueEntityId
         + ", runtimeEntityId="
         + this.runtimeEntityId
         + ", platformChatId="
         + this.platformChatId
         + ", position="
         + this.position
         + ", motion="
         + this.motion
         + ", rotation="
         + this.rotation
         + ", hand="
         + this.hand
         + ", adventureSettings="
         + this.adventureSettings
         + ", deviceId="
         + this.deviceId
         + ", buildPlatform="
         + this.buildPlatform
         + ", gameType="
         + this.gameType
         + ", abilityLayers="
         + this.abilityLayers
         + ", properties="
         + this.properties
         + ")";
   }
}
