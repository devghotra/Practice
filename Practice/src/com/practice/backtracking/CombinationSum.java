package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationSum {

	public static void main(String[] args) {
		CombinationSum cs2 = new CombinationSum();
		int[] candidates = { 2, 3, 6, 7 };
		System.out.println(cs2.combinationSum(candidates, 7));

	}

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<Integer> candidateList = new ArrayList<>();
		for (int num : candidates) {
			candidateList.add(num);
		}
		return combinationSum(candidateList, target);
	}

	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> candidates, int target) {
		Collections.sort(candidates);
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		backtrack(result, new ArrayList<>(), candidates, 0, target, 0);
		return result;
	}

	public void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, ArrayList<Integer> candidates, int current, int target, int start) {
		if (current == target) {
			result.add(new ArrayList<>(list));
			return;
		}

		for (int i = start; i < candidates.size(); i++) {
			if (i > start && candidates.get(i) == candidates.get(i - 1))
				continue;

			if (current + candidates.get(i) <= target) {
				current += candidates.get(i);
				list.add(candidates.get(i));
				backtrack(result, list, candidates, current, target, i);
				current -= candidates.get(i);
				list.remove(list.size() - 1);
			}
		}
	}

}
