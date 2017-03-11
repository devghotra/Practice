package com.practice.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak2 {
	
	// refer WorkBreak 1 for logic

	public static void main(String[] args) {
		//String dictionaryArr[] = {"cat", "cats", "dog", "and", "wich","sand", "sandwich"};
		//String s = "catsandwichdog";
		
		String dictionaryArr[] = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		
		
		//String dictionaryArr[] = {"a","aa","aaa"};
		//String s = "aaaaaaaaaaa";
		
		
		List<String> dictionaryList = Arrays.asList(dictionaryArr);
		
		WordBreak2 wb = new WordBreak2();
		List<String> result = wb.wordBreak(s, dictionaryList);
		System.out.println(result);

	}
	
	public List<String> wordBreak(String a, List<String> b) {
	    Set<String> dictionary = new HashSet<>(b);
	    return wordBreak(a, dictionary);
	}

	public List<String> wordBreak(String s, Set<String> dictionary) {
		
		int maxWordLength = 0;
		for(String word : dictionary){
			maxWordLength = word.length() > maxWordLength ? word.length() : maxWordLength;
		}

		Map<Integer, List<String>> map = new HashMap<>();
		List<String> emptyList = new ArrayList<>();
		map.put(0, emptyList);

		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		
		for (int i = 1; i <= s.length(); i++) {
			List<String> breaksTillLengthI = new ArrayList<>();
			map.put(i, breaksTillLengthI);
			int maxLengthToCheck = (i-maxWordLength) < 0 ? 0 : i-maxWordLength;
			for (int j = i-1; j >= maxLengthToCheck; j--) {
				String ss = s.substring(j, i);
				if(dp[j] && dictionary.contains(ss)){
					dp[i] = true;
					
					List<String> breaksTillLengthJ = map.get(j);
					if(breaksTillLengthJ.isEmpty()){
						breaksTillLengthI.add(ss);
					} else{
						for(String wb : breaksTillLengthJ){
							breaksTillLengthI.add(wb+" "+ss);
						}
					}
				}
			}
		}
		
		return map.get(s.length());
	}

}
