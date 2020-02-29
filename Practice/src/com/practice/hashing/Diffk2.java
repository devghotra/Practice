package com.practice.hashing;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Diffk2 {

    @Test
    public void test() {
        assertEquals(1, 1);
        Integer[] input = {11, 85, 100, 44, 3, 32, 96, 72, 93, 76, 67, 93, 63, 5, 10, 45, 99, 35, 13};
        assertEquals(1, diffPossible(Arrays.asList(input), 0));
    }

    public int diffPossible(final List<Integer> input, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer n : input) {
            if (set.contains(n)) {
                return 1;
            }
            set.add(n + k);
            set.add(n - k);
        }
        return 0;
    }

}
