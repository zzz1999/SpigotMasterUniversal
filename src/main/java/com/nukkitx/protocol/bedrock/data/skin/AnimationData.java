package com.nukkitx.protocol.bedrock.data.skin;

public final class AnimationData {
   private final ImageData image;
   private final AnimatedTextureType textureType;
   private final float frames;
   private final AnimationExpressionType expressionType;

   public AnimationData(ImageData image, AnimatedTextureType textureType, float frames) {
      this.image = image;
      this.textureType = textureType;
      this.frames = frames;
      this.expressionType = AnimationExpressionType.LINEAR;
   }

   public ImageData getImage() {
      return this.image;
   }

   public AnimatedTextureType getTextureType() {
      return this.textureType;
   }

   public float getFrames() {
      return this.frames;
   }

   public AnimationExpressionType getExpressionType() {
      return this.expressionType;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AnimationData)) {
         return false;
      }

      AnimationData other = (AnimationData)o;
      if (Float.compare(this.getFrames(), other.getFrames()) != 0) {
         return false;
      }

      Object this$image = this.getImage();
      Object other$image = other.getImage();
      if (this$image == null ? other$image == null : this$image.equals(other$image)) {
         Object this$textureType = this.getTextureType();
         Object other$textureType = other.getTextureType();
         if (this$textureType == null ? other$textureType == null : this$textureType.equals(other$textureType)) {
            Object this$expressionType = this.getExpressionType();
            Object other$expressionType = other.getExpressionType();
            return this$expressionType == null ? other$expressionType == null : this$expressionType.equals(other$expressionType);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + Float.floatToIntBits(this.getFrames());
      Object $image = this.getImage();
      result = result * 59 + ($image == null ? 43 : $image.hashCode());
      Object $textureType = this.getTextureType();
      result = result * 59 + ($textureType == null ? 43 : $textureType.hashCode());
      Object $expressionType = this.getExpressionType();
      return result * 59 + ($expressionType == null ? 43 : $expressionType.hashCode());
   }

   @Override
   public String toString() {
      return "AnimationData(image="
         + this.getImage()
         + ", textureType="
         + this.getTextureType()
         + ", frames="
         + this.getFrames()
         + ", expressionType="
         + this.getExpressionType()
         + ")";
   }

   public AnimationData(ImageData image, AnimatedTextureType textureType, float frames, AnimationExpressionType expressionType) {
      this.image = image;
      this.textureType = textureType;
      this.frames = frames;
      this.expressionType = expressionType;
   }
}
