package com.practice.binarysearch;

public class PowerFunction {

	public static void main(String[] args) {
		// System.out.println(pow(2132,0,12));
		System.out.println(pow(-1, 1, 20));
	}

	public static int pow(int x, int y, int z) {
		int sign = x < 0 ? -1 : 1;
		
		if(x == 0)
			return 0;
		
		if(y == 0)
			return 1;
		
		if (y == 1)
			return sign*x % z;
		
		int half = pow(x, y / 2, z) % z;
		int halfMod = (half * half) % z;
		
		if (y % 2 == 0) {
			return halfMod;
		} else {
			return ((halfMod % z) * (sign*x % z)) % z;
		}
	}

}
