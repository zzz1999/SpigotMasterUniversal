package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.cloudburstmc.math.vector.Vector2f;
import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.protocol.bedrock.data.AttributeData;
import org.cloudburstmc.protocol.bedrock.data.entity.EntityDataMap;
import org.cloudburstmc.protocol.bedrock.data.entity.EntityLinkData;
import org.cloudburstmc.protocol.bedrock.data.entity.EntityProperties;
import org.cloudburstmc.protocol.common.PacketSignal;

public class AddEntityPacket implements BedrockPacket {
   private List<AttributeData> attributes = new ObjectArrayList<>();
   private EntityDataMap metadata = new EntityDataMap();
   private List<EntityLinkData> entityLinks = new ObjectArrayList<>();
   private long uniqueEntityId;
   private long runtimeEntityId;
   private String identifier;
   private int entityType;
   private Vector3f position;
   private Vector3f motion;
   private Vector2f rotation;
   private float headRotation;
   private float bodyRotation;
   private final EntityProperties properties = new EntityProperties();

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.ADD_ENTITY;
   }

   public AddEntityPacket clone() {
      try {
         return (AddEntityPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public List<AttributeData> getAttributes() {
      return this.attributes;
   }

   public EntityDataMap getMetadata() {
      return this.metadata;
   }

   public List<EntityLinkData> getEntityLinks() {
      return this.entityLinks;
   }

   public long getUniqueEntityId() {
      return this.uniqueEntityId;
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public String getIdentifier() {
      return this.identifier;
   }

   public int getEntityType() {
      return this.entityType;
   }

   public Vector3f getPosition() {
      return this.position;
   }

   public Vector3f getMotion() {
      return this.motion;
   }

   public Vector2f getRotation() {
      return this.rotation;
   }

   public float getHeadRotation() {
      return this.headRotation;
   }

   public float getBodyRotation() {
      return this.bodyRotation;
   }

   public EntityProperties getProperties() {
      return this.properties;
   }

   public void setAttributes(final List<AttributeData> attributes) {
      this.attributes = attributes;
   }

   public void setMetadata(final EntityDataMap metadata) {
      this.metadata = metadata;
   }

   public void setEntityLinks(final List<EntityLinkData> entityLinks) {
      this.entityLinks = entityLinks;
   }

   public void setUniqueEntityId(final long uniqueEntityId) {
      this.uniqueEntityId = uniqueEntityId;
   }

   public void setRuntimeEntityId(final long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setIdentifier(final String identifier) {
      this.identifier = identifier;
   }

   public void setEntityType(final int entityType) {
      this.entityType = entityType;
   }

   public void setPosition(final Vector3f position) {
      this.position = position;
   }

   public void setMotion(final Vector3f motion) {
      this.motion = motion;
   }

   public void setRotation(final Vector2f rotation) {
      this.rotation = rotation;
   }

   public void setHeadRotation(final float headRotation) {
      this.headRotation = headRotation;
   }

   public void setBodyRotation(final float bodyRotation) {
      this.bodyRotation = bodyRotation;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AddEntityPacket)) {
         return false;
      }

      AddEntityPacket other = (AddEntityPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.uniqueEntityId != other.uniqueEntityId) {
         return false;
      }

      if (this.runtimeEntityId != other.runtimeEntityId) {
         return false;
      }

      if (this.entityType != other.entityType) {
         return false;
      }

      if (Float.compare(this.headRotation, other.headRotation) != 0) {
         return false;
      }

      if (Float.compare(this.bodyRotation, other.bodyRotation) != 0) {
         return false;
      }

      Object this$attributes = this.attributes;
      Object other$attributes = other.attributes;
      if (this$attributes == null ? other$attributes == null : this$attributes.equals(other$attributes)) {
         Object this$metadata = this.metadata;
         Object other$metadata = other.metadata;
         if (this$metadata == null ? other$metadata == null : this$metadata.equals(other$metadata)) {
            Object this$entityLinks = this.entityLinks;
            Object other$entityLinks = other.entityLinks;
            if (this$entityLinks == null ? other$entityLinks == null : this$entityLinks.equals(other$entityLinks)) {
               Object this$identifier = this.identifier;
               Object other$identifier = other.identifier;
               if (this$identifier == null ? other$identifier == null : this$identifier.equals(other$identifier)) {
                  Object this$position = this.position;
                  Object other$position = other.position;
                  if (this$position == null ? other$position == null : this$position.equals(other$position)) {
                     Object this$motion = this.motion;
                     Object other$motion = other.motion;
                     if (this$motion == null ? other$motion == null : this$motion.equals(other$motion)) {
                        Object this$rotation = this.rotation;
                        Object other$rotation = other.rotation;
                        if (this$rotation == null ? other$rotation == null : this$rotation.equals(other$rotation)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AddEntityPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $uniqueEntityId = this.uniqueEntityId;
      result = result * 59 + (int)($uniqueEntityId >>> 32 ^ $uniqueEntityId);
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      result = result * 59 + this.entityType;
      result = result * 59 + Float.floatToIntBits(this.headRotation);
      result = result * 59 + Float.floatToIntBits(this.bodyRotation);
      Object $attributes = this.attributes;
      result = result * 59 + ($attributes == null ? 43 : $attributes.hashCode());
      Object $metadata = this.metadata;
      result = result * 59 + ($metadata == null ? 43 : $metadata.hashCode());
      Object $entityLinks = this.entityLinks;
      result = result * 59 + ($entityLinks == null ? 43 : $entityLinks.hashCode());
      Object $identifier = this.identifier;
      result = result * 59 + ($identifier == null ? 43 : $identifier.hashCode());
      Object $position = this.position;
      result = result * 59 + ($position == null ? 43 : $position.hashCode());
      Object $motion = this.motion;
      result = result * 59 + ($motion == null ? 43 : $motion.hashCode());
      Object $rotation = this.rotation;
      result = result * 59 + ($rotation == null ? 43 : $rotation.hashCode());
      Object $properties = this.properties;
      return result * 59 + ($properties == null ? 43 : $properties.hashCode());
   }

   @Override
   public String toString() {
      return "AddEntityPacket(attributes="
         + this.attributes
         + ", metadata="
         + this.metadata
         + ", entityLinks="
         + this.entityLinks
         + ", uniqueEntityId="
         + this.uniqueEntityId
         + ", runtimeEntityId="
         + this.runtimeEntityId
         + ", identifier="
         + this.identifier
         + ", entityType="
         + this.entityType
         + ", position="
         + this.position
         + ", motion="
         + this.motion
         + ", rotation="
         + this.rotation
         + ", headRotation="
         + this.headRotation
         + ", bodyRotation="
         + this.bodyRotation
         + ", properties="
         + this.properties
         + ")";
   }
}
