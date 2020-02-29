package com.practice.heapsmaps;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

public class MagicianAndChocolates {

    @Test
    public void test() {
        assertEquals(1, 1);
        assertEquals(14, nchoc(3, Arrays.asList(6, 5)));
    }

    public int nchoc(int A, List<Integer> B) {
        int mod = 1000000007;
        int total = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        B.stream().forEach(c -> pq.add(c));

        while (A > 0) {
            int c = pq.poll();
            total += c % mod;
            pq.add(c / 2);
            A--;

            total %= mod;
        }

        return total;
    }
}
