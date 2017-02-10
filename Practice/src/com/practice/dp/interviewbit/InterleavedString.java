package com.practice.dp.interviewbit;

public class InterleavedString {

	public static void main(String[] args) {
		InterleavedString obj = new InterleavedString();
		System.out.println(obj.isInterleave("AAB", "AAC", "AACAAB"));

	}
	
	public int isInterleave(String a, String b, String c){
		
		if(c.length() != a.length()+b.length())
			return 0;
		
		boolean dp[][] = new boolean[b.length()+1][a.length()+1];
		dp[0][0] = true;
		
		//dp[i, 0] base case - if b matches to c
		for(int i=1; i<=b.length(); i++){
			dp[i][0] = dp[i-1][0] && b.charAt(i-1) == c.charAt(i-1);
		}
		
		//dp[0, j] base case - if a matches to c
		for(int j=1; j<=a.length(); j++){
			dp[0][j] = dp[0][j-1] && a.charAt(j-1) == c.charAt(j-1);
		}
		
		for(int i=1; i<=b.length(); i++){
			for(int j=1; j<=a.length(); j++){
				if(dp[i-1][j])
					dp[i][j] = b.charAt(i-1) == c.charAt(i+j-1);
				else if(dp[i][j-1])
					dp[i][j] = a.charAt(j-1) == c.charAt(i+j-1);
			}
		}
		
		
		return dp[b.length()][a.length()] ? 1 : 0;
	}
	
	/* a,b - Given strings
	 * c - Check if its interleaving with a & b
	 * 
	 * 1. Create a matrix taking both Strings a,b
	 * 2. dp[0, j] base case - if a matches to c
	 * 3. dp[i, 0] base case - if b matches to c
	 * 4. dp[i, j] is true
	 * 		if dp[i-1][j] is true and b[j] matches to c[i+j] element
	 * 		or dp[i][j-1] is true and a[i] matches to c[i+j] element
	 * 
	 * 	a = "aabcc",
		b = "dbbca",

		When c = "aadbbcbcac", return true.
	 * 			_	a	a	b	c	c 
			_	F	T	T	F	F	F
			d	F	F	T	T	F	F
			b	F	F	T	T	T	F
			b	F	F	T	F	T	T
			c	F	F	T	T	T	F
			a	F	F	F	F	T	T
			
			
			When c = "aadbbbaccc", return false.
				_	a	a	b	c	c
			_	F	T	T	F	F	F
			d	F	F	T	T	F	F
			b	F	F	T	T	F	F
			b	F	F	T	T	F	F
			c	F	F	F	F	F	F
			a	F	F	F	F	F	F
	 * 
	 */

}
