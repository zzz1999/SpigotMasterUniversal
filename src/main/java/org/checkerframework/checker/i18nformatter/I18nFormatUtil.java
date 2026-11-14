package org.checkerframework.checker.i18nformatter;

import java.text.ChoiceFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Locale.Category;
import org.checkerframework.checker.i18nformatter.qual.I18nChecksFormat;
import org.checkerframework.checker.i18nformatter.qual.I18nConversionCategory;
import org.checkerframework.checker.i18nformatter.qual.I18nValidFormat;

public class I18nFormatUtil {
   public static void tryFormatSatisfiability(String format) throws IllegalFormatException {
      MessageFormat.format(format, (Object[])null);
   }

   public static I18nConversionCategory[] formatParameterCategories(String format) throws IllegalFormatException {
      tryFormatSatisfiability(format);
      I18nFormatUtil.I18nConversion[] cs = I18nFormatUtil.MessageFormatParser.parse(format);
      int maxIndex = -1;
      Map<Integer, I18nConversionCategory> conv = new HashMap<>();

      for (I18nFormatUtil.I18nConversion c : cs) {
         int index = c.index;
         conv.put(index, I18nConversionCategory.intersect(c.category, conv.containsKey(index) ? conv.get(index) : I18nConversionCategory.UNUSED));
         maxIndex = Math.max(maxIndex, index);
      }

      I18nConversionCategory[] res = new I18nConversionCategory[maxIndex + 1];

      for (int i = 0; i <= maxIndex; i++) {
         res[i] = conv.containsKey(i) ? conv.get(i) : I18nConversionCategory.UNUSED;
      }

      return res;
   }

   @I18nChecksFormat
   public static boolean hasFormat(String format, I18nConversionCategory... cc) {
      I18nConversionCategory[] fcc = formatParameterCategories(format);
      if (fcc.length != cc.length) {
         return false;
      }

      for (int i = 0; i < cc.length; i++) {
         if (!I18nConversionCategory.isSubsetOf(cc[i], fcc[i])) {
            return false;
         }
      }

      return true;
   }

   @I18nValidFormat
   public static boolean isFormat(String format) {
      try {
         formatParameterCategories(format);
         return true;
      } catch (Exception e) {
         return false;
      }
   }

   private static class I18nConversion {
      public int index;
      public I18nConversionCategory category;

      public I18nConversion(int index, I18nConversionCategory category) {
         this.index = index;
         this.category = category;
      }

      @Override
      public String toString() {
         return this.category.toString() + "(index: " + this.index + ")";
      }
   }

   private static class MessageFormatParser {
      public static int maxOffset;
      private static Locale locale;
      private static List<I18nConversionCategory> categories;
      private static List<Integer> argumentIndices;
      private static int numFormat;
      private static final int SEG_RAW = 0;
      private static final int SEG_INDEX = 1;
      private static final int SEG_TYPE = 2;
      private static final int SEG_MODIFIER = 3;
      private static final int TYPE_NULL = 0;
      private static final int TYPE_NUMBER = 1;
      private static final int TYPE_DATE = 2;
      private static final int TYPE_TIME = 3;
      private static final int TYPE_CHOICE = 4;
      private static final String[] TYPE_KEYWORDS = new String[]{"", "number", "date", "time", "choice"};
      private static final int MODIFIER_DEFAULT = 0;
      private static final int MODIFIER_CURRENCY = 1;
      private static final int MODIFIER_PERCENT = 2;
      private static final int MODIFIER_INTEGER = 3;
      private static final String[] NUMBER_MODIFIER_KEYWORDS = new String[]{"", "currency", "percent", "integer"};
      private static final String[] DATE_TIME_MODIFIER_KEYWORDS = new String[]{"", "short", "medium", "long", "full"};

      public static I18nFormatUtil.I18nConversion[] parse(String pattern) {
         categories = new ArrayList<>();
         argumentIndices = new ArrayList<>();
         locale = Locale.getDefault(Category.FORMAT);
         applyPattern(pattern);
         I18nFormatUtil.I18nConversion[] ret = new I18nFormatUtil.I18nConversion[numFormat];

         for (int i = 0; i < numFormat; i++) {
            ret[i] = new I18nFormatUtil.I18nConversion(argumentIndices.get(i), categories.get(i));
         }

         return ret;
      }

