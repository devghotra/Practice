package com.practice.strings;

public class ZigzagString {

	public static void main(String[] args) {
		System.out.println(convert("ABCDEFGHIJKLMNOPQRS", 6));
	}

	public static String convert(String s, int n) {

		if (s.length() < n)
			return "";

		StringBuilder sb = new StringBuilder();

		int max = 10 * n;
		for (int i = 0; i < n; i++) {
			sb.append(s.charAt(i));
			int jumps = 0;
			if (i < (n - 1)) {
				jumps = 2 * (n - 1 - i);
			} else {
				jumps = 2 * i;
			}

			if (i == 0)
				max = jumps;

			int j = i + jumps;
			int c = 1;
			while (jumps != 0 && j < s.length()) {
				sb.append(s.charAt(j));
				if (j + jumps < max * c) {
					j += jumps;
				} else {
					j += (max - j) * 2;
				}
				c++;
			}
		}

		return sb.toString();
	}

	public static String convertSK(String a, int b) {
		int steps = b - 1;
		
		if (b == 1)
			return a;
		
		StringBuilder[] str = new StringBuilder[b];
		for (int i = 0; i < b; i++) {
			str[i] = new StringBuilder();
		}
		
		int direction = 1; // 1: down & -1: up
		int index = 0;
		int count = 0;

		for (int i = 0; i < a.length(); i++) {
			str[index].append(a.charAt(i));
			index = index + direction;

			count++;
			
			if (count == steps) {
				count = 0;
				direction = -direction;
			}

		}
		
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < b; i++) {
			result.append(str[i].toString());
		}

		return result.toString();
	}

}
