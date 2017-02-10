package com.practice.dp.interviewbit;

import java.util.Arrays;
import java.util.List;

public class CoinsInLine {

	public static void main(String[] args) {
		CoinsInLine inst = new CoinsInLine();
		Integer[] coinsArr = { 8, 15, 3, 7 };
		System.out.println(inst.maxcoin(Arrays.asList(coinsArr)));

	}

	/*	{ 8, 15, 3, 13, 9, 7 }
	 * 
	 * Matrix		8	15	3	13	9	7
				8	8	15	11	28	20	35
				15	-	15	15	18	28	27
				3	-	-	3	13	12	20
				13	-	-	-	13	13	20
				9	-	-	-	-	9	9
				7	-	-	-	-	-	7
										
			Sum		8	23	26	39	48	55
				
			How 35 is calculated in above example?
			- There are 2 options for player either to pick coin 7 or coin 8
			- if player picks coin 7 then out of rest of the coins other player would get total amount of 20 (dp[r][c-1])
			- if player picks coin 8 then out of rest of the coins other player would get total amount of 27 (dp[r+1][c])  
			- We need to pick a coin so that other players get minimum total amount from rest of the coins
			- so, pick the min from 2 options and subtract from total sum of coins so far => 55 - min(20, 27) => 55 - 20 = 35
			
	 */
	
	public int maxcoin(List<Integer> coins) {

		int[] sum = new int[coins.size()];
		int[][] dp = new int[coins.size()][coins.size()];

		for (int i = 0; i < dp.length; i++) {
			dp[i][i] = coins.get(i);
			sum[i] = i == 0 ? coins.get(i) : sum[i - 1] + coins.get(i);
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < dp.length - i; j++) {
				int r = j;
				int c = i + j;

				int sumOfCoinsUnderConsideration = r == 0 ? sum[c] : sum[c] - sum[r-1];
				dp[r][c] = sumOfCoinsUnderConsideration - Math.min(dp[r][c - 1], dp[r + 1][c]);
			}
		}

		return dp[0][coins.size() - 1];
	}

}