      private static void applyPattern(String pattern) {
         StringBuilder[] segments = new StringBuilder[4];
         segments[0] = new StringBuilder();
         int part = 0;
         numFormat = 0;
         boolean inQuote = false;
         int braceStack = 0;
         maxOffset = -1;

         for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (part == 0) {
               if (ch == '\'') {
                  if (i + 1 < pattern.length() && pattern.charAt(i + 1) == '\'') {
                     segments[part].append(ch);
                     i++;
                  } else {
                     inQuote = !inQuote;
                  }
               } else if (ch == '{' && !inQuote) {
                  part = 1;
                  if (segments[1] == null) {
                     segments[1] = new StringBuilder();
                  }
               } else {
                  segments[part].append(ch);
               }
            } else if (inQuote) {
               segments[part].append(ch);
               if (ch == '\'') {
                  inQuote = false;
               }
            } else {
               switch (ch) {
                  case ' ':
                     if (part != 2 || segments[2].length() > 0) {
                        segments[part].append(ch);
                     }
                     break;
                  case '\'':
                     inQuote = true;
                     segments[part].append(ch);
                     break;
                  case ',':
                     if (part < 3) {
                        if (segments[++part] == null) {
                           segments[part] = new StringBuilder();
                        }
                     } else {
                        segments[part].append(ch);
                     }
                     break;
                  case '{':
                     braceStack++;
                     segments[part].append(ch);
                     break;
                  case '}':
                     if (braceStack == 0) {
                        part = 0;
                        makeFormat(numFormat, segments);
                        numFormat++;
                        segments[1] = null;
                        segments[2] = null;
                        segments[3] = null;
                     } else {
                        braceStack--;
                        segments[part].append(ch);
                     }
                     break;
                  default:
                     segments[part].append(ch);
               }
            }
         }

         if (braceStack == 0 && part != 0) {
            maxOffset = -1;
            throw new IllegalArgumentException("Unmatched braces in the pattern");
         }
      }

      private static void makeFormat(int offsetNumber, StringBuilder[] textSegments) {
         String[] segments = new String[textSegments.length];

         for (int i = 0; i < textSegments.length; i++) {
            StringBuilder oneseg = textSegments[i];
            segments[i] = oneseg != null ? oneseg.toString() : "";
         }

         int argumentNumber;
         try {
            argumentNumber = Integer.parseInt(segments[1]);
         } catch (NumberFormatException e) {
            throw new IllegalArgumentException("can't parse argument number: " + segments[1], e);
         }

         if (argumentNumber < 0) {
            throw new IllegalArgumentException("negative argument number: " + argumentNumber);
         }

         int oldMaxOffset = maxOffset;
         maxOffset = offsetNumber;
         argumentIndices.add(argumentNumber);
         I18nConversionCategory category = null;
         if (segments[2].length() != 0) {
            int type = findKeyword(segments[2], TYPE_KEYWORDS);
            label63:
            switch (type) {
               case 0:
                  category = I18nConversionCategory.GENERAL;
                  break;
               case 1:
                  switch (findKeyword(segments[3], NUMBER_MODIFIER_KEYWORDS)) {
                     default:
                        try {
                           new DecimalFormat(segments[3], DecimalFormatSymbols.getInstance(locale));
                        } catch (IllegalArgumentException e) {
                           maxOffset = oldMaxOffset;
                           throw e;
                        }
                     case 0:
                     case 1:
                     case 2:
                     case 3:
                        category = I18nConversionCategory.NUMBER;
                        break label63;
                  }
               case 2:
               case 3:
                  int mod = findKeyword(segments[3], DATE_TIME_MODIFIER_KEYWORDS);
                  if (mod < 0 || mod >= DATE_TIME_MODIFIER_KEYWORDS.length) {
                     try {
                        new SimpleDateFormat(segments[3], locale);
                     } catch (IllegalArgumentException e) {
                        maxOffset = oldMaxOffset;
                        throw e;
                     }
                  }

                  category = I18nConversionCategory.DATE;
                  break;
               case 4:
                  if (segments[3].length() == 0) {
                     throw new IllegalArgumentException("Choice Pattern requires Subformat Pattern: " + segments[3]);
                  }

                  try {
                     new ChoiceFormat(segments[3]);
                  } catch (Exception e) {
                     maxOffset = oldMaxOffset;
                     throw new IllegalArgumentException("Choice Pattern incorrect: " + segments[3], e);
                  }

                  category = I18nConversionCategory.NUMBER;
                  break;
               default:
                  maxOffset = oldMaxOffset;
                  throw new IllegalArgumentException("unknown format type: " + segments[2]);
            }
         } else {
            category = I18nConversionCategory.GENERAL;
         }

         categories.add(category);
      }

      private static final int findKeyword(String s, String[] list) {
         for (int i = 0; i < list.length; i++) {
            if (s.equals(list[i])) {
               return i;
            }
         }

         String ls = s.trim().toLowerCase(Locale.ROOT);
         if (ls != s) {
            for (int i = 0; i < list.length; i++) {
               if (ls.equals(list[i])) {
                  return i;
               }
            }
         }

         return -1;
      }
   }
}
