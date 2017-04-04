package com.practice.backtracking;

import java.util.HashMap;
import java.util.Map;

public class WordPattern2_LC {

	static Map<Character, String> patternToStrMap = new HashMap<>();
	static Map<String, Character> strToPatternMap = new HashMap<>();

	public static void main(String[] args) {
		System.out.println(wordPatternMatch("ab", "aa"));
	}

	public static boolean wordPatternMatch(String pattern, String str) {
		return wordPatternMatch(pattern, 0, str, 0);
	}

	public static boolean wordPatternMatch(String pattern, int pIndex, String str, int strIndex) {

		if (pIndex == pattern.length() && strIndex == str.length())
			return true;

		if (pIndex == pattern.length() || strIndex == str.length())
			return false;

		Character p = pattern.charAt(pIndex);

		for (int j = strIndex; j < str.length(); j++) {
			// if its repeating pattern cut a string of previous match length and compare with previous match
			// if matched call recursively with next pattern and string starting after current matched word else return false
			if (patternToStrMap.containsKey(p)) {
				String prevMatch = patternToStrMap.get(p);
				String match = strIndex + prevMatch.length() <= str.length() ? str.substring(strIndex, strIndex + prevMatch.length()) : "";
				return match.equals(prevMatch) ? wordPatternMatch(pattern, pIndex + 1, str, j + prevMatch.length()) : false;
			} else {
				String match = str.substring(strIndex, j + 1);

				// current pattern (p) do not have any string match (match) - since we are in else block
				// but if this potential match already has a pattern then we cannot use this as potential match, 
				// so just continue to try another potential match
				if (strToPatternMap.containsKey(match))
					continue;

				patternToStrMap.put(p, match);
				strToPatternMap.put(match, p);

				if (!wordPatternMatch(pattern, pIndex + 1, str, j + 1)) {
					patternToStrMap.remove(p);
					strToPatternMap.remove(match);
				} else {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean wordPatternMatch_withoutPointers(String pattern, String str) {

		if (pattern.isEmpty() && str.isEmpty())
			return true;

		if (pattern.isEmpty() || str.isEmpty())
			return false;

		Character p = pattern.charAt(0);

		for (int j = 1; j <= str.length(); j++) {
			if (patternToStrMap.containsKey(p)) {
				String prevMatch = patternToStrMap.get(p);
				String match = prevMatch.length() > str.length() ? "" : str.substring(0, prevMatch.length());
				if (match.equals(prevMatch)) {
					return wordPatternMatch(pattern.substring(1), str.substring(j + prevMatch.length() - 1));
				} else {
					return false;
				}
			} else {
				String match = str.substring(0, j);

				if (strToPatternMap.containsKey(match))
					continue;

				patternToStrMap.put(p, match);
				strToPatternMap.put(match, p);

				if (!wordPatternMatch(pattern.substring(1), str.substring(j))) {
					patternToStrMap.remove(p);
					strToPatternMap.remove(match);
				} else {
					return true;
				}
			}
		}

		return false;
	}

}
