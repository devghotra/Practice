package com.practice.twopointers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxContinousSeriesOf1s {

    @Test
    public void test() {
        //System.out.println(maxone(Arrays.asList(0, 1, 1, 1), 0));
        System.out.println(maxone(Arrays.asList(1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0), 4));
        //System.out.println(maxone(Arrays.asList(1, 1, 0, 1, 1, 0, 0, 1, 1, 1), 1));
        //System.out.println(maxone(Arrays.asList(1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1), 2));
    }

    public List<Integer> maxone(List<Integer> A, int B) {

        int startIndex = 0, left = 0, right = 0;
        int flips = B;
        int count = 0;

        while (right < A.size()) {
            if (A.get(right) == 1) {
                right++;
            } else if (flips > 0) {
                flips--;
                right++;
            } else if (left < right) {
                flips += 1 - A.get(left);
                left++;
            } else {
                left++;
                right++;
            }

            if (right - left > count) {
                count = right - left;
                startIndex = left;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(startIndex + i);
        }

        return result;
    }
}
