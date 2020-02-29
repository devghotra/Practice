package com.practice.hashing;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ColorfulNumber {

    @Test
    public void test() {
        assertEquals(1, colorful(3245));
        assertEquals(0, colorful(1212));
    }

    public int colorful(int num) {
        Set<Integer> productSet = new HashSet<>();

        char[] nums = String.valueOf(num).toCharArray();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i] - '0';
            if (productSet.contains(n)) {
                return 0;
            } else {
                productSet.add(n);
            }

            for (int j = i + 1; j < nums.length; j++) {
                n *= nums[j] - '0';
                if (productSet.contains(n)) {
                    return 0;
                } else {
                    productSet.add(n);
                }
            }
        }

        return 1;
    }

}
