package org.cloudburstmc.protocol.common;

public interface DefinitionRegistry<D extends Definition> {
   D getDefinition(int runtimeId);

   boolean isRegistered(D definition);
}
