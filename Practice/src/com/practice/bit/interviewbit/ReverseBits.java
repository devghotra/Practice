package com.practice.bit.interviewbit;

public class ReverseBits {

	public static void main(String[] args) {
		System.out.println(reverseBits(3));
	}

	public static long reverseBits(long n) {
		long res = 0;

		for (int i = 31; i >= 0; i--) {
			long lastBit = n & 1;
			if (lastBit == 1)
				res = res | (lastBit << i);
			n = n >> 1;
		}

		return res;
	}

}
