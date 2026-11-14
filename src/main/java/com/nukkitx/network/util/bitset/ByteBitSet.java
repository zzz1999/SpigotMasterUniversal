package com.nukkitx.network.util.bitset;

public class ByteBitSet implements BitSet {
   private byte bitset;

   public ByteBitSet() {
      this.bitset = 0;
   }

   public ByteBitSet(byte bitset) {
      this.bitset = bitset;
   }

   public ByteBitSet(int bitset) {
      this.bitset = (byte)bitset;
   }

   public ByteBitSet(ByteBitSet bitSet) {
      this.bitset = bitSet.bitset;
   }

   private static void checkIndex(int index) {
      if (index < 0 || index >= 8) {
         throw new IndexOutOfBoundsException("Expected value 0-7");
      }
   }

   @Override
   public void flip(int index) {
      this.bitset = BitUtil.flipBit(this.bitset, index);
   }

   @Override
   public void set(int index, boolean value) {
      this.bitset = BitUtil.setBit(this.bitset, index, value);
   }

   @Override
   public boolean get(int index) {
      return BitUtil.getBit(this.bitset, index);
   }

   @Override
   public long[] getLongs() {
      return new long[]{this.bitset};
   }

   @Override
   public int[] getInts() {
      return new int[]{this.bitset};
   }

   @Override
   public short[] getShorts() {
      return new short[]{this.bitset};
   }

   @Override
   public byte[] getBytes() {
      return new byte[]{this.bitset};
   }

   @Override
   public void clear() {
      this.bitset = 0;
   }

   public byte get() {
      return this.bitset;
   }

   public void set(byte bitset) {
      this.bitset = bitset;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ByteBitSet)) {
         return false;
      }

      ByteBitSet that = (ByteBitSet)o;
      return this.bitset == that.get();
   }
}
