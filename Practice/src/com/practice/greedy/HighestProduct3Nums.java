package com.practice.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HighestProduct3Nums {

	public static void main(String[] args) {
		Integer[] nums = {0, -1, 3, 100, 70, 50};
		System.out.println(maxp3(new ArrayList<>(Arrays.asList(nums))));

	}
	
	public static int maxp3(ArrayList<Integer> nums){
		if(nums == null || nums.size() < 3)
			return 0;
		
		Collections.sort(nums);
		
		int p1 = nums.get(nums.size() - 3) * nums.get(nums.size() - 2) * nums.get(nums.size() - 1);
		int p2 = nums.get(0) * nums.get(1) * nums.get(nums.size() - 1);
		
		return Math.max(p1, p2);
	}

}
