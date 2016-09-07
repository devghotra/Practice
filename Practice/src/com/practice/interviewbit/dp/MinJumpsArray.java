package com.practice.interviewbit.dp;

import java.util.Arrays;
import java.util.List;

public class MinJumpsArray {

	public static void main(String[] args) {
		MinJumpsArray intsn = new MinJumpsArray();
		
		Integer[] arr = {9, 0, 0, 22, 0, 0, 39, 11, 3, 0, 0, 24, 1, 0, 50, 23, 3, 44, 0, 23, 2, 8, 20, 35, 0, 40, 34, 26, 36, 0, 
				35, 19, 20, 18, 11, 43, 19, 21, 40, 0, 14, 0, 14, 0, 0, 25, 35, 24, 49, 15, 13, 3, 0, 10, 31, 25, 27, 37, 27, 43, 
				44, 27, 8, 43, 0, 0, 33, 25, 19, 47, 0, 29, 5, 2, 12, 8, 7, 0, 16, 36, 0, 6, 17, 35, 36, 21, 0, 9, 1, 0, 43, 29, 39, 
				15, 18, 0, 34, 26, 48, 0, 34, 35, 7, 10, 0, 0, 15, 5, 12, 26, 0, 37, 30, 33, 27, 34, 9, 37, 22, 0, 0, 24, 30, 0, 0, 38,
				23, 25, 0, 30, 39, 24, 31, 0, 6, 19, 25, 0, 28, 15, 8, 0, 48, 0, 35, 41, 0, 24, 1, 41, 31, 0, 35, 21, 15, 26, 15, 27, 4,
				0, 8, 4, 0, 0, 2, 42, 18, 0, 28, 18, 49, 34, 5, 10, 41, 48, 26, 14, 45, 44, 9, 0, 49, 50, 24, 0, 0, 0, 23, 0, 17, 0, 47, 
				31, 0, 42, 0, 0, 0, 40, 46, 22, 50, 32, 20, 3, 44, 22, 0, 37, 25, 0, 19, 26, 14, 23, 27, 41, 0, 1, 13, 0, 48, 20, 37, 8, 
				0, 18, 0, 26, 12, 19, 32, 19, 22, 0, 0, 0, 0, 0, 16, 0, 0, 43, 0, 10, 5, 0, 6, 26, 0, 24, 40, 29, 0, 43, 18, 27, 0, 0, 37,
				0, 46, 35, 17, 0, 20, 44, 29, 29, 40, 33, 22, 27, 0, 0, 38, 21, 4, 0, 0, 15, 31, 48, 36, 10, 0, 41, 0, 45, 39, 0, 11, 9, 3, 
				38, 16, 0, 11, 22, 37, 0, 3, 44, 10, 12, 47, 22, 32, 7, 24, 1, 0, 22, 25, 0, 14, 0, 0, 0, 23, 0, 36, 1, 42, 46, 0, 48, 0, 33, 
				5, 27, 45, 0, 15, 29, 0, 50, 2, 31, 25, 6, 36, 19, 10, 23, 0, 37, 4, 1, 7, 12, 0, 0, 49 };
		System.out.println(intsn.jumpDynamic(Arrays.asList(arr)));
		System.out.println(intsn.jumpGreedy(Arrays.asList(arr)));
	}
	
	/*
	 * Populate each level which can be reached from current level and increment number of ways
	 * Also find min steps needed to reach to all those levels
	 * At the end of each iteration min steps for final level is found
	 * 
	 * Solution failed in time complexity
	 */
	
	public int jumpDynamic(List<Integer> a) {
		if(a == null || a.isEmpty())
			return -1;
		
		if(a.get(0) == 0){
			if(a.size() == 1)
				return 0;
			else
				return -1;
		}
		
		int[] waysToReach = new int[a.size()];
		int[] minJumps = new int[a.size()];
		waysToReach[0] = 1;
		minJumps[0]=0;
		
		for(int i=0; i<a.size()-1; i++){
			int maxSteps = a.get(i);
			
			if(waysToReach[i] == 0){
				break;
			}
			
			if(maxSteps == 0){
				continue;
			}
			
			int max = Integer.min(maxSteps, a.size()-1-i);
			
			for(int j=1; j<=max;j++){
				if(minJumps[i+j] == 0){
					minJumps[i+j] = minJumps[i]+1; 
				}
				waysToReach[i+j] += 1; 
				
				if(minJumps[a.size()-1] > 0){
					return minJumps[a.size()-1]; 
				}
			}
				
		}
		
		return -1;
		
	}

	
	public int jumpGreedy(List<Integer> a) {
		if(a == null || a.isEmpty())
			return -1;
		
		if(a.get(0) == 0){
			if(a.size() == 1)
				return 0;
			else
				return -1;
		}
		
		int[] minJumps = new int[a.size()];
		minJumps[0]=0;
		
		for(int i=0; i<a.size()-1; i++){
			System.out.println(a.size() + " iter - "+i);
			if(i != 0 && minJumps[i] == 0){
				continue;
			}
			
			int maxSteps = a.get(i);
			if(maxSteps == 0){
				continue;
			} else{
				minJumps[i+1] += 1;
			}
			
			int max = Integer.min(maxSteps, a.size()-1-i);
			
			minJumps[i+max] = minJumps[i] + 1;
			
			if(minJumps[a.size()-1] > 0){
				return minJumps[a.size()-1];
			}
		}
		
		return -1;
		
	}
}
