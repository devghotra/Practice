package com.practice.interviewbit.dp;

import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubSequence {

	public static void main(String[] args) {
		LongestIncreasingSubSequence inst = new LongestIncreasingSubSequence();
		
		//Integer[] arr = {2,2,2,2};
		//Integer[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		Integer[] arr = {14, 24, 18, 46, 55, 53, 82, 18, 101, 20, 78, 35, 68, 9, 16, 93, 101, 85, 81, 28, 78};
		
		Integer[] arr1 = {30, 92, 22, 48, 52, 64, 92, 50, 85, 38, 97, 15, 14, 75, 59, 46, 74, 6, 95, 67, 86, 88,
						25, 49, 67, 69, 50, 99, 83, 49, 60, 6, 90, 1, 50, 41, 57, 18, 36, 5, 44, 100, 23, 33, 52, 
						11, 46, 49, 34, 27, 77, 57, 93, 82, 38, 95, 6, 51, 100, 32, 11, 26, 50, 3, 55, 39, 84, 54, 
						44, 75, 76, 51, 21, 40, 28, 50, 30, 6, 84, 58, 76, 42, 35, 49, 98, 49, 13, 101, 3, 1, 60, 48, 99, 70 };
						
		System.out.println(inst.lis(Arrays.asList(arr)));
	}
	
	public int lis(List<Integer> a){
		
		int max = 0;
		int[] dp = new int[a.size()+1];
		
		for(int i=1;i<=a.size();i++){
			int num = a.get(i-1);
			int longestYet = 0;
			// go all the way back and find longest subsequence for a number smaller than this number
			for(int j=i-1;j>=1;j--){
				if(num > a.get(j-1) && longestYet < dp[j]){
					longestYet = dp[j];
				}
			}
			
			dp[i] = longestYet+1;
			if(max < dp[i])
				max = dp[i];
		}
		
		return max;
	}

}
