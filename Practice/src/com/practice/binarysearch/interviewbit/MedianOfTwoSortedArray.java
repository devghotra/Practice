package com.practice.binarysearch.interviewbit;

public class MedianOfTwoSortedArray {

	public static void main(String[] args) {
		int[] a = { 1 };
		int[] b = { 2, 3, 4, 5, 6 };

		double median = findMedianSortedArrays(a, b);
		System.out.println(median);
	}

	public static double findMedianSortedArrays(int[] a, int[] b) {
		int totalElements = a.length + b.length;

		int medianPos = totalElements / 2;
		if (totalElements % 2 == 0) {
			double m1 = findMedianSortedArrays(a, b, 0, a.length - 1, 0, b.length - 1, medianPos);
			double m2 = findMedianSortedArrays(a, b, 0, a.length - 1, 0, b.length - 1, medianPos + 1);
			return (m1 + m2) / 2;
		} else {
			return findMedianSortedArrays(a, b, 0, a.length - 1, 0, b.length - 1, medianPos + 1);
		}
	}

	// pos - position of element in merged array based on starting index 1
	private static int findMedianSortedArrays(int[] a, int[] b, int astart, int aend, int bstart, int bend, int pos) {
		if (astart > aend) {
			return b[bstart + pos - 1];
		} else if (bstart > bend) {
			return a[astart + pos - 1];
		} else if (pos == 1) {
			return a[astart] < b[bstart] ? a[astart] : b[bstart];
		}

		int m = pos / 2;

		int aVal = astart + m - 1 <= aend ? a[astart + m - 1] : Integer.MAX_VALUE;
		int bVal = bstart + m - 1 <= bend ? b[bstart + m - 1] : Integer.MAX_VALUE;

		if (aVal <= bVal) {
			return findMedianSortedArrays(a, b, astart + m, aend, bstart, bend, pos - m);
		} else {
			return findMedianSortedArrays(a, b, astart, aend, bstart + m, bend, pos - m);
		}
	}

}
