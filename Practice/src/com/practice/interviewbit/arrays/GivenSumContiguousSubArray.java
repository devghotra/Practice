package com.practice.interviewbit.arrays;

public class GivenSumContiguousSubArray {
	// Facebook problem

	public static void main(String[] args) {
		int[] a = {23,5,4,7,2,11};
		int sum = 52;
		System.out.println(isSumContinous(a, sum));
	}
	
	public static boolean isSumContinous(int[] a, int sum){
		int currSum = 0;
		int startIndex=0;
		for(int i=0; i<a.length;i++){
			int num = a[i];
			currSum = currSum + num;
			if(currSum > sum){
				while(currSum > sum){
					currSum = currSum - a[startIndex];
					startIndex++;
				}
			} 
			
			if(currSum == sum){
				return true;
			}
		}
		
		return false;
	}

}