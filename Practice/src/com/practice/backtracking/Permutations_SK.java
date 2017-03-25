package com.practice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations_SK {
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		permute(result, nums, 0, new ArrayList<>());
		System.out.println(result);
		return result;

	}

	/*
	 * 1234
	 * 1243
	 * 1324
	 * 1342
	 * 1423
	 * 1432
	 * 2134
	 *
	 *
	 *
	 *
	 *
	 * 3124
	 *
	 *
	 *
	 *
	 *
	 */
	private void permute(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> nums, int j, List<Integer> soFar) {
		if (soFar.size() == nums.size()) {
			ArrayList<Integer> copy = new ArrayList<>(soFar);
			result.add(copy);
			return;
		}
		for (int i = j; i < nums.size(); i++) {
			soFar.add(nums.get(i));
			swap(i, j, nums);
			permute(result, nums, j + 1, soFar);
			soFar.remove(soFar.size() - 1);
			// unswap it to retain the order
			swap(j, i, nums);
		}

	}

	private void swap(int i, int j, ArrayList<Integer> nums) {
		// TODO Auto-generated method stub
		int temp = nums.get(i);
		nums.set(i, nums.get(j));
		nums.set(j, temp);

	}

}
