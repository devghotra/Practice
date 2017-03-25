package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Collections;

//https://discuss.leetcode.com/topic/46162/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning
public class Subset {

	public static void main(String[] args) {
		Subset ss = new Subset();
		ArrayList<Integer> nums = new ArrayList<>();
		// nums.add(6);
		System.out.println(ss.subsets(nums));

	}

	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> nums) {
		Collections.sort(nums);
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		backtrack(result, new ArrayList<>(), nums, 0);
		return result;
	}

	public void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, ArrayList<Integer> nums, int start) {
		result.add(new ArrayList<>(list));
		for (int i = start; i < nums.size(); i++) {
			list.add(nums.get(i));
			backtrack(result, list, nums, i+1);
			list.remove(list.size()-1);
		}
	}

}
