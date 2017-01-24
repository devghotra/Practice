package com.practice.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationSum {

	public static void main(String[] args) {
		CombinationSum cs2 = new CombinationSum();
		int[] candidates = {2,4};
		System.out.println(cs2.combinationSum(candidates, 8));

	}

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<Integer> candidateList = new ArrayList<>();
		for(int num : candidates){
			candidateList.add(num);
		}
		return combinationSum(candidateList, target);
	}
	
	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> candidates, int target) {
		Collections.sort(candidates);
		return combinationSum(candidates, target, 0);
	}
	
	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> candidates, int target, int beginIndex) {
		ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
		
		for(int i=beginIndex; i<candidates.size(); i++){
			int num = candidates.get(i);
			
			// this check is to avoid duplicate combinations, if num is already processed in previous iteration for this begin index then just continue
			// first condition will only be true after 1st iteration of current for loop, on first iteration we don't need to check duplicate
			if(i-1 >= beginIndex && num == candidates.get(i-1))
				continue;
			
			if(num > target)
				continue;
			
			if(num == target){
				ArrayList<Integer> singleDigitCombination = new ArrayList<>();
				singleDigitCombination.add(num);
				combinations.add(singleDigitCombination);
			} else{
				// if same num can be repeated unlimited times then keep trying with same num (without incrementing index i)
				ArrayList<ArrayList<Integer>> partialCombinations = combinationSum(candidates, target-num, i);
				
				for(ArrayList<Integer> partialComb : partialCombinations){
					partialComb.add(0,num);
					combinations.add(partialComb);
				}
			}
			
			
		}
		
		return combinations;
	}

}
