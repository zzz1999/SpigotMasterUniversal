package org.checkerframework.checker.formatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IllegalFormatConversionException;
import java.util.IllegalFormatException;
import java.util.Map;
import java.util.MissingFormatArgumentException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.formatter.qual.ConversionCategory;
import org.checkerframework.checker.formatter.qual.ReturnsFormat;

public class FormatUtil {
   private static final String formatSpecifier = "%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])";
   private static Pattern fsPattern = Pattern.compile("%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])");

   @ReturnsFormat
   public static String asFormat(String format, ConversionCategory... cc) throws IllegalFormatException {
      ConversionCategory[] fcc = formatParameterCategories(format);
      if (fcc.length != cc.length) {
         throw new FormatUtil.ExcessiveOrMissingFormatArgumentException(cc.length, fcc.length);
      }

      for (int i = 0; i < cc.length; i++) {
         if (cc[i] != fcc[i]) {
            throw new FormatUtil.IllegalFormatConversionCategoryException(cc[i], fcc[i]);
         }
      }

      return format;
   }

   public static void tryFormatSatisfiability(String format) throws IllegalFormatException {
      String unused = String.format(format, (Object[])null);
   }

   public static ConversionCategory[] formatParameterCategories(String format) throws IllegalFormatException {
      tryFormatSatisfiability(format);
      int last = -1;
      int lasto = -1;
      int maxindex = -1;
      FormatUtil.Conversion[] cs = parse(format);
      Map<Integer, ConversionCategory> conv = new HashMap<>();

      for (FormatUtil.Conversion c : cs) {
         int index = c.index();
         switch (index) {
            case -1:
               break;
            case 0:
               last = ++lasto;
               break;
            default:
               last = index - 1;
         }

         maxindex = Math.max(maxindex, last);
         conv.put(last, ConversionCategory.intersect(conv.containsKey(last) ? conv.get(last) : ConversionCategory.UNUSED, c.category()));
      }

      ConversionCategory[] res = new ConversionCategory[maxindex + 1];

      for (int i = 0; i <= maxindex; i++) {
         res[i] = conv.containsKey(i) ? conv.get(i) : ConversionCategory.UNUSED;
      }

      return res;
   }

   private static int indexFromFormat(Matcher m) {
      String s = m.group(1);
      int index;
      if (s != null) {
         index = Integer.parseInt(s.substring(0, s.length() - 1));
      } else if (m.group(2) != null && m.group(2).contains(String.valueOf('<'))) {
         index = -1;
      } else {
         index = 0;
      }

      return index;
   }

   private static char conversionCharFromFormat(Matcher m) {
      String dt = m.group(5);
      return dt == null ? m.group(6).charAt(0) : dt.charAt(0);
   }

   private static FormatUtil.Conversion[] parse(String format) {
      ArrayList<FormatUtil.Conversion> cs = new ArrayList<>();
      Matcher m = fsPattern.matcher(format);

      while (m.find()) {
         char c = conversionCharFromFormat(m);
         switch (c) {
            case '%':
            case 'n':
               break;
            default:
               cs.add(new FormatUtil.Conversion(c, indexFromFormat(m)));
         }
      }

      return cs.toArray(new FormatUtil.Conversion[cs.size()]);
   }

   private static class Conversion {
      private final int index;
      private final ConversionCategory cath;

      public Conversion(char c, int index) {
         this.index = index;
         this.cath = ConversionCategory.fromConversionChar(c);
      }

      int index() {
         return this.index;
      }

      ConversionCategory category() {
         return this.cath;
      }
   }

   public static class ExcessiveOrMissingFormatArgumentException extends MissingFormatArgumentException {
      private static final long serialVersionUID = 17000126L;
      private final int expected;
      private final int found;

      public ExcessiveOrMissingFormatArgumentException(int expected, int found) {
         super("-");
         this.expected = expected;
         this.found = found;
      }

      public int getExpected() {
         return this.expected;
      }

      public int getFound() {
         return this.found;
      }

      @Override
      public String getMessage() {
         return String.format("Expected %d arguments but found %d.", this.expected, this.found);
      }
   }

   public static class IllegalFormatConversionCategoryException extends IllegalFormatConversionException {
      private static final long serialVersionUID = 17000126L;
      private final ConversionCategory expected;
      private final ConversionCategory found;

      public IllegalFormatConversionCategoryException(ConversionCategory expected, ConversionCategory found) {
         super(expected.chars.length() == 0 ? '-' : expected.chars.charAt(0), found.types == null ? Object.class : found.types[0]);
         this.expected = expected;
         this.found = found;
      }

      public ConversionCategory getExpected() {
         return this.expected;
      }

      public ConversionCategory getFound() {
         return this.found;
      }

      @Override
      public String getMessage() {
         return String.format("Expected category %s but found %s.", this.expected, this.found);
      }
   }
}
