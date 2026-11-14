package org.cloudburstmc.protocol.bedrock.data.inventory.itemstack.request;

public enum TextProcessingEventOrigin {
   SERVER_CHAT_PUBLIC,
   SERVER_CHAT_WHISPER,
   SIGN_TEXT,
   ANVIL_TEXT,
   BOOK_AND_QUILL_TEXT,
   COMMAND_BLOCK_TEXT,
   BLOCK_ENTITY_DATA_TEXT,
   JOIN_EVENT_TEXT,
   LEAVE_EVENT_TEXT,
   SLASH_COMMAND_TEXT,
   CARTOGRAPHY_TEXT,
   /** @deprecated */
   SLASH_COMMAND_NON_CHAT,
   /** @deprecated */
   SCOREBOARD_TEXT,
   /** @deprecated */
   TICKING_AREA_TEXT,
   KICK_COMMAND,
   TITLE_COMMAND,
   SUMMON_COMMAND,
   @Deprecated
   PASS_THROUGH_WITHOUT_SIFT,
   SERVER_FORM;
}
