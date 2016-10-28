package com.practice.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoSortedArray {

	public static void main(String[] args) {
		int[] a = { 1,2,3,4,5};
		int[] b = { 6,7};

		double median = findMedianSortedArrays(a, b);
		System.out.println(median);
	}

	public static double findMedianSortedArrays(int[] a, int[] b) {
		List<Integer> aList = new ArrayList<>();
		for (int a1 : a) {
			aList.add(a1);
		}

		List<Integer> bList = new ArrayList<>();
		for (int b1 : b) {
			bList.add(b1);
		}

		double median = findMedianSortedArrays(aList, bList);
		return median;
	}

	public static double findMedianSortedArrays(List<Integer> a, List<Integer> b) {
		int median = findMedian(a, b);
		if (median >= 0) {
			if ((a.size() + b.size()) % 2 == 1) {
				return a.get(median);
			} else {
				return (a.get(median) + a.get(median + 1)) / 2;
			}
		} else {
			median = findMedian(b, a);
			if (median >= 0) {
				if ((a.size() + b.size()) % 2 == 1) {
					return b.get(median);
				} else {
					return (b.get(median) + b.get(median + 1)) / 2;
				}
			} else {
				if(b.get(0) >= a.get(a.size() - 1))
					return (double)(a.get(a.size() - 1) + b.get(0)) / 2;
				else if(a.get(0) >= b.get(b.size() - 1))
					return (double)(b.get(b.size() - 1) + a.get(0)) / 2; 
				else 
					return -1;
			}
		}

	}

	public static int findMedian(List<Integer> a, List<Integer> b) {
		int medianIndex = (a.size() + b.size() - 1) / 2;

		int guessIndex = (a.size() - 1) / 2;
		int maxIndex = a.size() - 1;
		int minIndex = 0;
		while (minIndex <= maxIndex) {
			int smallerElements = medianIndex - guessIndex;

			if (smallerElements > 0 && smallerElements < b.size() && b.get(smallerElements - 1) <= a.get(guessIndex) && a.get(guessIndex) <= b.get(smallerElements)) {
				return guessIndex;
			} else {
				//if (guessIndex == 0 || guessIndex == a.size() - 1)
					//break;

				if (a.get(guessIndex) < b.get(smallerElements - 1)) {
					minIndex = guessIndex;
					guessIndex = (guessIndex + 1 + maxIndex) / 2;
				} else if (a.get(guessIndex) > b.get(smallerElements)) {
					maxIndex = guessIndex;
					guessIndex = (minIndex + guessIndex - 1) / 2;
				}
			}
		}

		return -1;

	}

}
