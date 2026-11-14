package org.cloudburstmc.protocol.bedrock.data;

public final class EduSharedUriResource {
   public static final EduSharedUriResource EMPTY = new EduSharedUriResource("", "");
   private final String buttonName;
   private final String linkUri;

   public EduSharedUriResource(final String buttonName, final String linkUri) {
      this.buttonName = buttonName;
      this.linkUri = linkUri;
   }

   public String getButtonName() {
      return this.buttonName;
   }

   public String getLinkUri() {
      return this.linkUri;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof EduSharedUriResource)) {
         return false;
      } else {
         EduSharedUriResource other = (EduSharedUriResource)o;
         Object this$buttonName = this.getButtonName();
         Object other$buttonName = other.getButtonName();
         if (this$buttonName == null ? other$buttonName == null : this$buttonName.equals(other$buttonName)) {
            Object this$linkUri = this.getLinkUri();
            Object other$linkUri = other.getLinkUri();
            return this$linkUri == null ? other$linkUri == null : this$linkUri.equals(other$linkUri);
         } else {
            return false;
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $buttonName = this.getButtonName();
      result = result * 59 + ($buttonName == null ? 43 : $buttonName.hashCode());
      Object $linkUri = this.getLinkUri();
      return result * 59 + ($linkUri == null ? 43 : $linkUri.hashCode());
   }

   @Override
   public String toString() {
      return "EduSharedUriResource(buttonName=" + this.getButtonName() + ", linkUri=" + this.getLinkUri() + ")";
   }
}
