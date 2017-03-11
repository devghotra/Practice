package com.practice.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeat {

	public static void main(String[] args) {
		LongestSubstringWithoutRepeat inst = new LongestSubstringWithoutRepeat();
		System.out.println(inst.lengthOfLongestSubstring("abcabcbb"));

	}

	public int lengthOfLongestSubstring(String input) {
		int maxLength = 0;
		int checkLengthFromIndex = 0;

		Map<Character, Integer> map = new HashMap<>();
		char[] charArr = input.toCharArray();
		for (int i = 0; i < charArr.length; i++) {
			char c = charArr[i];
			if (map.containsKey(c) && map.get(c) >= checkLengthFromIndex) {
				int length = i - checkLengthFromIndex;
				maxLength = Math.max(maxLength, length);
				checkLengthFromIndex = map.get(c)+1;
			}

			map.put(c, i);

		}

		int lastLength = charArr.length - checkLengthFromIndex;
		return Math.max(maxLength, lastLength);
	}
}
