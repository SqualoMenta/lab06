package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.lang.Math;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    private final static int N1 = 1000, N2 = 2000;

    /**
     * @param s
     *          unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final List<Integer> numeri = new ArrayList<>();
        for (int i = 0; i < N2 - N1; i++) {
            numeri.add(i + N1);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final List<Integer> numeroni = new LinkedList<>(numeri);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int temp;
        temp = numeri.get(N1 - N1);
        numeri.set(N1 - N1, numeri.get(N2 - N1 - 1));
        numeri.set(N2 - N1 - 1, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (int i : numeri) {
            System.out.println(i);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            numeri.add(N1 - N1, (int) Math.round(1000 * Math.random()));
        }
        System.out.println();
        System.out.println(System.nanoTime() - time);

        time = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            numeroni.add(N1 - N1, (int) Math.round(1000 * Math.random()));
        }
        System.out.println(System.nanoTime() - time);
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        System.out.println();
        time = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            numeri.get((N2 - N1) / 2);
        }
        System.out.println(System.nanoTime() - time);

        time = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            numeroni.get((N2 - N1) / 2);
        }
        System.out.println(System.nanoTime() - time);
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map<String,Long> cose = new HashMap<>();
        cose.put("Africa", 1_110_635_000l);
        cose.put("Americas", 972_005_000l);
        cose.put("Antarctica", 0l);
        cose.put("Asia", 4_298_723_000l);
        cose.put("Africa", 742_452_000l);
        cose.put("Africa", 38_304_000l);
        /*
         * 8) Compute the population of the world
         */
        long popolazioneMondiale = 0l;

        for (long popolazione : cose.values()) {
            popolazioneMondiale += popolazione;
        }
        System.out.println(popolazioneMondiale);
    }
}
