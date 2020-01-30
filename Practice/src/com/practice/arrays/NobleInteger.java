package com.practice.arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NobleInteger {

    @Test
    public void test() {
        assertEquals(-1, solve(Arrays.asList()));
        assertEquals(-1, solve(Arrays.asList(1)));
        assertEquals(1, solve(Arrays.asList(1, 2)));
        assertEquals(1, solve(Arrays.asList(1, 2, 3, 3)));
        assertEquals(1, solve(Arrays.asList(-4, -2, 0, -1, -6)));
    }


    public int solve(List<Integer> A) {
        Collections.sort(A);

        for (int i = 0; i < A.size(); i++) {
            if (i + 1 < A.size() && A.get(i) == A.get(i + 1)) {
                continue;
            }

            int num = A.get(i);
            int biggerItems = A.size() - i - 1;

            if (num == biggerItems) {
                return 1;
            }
        }

        return -1;
    }
}
