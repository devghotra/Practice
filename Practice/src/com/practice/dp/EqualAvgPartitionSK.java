package com.practice.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EqualAvgPartitionSK {
	
	ArrayList<Integer> res = new ArrayList<>();
	ArrayList<Integer> result = new ArrayList<>();
	ArrayList<Integer> resultIndex = new ArrayList<>();
	int totalSize;
	ArrayList<Integer> original = null;
	boolean[][][] dp;

	public static void main(String[] args) {
		EqualAvgPartitionSK inst = new EqualAvgPartitionSK();
		Integer[] input = { 19, 5, 38, 22, 44, 12, 17, 35 };
		// {2, 4, 6, 14, 15, 19, 24, 30, 30, 32, 32, 47};
		// {18, 29, 0, 47, 0, 41, 40, 28, 7, 1 };
		// {19, 5, 38, 22, 44, 12, 17, 35};
		// {1,7,9,11,15,29};
		long start = System.currentTimeMillis();
		System.out.println(inst.avgset(Arrays.asList(input)));
		System.out.println(System.currentTimeMillis() - start);
	}

	public ArrayList<ArrayList<Integer>> avgset(List<Integer> A) {
		result.clear();
		resultIndex.clear();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		totalSize = A.size();
		if (A == null || A.size() == 0)
			return result;

		Collections.sort(A);

		original = new ArrayList<Integer>(A);
		int totalSum = 0;
		for (int i = 0; i < A.size(); i++)
			totalSum += A.get(i);
		// System.out.println("Total Sum : " + totalSum + " Total Size: " +
		// totalSize);

		dp = new boolean[original.size()][totalSum + 1][totalSize];
		for (int i = 0; i < original.size(); i++) {
			for (int j = 0; j < totalSum + 1; j++) {
				for (int k = 0; k < totalSize; k++)
					dp[i][j][k] = true;
			}
		}
		for (int i = 1; i < totalSize; i++) {
			System.out.println("calling isPossible1 : "+i);
			if ((totalSum * i) % totalSize != 0)
				continue;
			int sumOfSet1 = (totalSum * i) / totalSize;
			System.out.println("calling isPossible2 : "+i);
			if (isPossible(i, 0, A, sumOfSet1)) {
				ArrayList<Integer> res1 = new ArrayList<Integer>(res);
				ArrayList<Integer> res2 = new ArrayList<Integer>();
				for (int k = 0; k < A.size(); k++) {
					if (resultIndex.contains(k))
						res1.add(A.get(k));
					else
						res2.add(A.get(k));
				}
				result.add(res1);
				result.add(res2);
				return result;
			}
		}
		return result;

	}

	public boolean isPossible(int size, int index, List<Integer> originalList, int sum) {
		if (sum < 0)
			return false;
		if (size == 0) {
			//System.out.println(result);
			return sum == 0;
		}
		if (index >= totalSize) {
			// System.out.println("returning False");
			return false;
		}
		if (dp[index][sum][size] == false) {
			System.out.println("In DP returning False " + index + " " + sum + " " + size);
			return false;
		}

		for (int i = index; i < originalList.size(); i++) {
			int currentNum = originalList.get(i);
			result.add(currentNum);
			resultIndex.add(i);
			if (isPossible(size - 1, i + 1, originalList, sum - currentNum))
				return true;
			result.remove(result.size() - 1);
			resultIndex.remove(resultIndex.size() - 1);
			dp[i][sum][size] = false;
		}

		return false;
	}
}
