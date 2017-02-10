
package com.practice.hashing.interviewbit;

import java.util.HashMap;
import java.util.Map;

public class WindowString {

	public static void main(String[] args) {
		WindowString ws = new WindowString();
		String S = "ADOBECODEBANC";
		String T = "ABC";
		
		String res2 = ws.minWindow(S,T);
		System.out.println(res2);
		
	}

	public String minWindow(String S, String T) {
		String minWindow = "";
		int sLen = S.length();
		int tLen = T.length();

		Map<Character, Integer> needToFind = new HashMap<>();
		Map<Character, Integer> hasFound = new HashMap<>();

		for (int i = 0; i < tLen; i++)
			needToFind.put(T.charAt(i), needToFind.get(T.charAt(i)) == null ? 1 : needToFind.get(T.charAt(i)) + 1);

		int matchedCount = 0;
		int begin = 0;
		for (int end = 0; end < sLen; end++) {
			char endChar = S.charAt(end);
			// skip characters not in T
			if (needToFind.get(endChar) == null)
				continue;

			hasFound.put(endChar, hasFound.get(endChar) == null ? 1 : hasFound.get(endChar) + 1);
			if (hasFound.get(endChar) <= needToFind.get(endChar))
				matchedCount++;

			// if window constraint is satisfied
			if (matchedCount == tLen) {
				char beginChar = S.charAt(begin);
				// advance begin index as far right as possible, stop when
				// advancing breaks window constraint.
				while (!hasFound.containsKey(beginChar) || hasFound.get(beginChar) > needToFind.get(beginChar)) {
					if(hasFound.containsKey(beginChar) && hasFound.get(beginChar) > needToFind.get(beginChar))
						hasFound.put(beginChar, hasFound.get(beginChar) - 1);
					
					begin++;
					beginChar = S.charAt(begin);
				}

				// update minWindow if a minimum length is met
				if (minWindow.isEmpty() || (end - begin) + 1 < minWindow.length()) {
					String subStringWindow = S.substring(begin, end + 1);
					if (minWindow.isEmpty() || subStringWindow.length() < minWindow.length()) {
						minWindow = subStringWindow;
					}
				}
			}
		}

		return minWindow;
	}
	
}
