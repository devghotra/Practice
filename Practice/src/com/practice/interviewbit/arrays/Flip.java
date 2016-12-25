package com.practice.interviewbit.arrays;

import java.util.ArrayList;

public class Flip {

	public static void main(String[] args) {
		// flip("101100001");
		// flip("101111111");

		System.out.println(flip("1101010001"));
	}

	public static ArrayList<Integer> flip(String A) {

		char[] arr = A.toCharArray();

		int maxSumSoFar = 0;
		int lastSum = 0;

		int max_start_index = 0;
		int max_end_index = -1;

		int startIndex = 0;

		for (int i = 0; i < arr.length; i++) {
			
			lastSum = arr[i] == '0' ? lastSum+1 : lastSum-1;

			if (lastSum > maxSumSoFar) {
				maxSumSoFar = lastSum;

				max_start_index = startIndex;
				max_end_index = i;
			}

			if (lastSum < 0) {
				startIndex = i + 1;
				lastSum = 0;
			}

		}

		ArrayList<Integer> result = new ArrayList<Integer>();
		if (max_end_index == -1) {
			return result;
		}

		result.add(max_start_index + 1);
		result.add(max_end_index + 1);

		return result;

	}

}
