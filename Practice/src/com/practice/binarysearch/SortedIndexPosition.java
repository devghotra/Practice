package com.practice.binarysearch;

import java.util.Arrays;
import java.util.List;

public class SortedIndexPosition {

	public static void main(String[] args) {
		Integer[] arr = {0,1,2,3,4,5,6};
		System.out.println(searchInsert(Arrays.asList(arr), 8));
	}

	public static int searchInsert(List<Integer> nums, int target) {
		int low = 0;
		int high = nums.size() - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums.get(mid) == target)
				return mid;

			if (nums.get(mid) > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return low;
	}
}
