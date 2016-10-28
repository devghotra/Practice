package com.practice.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Four4Sum {
	public static void main(String[] args) {
		Four4Sum fourSum = new Four4Sum();
		int[] input = { -477,-476,-471,-462,-440,-400,-398,-394,-394,-393,-389,-386,-350,-346,-338,-315,-273,-249,-182,-172,-166,-161,-149,-116,-112,-109,-100,-73,-33,-26,-22,-11,6,8,13,19,56,78,101,102,111,140,155,158,181,205,211,225,232,242,254,265,281,308,310,320,320,364,366,381,385,387,443,496,496 };
		System.out.println(fourSum.fourSum(input, 1236));

	}

	public ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
		Integer[] nums1 = new Integer[nums.length];
		for (int i = 0; i < nums.length; i++) {
			nums1[i] = nums[i];
		}
		return fourSum(Arrays.asList(nums1), target);
	}

	public ArrayList<ArrayList<Integer>> fourSum(List<Integer> input, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		Collections.sort(input);

		for (int i = 0; i <= input.size() - 4; i++) {
			int num1 = input.get(i);
			if (i > 0 && num1 == input.get(i - 1)) {
				continue;
			}
			for (int j = i + 1; j <= input.size() - 3; j++) {
				int num2 = input.get(j);
				if (j - i > 1 && num2 == input.get(j - 1)) {
					continue;
				}
				int l = j + 1;
				int r = input.size() - 1;
				while (l < r) {
					if (l - j > 1 && input.get(l).equals(input.get(l - 1))) {
						l++;
						continue;
					}

					if (r + 1 < input.size() && input.get(r).equals(input.get(r + 1))) {
						r--;
						continue;
					}

					int sum = num1 + num2 + input.get(l) + input.get(r);
					if (sum == target) {
						ArrayList<Integer> combination = new ArrayList<Integer>();
						combination.add(num1);
						combination.add(num2);
						combination.add(input.get(l));
						combination.add(input.get(r));
						result.add(combination);
						l++;
						r--;
					} else if (sum > target) {
						r--;
					} else {
						l++;
					}
				}
			}
		}

		return result;
	}

}
