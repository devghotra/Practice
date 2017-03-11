package com.practice.strings;

public class AddBinaryStrings {

	public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));
	}

	public static String addBinary(String a, String b) {
		
		StringBuilder sb = new StringBuilder();

		int carry = 0;
		int maxLen = Math.max(a.length(), b.length());
		
		for (int i = 1; i <= maxLen; i++) {
			int b1 = i <= a.length() && (a.charAt(a.length()-i) == '1') ? 1 : 0;
			int b2 = i <= b.length() && (b.charAt(b.length()-i) == '1') ? 1 : 0;
			
			sb.insert(0, b1 ^ b2 ^ carry);
			
			carry = carry == 1 ? (b1 | b2) & carry : b1 & b2;
		}
		
		if(carry == 1)
			sb.insert(0, 1);
		
		return sb.toString();
	}
}
