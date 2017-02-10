package com.practice.dp.interviewbit;

import java.util.Arrays;
import java.util.List;

public class CoinSumInfinite {
	
	public static void main(String[] args) {
		Integer[] arr = {18, 24, 23, 10, 16, 19, 2, 9, 5, 12, 17, 3, 28, 29, 4, 13, 15, 8};
		int sum = 458;
		
		System.out.println(coinchange2(Arrays.asList(arr), sum));
	}
	
	/*
	 * coin	0	1	2	3	4	5 <- sum
		0	0	0	0	0	0	0
		1	1	1	1	1	1	1
		2	1	1	2	3	3	4
		3	1	1	2	4	4	6
		
		1. create matrix as above, rows - coin number & col - partial sum to all the way to sum
		2. populate base case when sum is 0 - there is 1 way to return change
		3. populate rest of matrix
			3.1 if value of coin is greater then partial sum then there is no new way possible, just copy the ways possible without using this coin
			3.2 else it will be addition when coin is included (hence sum reduce by coin value) & when coin is excluded (same sum without this coin)
	*/
	
	public static int coinchange2(List<Integer> a, int b) {
		return coinchangeDynamic(a, a.size(), b);
	}
	
	public static int coinchangeDynamic(List<Integer> coins, int totalNumOfCoins, int sum) {
		int mod = 1000007;
		int[][] dp = new int[coins.size() + 1][sum + 1];

		// base case - when sum is 0 there is 1 way to return change - return empty set
		for (int i = 0; i <= coins.size(); i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= coins.size(); i++) {
			for (int j = 1; j <= sum; j++) {
				if (coins.get(i - 1) > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = (dp[i][j - coins.get(i - 1)] + dp[i - 1][j]) % mod;
				}
			}
		}

		return dp[totalNumOfCoins][sum];
	}
}
