package com.practice.backtracking.interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class Subset {

	public static void main(String[] args) {
		Subset ss = new Subset();
		ArrayList<Integer> nums = new ArrayList<>();
		// nums.add(6);
		System.out.println(ss.subsets(nums));

	}

	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> nums) {
		Collections.sort(nums);
		return subsets(nums, 0);
	}

	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> nums, int index) {
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
		
		if(nums.isEmpty()){
			subsets.add(nums);
			return subsets;
		}

		if (index == nums.size() - 1) {
			ArrayList<Integer> singleSubset = new ArrayList<>();
			singleSubset.add(nums.get(index));
			subsets.add(singleSubset);
		} else {
			int num = nums.get(index);
			ArrayList<Integer> singleNumSubset = new ArrayList<>();
			singleNumSubset.add(num);
			subsets.add(singleNumSubset);

			ArrayList<ArrayList<Integer>> partialSubsets = subsets(nums, index + 1);
			for (ArrayList<Integer> partialSubset : partialSubsets) {
				ArrayList<Integer> subset = new ArrayList<>(partialSubset);
				subset.add(0, num);
				subsets.add(subset);
			}
			subsets.addAll(partialSubsets);
		}

		if (index == 0) {
			ArrayList<Integer> emptySubset = new ArrayList<>();
			subsets.add(0, emptySubset);
		}

		return subsets;
	}

}
