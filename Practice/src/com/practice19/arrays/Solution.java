package com.practice19.arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Solution {

    @Test
    public void test() {
        int[] arr = {1, 3, 5, 7, 9, 11};
        double median = findMedianSortedArrays(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(21, 22, 23, 24, 25, 26, 27, 28, 29, 30));
        System.out.println(median);
    }

    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

        int medianIndex = (a.size() + b.size()) / 2;
        int min = Math.min(a.get(0), b.get(0));
        int max = Math.max(a.get(a.size() - 1), b.get(b.size() - 1));

        while (min < max) {
            int mid = (min + max) / 2;

            int aSteps = binarySearch(a, mid);
            int bSteps = binarySearch(b, mid);

            int totalSteps = aSteps + bSteps;
            if (totalSteps < medianIndex) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }


    public int binarySearch(List<Integer> list, int target) {
        int l = 0;
        int h = list.size() - 1;
        int index = -1;

        while (l <= h) {
            int mid = (l + h) / 2;
            if (list.get(mid) == target) {
                index = mid;
                break;
            }

            if (list.get(mid) > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return index == -1 ? l : index;
    }
}
