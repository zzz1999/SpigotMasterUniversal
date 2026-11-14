package it.unimi.dsi.fastutil;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntAVLTreeMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectAVLTreeSet;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectImmutableList;
import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FastutilReconstructionTest {

    private static void check(boolean condition, String message) {
        org.junit.Assert.assertTrue(message, condition);
    }

    private static int compare(Object left, Object right) {
        if (left instanceof Character) return Character.compare((Character) left, (Character) right);
        return Double.compare(((Number) left).doubleValue(), ((Number) right).doubleValue());
    }

    private static Object values(Class<?> type, int length, Random random) {
        Object array = Array.newInstance(type, length);
        for (int i = 0; i < length; i++) {
            int value = random.nextInt(121) - 60;
            if (type == byte.class) Array.setByte(array, i, (byte) value);
            else if (type == char.class) Array.setChar(array, i, (char) (value + 60));
            else if (type == short.class) Array.setShort(array, i, (short) value);
            else if (type == int.class) Array.setInt(array, i, value);
            else if (type == long.class) Array.setLong(array, i, value);
            else if (type == float.class) Array.setFloat(array, i, value / 4.0f);
            else Array.setDouble(array, i, value / 4.0);
        }
        return array;
    }

    private static void sorting(Class<?> type, String packageName, String className) throws Exception {
        final int length = 4099;
        Class<?> library = Class.forName("it.unimi.dsi.fastutil." + packageName + "." + className + "Arrays");
        Random random = new Random(781 + type.getName().hashCode());
        Object array = values(type, length, random);
        Method radix = library.getMethod("parallelRadixSortIndirect", int[].class,
                array.getClass(), int.class, int.class, boolean.class);
        for (boolean stable : new boolean[] {false, true}) {
            int[] permutation = IntStream.range(0, length).toArray();
            int from = 17;
            int to = length - 19;

            radix.invoke(null, permutation, array, from, to, stable);
            boolean[] seen = new boolean[length];
            for (int i = 0; i < length; i++) {
                check(!seen[permutation[i]], type + " duplicate permutation");
                seen[permutation[i]] = true;
                if (i < from || i >= to) check(permutation[i] == i, type + " changed outside sort range");
                if (i > from && i < to) {
                    int comparison = compare(Array.get(array, permutation[i - 1]), Array.get(array, permutation[i]));
                    check(comparison <= 0, type + " incorrect radix order");
                    if (stable && comparison == 0) {
                        check(permutation[i - 1] < permutation[i], type + " unstable equal values");
                    }
                }
            }
        }

        final Object first = values(type, length, random);
        final Object second = values(type, length, random);
        Integer[] expected = IntStream.range(0, length).boxed().toArray(Integer[]::new);
        Arrays.sort(expected, new Comparator<Integer>() {
            public int compare(Integer left, Integer right) {
                int primary = FastutilReconstructionTest.compare(Array.get(first, left), Array.get(first, right));
                return primary != 0 ? primary : FastutilReconstructionTest.compare(Array.get(second, left), Array.get(second, right));
            }
        });
        Object originalFirst = Array.newInstance(type, length);
        Object originalSecond = Array.newInstance(type, length);
        System.arraycopy(first, 0, originalFirst, 0, length);
        System.arraycopy(second, 0, originalSecond, 0, length);

        library.getMethod("quickSort", first.getClass(), second.getClass()).invoke(null, first, second);
        for (int i = 0; i < length; i++) {
            check(compare(Array.get(first, i), Array.get(originalFirst, expected[i])) == 0,
                    type + " incorrect primary paired quicksort value");
            check(compare(Array.get(second, i), Array.get(originalSecond, expected[i])) == 0,
                    type + " incorrect secondary paired quicksort value");
        }
    }

    private static void mapsAndCollectors() {
        Int2ObjectOpenHashMap<String> ints = new Int2ObjectOpenHashMap<String>();
        Long2ObjectOpenHashMap<String> longs = new Long2ObjectOpenHashMap<String>();
        Object2IntOpenHashMap<String> objects = new Object2IntOpenHashMap<String>();
        Map<Integer, String> reference = new HashMap<Integer, String>();
        for (int i = 0; i < 1500; i++) {
            ints.put(i, "v" + i);
            longs.put((long) i, "v" + i);
            objects.put("k" + i, i);
            reference.put(i, "v" + i);
        }
        check(ints.equals(reference), "int map equality");
        check(ints.entrySet().equals(reference.entrySet()), "generic entry set bridge");
        for (int i = 0; i < 1500; i++) {
            check(("v" + i).equals(longs.get((long) i)), "long map lookup");
            check(objects.getInt("k" + i) == i, "object map lookup");
        }
        Int2ObjectMap<String> readOnly = Int2ObjectMaps.unmodifiable(ints);
        check("missing".equals(readOnly.getOrDefault(-1, "missing")), "unmodifiable default lookup");
        check(readOnly.entrySet().size() == 1500, "unmodifiable entries");
        try {
            readOnly.put(-1, "bad");
            throw new AssertionError("unmodifiable map accepted mutation");
        } catch (UnsupportedOperationException expected) { /* Expected immutable view behavior. */ }

        Object2IntAVLTreeMap<String> sorted = new Object2IntAVLTreeMap<String>();
        ObjectAVLTreeSet<String> set = new ObjectAVLTreeSet<String>();
        for (String key : Arrays.asList("d", "b", "c", "a")) {
            sorted.put(key, key.charAt(0));
            set.add(key);
        }
        check(sorted.subMap("b", "d").size() == 2, "sorted map generic submap");
        check(set.headSet("c").size() == 2, "sorted set generic headset");
        check(set.tailSet("c").size() == 2, "sorted set generic tailset");

        java.util.List<Integer> expected = IntStream.range(0, 100).boxed().collect(Collectors.toList());
        ObjectArrayList<Integer> list = IntStream.range(0, 100).boxed().collect(ObjectArrayList.toListWithExpectedSize(100));
        ObjectImmutableList<Integer> immutable = IntStream.range(0, 100).boxed().collect(ObjectImmutableList.toListWithExpectedSize(100));
        ObjectLinkedOpenHashSet<Integer> linked = IntStream.range(0, 100).boxed().collect(ObjectLinkedOpenHashSet.toSetWithExpectedSize(100));
        ObjectOpenHashSet<Integer> unordered = IntStream.range(0, 100).boxed().collect(ObjectOpenHashSet.toSetWithExpectedSize(100));
        check(list.equals(expected), "list collector");
        check(immutable.equals(expected), "immutable list collector");
        check(linked.size() == 100 && linked.containsAll(expected), "linked set collector");
        check(unordered.size() == 100 && unordered.containsAll(expected), "set collector");
        check(IntStream.range(0, 100).parallel().boxed().collect(ObjectArrayList.toListWithExpectedSize(100)).equals(expected),
                "parallel list collector combine");
    }

    @org.junit.Test(timeout = 30000)
    public void primitiveSortsPreservePermutationOrderAndStability() throws Exception {
        // Force the queue-based branch even on runners with a one-worker common pool.
        java.util.concurrent.ForkJoinPool pool = new java.util.concurrent.ForkJoinPool(4);
        try {
            pool.submit(new java.util.concurrent.Callable<Void>() {
                public Void call() throws Exception {
                    sorting(byte.class, "bytes", "Byte");
                    sorting(char.class, "chars", "Char");
                    sorting(short.class, "shorts", "Short");
                    sorting(int.class, "ints", "Int");
                    sorting(long.class, "longs", "Long");
                    sorting(float.class, "floats", "Float");
                    sorting(double.class, "doubles", "Double");
                    return null;
                }
            }).get(20, java.util.concurrent.TimeUnit.SECONDS);
        } finally {
            pool.shutdownNow();
        }
    }

    @org.junit.Test(timeout = 10000)
    public void genericMapEntriesViewsAndCollectorsKeepTheirContracts() {
        mapsAndCollectors();
    }
}
