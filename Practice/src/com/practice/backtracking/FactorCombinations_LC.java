package com.practice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations_LC {

	public static void main(String[] args) {
		FactorCombinations_LC fc = new FactorCombinations_LC();
		List<List<Integer>> result = fc.getFactors(16);
		for(List<Integer> r : result){
			System.out.println(r);
		}
	}

	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<>();
		helper(result, new ArrayList<>(), n, 2);
		return result;
	}
	
	public void helper(List<List<Integer>> result, List<Integer> combination, int n, int start){
	    if (n <= 1) {
	    	// to avoid combination that just contains the number itself
	        if (combination.size() > 1) {
	        	result.add(new ArrayList<Integer>(combination));
	        }
	        return;
	    }
	    
	    for (int i = start; i <= n; i++) {
	        if (n % i == 0) {
	        	combination.add(i);							// add the number i
	            helper(result, combination, n/i, i);
	            combination.remove(combination.size()-1);	// remove number i
	        }
	    }
}
	
}
