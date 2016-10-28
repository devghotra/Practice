package com.practice.interview.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subset2 {

	public static void main(String[] args) {
		Subset2 ss = new Subset2();
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(1);
		nums.add(2);
		nums.add(2);
		nums.add(3);
		nums.add(3);
		//System.out.println(ss.subsets(nums).size() + " - "+ss.subsets(nums));
		
		int[] nums1 = {5,5,5};
		System.out.println(ss.subsetsWithDup(nums1));
	}
	
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		ArrayList<Integer> numsList = new ArrayList<>();
		for(int n : nums){
			numsList.add(n);
		}
		
		List<List<Integer>> finalList = new ArrayList<>();
		
		ArrayList<ArrayList<Integer>> list = subsetsWithDup(numsList);
		for(ArrayList<Integer> l : list){
			finalList.add(l);
		}
		
		return finalList;
	}

	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> nums) {
		Collections.sort(nums);
		return subsetsWithDup(nums, 0);
	}

	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> nums, int index) {
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

			boolean duplicate = false;
			if(index+1 < nums.size() && num == nums.get(index+1)){
				duplicate = true;
			}
			
			ArrayList<ArrayList<Integer>> partialSubsets = subsetsWithDup(nums, index + 1);
			
			ArrayList<Integer> singleNumSubset = new ArrayList<>();
			singleNumSubset.add(num);
			subsets.add(singleNumSubset);

			ArrayList<ArrayList<Integer>> toBeCarriedFromPrevious = new ArrayList<>();
			for (ArrayList<Integer> partialSubset : partialSubsets) {
				ArrayList<Integer> subset = new ArrayList<>(partialSubset);
				subset.add(0, num);
				subsets.add(subset);
				if(duplicate && (partialSubset.get(0) != num)){
					toBeCarriedFromPrevious.add(partialSubset);
				}
			}
			
			if(!duplicate)
				subsets.addAll(partialSubsets);
			else
				subsets.addAll(toBeCarriedFromPrevious);
		}

		if (index == 0) {
			ArrayList<Integer> emptySubset = new ArrayList<>();
			subsets.add(0, emptySubset);
		}

		return subsets;
	}

}
