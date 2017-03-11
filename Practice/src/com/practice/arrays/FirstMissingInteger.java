package com.practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstMissingInteger {

	public static void main(String[] args) {
		Integer[] nums = { 3,4,-1,1 };
		System.out.println(firstMissingPositive(new ArrayList<>(Arrays.asList(nums))));

	}

	// for IB - same logic as below method
	// CRUX - maximum number of positive numbers you can keep in array of size N is N
	// so we need to remove -ve and out of range +ive nums and swap elements until element finds its correct position, in the end array will be sorted
	// first NULL will give us missing number else all +ive nums are present till N so answer would be (N+1)
	public static int firstMissingPositive(ArrayList<Integer> nums) {
		int len = nums.size();

		for (int i = 0; i < len;) {
			if (nums.get(i) != null && nums.get(i) != i + 1) {

				// mark this num as NULL - 
				// if num at i is negative or larger than size of list or other num at num[i]-1th index is same as this num such as (2,2)
				if (nums.get(i) <= 0 || nums.get(i) > len || nums.get(i) == nums.get(nums.get(i) - 1)) {
					nums.set(i, null);
				} else {
					// else swap both num at ith index and num[i]-1th index
					Integer temp = nums.get(i) == null ? null : nums.get(nums.get(i) - 1);
					nums.set(nums.get(i) - 1, nums.get(i));
					nums.set(i, temp);
					continue;
				}
			}

			i++;
		}
		
		for (int i = 0; i < len; i++) {
			if (nums.get(i) == null)
				return i + 1;
		}

		return len + 1;
	}
	
	public static int firstMissingPositive(int[] nums) {
		int len = nums.length;

		for (int i = 0; i < nums.length;) {
			if (nums[i] != i + 1) {

				if (nums[i] <= 0 || nums[i] > len || nums[i] == nums[nums[i] - 1]) {
					nums[i] = Integer.MAX_VALUE;
				} else {
					int temp = nums[nums[i] - 1];
					nums[nums[i] - 1] = nums[i];
					nums[i] = temp;
					continue;
				}
			}

			i++;
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == Integer.MAX_VALUE)
				return i + 1;
		}

		return len + 1;
	}

}
