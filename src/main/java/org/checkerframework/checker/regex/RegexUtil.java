package org.checkerframework.checker.regex;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.checker.regex.qual.Regex;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.checkerframework.framework.qual.EnsuresQualifierIf;

public final class RegexUtil {
   private RegexUtil() {
      throw new Error("do not instantiate");
   }

   @Pure
   @EnsuresQualifierIf(result = true, expression = "#1", qualifier = Regex.class)
   public static boolean isRegex(String s) {
      return isRegex(s, 0);
   }

   @Pure
   @EnsuresQualifierIf(result = true, expression = "#1", qualifier = Regex.class)
   public static boolean isRegex(String s, int groups) {
      Pattern p;
      try {
         p = Pattern.compile(s);
      } catch (PatternSyntaxException e) {
         return false;
      }

      return getGroupCount(p) >= groups;
   }

   @Pure
   @EnsuresQualifierIf(result = true, expression = "#1", qualifier = Regex.class)
   public static boolean isRegex(char c) {
      return isRegex(Character.toString(c));
   }

   @SideEffectFree
   public static @Nullable String regexError(String s) {
      return regexError(s, 0);
   }

   @SideEffectFree
   public static @Nullable String regexError(String s, int groups) {
      try {
         Pattern p = Pattern.compile(s);
         int actualGroups = getGroupCount(p);
         return actualGroups < groups ? regexErrorMessage(s, groups, actualGroups) : null;
      } catch (PatternSyntaxException e) {
         return e.getMessage();
      }
   }

   @SideEffectFree
   public static @Nullable PatternSyntaxException regexException(String s) {
      return regexException(s, 0);
   }

   @SideEffectFree
   public static @Nullable PatternSyntaxException regexException(String s, int groups) {
      try {
         Pattern p = Pattern.compile(s);
         int actualGroups = getGroupCount(p);
         return actualGroups < groups ? new PatternSyntaxException(regexErrorMessage(s, groups, actualGroups), s, -1) : null;
      } catch (PatternSyntaxException pse) {
         return pse;
      }
   }

   @SideEffectFree
   public static @Regex String asRegex(String s) {
      return asRegex(s, 0);
   }

   @SideEffectFree
   public static @Regex String asRegex(String s, int groups) {
      try {
         Pattern p = Pattern.compile(s);
         int actualGroups = getGroupCount(p);
         if (actualGroups < groups) {
            throw new Error(regexErrorMessage(s, groups, actualGroups));
         } else {
            return s;
         }
      } catch (PatternSyntaxException e) {
         throw new Error(e);
      }
   }

   @SideEffectFree
   private static String regexErrorMessage(String s, int expectedGroups, int actualGroups) {
      return "regex \"" + s + "\" has " + actualGroups + " groups, but " + expectedGroups + " groups are needed.";
   }

   @Pure
   private static int getGroupCount(Pattern p) {
      return p.matcher("").groupCount();
   }

   public static class CheckedPatternSyntaxException extends Exception {
      private static final long serialVersionUID = 6266881831979001480L;
      private final PatternSyntaxException pse;

      public CheckedPatternSyntaxException(PatternSyntaxException pse) {
         this.pse = pse;
      }

      public CheckedPatternSyntaxException(String desc, String regex, int index) {
         this(new PatternSyntaxException(desc, regex, index));
      }

      public String getDescription() {
         return this.pse.getDescription();
      }

      public int getIndex() {
         return this.pse.getIndex();
      }

      @Pure
      @Override
      public String getMessage() {
         return this.pse.getMessage();
      }

      public String getPattern() {
         return this.pse.getPattern();
      }
   }
}
