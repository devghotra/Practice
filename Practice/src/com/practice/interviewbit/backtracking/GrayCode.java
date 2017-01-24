package com.practice.interviewbit.backtracking;

import java.util.ArrayList;

public class GrayCode {

	public static void main(String[] args) {
		GrayCode gc = new GrayCode();
		System.out.println(gc.grayCode(2));

	}

	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> codes = new ArrayList<>();
		if (n == 0) {
			codes.add(0);
			return codes;
		}

		if (n == 1) {
			codes.add(0);
			codes.add(1);
			return codes;
		}

		ArrayList<Integer> partialCodes = grayCode(n-1);
		codes.addAll(partialCodes); // all partial codes will be final response in same order
		for (int j = partialCodes.size() - 1; j >= 0; j--) {
			int a = partialCodes.get(j);
            int aa = 1 << n-1; // shift 1 to left n-1 times, for example if n=3 this operation will create 100 shifting 1 two places to left
            codes.add(a|aa); 
            // this OR operation gives next number, if a=1(binary 001) and aa=100 result of OR on both
            /*		001
             * 		100
             * 		----
             * 		101 -> 5
             */
		}

		return codes;
	}

}
