package com.practice.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Diffk2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Diffk2 diff = new Diffk2();
		Integer[] input = { 11, 85, 100, 44, 3, 32, 96, 72, 93, 76, 67, 93, 63, 5, 10, 45, 99, 35, 13 };
		//Integer[] input = {1, 3, 2};
		System.out.println(diff.diffPossible(Arrays.asList(input), 0));

	}
	
	public int diffPossible(final List<Integer> input, int k) {
		HashSet<Integer> set = new HashSet<>();
		for (Integer i : input) {
			if (set.contains(i)) {
				return 1;
			}
			set.add(i+k);
            set.add(i-k);
		}
		return 0;
	}

	/*
	 * Given an array A of integers and another non negative integer k,
	 * find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
	 * 
	 * Solution can be traversing forward or backward
	 * f1 - f2 = k -> f1 = k + f2 -> check f1 in map and ensure its not at same index as f2 (needed in case k=0)
	 * b1 - b2 = k -> b1 = k + b2 -> check b1 in map and ensure its not at same index as b2 (needed in case k=0)
	 * 
	 * 
	 */
	public int diffPossibleV0(final List<Integer> input, int k) {

		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < input.size(); i++) {
			int j = input.size() - 1 - i;
			
			int f2 = input.get(i);
			int b2 = input.get(j);
			
			int f1 = k + f2;
			int b1 = k + b2;
			
			if ((map.containsKey(f1) && map.get(f1) != i) || (map.containsKey(b1) && map.get(b1) != j)) {
				return 1;
			} else {
				map.put(f2, i);
				map.put(b2, j);
			}
		}

		return 0;
	}

}
