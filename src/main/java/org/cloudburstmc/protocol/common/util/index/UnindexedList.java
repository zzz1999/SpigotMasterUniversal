package org.cloudburstmc.protocol.common.util.index;

import java.util.List;

public class UnindexedList<T> implements Indexable<List<T>> {
   private final List<T> values;

   public UnindexedList(List<T> values) {
      this.values = values;
   }

   public List<T> get() {
      return this.values;
   }
}
