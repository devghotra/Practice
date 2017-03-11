package com.practice.bit;

import java.util.ArrayList;
import java.util.Arrays;

public class DifferentBitsSumPairwise {

	public static void main(String[] args) {
		Integer[] nums = { 65, 79, 94, 5, 65, 73, 15, 20, 20 };
		System.out.println(cntBits(new ArrayList<>(Arrays.asList(nums))));

	}
	
	/*
	 001
     011
     101 
     
    We are doing column wise and calculating ones and then remaining would be zeroes.
    Multiplying both will give you answer of that row.
    */

	public static int cntBits(ArrayList<Integer> nums) {

		int result = 0;
		int mod = 1000000007;

		for (int bitIdx = 0; bitIdx < 32; bitIdx++) {
			int ones = 0;
			for (int i = 0; i < nums.size(); i++) {
				int shiftToIndex = nums.get(i) >> bitIdx;
				if ((shiftToIndex & 1) == 1)
					ones++;
			}

			int zeros = nums.size() - ones;
			result += ones * zeros;
			result %= mod;
		}

		return result * 2;
	}

}
