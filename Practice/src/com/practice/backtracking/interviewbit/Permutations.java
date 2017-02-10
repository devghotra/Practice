package com.practice.backtracking.interviewbit;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		Permutations p = new Permutations();
		int[] nums = { 1, 2, 3 };
		//System.out.println(p.permute(nums));
	}

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
		return permute(nums, 0);
	}

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums, int beginIndex) {
		ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();

		if (beginIndex == nums.size() - 1) {
			ArrayList<Integer> singleNumPermutation = new ArrayList<>();
			singleNumPermutation.add(nums.get(beginIndex));
			permutations.add(singleNumPermutation);
			return permutations;
		}

		ArrayList<ArrayList<Integer>> partialPermutations = permute(nums, beginIndex + 1);
		for (List<Integer> partialPermutation : partialPermutations) {
			// # of locations to insert is largest index + 1
			for (int j = 0; j <= partialPermutation.size(); j++) {
				ArrayList<Integer> permutation = new ArrayList<>(partialPermutation);
				permutation.add(j, nums.get(beginIndex));
				permutations.add(permutation);
			}
		}

		return permutations;
	}
}
