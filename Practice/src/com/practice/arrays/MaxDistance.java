package com.practice.arrays;

public class MaxDistance {

	public static void main(String[] args) {
		int[] a = {34, 8, 10, 3, 2, 80, 30, 33, 1};
		System.out.println(maxIndexDiff(a, 9));
	}

	public static int maxIndexDiff(int arr[], int n) {
		int maxDiff;
		int i, j;

		int RMax[] = new int[n];
		int LMin[] = new int[n];

		/*
		 * Construct LMin[] such that LMin[i] stores the minimum value
		 * from (arr[0], arr[1], ... arr[i])
		 */
		LMin[0] = arr[0];
		for (i = 1; i < n; ++i)
			LMin[i] = min(arr[i], LMin[i - 1]);

		/*
		 * Construct RMax[] such that RMax[j] stores the maximum value
		 * from (arr[j], arr[j+1], ..arr[n-1])
		 */
		RMax[n - 1] = arr[n - 1];
		for (j = n - 2; j >= 0; --j)
			RMax[j] = max(arr[j], RMax[j + 1]);

		/*
		 * Traverse both arrays from left to right to find optimum j - i
		 * This process is similar to merge() of MergeSort
		 */
		i = 0;
		j = 0;
		maxDiff = -1;
		while (j < n && i < n) {
			if (LMin[i] < RMax[j]) {
				maxDiff = max(maxDiff, j - i);
				j = j + 1;
			} else
				i = i + 1;
		}

		return maxDiff;
	}

	public static int max(int x, int y) {
		return x > y ? x : y;
	}

	public static int min(int x, int y) {
		return x < y ? x : y;
	}

}
