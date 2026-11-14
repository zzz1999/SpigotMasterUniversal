package org.cloudburstmc.netty.util;

import io.netty.util.AbstractReferenceCounted;
import io.netty.util.internal.ObjectPool;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public class FastBinaryMinHeap<E> extends AbstractReferenceCounted {
   private static final FastBinaryMinHeap.Entry INFIMUM = new FastBinaryMinHeap.Entry(Long.MAX_VALUE);
   private static final FastBinaryMinHeap.Entry SUPREMUM = new FastBinaryMinHeap.Entry(Long.MIN_VALUE);
   private static final ObjectPool<FastBinaryMinHeap.Entry> RECYCLER = ObjectPool.newPool(x$0 -> new FastBinaryMinHeap.Entry(x$0));
   private int size;
   private FastBinaryMinHeap.Entry[] heap;

   public FastBinaryMinHeap() {
      this(8);
   }

   public FastBinaryMinHeap(int initialCapacity) {
      this.heap = new FastBinaryMinHeap.Entry[++initialCapacity];
      Arrays.fill(this.heap, INFIMUM);
      this.heap[0] = SUPREMUM;
   }

   private static FastBinaryMinHeap.Entry newEntry(Object element, long weight) {
      FastBinaryMinHeap.Entry entry = RECYCLER.get();
      entry.element = element;
      entry.weight = weight;
      return entry;
   }

   private void resize(int capacity) {
      int adjustedSize = this.size + 1;
      int copyLength = Math.min(this.heap.length, adjustedSize);
      FastBinaryMinHeap.Entry[] newHeap = new FastBinaryMinHeap.Entry[capacity];
      System.arraycopy(this.heap, 0, newHeap, 0, copyLength);
      if (capacity > adjustedSize) {
         Arrays.fill(newHeap, adjustedSize, capacity, INFIMUM);
      }

      this.heap = newHeap;
   }

   public void insert(long weight, E element) {
      Objects.requireNonNull(element, "element");
      this.ensureCapacity(this.size + 1);
      this.insert0(weight, element);
   }

   private void ensureCapacity(int size) {
      if (size + 1 >= this.heap.length) {
         this.resize(RakUtils.powerOfTwoCeiling(size + 1));
      }
   }

   public E peek() {
      FastBinaryMinHeap.Entry entry = this.heap[1];
      return (E)(entry != null ? entry.element : null);
   }

   private void insert0(long weight, E element) {
      int hole = ++this.size;
      int pred = hole >> 1;

      for (long predWeight = this.heap[pred].weight; predWeight > weight; predWeight = this.heap[pred].weight) {
         this.heap[hole] = this.heap[pred];
         hole = pred;
         pred >>= 1;
      }

      this.heap[hole] = newEntry(element, weight);
   }

   public void insertSeries(long weight, E[] elements) {
      Objects.requireNonNull(elements, "elements");
      if (elements.length != 0) {
         this.ensureCapacity(this.size + elements.length);
         boolean optimized = this.size == 0;
         if (!optimized) {
            optimized = true;
            int parentIdx = 0;

            for (int currentIdx = this.size; parentIdx < currentIdx; parentIdx++) {
               if (weight < this.heap[parentIdx].weight) {
                  optimized = false;
                  break;
               }
            }
         }

         if (optimized) {
            for (E element : elements) {
               Objects.requireNonNull(element, "element");
               this.heap[++this.size] = newEntry(element, weight);
            }
         } else {
            for (E element : elements) {
               Objects.requireNonNull(element, "element");
               this.insert0(weight, element);
            }
         }
      }
   }

   public E poll() {
      if (this.size > 0) {
         E e = (E)this.heap[1].element;
         this.remove();
         return e;
      } else {
         return null;
      }
   }

   public int size() {
      return this.size;
   }

   public void remove() {
      if (this.size == 0) {
         throw new NoSuchElementException("Heap is empty");
      }

      this.heap[1].release();
      int hole = 1;
      int succ = 2;

      int sz;
      for (sz = this.size; succ < sz; succ <<= 1) {
         FastBinaryMinHeap.Entry entry1 = this.heap[succ];
         FastBinaryMinHeap.Entry entry2 = this.heap[succ + 1];
         if (entry1.weight > entry2.weight) {
            this.heap[hole] = entry2;
            succ++;
         } else {
            this.heap[hole] = entry1;
         }

         hole = succ;
      }

      FastBinaryMinHeap.Entry bubble = this.heap[sz];

      for (int pred = hole >> 1; this.heap[pred].weight > bubble.weight; pred >>= 1) {
         this.heap[hole] = this.heap[pred];
         hole = pred;
      }

      this.heap[hole] = bubble;
      this.heap[sz] = INFIMUM;
      this.size--;
      if (this.size << 2 < this.heap.length && this.size > 4) {
         this.resize(this.size << 1);
      }
   }

   public boolean isEmpty() {
      return this.size == 0;
   }

   @Override
   protected void deallocate() {
      while (this.size > 0) {
         FastBinaryMinHeap.Entry entry = this.heap[1];
         this.remove();
         entry.release();
      }
   }

   public FastBinaryMinHeap<E> touch(Object hint) {
      return this;
   }

   private static class Entry extends AbstractReferenceCounted {
      private final ObjectPool.Handle<FastBinaryMinHeap.Entry> handle;
      private Object element;
      private long weight;

      private Entry(long weight) {
         this.weight = weight;
         this.handle = null;
      }

      private Entry(ObjectPool.Handle<FastBinaryMinHeap.Entry> handle) {
         this.handle = handle;
      }

      @Override
      protected void deallocate() {
         this.setRefCnt(1);
         if (this.handle != null) {
            this.element = null;
            this.weight = 0L;
            this.handle.recycle(this);
         }
      }

      public FastBinaryMinHeap.Entry touch(Object hint) {
         return this;
      }
   }
}
