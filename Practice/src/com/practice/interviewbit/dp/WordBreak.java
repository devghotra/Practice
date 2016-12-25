package com.practice.interviewbit.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		String dictionaryArr[] = {"i", "il", "tke", "sam"};
		List<String> dictionaryList = Arrays.asList(dictionaryArr);
		
		WordBreak wb = new WordBreak();
		System.out.println(wb.wordBreak("iiltkesam", dictionaryList));
	}
	
	public int wordBreak(String a, List<String> b) {
	    Set<String> dictionary = new HashSet<>(b);
	    return wordBreak(a, dictionary) ? 1 : 0;
	}
	
	public boolean wordBreak(String s, Set<String> dictionary) {

		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		
		// i denote length of string, dp[i] = true implies string of length i (from beginning) is valid
		for (int i = 1; i <= s.length(); i++) {
			for (int j = i-1; j >= 0; j--) {
				// start from end and check if string till length j is valid && substring from j+1 length to i is valid 
				/* example 
			 		to find dp[5] check (all numbers in terms of length, not index)  
							- or 1-4 is valid and 5 contains in dictionary  
							- or 1-3 is valid and 4-5 contains in dictionary
							- or 1-2 is valid and 3-5 contains in dictionary
							- or 1 is valid and 2-5 contains in dictionary
							- or if 1-5 contains in dictionary
							
							break on first true condition and set dp[5] = true
							
				*/
				if(dp[j] && dictionary.contains(s.substring(j, i))){
					dp[i] = true;
					break;
				}
			}
		}

		return dp[s.length()];
	}

}