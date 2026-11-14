package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.UUID;
import org.cloudburstmc.math.vector.Vector2f;
import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.math.vector.Vector3i;
import org.cloudburstmc.nbt.NbtList;
import org.cloudburstmc.nbt.NbtMap;
import org.cloudburstmc.protocol.bedrock.data.AuthoritativeMovementMode;
import org.cloudburstmc.protocol.bedrock.data.BlockPropertyData;
import org.cloudburstmc.protocol.bedrock.data.ChatRestrictionLevel;
import org.cloudburstmc.protocol.bedrock.data.EduSharedUriResource;
import org.cloudburstmc.protocol.bedrock.data.ExperimentData;
import org.cloudburstmc.protocol.bedrock.data.GamePublishSetting;
import org.cloudburstmc.protocol.bedrock.data.GameRuleData;
import org.cloudburstmc.protocol.bedrock.data.GameType;
import org.cloudburstmc.protocol.bedrock.data.NetworkPermissions;
import org.cloudburstmc.protocol.bedrock.data.PlayerPermission;
import org.cloudburstmc.protocol.bedrock.data.SpawnBiomeType;
import org.cloudburstmc.protocol.bedrock.data.WorldType;
import org.cloudburstmc.protocol.bedrock.data.definitions.ItemDefinition;
import org.cloudburstmc.protocol.common.PacketSignal;
import org.cloudburstmc.protocol.common.util.OptionalBoolean;

