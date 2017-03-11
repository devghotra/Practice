package com.practice.strings;

// https://discuss.leetcode.com/topic/9490/clear-java-solution-with-ifs
public class ValidNumber {

	public static void main(String[] args) {
		System.out.println(isNumber("-1."));
	}

	public static boolean isNumber(String s) {

		s = s.trim();
		boolean numSeen = false;
		boolean pointSeen = false;
		boolean numAfterESeen = true;
		boolean eSeen = false;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c >= '0' && c <= '9') {
				numSeen = true;
				numAfterESeen = true;
			} else if (c == '.') {
				if (pointSeen || eSeen) {
					return false;
				}
				pointSeen = true;
			} else if (c == 'e') {
				if (eSeen || !numSeen) {
					return false;
				}
				eSeen = true;
				numAfterESeen = false;
			} else if (c == '+' || c == '-') {
				if(i != 0 && s.charAt(i - 1) != 'e')
					return false;
			} else {
				return false;
			}
		}

		return numSeen && numAfterESeen;
	}

}
