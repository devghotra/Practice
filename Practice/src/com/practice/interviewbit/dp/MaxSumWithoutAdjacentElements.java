package com.practice.interviewbit.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumWithoutAdjacentElements {

	public static void main(String[] args) {
		MaxSumWithoutAdjacentElements inst = new MaxSumWithoutAdjacentElements();
		
		Integer[] arr1 = {16, 5, 54, 55, 36, 82, 61, 77, 66, 61};
		Integer[] arr2 = {31, 30, 36, 70, 9, 37, 1, 11, 68, 14};
		
		ArrayList<List<Integer>> a = new ArrayList<>();
		a.add(Arrays.asList(arr1));
		a.add(Arrays.asList(arr2));
		
		System.out.println(inst.adjacent(a));
		
		//Integer[] arr = {16, 5, 54, 55, 36, 82, 61, 77, 66, 61};
		//System.out.println(inst.maxSum(Arrays.asList(arr)));
		

	}
	
	public int maxSum(List<Integer> a) {
		if(a == null || a.isEmpty())
			return 0;
		
		int maxSumArr[] = new int[a.size()+1];
		maxSumArr[1] = a.get(0); 
		int maxSum = maxSumArr[1];
		
		for(int i=2; i<=a.size(); i++){
			int num = a.get(i-1);
			if(i==2){
				maxSumArr[i] = num;
			} else{
				int s1 = maxSumArr[i-2] + num;
				int s2 = (i-3 > 0) ? maxSumArr[i-3] + num : 0;
				
				maxSumArr[i] = Integer.max(s1,s2);
			}
			
			if(maxSumArr[i] > maxSum)
				maxSum = maxSumArr[i];
		}
		
		return maxSumArr[a.size()];
	}
	
	public int adjacent(ArrayList<List<Integer>> a) {
		
		if(a == null || a.isEmpty())
			return 0;
		
		List<Integer> a1 = a.get(0);
		List<Integer> a2 = a.get(1);
		
		int size = a1.size();
		
		int maxSumArr[] = new int[size+1];
		maxSumArr[1] = a1.get(0) > a2.get(0) ? a1.get(0) : a2.get(0);
		
		int maxSum = maxSumArr[1];
		
		if(size > 1){
			maxSumArr[2] = a1.get(1) > a2.get(1) ? a1.get(1) : a2.get(1);
			if(maxSumArr[2] > maxSum)
				maxSum = maxSumArr[2];
		}
		
		for(int i=3; i<=size; i++){
			int num = Integer.max(a1.get(i-1), a2.get(i-1));
			int s1 = maxSumArr[i-2] + num;
			int s2 = maxSumArr[i-3] + num;
			
			maxSumArr[i] = Integer.max(s1,s2);
			
			if(maxSumArr[i] > maxSum)
				maxSum = maxSumArr[i];
		}
		
		return maxSum;
	}
	
}
