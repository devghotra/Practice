package com.practice.strings;

public class ReverseString {

	public static void main(String[] args) {
		ReverseString rs = new ReverseString();
		System.out.println(rs.reverseWords("hello"));
	}

	public String reverseWords(String s) {
		char EMPTY = ' ';
		StringBuilder reverse = new StringBuilder();

		char lastChar = EMPTY;
		StringBuilder word = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (c == EMPTY) {
				if (lastChar != EMPTY) {
					reverse.append(word);
					word = new StringBuilder();
				}
			} else {
				if (reverse.length() != 0 && word.length() == 0)
					reverse.append(EMPTY);

				word.insert(0, c);
			}
			lastChar = c;
		}

		reverse.append(word);

		return reverse.toString();
	}
}
