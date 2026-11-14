package org.cloudburstmc.protocol.common.util;

import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface TextConverter {
   TextConverter.Default DEFAULT = new TextConverter.Default();

   default CharSequence deserialize(String text) {
      return this.deserialize(text, true);
   }

   CharSequence deserialize(String text, boolean translatable);

   CharSequence deserializeJson(String text, boolean translatable);

   CharSequence deserializeWithArguments(String text, List<String> parameters, boolean translatable);

   String serialize(CharSequence text);

   String serializeJson(CharSequence text);

   String serializeWithArguments(CharSequence text, List<String> parameters);

   @Nullable Boolean needsTranslation(CharSequence text);

   final class Default implements TextConverter {
      @Override
      public CharSequence deserialize(String text, boolean translatable) {
         return text;
      }

      @Override
      public CharSequence deserializeJson(String text, boolean translatable) {
         return text;
      }

      @Override
      public CharSequence deserializeWithArguments(String text, List<String> parameters, boolean translatable) {
         return text;
      }

      @Override
      public String serialize(CharSequence text) {
         return text.toString();
      }

      @Override
      public String serializeJson(CharSequence text) {
         return text.toString();
      }

      @Override
      public String serializeWithArguments(CharSequence text, List<String> parameters) {
         return text.toString();
      }

      @Override
      public Boolean needsTranslation(CharSequence text) {
         return null;
      }

      private Default() {
      }
   }
}
