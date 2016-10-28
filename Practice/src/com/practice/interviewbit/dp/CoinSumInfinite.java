package com.practice.interviewbit.dp;

import java.util.Arrays;
import java.util.List;

public class CoinSumInfinite {
	
	static Integer[][] store;

	public static void main(String[] args) {
		Integer[] arr = {18, 24, 23, 10, 16, 19, 2, 9, 5, 12, 17, 3, 28, 29, 4, 13, 15, 8};
		int sum = 458;
		
		//Integer[] arr = {4,6};
		//int sum = 24;
		
		System.out.println(coinchange2(Arrays.asList(arr), sum));
	}
	
	public static int coinchange2(List<Integer> a, int b) {
		
		int recAns = coinchangeRecursively(a, a.size(), b);
		System.out.println("REC - "+recAns);
		
		int dpAns =  coinchangeDynamic(a, a.size(), b);
		System.out.println("DP - "+dpAns);
		
		return 0;
	}
	
	public static int coinchangeDynamic(List<Integer> coins, int totalNumOfCoins, int sum) {
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
		int[][] memo = new int[coins.size()+1][sum+1];
		
		// base case - when sum is 0 there is 1 way to return change
		for(int i=0; i<=coins.size(); i++){
			memo[i][0] = 1;
		}
		
		for(int coinNum=1; coinNum<=coins.size(); coinNum++){
			for(int partialSum=1; partialSum<=sum; partialSum++){
				if(coins.get(coinNum-1) > partialSum){
					memo[coinNum][partialSum] = memo[coinNum-1][partialSum];
				} else{
					memo[coinNum][partialSum] = memo[coinNum][partialSum-coins.get(coinNum-1)] + memo[coinNum-1][partialSum];
				}
			}
		}
		
		return memo[totalNumOfCoins][sum];
	}
	
	
	public static int coinchangeRecursively(List<Integer> coins, int coinNum, int sum) {
		
		/*
		 * doesn't work - keeps running
		 */
		
		//System.out.println("iter "+iter+" Sum "+sum+" Coin "+coinNum);
		
		if(store == null){
			store = new Integer[coins.size()+1][sum+1];
		}
		
		if(sum < 0)
			return 0;
		
		if(sum == 0){
			return 1;
		}
		
		if(coinNum == 0 && sum > 0)
			return 0;
		
		int s1 = 0;
		if(sum-coins.get(coinNum-1) < 0){
			s1 = 0;
		} else if(store[coinNum][sum-coins.get(coinNum-1)] == null){
			s1 = coinchangeRecursively(coins, coinNum, sum-coins.get(coinNum-1));
			store[coinNum][sum-coins.get(coinNum-1)] = s1;
		} else{
			s1 = store[coinNum][sum-coins.get(coinNum-1)];
		}
			
		int s2 = 0;
		if(sum < 0){
			s2 = 0;
		} else if(store[coinNum-1][sum] == null){
			s2 = coinchangeRecursively(coins, coinNum-1, sum);
			store[coinNum-1][sum] = s2;
		} else{
			s2 = store[coinNum-1][sum];
		}
		
		store[coinNum][sum] = s1+s2;
				
		return store[coinNum][sum];
		
		// add the ways : when coin is already included in sum + when coin is not included in sum
		//return coinchangeRecursively(coins, coinNum, sum-coins.get(coinNum-1)) + coinchangeRecursively(coins, coinNum-1, sum);
	}

	public static int coinchangeWithDups(List<Integer> a, int b) {
		/*
		 * wrong solution
		 */
		int[] combinations = new int[b+1];
		combinations[0] = 0;
		
		for(int i=1;i<=b;i++){
			for(int j=0;j<a.size();j++){
				int coin = a.get(j);
				
				if(coin == i){
					combinations[i] = combinations[i] + 1;
				}
				else if(coin < i){
					for(int k=i-1;k>=0;k--){
						if(k+coin==i){
							int prev = combinations[k] > 0 ? combinations[k] : 1;
							combinations[i] = combinations[i] + prev;
							break;
						}
					}
				}
			}
		}
		
		return combinations[b];
	}
}
