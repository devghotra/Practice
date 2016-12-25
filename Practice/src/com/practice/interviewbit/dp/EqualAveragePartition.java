package com.practice.interviewbit.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EqualAveragePartition {

	public static void main(String[] args) {
		EqualAveragePartition inst = new EqualAveragePartition();
		Integer[] input = { 1,7,9,11,15,29 };
		// {2, 4, 6, 14, 15, 19, 24, 30, 30, 32, 32, 47};
		// {18, 29, 0, 47, 0, 41, 40, 28, 7, 1 };
		// {19, 5, 38, 22, 44, 12, 17, 35};
		// {1,7,9,11,15,29};
		long start = System.currentTimeMillis();
		System.out.println(inst.avgset(Arrays.asList(input)));
		System.out.println(System.currentTimeMillis() - start);

	}

	public ArrayList<ArrayList<Integer>> avgset(List<Integer> input) {

		int size = input.size();
		int totalSum = 0;
		for (int n : input) {
			totalSum += n;
		}

		Collections.sort(input);

		/*
		 	Boolean[][][] dp = new Boolean[size][size][totalSum + 1];
			for (int i = 1; i <= size; i++) {
			int num = input.get(i - 1);
			dp[i][1][num] = true;
				for (int j = 1; j <= i - 1; j++) {
					for (int k = 1; k <= totalSum; k++) {
						if (dp[i - 1][j][k]) {
							dp[i][j][k] = true;
							dp[i][j + 1][k + num] = true;
						}
					}
				}
			}
		 */


		Boolean[][][] dp = new Boolean[size][totalSum + 1][size];

		Set<Integer> partition1Indexes = new HashSet<>();
		for (int i = 1; i < size; i++) {
			
			if ((totalSum * i) % size != 0)
				continue;
			
			int sumOfSet1 = (totalSum * i) / size;
			if (isPossible(0, i, sumOfSet1, input, partition1Indexes, dp))
				break;
		}

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		if (!partition1Indexes.isEmpty()) {
			ArrayList<Integer> partition1 = new ArrayList<>();
			ArrayList<Integer> partition2 = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				if (partition1Indexes.contains(i))
					partition1.add(input.get(i));
				else
					partition2.add(input.get(i));
			}

			result.add(partition1);
			result.add(partition2);
		}

		return result;
	}

	private boolean isPossible(int index, int size, int sum, List<Integer> input, Set<Integer> partition1Indexes, Boolean[][][] dp) {
		
		if (size == 0)
			return sum == 0;
		
		if (sum < 0 || index >= input.size())
			return false;

		if (dp[index][sum][size] != null && dp[index][sum][size] == false)
			return false;

		for (int i = index; i < input.size(); i++) {
			int num = input.get(i);
			if (isPossible(i + 1, size - 1, sum - num, input, partition1Indexes, dp)) {
				dp[i][sum][size] = true;
				partition1Indexes.add(i);
				return true;
			} else {
				dp[i][sum][size] = false;
			}
		}

		return false;
	}
}