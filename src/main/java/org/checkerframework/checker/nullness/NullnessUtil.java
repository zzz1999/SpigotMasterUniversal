package org.checkerframework.checker.nullness;

import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class NullnessUtil {
   private NullnessUtil() {
      throw new AssertionError("shouldn't be instantiated");
   }

   @EnsuresNonNull("#1")
   public static <T> T castNonNull(T ref) {
      assert ref != null : "Misuse of castNonNull: called with a null argument";
      return ref;
   }

   @EnsuresNonNull("#1")
   public static <T> T[] castNonNullDeep(T[] arr) {
      return (T[])castNonNullArray(arr);
   }

   @EnsuresNonNull("#1")
   public static <T> T[][] castNonNullDeep(T[][] arr) {
      return (T[][])((Object[][])castNonNullArray((T[])arr));
   }

   @EnsuresNonNull("#1")
   public static <T> T[][][] castNonNullDeep(T[][][] arr) {
      return (T[][][])((Object[][][])castNonNullArray((T[])arr));
   }

   @EnsuresNonNull("#1")
   public static <T> T[][][][] castNonNullDeep(T[][][][] arr) {
      return (T[][][][])((Object[][][][])castNonNullArray((T[])arr));
   }

   @EnsuresNonNull("#1")
   public static <T> T[][][][][] castNonNullDeep(T[][][][][] arr) {
      return (T[][][][][])((Object[][][][][])castNonNullArray((T[])arr));
   }

   private static <T> T[] castNonNullArray(T[] arr) {
      assert arr != null : "Misuse of castNonNullArray: called with a null array argument";

      for (int i = 0; i < arr.length; i++) {
         assert arr[i] != null : "Misuse of castNonNull: called with a null array element";
         checkIfArray(arr[i]);
      }

      return arr;
   }

   private static void checkIfArray(@NonNull Object ref) {
      assert ref != null : "Misuse of checkIfArray: called with a null argument";
      Class<?> comp = ref.getClass().getComponentType();
      if (comp != null && !comp.isPrimitive()) {
         castNonNullArray((Object[])ref);
      }
   }
}
