package com.practice.interviewbit.binarysearch;

public class PowerFunction {

	public static void main(String[] args) {
		// System.out.println(pow(2132,0,12));
		System.out.println(pow(71045970, 41535484, 64735492));
	}

	public static int pow(int x, int n, int d) {
		long pow = (long) myPow(x, n, d);
		int mod = (int) (pow % d);
		return mod < 0 ? mod + d : mod;
	}

	public static double myPow(int x, int n, int d) {
		if (n == 0)
			return 1;

		if (n == 1)
			return x % d;

		double halfPow = myPow(x, n / 2, d);

		double pow = 0;
		if ((n & 1) == 1) {
			pow = (halfPow * halfPow * x) % d;
		} else {
			pow = (halfPow * halfPow) % d;
		}

		return n < 0 ? 1 / pow : pow;
	}

}
