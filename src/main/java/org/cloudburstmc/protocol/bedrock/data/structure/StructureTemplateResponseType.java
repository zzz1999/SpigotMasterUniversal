package org.cloudburstmc.protocol.bedrock.data.structure;

public enum StructureTemplateResponseType {
   NONE,
   EXPORT,
   QUERY,
   /** @deprecated */
   IMPORT;

   private static final StructureTemplateResponseType[] VALUES = values();

   public static StructureTemplateResponseType from(int id) {
      return VALUES[id];
   }
}
