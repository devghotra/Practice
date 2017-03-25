package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum2 {

	public static void main(String[] args) {
		CombinationSum2 cs2 = new CombinationSum2();
		int[] candidates = {8, 10, 6, 11, 1, 16, 8};
		System.out.println(cs2.combinationSum2(candidates, 28));

	}

	public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
		ArrayList<Integer> candidateList = new ArrayList<>();
		for(int num : candidates){
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
				backtrack(result, list, candidates, current, target, i+1);
				current -= candidates.get(i);
				list.remove(list.size() - 1);
			}
		}
	}

}
