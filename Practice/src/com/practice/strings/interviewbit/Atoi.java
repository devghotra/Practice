package com.practice.strings.interviewbit;

public class Atoi {

	public static void main(String[] args) {
		System.out.println(myAtoi("9"));
	}

	public static int myAtoi(String s) {
		
		String str = s.trim();
		if(str.isEmpty())
			return 0;

		double result = 0;
		char flag = '+';
		int i = 0;
		
		if(str.charAt(0) == '-'){
			flag = '-';
			i++;
		} else if(str.charAt(0) == '+'){
			flag = '+';
			i++;
		}

		for (;i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= '0' && c <= '9') {
				result = result * 10 + (str.charAt(i) - '0');
			} else {
				break;
			}
		}

		if (flag == '-')
			result = -result;

		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;

		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		return (int) result;

	}

}
