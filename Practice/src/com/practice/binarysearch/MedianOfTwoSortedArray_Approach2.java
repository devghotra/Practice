package com.practice.binarysearch;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MedianOfTwoSortedArray_Approach2 {
    /**
     * Doesn't work for negative numbers
     * https://www.geeksforgeeks.org/find-median-row-wise-sorted-matrix/
     */
    @Test
    public void test() {
        double median = findMedianSortedArrays(Arrays.asList(-37, -9, 10, 19), Arrays.asList(-29, 18, 46));
        System.out.println(median);
    }

    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int medianIndex = (a.size() + b.size()) / 2;

        int aMin = a.isEmpty() ? Integer.MAX_VALUE : a.get(0);
        int aMax = a.isEmpty() ? Integer.MIN_VALUE : a.get(a.size() - 1);

        int bMin = b.isEmpty() ? Integer.MAX_VALUE : b.get(0);
        int bMax = b.isEmpty() ? Integer.MIN_VALUE : b.get(b.size() - 1);

        int min = Math.min(aMin, bMin);
        int max = Math.max(aMax, bMax);

        while (min < max) {
            // imagine mid as median and then check how many steps it would take on both lists, accordingly adjust min & max
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
