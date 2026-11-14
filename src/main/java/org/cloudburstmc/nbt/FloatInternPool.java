package org.cloudburstmc.nbt;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class FloatInternPool {
   private static final Map<Object, FloatInternPool.WeakFloat> CACHE = new ConcurrentSkipListMap<>(
      (a, b) -> a instanceof Float
         ? Float.compare((Float)a, ((FloatInternPool.WeakFloat)b).value)
         : Float.compare(((FloatInternPool.WeakFloat)a).value, ((FloatInternPool.WeakFloat)b).value)
   );
   private static final ReferenceQueue<?>[] REFERENCE_QUEUES = IntStream.range(0, Runtime.getRuntime().availableProcessors())
      .mapToObj(i -> new ReferenceQueue())
      .toArray(ReferenceQueue[]::new);

   private static void expungeStaleEntries(@NonNull ReferenceQueue<?> referenceQueue) {
      FloatInternPool.WeakFloat entry;
      while ((entry = (FloatInternPool.WeakFloat)referenceQueue.poll()) != null) {
         CACHE.remove(entry, entry);
      }
   }

   public static Float intern(float value) {
      Float boxed = value;
      FloatInternPool.WeakFloat entry = CACHE.get(boxed);
      if (entry != null) {
         expungeStaleEntries(entry.referenceQueue);
         Float interned;
         if ((interned = entry.get()) != null) {
            return interned;
         }
      }

      FloatInternPool.WeakFloat newEntry = new FloatInternPool.WeakFloat(boxed, REFERENCE_QUEUES[ThreadLocalRandom.current().nextInt(REFERENCE_QUEUES.length)]);

      Float interned;
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

   private static final class WeakFloat extends WeakReference<Float> {
      private final float value;
      private final ReferenceQueue<?> referenceQueue;

      public WeakFloat(@NonNull Float value, @NonNull ReferenceQueue referenceQueue) {
         super(value, referenceQueue);
         this.value = value;
         this.referenceQueue = referenceQueue;
      }
   }
}
