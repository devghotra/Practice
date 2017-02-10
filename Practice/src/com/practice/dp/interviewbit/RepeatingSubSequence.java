package com.practice.dp.interviewbit;

public class RepeatingSubSequence {

	public static void main(String[] args) {
		RepeatingSubSequence rss = new RepeatingSubSequence();
		System.out.println(rss.anytwo("ATGCATGCA"));

	}
	
	/*
	 * 1. Find LCS(String, String) with restriction of not to consider chars at same index position - http://www.geeksforgeeks.org/longest-repeating-subsequence/
	 * 2. Create a matrix of size of string
	 * 3. start element next to diagonal position, at and before diagonal subsequence max repeating subsequence length would be 0
	 * 4. if chars matches then length of max repeating subsequence would increment by 1
	 * 5. else copy the diagonal value
	 * 
	 * 
	 *		ATGCATGCA
	 *
	 * 			A	T	G	C	A	T	G	C	A
			A	0	0	0	0	1	1	1	1	1
			T		0	0	0	0	2	2	2	2
			G			0	0	0	0	3	3	3
			C				0	0	0	0	4	4
			A					0	0	0	0	5
			T						0	0	0	0
			G							0	0	0
			C								0	0
			A									0
	 * 
	 * 
	 */
	
	public int anytwo(String s){
		int[][] dp = new int[s.length()+1][s.length()+1];
		
		int max = 0;
		for(int i=1;i<=s.length();i++){
			char s1 = s.charAt(i-1);
			for(int j=i+1;j<=s.length();j++){
				char s2 = s.charAt(j-1);
				if(s1==s2){
					dp[i][j] = dp[i-1][j-1] + 1;
				} else{
					dp[i][j] = Integer.max(dp[i-1][j-1], dp[i][j-1]);
				}
				
				if(dp[i][j] > max)
					max = dp[i][j];
			}
		}
		
		return max >= 2 ? 1 : 0;
	}

}
