package com.practice.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumUnsortedSubarray {

	public static void main(String[] args) {
		Integer[] in = { 1, 2, 3, 5, 6, 13, 15, 16, 17, 13, 13, 15, 17, 17, 17, 17, 17, 19, 19 };
		System.out.println(subUnsort(new ArrayList<>(Arrays.asList(in))));

	}

	public static ArrayList<Integer> subUnsort(ArrayList<Integer> input) {
		ArrayList<Integer> result = new ArrayList<>();
		if (input.size() < 2) {
			result.add(-1);
			return result;
		}
		
		// from left
		int l1 = -1;
		int r1 = -1;
		int max = input.get(0);
		for (int i = 1; i < input.size(); i++) {
			int current = input.get(i);
			max = Math.max(max, current);
			if (current < input.get(i - 1) || current < max) {
				if (l1 == -1) {
					l1 = i - 1;
					r1 = i;
				} else {
					r1 = i;
				}

			}
		}

		// from right
		int l2 = -1;
		int r2 = -1;
		int min = input.get(input.size() - 1);
		for (int i = input.size() - 2; i >= 0; i--) {
			int current = input.get(i);
			min = Math.min(min, current);
			if (current > input.get(i + 1) || current > min) {
				if (l2 == -1) {
					l2 = i;
					r2 = i;
				} else {
					r2 = i;
				}

			}
		}

		if (l1 == -1) {
			result.add(l1);
		} else {
			result.add(Math.min(l1, r2));
			result.add(Math.max(r1, l2));
		}
		return result;
	}

}
