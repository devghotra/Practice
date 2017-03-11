package com.practice.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

public class SortByColor {

	public static void main(String[] args) {
		Integer[] nums = { 0, 1, 1, 0, 2, 1, 2, 0, 2 };
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(nums));
		sortColors(list);
		System.out.println(list);
	}

	public static void sortColors(ArrayList<Integer> nums) {
		int p0 = 0;				// pointer for last valid position of 0
		int p2 = nums.size()-1; // pointer for last valid position of 2

		for (int i = 0; i < p2;) {
			if (nums.get(i).intValue() == 0) {
				swap(nums, p0, i);
				p0++;
			} else if (nums.get(i).intValue() == 2) {
				swap(nums, p2, i);
				p2--;
				continue;
			}
			i++;
		}
	}

	private static void swap(ArrayList<Integer> nums, int p1, int p2) {
		int temp = nums.get(p2);
		nums.set(p2, nums.get(p1));
		nums.set(p1, temp);
	}

}
