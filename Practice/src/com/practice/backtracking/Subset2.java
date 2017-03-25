package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class Subset2 {

	public static void main(String[] args) {
		Subset2 ss = new Subset2();
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(1);
		nums.add(2);
		nums.add(2);
		//nums.add(3);
		//nums.add(3);
		
		System.out.println(ss.subsetsWithDup(nums));
	}
	
	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> nums) {
		Collections.sort(nums);
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		backtrack(result, new ArrayList<>(), nums, 0);
		return result;
	}

	public void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, ArrayList<Integer> nums, int start) {
		result.add(new ArrayList<>(list));
		for (int i = start; i < nums.size(); i++) {
			if(i > start && nums.get(i).equals(nums.get(i-1)) ){
				continue;
			}
			
			list.add(nums.get(i));
			backtrack(result, list, nums, i+1);
			list.remove(list.size()-1);
		}
	}

}
