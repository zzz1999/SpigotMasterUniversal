package org.cloudburstmc.netty.util;

import io.netty.util.ReferenceCountUtil;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RoundRobinArray<E> implements Collection<E> {
   private final Object[] elements;
   private final int mask;

   public RoundRobinArray(int fixedCapacity) {
      fixedCapacity = RakUtils.powerOfTwoCeiling(fixedCapacity);
      this.elements = new Object[fixedCapacity];
      this.mask = fixedCapacity - 1;
   }

   public E get(int index) {
      return (E)this.elements[index & this.mask];
   }

   public void set(int index, E value) {
      int idx = index & this.mask;
      Object element = this.elements[idx];
      this.elements[idx] = value;
      ReferenceCountUtil.release(element);
   }

   public void remove(int index, E expected) {
      int idx = index & this.mask;
      Object element = this.elements[idx];
      if (element == expected) {
         this.elements[idx] = null;
         ReferenceCountUtil.release(element);
      }
   }

   @Override
   public int size() {
      throw new UnsupportedOperationException();
   }

   @Override
   public boolean isEmpty() {
      throw new UnsupportedOperationException();
   }

   @Override
   public boolean contains(Object o) {
      throw new UnsupportedOperationException();
   }

   @Override
   public Iterator<E> iterator() {
      return new RoundRobinArray.Itr();
   }

   @Override
   public Object[] toArray() {
      return Arrays.copyOf(this.elements, this.elements.length);
   }

   @Override
   public <T> T[] toArray(T[] a) {
      if (a.length < this.elements.length) {
         return (T[])Arrays.copyOf(this.elements, this.elements.length, (Class<? extends T[]>)a.getClass());
      }

      System.arraycopy(this.elements, 0, a, 0, this.elements.length);
      if (a.length > this.elements.length) {
         a[this.elements.length] = null;
      }

      return a;
   }

   @Override
   public boolean add(E e) {
      throw new UnsupportedOperationException();
   }

   @Override
   public boolean remove(Object o) {
      throw new UnsupportedOperationException();
   }

   @Override
   public boolean containsAll(Collection<?> c) {
      throw new UnsupportedOperationException();
   }

   @Override
   public boolean addAll(Collection<? extends E> c) {
      throw new UnsupportedOperationException();
   }

   @Override
   public boolean removeAll(Collection<?> c) {
      throw new UnsupportedOperationException();
   }

   @Override
   public boolean retainAll(Collection<?> c) {
      throw new UnsupportedOperationException();
   }

   @Override
   public void clear() {
      Arrays.fill(this.elements, null);
   }

   private class Itr implements Iterator<E> {
      int cursor;
      int lastRet = -1;

      Itr() {
      }

      @Override
      public boolean hasNext() {
         return this.cursor != RoundRobinArray.this.elements.length;
      }

      @Override
      public E next() {
         int i = this.cursor;
         if (i >= RoundRobinArray.this.elements.length) {
            throw new NoSuchElementException();
         }

         this.cursor = i + 1;
         return (E)RoundRobinArray.this.elements[this.lastRet = i];
      }

      @Override
      public void remove() {
         if (this.lastRet < 0) {
            throw new IllegalStateException();
         }

         Object object = RoundRobinArray.this.elements[this.lastRet];
         RoundRobinArray.this.elements[this.lastRet] = null;
         ReferenceCountUtil.release(object);
         this.cursor = this.lastRet;
         this.lastRet = -1;
      }
   }
}
