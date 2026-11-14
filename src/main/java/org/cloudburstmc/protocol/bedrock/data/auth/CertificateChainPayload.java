package org.cloudburstmc.protocol.bedrock.data.auth;

import java.util.List;
import java.util.Objects;

public class CertificateChainPayload implements AuthPayload {
   private final List<String> chain;
   private final AuthType type;

   public CertificateChainPayload(List<String> chain) {
      this(chain, AuthType.UNKNOWN);
   }

   public CertificateChainPayload(List<String> chain, AuthType type) {
      this.chain = chain;
      this.type = Objects.requireNonNull(type);
   }

   @Override
   public AuthType getAuthType() {
      return this.type;
   }

   public List<String> getChain() {
      return this.chain;
   }
}
