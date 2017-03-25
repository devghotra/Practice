package com.practice.backtracking;

import java.util.ArrayList;

public class Permutations {

	public static void main(String[] args) {
		Permutations p = new Permutations();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(p.permute(list));
	}

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
		ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();
		backtrack(permutations, new ArrayList<>(), nums);
		return permutations;
	}

	public void backtrack(ArrayList<ArrayList<Integer>> permutations, ArrayList<Integer> list, ArrayList<Integer> nums) {
		if (list.size() == nums.size()) {
			permutations.add(new ArrayList<>(list));
			return;
		}

		for (int i = 0; i < nums.size(); i++) {
			if (list.contains(nums.get(i)))
				continue;

			list.add(nums.get(i));
			backtrack(permutations, list, nums);
			list.remove(list.size() - 1);
		}

	}

}
