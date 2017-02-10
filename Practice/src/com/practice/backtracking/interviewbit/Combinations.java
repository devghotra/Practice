package com.practice.backtracking.interviewbit;

import java.util.ArrayList;

public class Combinations {

	public static void main(String[] args) {
		Combinations c = new Combinations();
		System.out.println(c.combine(4, 5));
	}
	
	public ArrayList<ArrayList<Integer>> combine(int n, int k){
		return combine(n, k, 1);
	}

	public ArrayList<ArrayList<Integer>> combine(int n, int k, int beginFrom) {
		ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();

		for (int i = beginFrom; i <= n; i++) {
			if(k == 1){
				ArrayList<Integer> partialComb = new ArrayList<>();
				partialComb.add(i);
				combinations.add(partialComb);
			} else{
				ArrayList<ArrayList<Integer>> partialCombinations = combine(n, k-1, i+1);
				for(ArrayList<Integer> partialComb : partialCombinations){
					partialComb.add(0,i);
					combinations.add(partialComb);
				}
			}
		}

		return combinations;
	}

}
