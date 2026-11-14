package org.cloudburstmc.protocol.bedrock.data;

public final class NetworkPermissions {
   public static final NetworkPermissions DEFAULT = new NetworkPermissions(false);
   private final boolean serverAuthSounds;

   public NetworkPermissions(final boolean serverAuthSounds) {
      this.serverAuthSounds = serverAuthSounds;
   }

   public boolean isServerAuthSounds() {
      return this.serverAuthSounds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NetworkPermissions)) {
         return false;
      }

      NetworkPermissions other = (NetworkPermissions)o;
      return this.isServerAuthSounds() == other.isServerAuthSounds();
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      return result * 59 + (this.isServerAuthSounds() ? 79 : 97);
   }

   @Override
   public String toString() {
      return "NetworkPermissions(serverAuthSounds=" + this.isServerAuthSounds() + ")";
   }
}
