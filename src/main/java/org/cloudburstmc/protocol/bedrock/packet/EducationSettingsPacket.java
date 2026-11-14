package org.cloudburstmc.protocol.bedrock.packet;

import java.util.Optional;
import org.cloudburstmc.protocol.common.PacketSignal;
import org.cloudburstmc.protocol.common.util.OptionalBoolean;

public class EducationSettingsPacket implements BedrockPacket {
   private String codeBuilderUri;
   private String codeBuilderTitle;
   private boolean canResizeCodeBuilder;
   private boolean disableLegacyTitle;
   private String postProcessFilter;
   private String screenshotBorderPath;
   private OptionalBoolean entityCapabilities;
   private Optional<String> overrideUri;
   private boolean quizAttached;
   private OptionalBoolean externalLinkSettings;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.EDUCATION_SETTINGS;
   }

   public EducationSettingsPacket clone() {
      try {
         return (EducationSettingsPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public String getCodeBuilderUri() {
      return this.codeBuilderUri;
   }

   public String getCodeBuilderTitle() {
      return this.codeBuilderTitle;
   }

   public boolean isCanResizeCodeBuilder() {
      return this.canResizeCodeBuilder;
   }

   public boolean isDisableLegacyTitle() {
      return this.disableLegacyTitle;
   }

   public String getPostProcessFilter() {
      return this.postProcessFilter;
   }

   public String getScreenshotBorderPath() {
      return this.screenshotBorderPath;
   }

   public OptionalBoolean getEntityCapabilities() {
      return this.entityCapabilities;
   }

   public Optional<String> getOverrideUri() {
      return this.overrideUri;
   }

   public boolean isQuizAttached() {
      return this.quizAttached;
   }

   public OptionalBoolean getExternalLinkSettings() {
      return this.externalLinkSettings;
   }

   public void setCodeBuilderUri(final String codeBuilderUri) {
      this.codeBuilderUri = codeBuilderUri;
   }

   public void setCodeBuilderTitle(final String codeBuilderTitle) {
      this.codeBuilderTitle = codeBuilderTitle;
   }

   public void setCanResizeCodeBuilder(final boolean canResizeCodeBuilder) {
      this.canResizeCodeBuilder = canResizeCodeBuilder;
   }

   public void setDisableLegacyTitle(final boolean disableLegacyTitle) {
      this.disableLegacyTitle = disableLegacyTitle;
   }

   public void setPostProcessFilter(final String postProcessFilter) {
      this.postProcessFilter = postProcessFilter;
   }

   public void setScreenshotBorderPath(final String screenshotBorderPath) {
      this.screenshotBorderPath = screenshotBorderPath;
   }

   public void setEntityCapabilities(final OptionalBoolean entityCapabilities) {
      this.entityCapabilities = entityCapabilities;
   }

   public void setOverrideUri(final Optional<String> overrideUri) {
      this.overrideUri = overrideUri;
   }

   public void setQuizAttached(final boolean quizAttached) {
      this.quizAttached = quizAttached;
   }

   public void setExternalLinkSettings(final OptionalBoolean externalLinkSettings) {
      this.externalLinkSettings = externalLinkSettings;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EducationSettingsPacket)) {
         return false;
      }

      EducationSettingsPacket other = (EducationSettingsPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.canResizeCodeBuilder != other.canResizeCodeBuilder) {
         return false;
      }

      if (this.disableLegacyTitle != other.disableLegacyTitle) {
         return false;
      }

      if (this.quizAttached != other.quizAttached) {
         return false;
      }

      Object this$codeBuilderUri = this.codeBuilderUri;
      Object other$codeBuilderUri = other.codeBuilderUri;
      if (this$codeBuilderUri == null ? other$codeBuilderUri == null : this$codeBuilderUri.equals(other$codeBuilderUri)) {
         Object this$codeBuilderTitle = this.codeBuilderTitle;
         Object other$codeBuilderTitle = other.codeBuilderTitle;
         if (this$codeBuilderTitle == null ? other$codeBuilderTitle == null : this$codeBuilderTitle.equals(other$codeBuilderTitle)) {
            Object this$postProcessFilter = this.postProcessFilter;
            Object other$postProcessFilter = other.postProcessFilter;
            if (this$postProcessFilter == null ? other$postProcessFilter == null : this$postProcessFilter.equals(other$postProcessFilter)) {
               Object this$screenshotBorderPath = this.screenshotBorderPath;
               Object other$screenshotBorderPath = other.screenshotBorderPath;
               if (this$screenshotBorderPath == null ? other$screenshotBorderPath == null : this$screenshotBorderPath.equals(other$screenshotBorderPath)) {
                  Object this$entityCapabilities = this.entityCapabilities;
                  Object other$entityCapabilities = other.entityCapabilities;
                  if (this$entityCapabilities == null ? other$entityCapabilities == null : this$entityCapabilities.equals(other$entityCapabilities)) {
                     Object this$overrideUri = this.overrideUri;
                     Object other$overrideUri = other.overrideUri;
                     if (this$overrideUri == null ? other$overrideUri == null : this$overrideUri.equals(other$overrideUri)) {
                        Object this$externalLinkSettings = this.externalLinkSettings;
                        Object other$externalLinkSettings = other.externalLinkSettings;
                        return this$externalLinkSettings == null
                           ? other$externalLinkSettings == null
                           : this$externalLinkSettings.equals(other$externalLinkSettings);
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
      return other instanceof EducationSettingsPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.canResizeCodeBuilder ? 79 : 97);
      result = result * 59 + (this.disableLegacyTitle ? 79 : 97);
      result = result * 59 + (this.quizAttached ? 79 : 97);
      Object $codeBuilderUri = this.codeBuilderUri;
      result = result * 59 + ($codeBuilderUri == null ? 43 : $codeBuilderUri.hashCode());
      Object $codeBuilderTitle = this.codeBuilderTitle;
      result = result * 59 + ($codeBuilderTitle == null ? 43 : $codeBuilderTitle.hashCode());
      Object $postProcessFilter = this.postProcessFilter;
      result = result * 59 + ($postProcessFilter == null ? 43 : $postProcessFilter.hashCode());
      Object $screenshotBorderPath = this.screenshotBorderPath;
      result = result * 59 + ($screenshotBorderPath == null ? 43 : $screenshotBorderPath.hashCode());
      Object $entityCapabilities = this.entityCapabilities;
      result = result * 59 + ($entityCapabilities == null ? 43 : $entityCapabilities.hashCode());
      Object $overrideUri = this.overrideUri;
      result = result * 59 + ($overrideUri == null ? 43 : $overrideUri.hashCode());
      Object $externalLinkSettings = this.externalLinkSettings;
      return result * 59 + ($externalLinkSettings == null ? 43 : $externalLinkSettings.hashCode());
   }

   @Override
   public String toString() {
      return "EducationSettingsPacket(codeBuilderUri="
         + this.codeBuilderUri
         + ", codeBuilderTitle="
         + this.codeBuilderTitle
         + ", canResizeCodeBuilder="
         + this.canResizeCodeBuilder
         + ", disableLegacyTitle="
         + this.disableLegacyTitle
         + ", postProcessFilter="
         + this.postProcessFilter
         + ", screenshotBorderPath="
         + this.screenshotBorderPath
         + ", entityCapabilities="
         + this.entityCapabilities
         + ", overrideUri="
         + this.overrideUri
         + ", quizAttached="
         + this.quizAttached
         + ", externalLinkSettings="
         + this.externalLinkSettings
         + ")";
   }
}
