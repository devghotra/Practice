package com.practice.bit;

public class NumberOf1Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numSetBits(long a) {
		int result = 0;

		while (a > 0) {
			if ((a & 1) > 0) {
				result++;
			}

			a = a >> 1;
		}

		return result;
	}

}
