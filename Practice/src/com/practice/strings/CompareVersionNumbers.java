package com.practice.strings;

import java.math.BigInteger;

public class CompareVersionNumbers {

	public static void main(String[] args) {
		CompareVersionNumbers inst = new CompareVersionNumbers();
		System.out.println(inst.compareVersion("44444444444444444444444444", "4444444444444444444444444"));
	}

	public int compareVersion(String v1, String v2) {
		int i1 = 0;
		int i2 = 0;

		while (i1 < v1.length() || i2 < v2.length()) {
			String sv1 = "";
			String sv2 = "";

			for (int j1 = i1; j1 < v1.length(); j1++, i1++) {
				char c = v1.charAt(j1);
				if (c == '.') {
					i1 = ++j1;
					break;
				}
				sv1 += c;
			}

			for (int j2 = i2; j2 < v2.length(); j2++, i2++) {
				char c = v2.charAt(j2);
				if (c == '.') {
					i2 = ++j2;
					break;
				}
				sv2 += c;
			}

			int res = compare(sv1, sv2);
			if (res != 0)
				return res;
		}

		return 0;
	}

	private int compare(String sv1, String sv2) {
		if (sv1.equals(sv2))
			return 0;

		BigInteger n1 = sv1.isEmpty() ? BigInteger.ZERO : new BigInteger(sv1);
		BigInteger n2 = sv2.isEmpty() ? BigInteger.ZERO : new BigInteger(sv2);
		return n1.compareTo(n2);
	}

}
