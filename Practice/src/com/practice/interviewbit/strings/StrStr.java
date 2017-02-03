package com.practice.interviewbit.strings;

import java.util.HashMap;

public class StrStr {

	// 2 approaches, also check CheckIfSubstring.
	// this is SK approach that works in O(n)

	public static void main(String[] args) {
		System.out.println(strStr("bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba", "babaaa"));
		// System.out.println(strStr("ississippi", "issip"));
	}

	public static int strStr(final String haystack, final String needle) {
		if (needle.length() > haystack.length()) {
			return -1;
		}
		if (needle.isEmpty()) {
			return 0;
		}
		HashMap<Character, Integer> target = new HashMap<>();
		HashMap<Character, Integer> current = new HashMap<>();

		for (int i = 0; i < needle.length(); i++) {
			char c = needle.charAt(i);
			if (target.containsKey(c)) {
				target.put(c, target.get(c) + 1);
			} else {
				target.put(c, 1);
			}
		}

		for (int i = 0; i < needle.length(); i++) {
			char c = haystack.charAt(i);
			if (current.containsKey(c)) {
				current.put(c, current.get(c) + 1);
			} else {
				current.put(c, 1);
			}
		}
		if (checkCurrent(current, target)) {
			if (needle.equals(haystack.substring(0, needle.length())))
				return 0;
		}
		int j = 0;
		for (j = needle.length(); j < haystack.length(); j++) {

			if (checkCurrent(current, target)) {
				if (needle.equals(haystack.substring(j - needle.length(), j)))
					return j - needle.length();
			}
			int a = current.get(haystack.charAt(j - needle.length()));
			current.put(haystack.charAt(j - needle.length()), a - 1);
			current.put(haystack.charAt(j), current.get(haystack.charAt(j)) != null ? current.get(haystack.charAt(j)) + 1 : 1);
		}
		return -1;
	}

	private static boolean checkCurrent(HashMap<Character, Integer> current, HashMap<Character, Integer> target) {
		for (Character c : target.keySet()) {
			if (current.get(c) != target.get(c))
				return false;
		}
		return true;
	}
}
