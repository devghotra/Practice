package com.practice.twopointers;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ContainerWithMostWater {

    @Test
    public void test() {
        assertEquals(80, maxArea(Arrays.asList(2, 3, 50, 10, 40, 3, 1, 6)));
    }

    public int maxArea(List<Integer> heights) {
        int maxArea = 0;
        int left = 0;
        int right = heights.size() - 1;

        while (left < right) {
            int capacity = (right - left) * Math.min(heights.get(right), heights.get(left));
            maxArea = Math.max(maxArea, capacity);

            if (heights.get(left) < heights.get(right)) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