public class StartGamePacket implements BedrockPacket {
   private final List<GameRuleData<?>> gamerules = new ObjectArrayList<>();
   private long uniqueEntityId;
   private long runtimeEntityId;
   private GameType playerGameType;
   private Vector3f playerPosition;
   private Vector2f rotation;
   private long seed;
   private SpawnBiomeType spawnBiomeType;
   private String customBiomeName;
   private int dimensionId;
   private int generatorId;
   private GameType levelGameType;
   private int difficulty;
   private Vector3i defaultSpawn;
   private boolean achievementsDisabled;
   private int dayCycleStopTime;
   private int eduEditionOffers;
   private boolean eduFeaturesEnabled;
   private String educationProductionId;
   private float rainLevel;
   private float lightningLevel;
   private boolean platformLockedContentConfirmed;
   private boolean multiplayerGame;
   private boolean broadcastingToLan;
   private GamePublishSetting xblBroadcastMode;
   private GamePublishSetting platformBroadcastMode;
   private boolean commandsEnabled;
   private boolean texturePacksRequired;
   private final List<ExperimentData> experiments = new ObjectArrayList<>();
   private boolean experimentsPreviouslyToggled;
   private boolean bonusChestEnabled;
   private boolean startingWithMap;
   private boolean trustingPlayers;
   private PlayerPermission defaultPlayerPermission;
   private int serverChunkTickRange;
   private boolean behaviorPackLocked;
   private boolean resourcePackLocked;
   private boolean fromLockedWorldTemplate;
   private boolean usingMsaGamertagsOnly;
   private boolean fromWorldTemplate;
   private boolean worldTemplateOptionLocked;
   private boolean onlySpawningV1Villagers;
   private String vanillaVersion;
   private int limitedWorldWidth;
   private int limitedWorldHeight;
   private boolean netherType;
   private EduSharedUriResource eduSharedUriResource = EduSharedUriResource.EMPTY;
   private OptionalBoolean forceExperimentalGameplay;
   private ChatRestrictionLevel chatRestrictionLevel;
   private boolean disablingPlayerInteractions;
   private boolean disablingPersonas;
   private boolean disablingCustomSkins;
   private String levelId;
   private CharSequence levelName;
   private String premiumWorldTemplateId;
   private boolean trial;
   /** @deprecated */
   private AuthoritativeMovementMode authoritativeMovementMode;
   private int rewindHistorySize;
   boolean serverAuthoritativeBlockBreaking;
   private long currentTick;
   private int enchantmentSeed;
   private NbtList<NbtMap> blockPalette;
   private final List<BlockPropertyData> blockProperties = new ObjectArrayList<>();
   /** @deprecated */
   private List<ItemDefinition> itemDefinitions = new ObjectArrayList<>();
   private String multiplayerCorrelationId;
   private boolean inventoriesServerAuthoritative;
   private String serverEngine;
   private NbtMap playerPropertyData;
   private long blockRegistryChecksum;
   private UUID worldTemplateId;
   private WorldType editorWorldType = WorldType.NON_EDITOR;
   private boolean clientSideGenerationEnabled;
   private boolean emoteChatMuted;
   private boolean blockNetworkIdsHashed;
   private boolean createdInEditor;
   private boolean exportedFromEditor;
   private NetworkPermissions networkPermissions = NetworkPermissions.DEFAULT;
   private boolean hardcore;
   private String serverId;
   private String worldId;
   private String scenarioId;
   private String ownerId;
   private boolean tickDeathSystemsEnabled;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.START_GAME;
   }

   public StartGamePacket clone() {
      try {
         return (StartGamePacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public String getLevelName() {
      return this.getLevelName(String.class);
   }

   public <T extends CharSequence> T getLevelName(Class<T> type) {
      return type.cast(this.levelName);
   }

   public List<GameRuleData<?>> getGamerules() {
      return this.gamerules;
   }

   public long getUniqueEntityId() {
      return this.uniqueEntityId;
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public GameType getPlayerGameType() {
      return this.playerGameType;
   }

   public Vector3f getPlayerPosition() {
      return this.playerPosition;
   }

   public Vector2f getRotation() {
      return this.rotation;
   }

   public long getSeed() {
      return this.seed;
   }

   public SpawnBiomeType getSpawnBiomeType() {
      return this.spawnBiomeType;
   }

   public String getCustomBiomeName() {
      return this.customBiomeName;
   }

   public int getDimensionId() {
      return this.dimensionId;
   }

   public int getGeneratorId() {
      return this.generatorId;
   }

   public GameType getLevelGameType() {
      return this.levelGameType;
   }

   public int getDifficulty() {
      return this.difficulty;
   }

   public Vector3i getDefaultSpawn() {
      return this.defaultSpawn;
   }

   public boolean isAchievementsDisabled() {
      return this.achievementsDisabled;
   }

   public int getDayCycleStopTime() {
      return this.dayCycleStopTime;
   }

   public int getEduEditionOffers() {
      return this.eduEditionOffers;
   }

   public boolean isEduFeaturesEnabled() {
      return this.eduFeaturesEnabled;
   }

   public String getEducationProductionId() {
      return this.educationProductionId;
   }

   public float getRainLevel() {
      return this.rainLevel;
   }

   public float getLightningLevel() {
      return this.lightningLevel;
   }

   public boolean isPlatformLockedContentConfirmed() {
      return this.platformLockedContentConfirmed;
   }

   public boolean isMultiplayerGame() {
      return this.multiplayerGame;
   }

   public boolean isBroadcastingToLan() {
      return this.broadcastingToLan;
   }

   public GamePublishSetting getXblBroadcastMode() {
      return this.xblBroadcastMode;
   }

   public GamePublishSetting getPlatformBroadcastMode() {
      return this.platformBroadcastMode;
   }

   public boolean isCommandsEnabled() {
      return this.commandsEnabled;
   }

   public boolean isTexturePacksRequired() {
      return this.texturePacksRequired;
   }

   public List<ExperimentData> getExperiments() {
      return this.experiments;
   }

   public boolean isExperimentsPreviouslyToggled() {
      return this.experimentsPreviouslyToggled;
   }

   public boolean isBonusChestEnabled() {
      return this.bonusChestEnabled;
   }

   public boolean isStartingWithMap() {
      return this.startingWithMap;
   }

   public boolean isTrustingPlayers() {
      return this.trustingPlayers;
   }

   public PlayerPermission getDefaultPlayerPermission() {
      return this.defaultPlayerPermission;
   }

   public int getServerChunkTickRange() {
      return this.serverChunkTickRange;
   }

   public boolean isBehaviorPackLocked() {
      return this.behaviorPackLocked;
   }

   public boolean isResourcePackLocked() {
      return this.resourcePackLocked;
   }

   public boolean isFromLockedWorldTemplate() {
      return this.fromLockedWorldTemplate;
   }

   public boolean isUsingMsaGamertagsOnly() {
      return this.usingMsaGamertagsOnly;
   }

   public boolean isFromWorldTemplate() {
      return this.fromWorldTemplate;
   }

   public boolean isWorldTemplateOptionLocked() {
      return this.worldTemplateOptionLocked;
   }

   public boolean isOnlySpawningV1Villagers() {
      return this.onlySpawningV1Villagers;
   }

   public String getVanillaVersion() {
      return this.vanillaVersion;
   }

   public int getLimitedWorldWidth() {
      return this.limitedWorldWidth;
   }

   public int getLimitedWorldHeight() {
      return this.limitedWorldHeight;
   }

   public boolean isNetherType() {
      return this.netherType;
   }

   public EduSharedUriResource getEduSharedUriResource() {
      return this.eduSharedUriResource;
   }

   public OptionalBoolean getForceExperimentalGameplay() {
      return this.forceExperimentalGameplay;
   }

   public ChatRestrictionLevel getChatRestrictionLevel() {
      return this.chatRestrictionLevel;
   }

   public boolean isDisablingPlayerInteractions() {
      return this.disablingPlayerInteractions;
   }

   public boolean isDisablingPersonas() {
      return this.disablingPersonas;
   }

   public boolean isDisablingCustomSkins() {
      return this.disablingCustomSkins;
   }

   public String getLevelId() {
      return this.levelId;
   }

   public String getPremiumWorldTemplateId() {
      return this.premiumWorldTemplateId;
   }

   public boolean isTrial() {
      return this.trial;
   }

   @Deprecated
   public AuthoritativeMovementMode getAuthoritativeMovementMode() {
      return this.authoritativeMovementMode;
   }

   public int getRewindHistorySize() {
      return this.rewindHistorySize;
   }

   public boolean isServerAuthoritativeBlockBreaking() {
      return this.serverAuthoritativeBlockBreaking;
   }

   public long getCurrentTick() {
      return this.currentTick;
   }

   public int getEnchantmentSeed() {
      return this.enchantmentSeed;
   }

   public NbtList<NbtMap> getBlockPalette() {
      return this.blockPalette;
   }

   public List<BlockPropertyData> getBlockProperties() {
      return this.blockProperties;
   }

   @Deprecated
   public List<ItemDefinition> getItemDefinitions() {
      return this.itemDefinitions;
   }

   public String getMultiplayerCorrelationId() {
      return this.multiplayerCorrelationId;
   }

   public boolean isInventoriesServerAuthoritative() {
      return this.inventoriesServerAuthoritative;
   }

   public String getServerEngine() {
      return this.serverEngine;
   }

   public NbtMap getPlayerPropertyData() {
      return this.playerPropertyData;
   }

   public long getBlockRegistryChecksum() {
      return this.blockRegistryChecksum;
   }

   public UUID getWorldTemplateId() {
      return this.worldTemplateId;
   }

   public WorldType getEditorWorldType() {
      return this.editorWorldType;
   }

   public boolean isClientSideGenerationEnabled() {
      return this.clientSideGenerationEnabled;
   }

   public boolean isEmoteChatMuted() {
      return this.emoteChatMuted;
   }

   public boolean isBlockNetworkIdsHashed() {
      return this.blockNetworkIdsHashed;
   }

   public boolean isCreatedInEditor() {
      return this.createdInEditor;
   }

   public boolean isExportedFromEditor() {
      return this.exportedFromEditor;
   }

   public NetworkPermissions getNetworkPermissions() {
      return this.networkPermissions;
   }

   public boolean isHardcore() {
      return this.hardcore;
   }

   public String getServerId() {
      return this.serverId;
   }

   public String getWorldId() {
      return this.worldId;
   }

   public String getScenarioId() {
      return this.scenarioId;
   }

   public String getOwnerId() {
      return this.ownerId;
   }

   public boolean isTickDeathSystemsEnabled() {
      return this.tickDeathSystemsEnabled;
   }

   public void setUniqueEntityId(final long uniqueEntityId) {
      this.uniqueEntityId = uniqueEntityId;
   }

   public void setRuntimeEntityId(final long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setPlayerGameType(final GameType playerGameType) {
      this.playerGameType = playerGameType;
   }

   public void setPlayerPosition(final Vector3f playerPosition) {
      this.playerPosition = playerPosition;
   }

   public void setRotation(final Vector2f rotation) {
      this.rotation = rotation;
   }

   public void setSeed(final long seed) {
      this.seed = seed;
   }

   public void setSpawnBiomeType(final SpawnBiomeType spawnBiomeType) {
      this.spawnBiomeType = spawnBiomeType;
   }

   public void setCustomBiomeName(final String customBiomeName) {
      this.customBiomeName = customBiomeName;
   }

   public void setDimensionId(final int dimensionId) {
      this.dimensionId = dimensionId;
   }

   public void setGeneratorId(final int generatorId) {
      this.generatorId = generatorId;
   }

   public void setLevelGameType(final GameType levelGameType) {
      this.levelGameType = levelGameType;
   }

   public void setDifficulty(final int difficulty) {
      this.difficulty = difficulty;
   }

   public void setDefaultSpawn(final Vector3i defaultSpawn) {
      this.defaultSpawn = defaultSpawn;
   }

   public void setAchievementsDisabled(final boolean achievementsDisabled) {
      this.achievementsDisabled = achievementsDisabled;
   }

   public void setDayCycleStopTime(final int dayCycleStopTime) {
      this.dayCycleStopTime = dayCycleStopTime;
   }

   public void setEduEditionOffers(final int eduEditionOffers) {
      this.eduEditionOffers = eduEditionOffers;
   }

   public void setEduFeaturesEnabled(final boolean eduFeaturesEnabled) {
      this.eduFeaturesEnabled = eduFeaturesEnabled;
   }

   public void setEducationProductionId(final String educationProductionId) {
      this.educationProductionId = educationProductionId;
   }

   public void setRainLevel(final float rainLevel) {
      this.rainLevel = rainLevel;
   }

   public void setLightningLevel(final float lightningLevel) {
      this.lightningLevel = lightningLevel;
   }

   public void setPlatformLockedContentConfirmed(final boolean platformLockedContentConfirmed) {
      this.platformLockedContentConfirmed = platformLockedContentConfirmed;
   }

   public void setMultiplayerGame(final boolean multiplayerGame) {
      this.multiplayerGame = multiplayerGame;
   }

   public void setBroadcastingToLan(final boolean broadcastingToLan) {
      this.broadcastingToLan = broadcastingToLan;
   }

   public void setXblBroadcastMode(final GamePublishSetting xblBroadcastMode) {
      this.xblBroadcastMode = xblBroadcastMode;
   }

   public void setPlatformBroadcastMode(final GamePublishSetting platformBroadcastMode) {
      this.platformBroadcastMode = platformBroadcastMode;
   }

   public void setCommandsEnabled(final boolean commandsEnabled) {
      this.commandsEnabled = commandsEnabled;
   }

   public void setTexturePacksRequired(final boolean texturePacksRequired) {
      this.texturePacksRequired = texturePacksRequired;
   }

   public void setExperimentsPreviouslyToggled(final boolean experimentsPreviouslyToggled) {
      this.experimentsPreviouslyToggled = experimentsPreviouslyToggled;
   }

   public void setBonusChestEnabled(final boolean bonusChestEnabled) {
      this.bonusChestEnabled = bonusChestEnabled;
   }

   public void setStartingWithMap(final boolean startingWithMap) {
      this.startingWithMap = startingWithMap;
   }

   public void setTrustingPlayers(final boolean trustingPlayers) {
      this.trustingPlayers = trustingPlayers;
   }

   public void setDefaultPlayerPermission(final PlayerPermission defaultPlayerPermission) {
      this.defaultPlayerPermission = defaultPlayerPermission;
   }

   public void setServerChunkTickRange(final int serverChunkTickRange) {
      this.serverChunkTickRange = serverChunkTickRange;
   }

   public void setBehaviorPackLocked(final boolean behaviorPackLocked) {
      this.behaviorPackLocked = behaviorPackLocked;
   }

   public void setResourcePackLocked(final boolean resourcePackLocked) {
      this.resourcePackLocked = resourcePackLocked;
   }

   public void setFromLockedWorldTemplate(final boolean fromLockedWorldTemplate) {
      this.fromLockedWorldTemplate = fromLockedWorldTemplate;
   }

   public void setUsingMsaGamertagsOnly(final boolean usingMsaGamertagsOnly) {
      this.usingMsaGamertagsOnly = usingMsaGamertagsOnly;
   }

   public void setFromWorldTemplate(final boolean fromWorldTemplate) {
      this.fromWorldTemplate = fromWorldTemplate;
   }

   public void setWorldTemplateOptionLocked(final boolean worldTemplateOptionLocked) {
      this.worldTemplateOptionLocked = worldTemplateOptionLocked;
   }

   public void setOnlySpawningV1Villagers(final boolean onlySpawningV1Villagers) {
      this.onlySpawningV1Villagers = onlySpawningV1Villagers;
   }

   public void setVanillaVersion(final String vanillaVersion) {
      this.vanillaVersion = vanillaVersion;
   }

   public void setLimitedWorldWidth(final int limitedWorldWidth) {
      this.limitedWorldWidth = limitedWorldWidth;
   }

   public void setLimitedWorldHeight(final int limitedWorldHeight) {
      this.limitedWorldHeight = limitedWorldHeight;
   }

   public void setNetherType(final boolean netherType) {
      this.netherType = netherType;
   }

   public void setEduSharedUriResource(final EduSharedUriResource eduSharedUriResource) {
      this.eduSharedUriResource = eduSharedUriResource;
   }

   public void setForceExperimentalGameplay(final OptionalBoolean forceExperimentalGameplay) {
      this.forceExperimentalGameplay = forceExperimentalGameplay;
   }

   public void setChatRestrictionLevel(final ChatRestrictionLevel chatRestrictionLevel) {
      this.chatRestrictionLevel = chatRestrictionLevel;
   }

   public void setDisablingPlayerInteractions(final boolean disablingPlayerInteractions) {
      this.disablingPlayerInteractions = disablingPlayerInteractions;
   }

   public void setDisablingPersonas(final boolean disablingPersonas) {
      this.disablingPersonas = disablingPersonas;
   }

   public void setDisablingCustomSkins(final boolean disablingCustomSkins) {
      this.disablingCustomSkins = disablingCustomSkins;
   }

   public void setLevelId(final String levelId) {
      this.levelId = levelId;
   }

   public void setLevelName(final CharSequence levelName) {
      this.levelName = levelName;
   }

   public void setPremiumWorldTemplateId(final String premiumWorldTemplateId) {
      this.premiumWorldTemplateId = premiumWorldTemplateId;
   }

   public void setTrial(final boolean trial) {
      this.trial = trial;
   }

   @Deprecated
   public void setAuthoritativeMovementMode(final AuthoritativeMovementMode authoritativeMovementMode) {
      this.authoritativeMovementMode = authoritativeMovementMode;
   }

   public void setRewindHistorySize(final int rewindHistorySize) {
      this.rewindHistorySize = rewindHistorySize;
   }

   public void setServerAuthoritativeBlockBreaking(final boolean serverAuthoritativeBlockBreaking) {
      this.serverAuthoritativeBlockBreaking = serverAuthoritativeBlockBreaking;
   }

   public void setCurrentTick(final long currentTick) {
      this.currentTick = currentTick;
   }

   public void setEnchantmentSeed(final int enchantmentSeed) {
      this.enchantmentSeed = enchantmentSeed;
   }

   public void setBlockPalette(final NbtList<NbtMap> blockPalette) {
      this.blockPalette = blockPalette;
   }

   @Deprecated
   public void setItemDefinitions(final List<ItemDefinition> itemDefinitions) {
      this.itemDefinitions = itemDefinitions;
   }

   public void setMultiplayerCorrelationId(final String multiplayerCorrelationId) {
      this.multiplayerCorrelationId = multiplayerCorrelationId;
   }

   public void setInventoriesServerAuthoritative(final boolean inventoriesServerAuthoritative) {
      this.inventoriesServerAuthoritative = inventoriesServerAuthoritative;
   }

   public void setServerEngine(final String serverEngine) {
      this.serverEngine = serverEngine;
   }

   public void setPlayerPropertyData(final NbtMap playerPropertyData) {
      this.playerPropertyData = playerPropertyData;
   }

   public void setBlockRegistryChecksum(final long blockRegistryChecksum) {
      this.blockRegistryChecksum = blockRegistryChecksum;
   }

   public void setWorldTemplateId(final UUID worldTemplateId) {
      this.worldTemplateId = worldTemplateId;
   }

   public void setEditorWorldType(final WorldType editorWorldType) {
      this.editorWorldType = editorWorldType;
   }

   public void setClientSideGenerationEnabled(final boolean clientSideGenerationEnabled) {
      this.clientSideGenerationEnabled = clientSideGenerationEnabled;
   }

   public void setEmoteChatMuted(final boolean emoteChatMuted) {
      this.emoteChatMuted = emoteChatMuted;
   }

   public void setBlockNetworkIdsHashed(final boolean blockNetworkIdsHashed) {
      this.blockNetworkIdsHashed = blockNetworkIdsHashed;
   }

   public void setCreatedInEditor(final boolean createdInEditor) {
      this.createdInEditor = createdInEditor;
   }

   public void setExportedFromEditor(final boolean exportedFromEditor) {
      this.exportedFromEditor = exportedFromEditor;
   }

   public void setNetworkPermissions(final NetworkPermissions networkPermissions) {
      this.networkPermissions = networkPermissions;
   }

   public void setHardcore(final boolean hardcore) {
      this.hardcore = hardcore;
   }

   public void setServerId(final String serverId) {
      this.serverId = serverId;
   }

   public void setWorldId(final String worldId) {
      this.worldId = worldId;
   }

   public void setScenarioId(final String scenarioId) {
      this.scenarioId = scenarioId;
   }

   public void setOwnerId(final String ownerId) {
      this.ownerId = ownerId;
   }

   public void setTickDeathSystemsEnabled(final boolean tickDeathSystemsEnabled) {
      this.tickDeathSystemsEnabled = tickDeathSystemsEnabled;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StartGamePacket)) {
         return false;
      }

      StartGamePacket other = (StartGamePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.uniqueEntityId != other.uniqueEntityId) {
         return false;
      }

      if (this.runtimeEntityId != other.runtimeEntityId) {
         return false;
      }

      if (this.seed != other.seed) {
         return false;
      }

      if (this.dimensionId != other.dimensionId) {
         return false;
      }

      if (this.generatorId != other.generatorId) {
         return false;
      }

      if (this.difficulty != other.difficulty) {
         return false;
      }

      if (this.achievementsDisabled != other.achievementsDisabled) {
         return false;
      }

      if (this.dayCycleStopTime != other.dayCycleStopTime) {
         return false;
      }

      if (this.eduEditionOffers != other.eduEditionOffers) {
         return false;
      }

      if (this.eduFeaturesEnabled != other.eduFeaturesEnabled) {
         return false;
      }

      if (Float.compare(this.rainLevel, other.rainLevel) != 0) {
         return false;
      }

      if (Float.compare(this.lightningLevel, other.lightningLevel) != 0) {
         return false;
      }

      if (this.platformLockedContentConfirmed != other.platformLockedContentConfirmed) {
         return false;
      }

      if (this.multiplayerGame != other.multiplayerGame) {
         return false;
      }

      if (this.broadcastingToLan != other.broadcastingToLan) {
         return false;
      }

      if (this.commandsEnabled != other.commandsEnabled) {
         return false;
      }

      if (this.texturePacksRequired != other.texturePacksRequired) {
         return false;
      }

      if (this.experimentsPreviouslyToggled != other.experimentsPreviouslyToggled) {
         return false;
      }

      if (this.bonusChestEnabled != other.bonusChestEnabled) {
         return false;
      }

      if (this.startingWithMap != other.startingWithMap) {
         return false;
      }

      if (this.trustingPlayers != other.trustingPlayers) {
         return false;
      }

      if (this.serverChunkTickRange != other.serverChunkTickRange) {
         return false;
      }

      if (this.behaviorPackLocked != other.behaviorPackLocked) {
         return false;
      }

      if (this.resourcePackLocked != other.resourcePackLocked) {
         return false;
      }

      if (this.fromLockedWorldTemplate != other.fromLockedWorldTemplate) {
         return false;
      }

      if (this.usingMsaGamertagsOnly != other.usingMsaGamertagsOnly) {
         return false;
      }

      if (this.fromWorldTemplate != other.fromWorldTemplate) {
         return false;
      }

      if (this.worldTemplateOptionLocked != other.worldTemplateOptionLocked) {
         return false;
      }

      if (this.onlySpawningV1Villagers != other.onlySpawningV1Villagers) {
         return false;
      }

      if (this.limitedWorldWidth != other.limitedWorldWidth) {
         return false;
      }

      if (this.limitedWorldHeight != other.limitedWorldHeight) {
         return false;
      }

      if (this.netherType != other.netherType) {
         return false;
      }

      if (this.disablingPlayerInteractions != other.disablingPlayerInteractions) {
         return false;
      }

      if (this.disablingPersonas != other.disablingPersonas) {
         return false;
      }

      if (this.disablingCustomSkins != other.disablingCustomSkins) {
         return false;
      }

      if (this.trial != other.trial) {
         return false;
      }

      if (this.rewindHistorySize != other.rewindHistorySize) {
         return false;
      }

      if (this.serverAuthoritativeBlockBreaking != other.serverAuthoritativeBlockBreaking) {
         return false;
      }

      if (this.currentTick != other.currentTick) {
         return false;
      }

      if (this.enchantmentSeed != other.enchantmentSeed) {
         return false;
      }

      if (this.inventoriesServerAuthoritative != other.inventoriesServerAuthoritative) {
         return false;
      }

      if (this.blockRegistryChecksum != other.blockRegistryChecksum) {
         return false;
      }

      if (this.clientSideGenerationEnabled != other.clientSideGenerationEnabled) {
         return false;
      }

      if (this.emoteChatMuted != other.emoteChatMuted) {
         return false;
      }

      if (this.blockNetworkIdsHashed != other.blockNetworkIdsHashed) {
         return false;
      }

      if (this.createdInEditor != other.createdInEditor) {
         return false;
      }

      if (this.exportedFromEditor != other.exportedFromEditor) {
         return false;
      }

      if (this.hardcore != other.hardcore) {
         return false;
      }

      if (this.tickDeathSystemsEnabled != other.tickDeathSystemsEnabled) {
         return false;
      }

      Object this$gamerules = this.gamerules;
      Object other$gamerules = other.gamerules;
      if (this$gamerules == null ? other$gamerules == null : this$gamerules.equals(other$gamerules)) {
         Object this$playerGameType = this.playerGameType;
         Object other$playerGameType = other.playerGameType;
         if (this$playerGameType == null ? other$playerGameType == null : this$playerGameType.equals(other$playerGameType)) {
            Object this$playerPosition = this.playerPosition;
            Object other$playerPosition = other.playerPosition;
            if (this$playerPosition == null ? other$playerPosition == null : this$playerPosition.equals(other$playerPosition)) {
               Object this$rotation = this.rotation;
               Object other$rotation = other.rotation;
               if (this$rotation == null ? other$rotation == null : this$rotation.equals(other$rotation)) {
                  Object this$spawnBiomeType = this.spawnBiomeType;
                  Object other$spawnBiomeType = other.spawnBiomeType;
                  if (this$spawnBiomeType == null ? other$spawnBiomeType == null : this$spawnBiomeType.equals(other$spawnBiomeType)) {
                     Object this$customBiomeName = this.customBiomeName;
                     Object other$customBiomeName = other.customBiomeName;
                     if (this$customBiomeName == null ? other$customBiomeName == null : this$customBiomeName.equals(other$customBiomeName)) {
                        Object this$levelGameType = this.levelGameType;
                        Object other$levelGameType = other.levelGameType;
                        if (this$levelGameType == null ? other$levelGameType == null : this$levelGameType.equals(other$levelGameType)) {
                           Object this$defaultSpawn = this.defaultSpawn;
                           Object other$defaultSpawn = other.defaultSpawn;
                           if (this$defaultSpawn == null ? other$defaultSpawn == null : this$defaultSpawn.equals(other$defaultSpawn)) {
                              Object this$educationProductionId = this.educationProductionId;
                              Object other$educationProductionId = other.educationProductionId;
                              if (this$educationProductionId == null
                                 ? other$educationProductionId == null
                                 : this$educationProductionId.equals(other$educationProductionId)) {
                                 Object this$xblBroadcastMode = this.xblBroadcastMode;
                                 Object other$xblBroadcastMode = other.xblBroadcastMode;
                                 if (this$xblBroadcastMode == null ? other$xblBroadcastMode == null : this$xblBroadcastMode.equals(other$xblBroadcastMode)) {
                                    Object this$platformBroadcastMode = this.platformBroadcastMode;
                                    Object other$platformBroadcastMode = other.platformBroadcastMode;
                                    if (this$platformBroadcastMode == null
                                       ? other$platformBroadcastMode == null
                                       : this$platformBroadcastMode.equals(other$platformBroadcastMode)) {
                                       Object this$experiments = this.experiments;
                                       Object other$experiments = other.experiments;
                                       if (this$experiments == null ? other$experiments == null : this$experiments.equals(other$experiments)) {
                                          Object this$defaultPlayerPermission = this.defaultPlayerPermission;
                                          Object other$defaultPlayerPermission = other.defaultPlayerPermission;
                                          if (this$defaultPlayerPermission == null
                                             ? other$defaultPlayerPermission == null
                                             : this$defaultPlayerPermission.equals(other$defaultPlayerPermission)) {
                                             Object this$vanillaVersion = this.vanillaVersion;
                                             Object other$vanillaVersion = other.vanillaVersion;
                                             if (this$vanillaVersion == null ? other$vanillaVersion == null : this$vanillaVersion.equals(other$vanillaVersion)) {
                                                Object this$eduSharedUriResource = this.eduSharedUriResource;
                                                Object other$eduSharedUriResource = other.eduSharedUriResource;
                                                if (this$eduSharedUriResource == null
                                                   ? other$eduSharedUriResource == null
                                                   : this$eduSharedUriResource.equals(other$eduSharedUriResource)) {
                                                   Object this$forceExperimentalGameplay = this.forceExperimentalGameplay;
                                                   Object other$forceExperimentalGameplay = other.forceExperimentalGameplay;
                                                   if (this$forceExperimentalGameplay == null
                                                      ? other$forceExperimentalGameplay == null
                                                      : this$forceExperimentalGameplay.equals(other$forceExperimentalGameplay)) {
                                                      Object this$chatRestrictionLevel = this.chatRestrictionLevel;
                                                      Object other$chatRestrictionLevel = other.chatRestrictionLevel;
                                                      if (this$chatRestrictionLevel == null
                                                         ? other$chatRestrictionLevel == null
                                                         : this$chatRestrictionLevel.equals(other$chatRestrictionLevel)) {
                                                         Object this$levelId = this.levelId;
                                                         Object other$levelId = other.levelId;
                                                         if (this$levelId == null ? other$levelId == null : this$levelId.equals(other$levelId)) {
                                                            Object this$levelName = this.levelName;
                                                            Object other$levelName = other.levelName;
                                                            if (this$levelName == null ? other$levelName == null : this$levelName.equals(other$levelName)) {
                                                               Object this$premiumWorldTemplateId = this.premiumWorldTemplateId;
                                                               Object other$premiumWorldTemplateId = other.premiumWorldTemplateId;
                                                               if (this$premiumWorldTemplateId == null
                                                                  ? other$premiumWorldTemplateId == null
                                                                  : this$premiumWorldTemplateId.equals(other$premiumWorldTemplateId)) {
                                                                  Object this$authoritativeMovementMode = this.authoritativeMovementMode;
                                                                  Object other$authoritativeMovementMode = other.authoritativeMovementMode;
                                                                  if (this$authoritativeMovementMode == null
                                                                     ? other$authoritativeMovementMode == null
                                                                     : this$authoritativeMovementMode.equals(other$authoritativeMovementMode)) {
                                                                     Object this$blockPalette = this.blockPalette;
                                                                     Object other$blockPalette = other.blockPalette;
                                                                     if (this$blockPalette == null
                                                                        ? other$blockPalette == null
                                                                        : this$blockPalette.equals(other$blockPalette)) {
                                                                        Object this$blockProperties = this.blockProperties;
                                                                        Object other$blockProperties = other.blockProperties;
                                                                        if (this$blockProperties == null
                                                                           ? other$blockProperties == null
                                                                           : this$blockProperties.equals(other$blockProperties)) {
                                                                           Object this$itemDefinitions = this.itemDefinitions;
                                                                           Object other$itemDefinitions = other.itemDefinitions;
                                                                           if (this$itemDefinitions == null
                                                                              ? other$itemDefinitions == null
                                                                              : this$itemDefinitions.equals(other$itemDefinitions)) {
                                                                              Object this$multiplayerCorrelationId = this.multiplayerCorrelationId;
                                                                              Object other$multiplayerCorrelationId = other.multiplayerCorrelationId;
                                                                              if (this$multiplayerCorrelationId == null
                                                                                 ? other$multiplayerCorrelationId == null
                                                                                 : this$multiplayerCorrelationId.equals(other$multiplayerCorrelationId)) {
                                                                                 Object this$serverEngine = this.serverEngine;
                                                                                 Object other$serverEngine = other.serverEngine;
                                                                                 if (this$serverEngine == null
                                                                                    ? other$serverEngine == null
                                                                                    : this$serverEngine.equals(other$serverEngine)) {
                                                                                    Object this$playerPropertyData = this.playerPropertyData;
                                                                                    Object other$playerPropertyData = other.playerPropertyData;
                                                                                    if (this$playerPropertyData == null
                                                                                       ? other$playerPropertyData == null
                                                                                       : this$playerPropertyData.equals(other$playerPropertyData)) {
                                                                                       Object this$worldTemplateId = this.worldTemplateId;
                                                                                       Object other$worldTemplateId = other.worldTemplateId;
                                                                                       if (this$worldTemplateId == null
                                                                                          ? other$worldTemplateId == null
                                                                                          : this$worldTemplateId.equals(other$worldTemplateId)) {
                                                                                          Object this$editorWorldType = this.editorWorldType;
                                                                                          Object other$editorWorldType = other.editorWorldType;
                                                                                          if (this$editorWorldType == null
                                                                                             ? other$editorWorldType == null
                                                                                             : this$editorWorldType.equals(other$editorWorldType)) {
                                                                                             Object this$networkPermissions = this.networkPermissions;
                                                                                             Object other$networkPermissions = other.networkPermissions;
                                                                                             if (this$networkPermissions == null
                                                                                                ? other$networkPermissions == null
                                                                                                : this$networkPermissions.equals(other$networkPermissions)) {
                                                                                                Object this$serverId = this.serverId;
                                                                                                Object other$serverId = other.serverId;
                                                                                                if (this$serverId == null
                                                                                                   ? other$serverId == null
                                                                                                   : this$serverId.equals(other$serverId)) {
                                                                                                   Object this$worldId = this.worldId;
                                                                                                   Object other$worldId = other.worldId;
                                                                                                   if (this$worldId == null
                                                                                                      ? other$worldId == null
                                                                                                      : this$worldId.equals(other$worldId)) {
                                                                                                      Object this$scenarioId = this.scenarioId;
                                                                                                      Object other$scenarioId = other.scenarioId;
                                                                                                      if (this$scenarioId == null
                                                                                                         ? other$scenarioId == null
                                                                                                         : this$scenarioId.equals(other$scenarioId)) {
                                                                                                         Object this$ownerId = this.ownerId;
                                                                                                         Object other$ownerId = other.ownerId;
                                                                                                         return this$ownerId == null
                                                                                                            ? other$ownerId == null
                                                                                                            : this$ownerId.equals(other$ownerId);
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
      return other instanceof StartGamePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $uniqueEntityId = this.uniqueEntityId;
      result = result * 59 + (int)($uniqueEntityId >>> 32 ^ $uniqueEntityId);
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      long $seed = this.seed;
      result = result * 59 + (int)($seed >>> 32 ^ $seed);
      result = result * 59 + this.dimensionId;
      result = result * 59 + this.generatorId;
      result = result * 59 + this.difficulty;
      result = result * 59 + (this.achievementsDisabled ? 79 : 97);
      result = result * 59 + this.dayCycleStopTime;
      result = result * 59 + this.eduEditionOffers;
      result = result * 59 + (this.eduFeaturesEnabled ? 79 : 97);
      result = result * 59 + Float.floatToIntBits(this.rainLevel);
      result = result * 59 + Float.floatToIntBits(this.lightningLevel);
      result = result * 59 + (this.platformLockedContentConfirmed ? 79 : 97);
      result = result * 59 + (this.multiplayerGame ? 79 : 97);
      result = result * 59 + (this.broadcastingToLan ? 79 : 97);
      result = result * 59 + (this.commandsEnabled ? 79 : 97);
      result = result * 59 + (this.texturePacksRequired ? 79 : 97);
      result = result * 59 + (this.experimentsPreviouslyToggled ? 79 : 97);
      result = result * 59 + (this.bonusChestEnabled ? 79 : 97);
      result = result * 59 + (this.startingWithMap ? 79 : 97);
      result = result * 59 + (this.trustingPlayers ? 79 : 97);
      result = result * 59 + this.serverChunkTickRange;
      result = result * 59 + (this.behaviorPackLocked ? 79 : 97);
      result = result * 59 + (this.resourcePackLocked ? 79 : 97);
      result = result * 59 + (this.fromLockedWorldTemplate ? 79 : 97);
      result = result * 59 + (this.usingMsaGamertagsOnly ? 79 : 97);
      result = result * 59 + (this.fromWorldTemplate ? 79 : 97);
      result = result * 59 + (this.worldTemplateOptionLocked ? 79 : 97);
      result = result * 59 + (this.onlySpawningV1Villagers ? 79 : 97);
      result = result * 59 + this.limitedWorldWidth;
      result = result * 59 + this.limitedWorldHeight;
      result = result * 59 + (this.netherType ? 79 : 97);
      result = result * 59 + (this.disablingPlayerInteractions ? 79 : 97);
      result = result * 59 + (this.disablingPersonas ? 79 : 97);
      result = result * 59 + (this.disablingCustomSkins ? 79 : 97);
      result = result * 59 + (this.trial ? 79 : 97);
      result = result * 59 + this.rewindHistorySize;
      result = result * 59 + (this.serverAuthoritativeBlockBreaking ? 79 : 97);
      long $currentTick = this.currentTick;
      result = result * 59 + (int)($currentTick >>> 32 ^ $currentTick);
      result = result * 59 + this.enchantmentSeed;
      result = result * 59 + (this.inventoriesServerAuthoritative ? 79 : 97);
      long $blockRegistryChecksum = this.blockRegistryChecksum;
      result = result * 59 + (int)($blockRegistryChecksum >>> 32 ^ $blockRegistryChecksum);
      result = result * 59 + (this.clientSideGenerationEnabled ? 79 : 97);
      result = result * 59 + (this.emoteChatMuted ? 79 : 97);
      result = result * 59 + (this.blockNetworkIdsHashed ? 79 : 97);
      result = result * 59 + (this.createdInEditor ? 79 : 97);
      result = result * 59 + (this.exportedFromEditor ? 79 : 97);
      result = result * 59 + (this.hardcore ? 79 : 97);
      result = result * 59 + (this.tickDeathSystemsEnabled ? 79 : 97);
      Object $gamerules = this.gamerules;
      result = result * 59 + ($gamerules == null ? 43 : $gamerules.hashCode());
      Object $playerGameType = this.playerGameType;
      result = result * 59 + ($playerGameType == null ? 43 : $playerGameType.hashCode());
      Object $playerPosition = this.playerPosition;
      result = result * 59 + ($playerPosition == null ? 43 : $playerPosition.hashCode());
      Object $rotation = this.rotation;
      result = result * 59 + ($rotation == null ? 43 : $rotation.hashCode());
      Object $spawnBiomeType = this.spawnBiomeType;
      result = result * 59 + ($spawnBiomeType == null ? 43 : $spawnBiomeType.hashCode());
      Object $customBiomeName = this.customBiomeName;
      result = result * 59 + ($customBiomeName == null ? 43 : $customBiomeName.hashCode());
      Object $levelGameType = this.levelGameType;
      result = result * 59 + ($levelGameType == null ? 43 : $levelGameType.hashCode());
      Object $defaultSpawn = this.defaultSpawn;
      result = result * 59 + ($defaultSpawn == null ? 43 : $defaultSpawn.hashCode());
      Object $educationProductionId = this.educationProductionId;
      result = result * 59 + ($educationProductionId == null ? 43 : $educationProductionId.hashCode());
      Object $xblBroadcastMode = this.xblBroadcastMode;
      result = result * 59 + ($xblBroadcastMode == null ? 43 : $xblBroadcastMode.hashCode());
      Object $platformBroadcastMode = this.platformBroadcastMode;
      result = result * 59 + ($platformBroadcastMode == null ? 43 : $platformBroadcastMode.hashCode());
      Object $experiments = this.experiments;
      result = result * 59 + ($experiments == null ? 43 : $experiments.hashCode());
      Object $defaultPlayerPermission = this.defaultPlayerPermission;
      result = result * 59 + ($defaultPlayerPermission == null ? 43 : $defaultPlayerPermission.hashCode());
      Object $vanillaVersion = this.vanillaVersion;
      result = result * 59 + ($vanillaVersion == null ? 43 : $vanillaVersion.hashCode());
      Object $eduSharedUriResource = this.eduSharedUriResource;
      result = result * 59 + ($eduSharedUriResource == null ? 43 : $eduSharedUriResource.hashCode());
      Object $forceExperimentalGameplay = this.forceExperimentalGameplay;
      result = result * 59 + ($forceExperimentalGameplay == null ? 43 : $forceExperimentalGameplay.hashCode());
      Object $chatRestrictionLevel = this.chatRestrictionLevel;
      result = result * 59 + ($chatRestrictionLevel == null ? 43 : $chatRestrictionLevel.hashCode());
      Object $levelId = this.levelId;
      result = result * 59 + ($levelId == null ? 43 : $levelId.hashCode());
      Object $levelName = this.levelName;
      result = result * 59 + ($levelName == null ? 43 : $levelName.hashCode());
      Object $premiumWorldTemplateId = this.premiumWorldTemplateId;
      result = result * 59 + ($premiumWorldTemplateId == null ? 43 : $premiumWorldTemplateId.hashCode());
      Object $authoritativeMovementMode = this.authoritativeMovementMode;
      result = result * 59 + ($authoritativeMovementMode == null ? 43 : $authoritativeMovementMode.hashCode());
      Object $blockPalette = this.blockPalette;
      result = result * 59 + ($blockPalette == null ? 43 : $blockPalette.hashCode());
      Object $blockProperties = this.blockProperties;
      result = result * 59 + ($blockProperties == null ? 43 : $blockProperties.hashCode());
      Object $itemDefinitions = this.itemDefinitions;
      result = result * 59 + ($itemDefinitions == null ? 43 : $itemDefinitions.hashCode());
      Object $multiplayerCorrelationId = this.multiplayerCorrelationId;
      result = result * 59 + ($multiplayerCorrelationId == null ? 43 : $multiplayerCorrelationId.hashCode());
      Object $serverEngine = this.serverEngine;
      result = result * 59 + ($serverEngine == null ? 43 : $serverEngine.hashCode());
      Object $playerPropertyData = this.playerPropertyData;
      result = result * 59 + ($playerPropertyData == null ? 43 : $playerPropertyData.hashCode());
      Object $worldTemplateId = this.worldTemplateId;
      result = result * 59 + ($worldTemplateId == null ? 43 : $worldTemplateId.hashCode());
      Object $editorWorldType = this.editorWorldType;
      result = result * 59 + ($editorWorldType == null ? 43 : $editorWorldType.hashCode());
      Object $networkPermissions = this.networkPermissions;
      result = result * 59 + ($networkPermissions == null ? 43 : $networkPermissions.hashCode());
      Object $serverId = this.serverId;
      result = result * 59 + ($serverId == null ? 43 : $serverId.hashCode());
      Object $worldId = this.worldId;
      result = result * 59 + ($worldId == null ? 43 : $worldId.hashCode());
      Object $scenarioId = this.scenarioId;
      result = result * 59 + ($scenarioId == null ? 43 : $scenarioId.hashCode());
      Object $ownerId = this.ownerId;
      return result * 59 + ($ownerId == null ? 43 : $ownerId.hashCode());
   }

   @Override
   public String toString() {
      return "StartGamePacket(gamerules="
         + this.gamerules
         + ", uniqueEntityId="
         + this.uniqueEntityId
         + ", runtimeEntityId="
         + this.runtimeEntityId
         + ", playerGameType="
         + this.playerGameType
         + ", playerPosition="
         + this.playerPosition
         + ", rotation="
         + this.rotation
         + ", seed="
         + this.seed
         + ", spawnBiomeType="
         + this.spawnBiomeType
         + ", customBiomeName="
         + this.customBiomeName
         + ", dimensionId="
         + this.dimensionId
         + ", generatorId="
         + this.generatorId
         + ", levelGameType="
         + this.levelGameType
         + ", difficulty="
         + this.difficulty
         + ", defaultSpawn="
         + this.defaultSpawn
         + ", achievementsDisabled="
         + this.achievementsDisabled
         + ", dayCycleStopTime="
         + this.dayCycleStopTime
         + ", eduEditionOffers="
         + this.eduEditionOffers
         + ", eduFeaturesEnabled="
         + this.eduFeaturesEnabled
         + ", educationProductionId="
         + this.educationProductionId
         + ", rainLevel="
         + this.rainLevel
         + ", lightningLevel="
         + this.lightningLevel
         + ", platformLockedContentConfirmed="
         + this.platformLockedContentConfirmed
         + ", multiplayerGame="
         + this.multiplayerGame
         + ", broadcastingToLan="
         + this.broadcastingToLan
         + ", xblBroadcastMode="
         + this.xblBroadcastMode
         + ", platformBroadcastMode="
         + this.platformBroadcastMode
         + ", commandsEnabled="
         + this.commandsEnabled
         + ", texturePacksRequired="
         + this.texturePacksRequired
         + ", experiments="
         + this.experiments
         + ", experimentsPreviouslyToggled="
         + this.experimentsPreviouslyToggled
         + ", bonusChestEnabled="
         + this.bonusChestEnabled
         + ", startingWithMap="
         + this.startingWithMap
         + ", trustingPlayers="
         + this.trustingPlayers
         + ", defaultPlayerPermission="
         + this.defaultPlayerPermission
         + ", serverChunkTickRange="
         + this.serverChunkTickRange
         + ", behaviorPackLocked="
         + this.behaviorPackLocked
         + ", resourcePackLocked="
         + this.resourcePackLocked
         + ", fromLockedWorldTemplate="
         + this.fromLockedWorldTemplate
         + ", usingMsaGamertagsOnly="
         + this.usingMsaGamertagsOnly
         + ", fromWorldTemplate="
         + this.fromWorldTemplate
         + ", worldTemplateOptionLocked="
         + this.worldTemplateOptionLocked
         + ", onlySpawningV1Villagers="
         + this.onlySpawningV1Villagers
         + ", vanillaVersion="
         + this.vanillaVersion
         + ", limitedWorldWidth="
         + this.limitedWorldWidth
         + ", limitedWorldHeight="
         + this.limitedWorldHeight
         + ", netherType="
         + this.netherType
         + ", eduSharedUriResource="
         + this.eduSharedUriResource
         + ", forceExperimentalGameplay="
         + this.forceExperimentalGameplay
         + ", chatRestrictionLevel="
         + this.chatRestrictionLevel
         + ", disablingPlayerInteractions="
         + this.disablingPlayerInteractions
         + ", disablingPersonas="
         + this.disablingPersonas
         + ", disablingCustomSkins="
         + this.disablingCustomSkins
         + ", levelId="
         + this.levelId
         + ", levelName="
         + this.levelName
         + ", premiumWorldTemplateId="
         + this.premiumWorldTemplateId
         + ", trial="
         + this.trial
         + ", authoritativeMovementMode="
         + this.authoritativeMovementMode
         + ", rewindHistorySize="
         + this.rewindHistorySize
         + ", serverAuthoritativeBlockBreaking="
         + this.serverAuthoritativeBlockBreaking
         + ", currentTick="
         + this.currentTick
         + ", enchantmentSeed="
         + this.enchantmentSeed
         + ", blockProperties="
         + this.blockProperties
         + ", multiplayerCorrelationId="
         + this.multiplayerCorrelationId
         + ", inventoriesServerAuthoritative="
         + this.inventoriesServerAuthoritative
         + ", serverEngine="
         + this.serverEngine
         + ", playerPropertyData="
         + this.playerPropertyData
         + ", blockRegistryChecksum="
         + this.blockRegistryChecksum
         + ", worldTemplateId="
         + this.worldTemplateId
         + ", editorWorldType="
         + this.editorWorldType
         + ", clientSideGenerationEnabled="
         + this.clientSideGenerationEnabled
         + ", emoteChatMuted="
         + this.emoteChatMuted
         + ", blockNetworkIdsHashed="
         + this.blockNetworkIdsHashed
         + ", createdInEditor="
         + this.createdInEditor
         + ", exportedFromEditor="
         + this.exportedFromEditor
         + ", networkPermissions="
         + this.networkPermissions
         + ", hardcore="
         + this.hardcore
         + ", serverId="
         + this.serverId
         + ", worldId="
         + this.worldId
         + ", scenarioId="
         + this.scenarioId
         + ", ownerId="
         + this.ownerId
         + ", tickDeathSystemsEnabled="
         + this.tickDeathSystemsEnabled
         + ")";
   }
}
