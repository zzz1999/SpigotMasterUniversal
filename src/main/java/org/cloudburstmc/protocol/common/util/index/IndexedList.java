package org.cloudburstmc.protocol.common.util.index;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class IndexedList<T> implements Indexable<List<T>> {
   private final List<T> values;
   private final int[] indices;
   private List<T> cached;

   public IndexedList(List<T> values, int[] indices) {
      this.values = Objects.requireNonNull(values, "values cannot be null");
      this.indices = Objects.requireNonNull(indices, "indices cannot be null");
   }

   public List<T> get() {
      if (this.cached != null) {
         return this.cached;
      }

      if (this.indices.length == 0) {
         return Collections.emptyList();
      }

      List<T> indexedValues = new ObjectArrayList<>(this.indices.length);

      for (int index : this.indices) {
         indexedValues.add(this.values.get(index));
      }

      return this.cached = indexedValues;
   }
}
