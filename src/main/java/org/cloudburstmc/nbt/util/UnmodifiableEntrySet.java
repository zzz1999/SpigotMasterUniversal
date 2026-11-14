package org.cloudburstmc.nbt.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterator;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class UnmodifiableEntrySet<K, V> implements Set<Entry<K, V>>, Collection<Entry<K, V>> {
   private final Set<? extends Entry<K, V>> entrySet;

   public UnmodifiableEntrySet(Set<? extends Entry<K, V>> entrySet) {
      this.entrySet = entrySet;
   }

   static <K, V> Consumer<Entry<K, V>> entryConsumer(Consumer<? super Entry<K, V>> action) {
      return e -> action.accept(new UnmodifiableEntrySet.UnmodifiableEntry<>(e));
   }

   @Override
   public void forEach(Consumer<? super Entry<K, V>> action) {
      Objects.requireNonNull(action);
      this.entrySet.forEach(entryConsumer(action));
   }

   @Override
   public int hashCode() {
      return this.entrySet.hashCode();
   }

   @Override
   public int size() {
      return this.entrySet.size();
   }

   @Override
   public boolean isEmpty() {
      return this.entrySet.isEmpty();
   }

   @Override
   public String toString() {
      return this.entrySet.toString();
   }

   public boolean add(Entry<K, V> e) {
      throw new UnsupportedOperationException();
   }

   @Override
   public boolean addAll(Collection<? extends Entry<K, V>> c) {
      throw new UnsupportedOperationException();
   }

   @Override
   public boolean remove(Object o) {
      throw new UnsupportedOperationException();
   }

   @Override
   public boolean removeAll(Collection<?> coll) {
      throw new UnsupportedOperationException();
   }

   @Override
   public boolean retainAll(Collection<?> coll) {
      throw new UnsupportedOperationException();
   }

   @Override
   public void clear() {
      throw new UnsupportedOperationException();
   }

   @Override
   public Spliterator<Entry<K, V>> spliterator() {
      return new UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator<>((Spliterator<Entry<K, V>>)this.entrySet.spliterator());
   }

   @Override
   public Stream<Entry<K, V>> stream() {
      return StreamSupport.stream(this.spliterator(), false);
   }

   @Override
   public Stream<Entry<K, V>> parallelStream() {
      return StreamSupport.stream(this.spliterator(), true);
   }

   @Override
   public Iterator<Entry<K, V>> iterator() {
      return new Iterator<Entry<K, V>>() {
         private final Iterator<? extends Entry<? extends K, ? extends V>> i = UnmodifiableEntrySet.this.entrySet.iterator();

         @Override
         public boolean hasNext() {
            return this.i.hasNext();
         }

         public Entry<K, V> next() {
            return new UnmodifiableEntrySet.UnmodifiableEntry<>((Entry<? extends K, ? extends V>)this.i.next());
         }

         @Override
         public void remove() {
            throw new UnsupportedOperationException();
         }
      };
   }

   @Override
   public Object[] toArray() {
      Object[] a = this.entrySet.toArray();

      for (int i = 0; i < a.length; i++) {
         a[i] = new UnmodifiableEntrySet.UnmodifiableEntry((Entry<? extends K, ? extends V>)a[i]);
      }

      return a;
   }

   @Override
   public <T> T[] toArray(T[] a) {
      Object[] arr = this.entrySet.toArray(a.length == 0 ? a : Arrays.copyOf(a, 0));

      for (int i = 0; i < arr.length; i++) {
         arr[i] = new UnmodifiableEntrySet.UnmodifiableEntry((Entry<? extends K, ? extends V>)arr[i]);
      }

      if (arr.length > a.length) {
         return (T[])arr;
      }

      System.arraycopy(arr, 0, a, 0, arr.length);
      if (a.length > arr.length) {
         a[arr.length] = null;
      }

      return a;
   }

   @Override
   public boolean contains(Object o) {
      return !(o instanceof Entry) ? false : this.entrySet.contains(new UnmodifiableEntrySet.UnmodifiableEntry((Entry<? extends K, ? extends V>)o));
   }

   @Override
   public boolean containsAll(Collection<?> coll) {
      for (Object e : coll) {
         if (!this.contains(e)) {
            return false;
         }
      }

      return true;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Set)) {
         return false;
      }

      Set<?> s = (Set<?>)o;
      return s.size() != this.entrySet.size() ? false : this.containsAll(s);
   }

   private static class UnmodifiableEntry<K, V> implements Entry<K, V> {
      private Entry<? extends K, ? extends V> e;

      UnmodifiableEntry(Entry<? extends K, ? extends V> e) {
         this.e = Objects.requireNonNull(e);
      }

      @Override
      public K getKey() {
         return (K)this.e.getKey();
      }

      @Override
      public V getValue() {
         return (V)this.e.getValue();
      }

      @Override
      public V setValue(V value) {
         throw new UnsupportedOperationException();
      }

      @Override
      public int hashCode() {
         return this.e.hashCode();
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) {
            return true;
         }

         if (!(o instanceof Entry)) {
            return false;
         }

         Entry<?, ?> t = (Entry<?, ?>)o;
         return Objects.equals(this.e.getKey(), t.getKey()) && Objects.equals(this.e.getValue(), t.getValue());
      }

      @Override
      public String toString() {
         return this.e.toString();
      }
   }

   static final class UnmodifiableEntrySetSpliterator<K, V> implements Spliterator<Entry<K, V>> {
      final Spliterator<Entry<K, V>> s;

      UnmodifiableEntrySetSpliterator(Spliterator<Entry<K, V>> s) {
         this.s = s;
      }

      @Override
      public boolean tryAdvance(Consumer<? super Entry<K, V>> action) {
         Objects.requireNonNull(action);
         return this.s.tryAdvance(UnmodifiableEntrySet.entryConsumer(action));
      }

      @Override
      public void forEachRemaining(Consumer<? super Entry<K, V>> action) {
         Objects.requireNonNull(action);
         this.s.forEachRemaining(UnmodifiableEntrySet.entryConsumer(action));
      }

      @Override
      public Spliterator<Entry<K, V>> trySplit() {
         Spliterator<Entry<K, V>> split = this.s.trySplit();
         return split == null ? null : new UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator<>(split);
      }

      @Override
      public long estimateSize() {
         return this.s.estimateSize();
      }

      @Override
      public long getExactSizeIfKnown() {
         return this.s.getExactSizeIfKnown();
      }

      @Override
      public int characteristics() {
         return this.s.characteristics();
      }

      @Override
      public boolean hasCharacteristics(int characteristics) {
         return this.s.hasCharacteristics(characteristics);
      }

      @Override
      public Comparator<? super Entry<K, V>> getComparator() {
         return this.s.getComparator();
      }
   }
}
