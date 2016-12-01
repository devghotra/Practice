package com.practice.interviewbit.strings;

public class CheckIfSubstring {

	public static void main(String[] args) {
		CheckIfSubstring inst = new CheckIfSubstring();
		System.out.println(inst.strStr("ississippi", "issip"));

	}

	public int strStr(String haystack, String needle) {

		if (needle.isEmpty())
			return 0;

		int j = 0;
		for (int i = 0; i < haystack.length(); i++) {
			char h = haystack.charAt(i);
			char n = needle.charAt(j);

			if (h == n) {
				j++;
				if (j == needle.length()) {
					return i - (j - 1);
				}
			} else {
				// take back i to one position ahead of last start position
				// this will take i to last start position, for loop increment will take it one position ahead of it
				i = i-j;
				j = 0;
			}
		}

		return -1;
	}

}
