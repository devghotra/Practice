package com.practice.interviewbit.backtracking;

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
		return combinationSum(candidates, target, 0);
	}
	
	public ArrayList<ArrayList<Integer>> combinationSum(List<Integer> candidates, int target, int beginIndex) {
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
				ArrayList<ArrayList<Integer>> partialCombinations = combinationSum(candidates, target-num, i+1);
				
				for(ArrayList<Integer> partialComb : partialCombinations){
					partialComb.add(0,num);
					combinations.add(partialComb);
				}
			}
			
			
		}
		
		return combinations;
	}

}
