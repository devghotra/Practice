package com.practice.dp;

public class StairsClimb {
	
	public static void main(String[] args) {
		StairsClimb inst = new StairsClimb();
		System.out.println(inst.climbStairs(10));
	}
	/*
	 * ways[n] = ways[n-1] + ways[n-2]
	 */
	public int climbStairs(int a){
		if(a<1){
			return 0;
		}

		int[] dp = new int[a+1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i=2; i<=a; i++){
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[a];
	}

}
