package com.practice.dp;

public class DistinctSubsequence {
	
	public static void main(String[] args){
		DistinctSubsequence ds = new DistinctSubsequence();
		System.out.println(ds.numDistinct("ABCDE", "AEC"));
	}
	
	/*
	 * 1. Create a matrix of TxS
	 * 2. Base case is when i=0 then dp[0][j] = 1; i.e empty string has 1 distinct sequence in any given string
	 * 3. if chars doesn't match just copy the diagonal value
	 * 4. else value would be diagonal val + previous val
	 * diagonal val - number of distinct subsequences without considering Ith and Jth element 
	 * previous val - subsequences already made including Ith element but not the Jth element
	 * 
	 * RABBBIT -> RABBIT
	 * 
	 * 		_	R	A	B	B	B	I	T
		_	1	1	1	1	1	1	1	1
		R	0	1	1	1	1	1	1	1
		A	0	0	1	1	1	1	1	1
		B	0	0	0	1	2	3	3	3
		B	0	0	0	0	1	3	3	3
		I	0	0	0	0	0	0	3	3
		T	0	0	0	0	0	0	0	3
	 * 
	 */
	
	public int numDistinct(String S, String T){
		
		int dp[][] = new int[T.length()+1][S.length()+1];
		
		for(int j=0;j<=S.length();j++){
			dp[0][j] = 1;
		}
		
		for(int i=1;i<=T.length();i++){
			char t = T.charAt(i-1);
			for(int j=1;j<=S.length();j++){
				char s = S.charAt(j-1);
				
				if(t==s){
					dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
				} else{
					dp[i][j] = dp[i][j-1];
				}
			}
		}
		
		return dp[T.length()][S.length()];
	}

}
