package com.practice.bit;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SingleNumber2 {

    @Test
    public void test() {
        assertEquals(2, singleNumber(Arrays.asList(1, 1, 1, 2, 2, 3, 3, 3)));
    }

    /**
     * For every bit position count number of zeros,
     * if that divides by 3 then it will be 1 bit on that position for missing number
     */
    public long singleNumber(final List<Integer> A) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int zeros = 0;
            for (int j = 0; j < A.size(); j++) {
                if ((A.get(j) & (1 << i)) == 0) {
                    zeros++;
                }
            }

            if (zeros % 3 == 0) {
                res = res | 1 << i;
            }
        }

        return res;
    }
}
