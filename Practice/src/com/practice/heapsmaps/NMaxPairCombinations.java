package com.practice.heapsmaps;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class NMaxPairCombinations {


    @Test
    public void test() {
        assertEquals(1, 1);
        System.out.println(solve(
                new ArrayList<>(Arrays.asList(48, 46, 45, 43, 43, 42, 41, 40, 37, 36, 36, 34)),
                new ArrayList<>(Arrays.asList(49, 47, 47, 47, 46, 45, 44, 43, 42, 39, 38, 38))));
    }

    public List<Integer> solve(List<Integer> A, List<Integer> B) {
        int n = A.size();
        ArrayList<Integer> result = new ArrayList<>();
        A.sort(Comparator.reverseOrder());
        B.sort(Comparator.reverseOrder());

        Set<Pair> maxSumPairs = new HashSet<>();
        TreeMap<Integer, List<Pair>> sumToIndexesMaxQueue = new TreeMap<>(Comparator.reverseOrder());
        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(0, 0));
        sumToIndexesMaxQueue.put(A.get(0) + B.get(0), pairs);

        while (result.size() < n) {
            Map.Entry<Integer, List<Pair>> maxSumEntry = sumToIndexesMaxQueue.firstEntry();
            Pair maxPair = maxSumEntry.getValue().remove(0);
            result.add(maxSumEntry.getKey());

            if (maxSumEntry.getValue().isEmpty()) {
                sumToIndexesMaxQueue.pollFirstEntry();
            }

            int i = maxPair.i;
            int j = maxPair.j;

            List<Pair> nextPairs = new ArrayList<>();
            nextPairs.add(new Pair(i, j + 1));
            nextPairs.add(new Pair(i + 1, j));

            nextPairs.forEach(pair -> {
                if (!maxSumPairs.contains(pair) && pair.i >= 0 && pair.i < n && pair.j >= 0 && pair.j < n) {
                    int sum = A.get(pair.i) + B.get(pair.j);
                    List<Pair> pairsForSum = sumToIndexesMaxQueue.containsKey(sum) ? sumToIndexesMaxQueue.get(sum) : new ArrayList<>();
                    pairsForSum.add(pair);
                    sumToIndexesMaxQueue.put(sum, pairsForSum);
                    maxSumPairs.add(pair);
                }
            });
        }
        return result;
    }

    class Pair {
        int i, j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return i == pair.i &&
                    j == pair.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    /*******************************************************************************
     *   O(n2) solution but efficient space complexity                             *
     *******************************************************************************/
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Collections.sort(A);
        Collections.sort(B);

        for (int i = A.size() - 1; i >= 0; i--) {
            for (int j = B.size() - 1; j >= 0; j--) {
                if (pq.size() < A.size()) {
                    pq.add(A.get(i) + B.get(j));
                } else {
                    if (A.get(i) + B.get(j) <= pq.peek()) { // it is less
                        break;
                    } else {
                        pq.poll();
                        pq.add(A.get(i) + B.get(j));
                    }
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (pq.size() > 0)
            result.add(0, pq.poll());
        return result;
    }
}


