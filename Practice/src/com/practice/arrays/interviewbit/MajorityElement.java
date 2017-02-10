package com.practice.arrays.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElement {

	public static void main(String[] args) {
		Integer[] nums = { 1, 2, 1, 2, 1, 1, 3, 3, 4 };
		System.out.println(majorityElement(new ArrayList<>(Arrays.asList(nums))));
	}

	public static int majorityElement(List<Integer> nums) {
		List<Integer> result = new ArrayList<>();

		Integer n1 = null, n2 = null;
		int c1 = 0, c2 = 0;

		for (int num : nums) {
			if (n1 != null && n1.intValue() == num) {
				c1++;
			} else if (n2 != null && n2.intValue() == num) {
				c2++;
			} else if (c1 == 0) {
				n1 = num;
				c1 = 1;
			} else if (c2 == 0) {
				n2 = num;
				c2 = 1;
			} else {
				c1--;
				c2--;
			}
		}
		
		c1 = 0; c2 = 0;

		for (int i : nums) {
			if (i == n1.intValue()) {
				c1++;
			} else if (i == n2.intValue()) {
				c2++;
			}
		}

		if (c1 > nums.size() / 3)
			result.add(n1);
		if (c2 > nums.size() / 3)
			result.add(n2);

		return result.isEmpty() ? -1 : result.get(0);
	}

}
