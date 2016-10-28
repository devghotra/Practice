package com.practice.questions;

public class FindElementRotatedArray {

	public static void main(String[] args) {
		 int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
		 
		 System.out.println(search(arr, 6, 0, 8));
	}

	public static boolean search(int[] a, int num, int startIndex, int endIndex) {
		if (endIndex < startIndex) 
			return false;
		
		int mid = (startIndex + endIndex) / 2;

		if (a[mid] == num) {
			return true;
		}
		
		// if 1st half is sorted
		if (a[mid] > a[startIndex]) {
			if (a[startIndex] < num && num < a[mid]) {
				// if num is in range of 1st half
				return search(a, num, startIndex, mid-1);
			} else {
				// else try 2nd half
				return search(a, num, mid+1, endIndex);
			}
		}
		
		// if 1st half is not sorted then 2nd half must be sorted, if number is in range of 2nd half then search 2nd half
		if (num >= a[mid] && num <= a[endIndex]) {
			return search(a, num, mid + 1, endIndex);
		}

		// if 1st half is not sorted and number is not in range of 2nd half then search in first half
		return search(a, num, 1, mid - 1);
	}
}
