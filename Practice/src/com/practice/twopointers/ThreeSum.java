package com.practice.twopointers;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ThreeSum {

    @Test
    public void test() {
        assertEquals(-2, threeSumClosest(Arrays.asList(9, -3, -7, 5, 2, -6, 3, -9, -10, 5, -2, -5, 5, 2, -7, 6,
                -4, -7, -9, -7, -8, -6, 6, 7, 8, -6, 2, -10, -6, -1, -4, -1, 1, 5, -4, -9, -10, 2, -10, 4, -3, 4, 10, 2, 3), -2));
    }

    public int threeSumClosest(List<Integer> nums, int target) {
        Collections.sort(nums);

        int offBy = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < nums.size(); i++) {
            int j = i + 1;
            int k = nums.size() - 1;

            while (j < k) {
                int sum = nums.get(i) + nums.get(j) + nums.get(k);
                int diff = Math.abs(sum - target);

                if (diff == 0) return sum;

                if (diff < offBy) {
                    offBy = diff;
                    result = sum;
                }
                if (sum <= target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }
}
