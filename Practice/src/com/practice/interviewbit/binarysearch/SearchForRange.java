package com.practice.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchForRange {

	public static void main(String[] args) {
		//int[] arr = { 5, 7, 7, 8, 8, 10 };
		Integer[] arr = {1,1,1,1,1,1,1};

		ArrayList<Integer> result = searchRange(Arrays.asList(arr), 1);
		System.out.println(result.toString());

	}
	
	public static ArrayList<Integer> searchRange(final List<Integer> nums, int target) {
        return search(nums, target, 0, nums.size()-1);
    }

	public static ArrayList<Integer> search(List<Integer> nums, int target, int low, int high) {

		ArrayList<Integer> result = new ArrayList<>();
		if(nums.get(low).equals(target) && nums.get(high).equals(target)){
			result.add(low);
			result.add(high);
			return result;
		}
		
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums.get(mid) < target) {
				low = mid + 1;
			} else if (nums.get(mid) > target) {
				high = mid - 1;
			} else {
				ArrayList<Integer> start = null;
				ArrayList<Integer> end = null;
				if(mid-1 >= 0 && nums.get(mid-1) == target){
					start = search(nums, target, low, mid - 1);
				}
				
				if(mid+1 < nums.size() && nums.get(mid+1) == target){
					end = search(nums, target, mid+1, high);
				}
				
				result.add(start == null ? mid : start.get(0));
				result.add(end == null ? mid : end.get(1));
				
				return result;
			}
		}
		
		result.add(-1);
		result.add(-1);
		return result;
	}

}
