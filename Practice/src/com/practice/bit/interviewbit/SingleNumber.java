package com.practice.bit.interviewbit;

import java.util.List;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int singleNumber(final List<Integer> nums) {

		int n = nums.get(0);
		for (int i = 1; i < nums.size(); i++) {
			n = n ^ nums.get(i);
		}
		
		return n;
	}
}
