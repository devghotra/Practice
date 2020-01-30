package com.practice.binarysearch;

import java.util.List;

public class MedianOfTwoSortedArray {

    public static void main(String[] args) {

        int[] a = {1};
        int[] b = {2, 3, 4, 5, 6};

        double median = findMedianSortedArrays(a, b);
        System.out.println(median);
    }

    public static double findMedianSortedArrays(int[] a, int[] b) {
        int totalElements = a.length + b.length;

        int medianPos = totalElements / 2;
        if (totalElements % 2 == 0) {
            double m1 = findMedianSortedArrays(a, b, 0, 0, medianPos);
            double m2 = findMedianSortedArrays(a, b, 0, 0, medianPos + 1);
            return (m1 + m2) / 2;
        } else {
            return findMedianSortedArrays(a, b, 0, 0, medianPos + 1);
        }
    }

    // pos - position of element in merged array based on starting index 1
    private static int findMedianSortedArrays(int[] a, int[] b, int astart, int bstart, int pos) {
        if (astart >= a.length) {
            return b[bstart + pos - 1];
        } else if (bstart >= b.length) {
            return a[astart + pos - 1];
        } else if (pos == 1) {
            return a[astart] < b[bstart] ? a[astart] : b[bstart];
        }

        int m = pos / 2;

        int aVal = astart + m - 1 < a.length ? a[astart + m - 1] : Integer.MAX_VALUE;
        int bVal = bstart + m - 1 < b.length ? b[bstart + m - 1] : Integer.MAX_VALUE;

        if (aVal <= bVal) {
            return findMedianSortedArrays(a, b, astart + m, bstart, pos - m);
        } else {
            return findMedianSortedArrays(a, b, astart, bstart + m, pos - m);
        }
    }


    // Same solution for IB
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int totalElements = a.size() + b.size();

        int medianPos = totalElements / 2;
        if (totalElements % 2 == 0) {
            double m1 = findMedianSortedArrays(a, b, 0, 0, medianPos);
            double m2 = findMedianSortedArrays(a, b, 0, 0, medianPos + 1);
            return (m1 + m2) / 2;
        } else {
            return findMedianSortedArrays(a, b, 0, 0, medianPos + 1);
        }
    }

    private static int findMedianSortedArrays(final List<Integer> a, final List<Integer> b, int astart, int bstart, int pos) {
        if (astart >= a.size()) {
            return b.get(bstart + pos - 1);
        } else if (bstart >= b.size()) {
            return a.get(astart + pos - 1);
        } else if (pos == 1) {
            return a.get(astart) < b.get(bstart) ? a.get(astart) : b.get(bstart);
        }

        int m = pos / 2;

        int aVal = astart + m - 1 < a.size() ? a.get(astart + m - 1) : Integer.MAX_VALUE;
        int bVal = bstart + m - 1 < b.size() ? b.get(bstart + m - 1) : Integer.MAX_VALUE;

        if (aVal <= bVal) {
            return findMedianSortedArrays(a, b, astart + m, bstart, pos - m);
        } else {
            return findMedianSortedArrays(a, b, astart, bstart + m, pos - m);
        }
    }

}
