package com.practice.problems.fb;

public class MoveZeroes {
	
	public static void main(String[] args) {
		int[] nums = {1};
		moveZeroes(nums);
		for(int n : nums){
			System.out.print(n + " ");
		}
	}

	public static void moveZeroes(int[] nums) {
        
		int nonZeroPointer = -1;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] != 0){
			    if(nonZeroPointer++ != i){
			    	nums[nonZeroPointer] = nums[i];
					nums[i] = 0;
			    }
			}
		}
	
    }
}
