package com.practice.interviewbit.dp;

import java.util.Arrays;
import java.util.List;

public class JumpGameArray {

	public static void main(String[] args) {
		JumpGameArray intsn = new JumpGameArray();
		
		Integer[] arr = {2,1,1,1,4};
		System.out.println(intsn.canJump(Arrays.asList(arr)));
	}
	
	/*
	 * Populate each level which can be reached from current level and increment number of ways
	 * At the end of each iteration check if final level has been reached
	 */
	
	public int canJump(List<Integer> a) {
		if(a == null || a.isEmpty())
			return 0;
		
		if(a.get(0) == 0){
			if(a.size() == 1)
				return 1;
			else
				return 0;
		}
		
		int[] waysToReach = new int[a.size()];
		waysToReach[0] = 1;
		
		for(int i=0; i<a.size()-1; i++){
			int maxSteps = a.get(i);
			
			// if you can't reach at this level then you can't go ahead
			if(waysToReach[i] == 0){
				break;
			}
			
			if(maxSteps == 0){
				continue;
			}
			
			int max = Integer.min(maxSteps, a.size()-1-i);
			
			for(int j=1; j<=max;j++){
				waysToReach[i+j] += 1; 
			}
			
			if(waysToReach[a.size()-1] > 0)
				return 1;
		}
		
		if(waysToReach[a.size()-1] > 0)
			return 1;
		else
			return 0;
		
	}
	

}
