package org.cloudburstmc.protocol.bedrock.data.auth;

import java.util.Objects;
import org.cloudburstmc.protocol.common.util.Preconditions;

public class TokenPayload implements AuthPayload {
   private final String token;
   private final AuthType type;

   public TokenPayload(String token, AuthType type) {
      Preconditions.checkArgument(type != AuthType.UNKNOWN, "TokenPayload cannot be of type UNKNOWN");
      this.token = token;
      this.type = Objects.requireNonNull(type);
   }

   @Override
   public AuthType getAuthType() {
      return this.type;
   }

   public String getToken() {
      return this.token;
   }
}
