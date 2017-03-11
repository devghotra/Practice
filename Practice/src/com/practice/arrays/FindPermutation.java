package com.practice.arrays;

import java.util.ArrayList;

public class FindPermutation {

	public static void main(String[] args) {
		System.out.println(findPerm("DIIDDDIDDID", 12));
	}
	
	public static ArrayList<Integer> findPerm(String s, int n){
		ArrayList<Integer> result = new ArrayList<>();
		
		result.add(1);
		int D = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'I'){
				result.add(i+2);
				D = 0;
			} else{
				result.add(i-D, i+2);
				D++;
			}
		}
		
		return result;
	}

}
