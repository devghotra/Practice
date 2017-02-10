package com.practice.dp.interviewbit;

public class RegularExpression2 {

	public static void main(String[] args) {
		RegularExpression2 o = new RegularExpression2();
		
		
		System.out.println(o.isMatch("aaabc", "a*c"));
		System.out.println(o.isMatch("ay", "a*b.*y"));
		System.out.println(o.isMatch("by", "a*b.*y"));
		System.out.println(o.isMatch("bly", "a*b.*y"));
		System.out.println(o.isMatch("ablmy", "a*b.*y"));
		System.out.println(o.isMatch("devinder", ".*v.*der"));
		System.out.println(o.isMatch("abbbc","ab*c"));
		
		System.out.println(o.isMatch("ac","ab*c"));
		

	}

	public int isMatch(String input, String regex) {
		   
			boolean[][] dp = new boolean[input.length() + 1][regex.length() + 1];

			dp[0][0] = true;
			for (int j = 1; j <= regex.length(); j++) {
				char c = regex.charAt(j - 1);
				if (c == '*') {
					dp[0][j] = dp[0][j-1] || dp[0][j-2];
				}
			}

			for (int i = 1; i <= input.length(); i++) {
				char inputChar = input.charAt(i - 1);
				for (int j = 1; j <= regex.length(); j++) {
					char regexChar = regex.charAt(j - 1);
					if (inputChar == regexChar || regexChar == '.') {
						dp[i][j] = dp[i - 1][j - 1];
					} else if (regexChar == '*') {
						char prevRegexChar = regex.charAt(j - 2);
						if(prevRegexChar == inputChar || prevRegexChar == '.'){
							//dp[i][j] = 1 occurance || 0 occurance || more occurances(1+)
							dp[i][j] = dp[i][j-1] || dp[i][j-2] || dp[i-1][j];
						} else{
							dp[i][j] = dp[i][j-2];
						}
					}
				}
			}

			return dp[input.length()][regex.length()] ? 1 : 0;
		
		}

}