package com.practice.interviewbit.dp;

public class UniqueBinaryTreesCount {

	public static void main(String[] args) {
		UniqueBinaryTreesCount inst = new UniqueBinaryTreesCount();
		System.out.println(inst.numTrees(5));

	}
	
	public int numTrees(int a) {
		
		int[] dp = new int[a+1];
		dp[0] = 1;
		
		for(int i=1; i<=a; i++){
			for(int j=1; j<=i; j++){
				dp[i] = dp[i] + dp[j-1]*dp[i-j];
			}
		}
		
		return dp[a];
	}

}
