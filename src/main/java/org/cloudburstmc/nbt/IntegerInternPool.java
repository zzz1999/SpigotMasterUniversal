package org.cloudburstmc.nbt;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class IntegerInternPool {
   private static final Map<Object, IntegerInternPool.WeakInteger> CACHE = new ConcurrentSkipListMap<>(
      (a, b) -> a instanceof Integer
         ? Integer.compare((Integer)a, ((IntegerInternPool.WeakInteger)b).value)
         : Integer.compare(((IntegerInternPool.WeakInteger)a).value, ((IntegerInternPool.WeakInteger)b).value)
   );
   private static final ReferenceQueue<?>[] REFERENCE_QUEUES = IntStream.range(0, Runtime.getRuntime().availableProcessors())
      .mapToObj(i -> new ReferenceQueue())
      .toArray(ReferenceQueue[]::new);

   private static void expungeStaleEntries(@NonNull ReferenceQueue<?> referenceQueue) {
      IntegerInternPool.WeakInteger entry;
      while ((entry = (IntegerInternPool.WeakInteger)referenceQueue.poll()) != null) {
         CACHE.remove(entry, entry);
      }
   }

   public static Integer intern(int value) {
      if ((byte)value == value) {
         return value;
      }

      Integer boxed = value;
      IntegerInternPool.WeakInteger entry = CACHE.get(boxed);
      if (entry != null) {
         expungeStaleEntries(entry.referenceQueue);
         Integer interned;
         if ((interned = entry.get()) != null) {
            return interned;
         }
      }

      IntegerInternPool.WeakInteger newEntry = new IntegerInternPool.WeakInteger(
         boxed, REFERENCE_QUEUES[ThreadLocalRandom.current().nextInt(REFERENCE_QUEUES.length)]
      );

      Integer interned;
      do {
         entry = CACHE.putIfAbsent(newEntry, newEntry);
         if (entry != null) {
            expungeStaleEntries(entry.referenceQueue);
            interned = entry.get();
         } else {
            interned = boxed;
         }
      } while (interned == null);

      return interned;
   }

   private static final class WeakInteger extends WeakReference<Integer> {
      private final int value;
      private final ReferenceQueue<?> referenceQueue;

      public WeakInteger(@NonNull Integer value, @NonNull ReferenceQueue referenceQueue) {
         super(value, referenceQueue);
         this.value = value;
         this.referenceQueue = referenceQueue;
      }
   }
}
