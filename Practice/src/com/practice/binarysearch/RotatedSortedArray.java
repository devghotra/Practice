package com.practice.binarysearch;

import java.util.Arrays;
import java.util.List;

public class RotatedSortedArray {

	public static void main(String[] args) {
		Integer[] nums = {7,0,1,2,3,4,5,6};
		
		System.out.println(search(Arrays.asList(nums), 0));
	}

	public static int search(final List<Integer> nums, int target) {
		int low = 0;
		int high = nums.size()-1;
		
		while(low <= high){
			int mid = (low+high)/2;
			
			if(nums.get(mid) == target)
				return mid;
			
			// 1st half is un-sorted so check if target is in 2nd
			if(nums.get(low) > nums.get(mid)){
				if(target > nums.get(mid) && target <= nums.get(high)){
					low = mid+1;
				} else{
					high = mid-1;
				}
			} else{
				// 2nd half is un-sorted, so check if target is in 1st
				if(target >= nums.get(low) && target < nums.get(mid)){
					high = mid-1;
				} else{
					low = mid+1;
				}
			}
		}
		
		return -1;
	}

}
