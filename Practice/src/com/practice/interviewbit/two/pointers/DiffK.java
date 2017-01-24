package com.practice.interviewbit.two.pointers;

import java.util.Arrays;
import java.util.List;

public class DiffK {

	public static void main(String[] args) {
		Integer[] arr = {1,2,3};
			//{0, 1, 9, 10, 13, 17, 17, 17, 23, 25, 29, 30, 37, 38, 39, 39, 40, 41, 42, 60, 64, 70, 70, 70, 72, 75, 85, 85, 90, 91, 91, 93, 95};
		System.out.println(isDiffK(Arrays.asList(arr), 0));

	}

	
	public static int isDiffK(List<Integer> list, int k){
		if(list.size() < 2)
			return 0;
		
		int start = 0;
		int end = 1;
		
		while(start < end && end < list.size()){
			int diff = list.get(end) - list.get(start);
			
			if(diff == k)
				return 1;
			else if(diff > k)
				start++;
			else
				end++;
			
			if(start == end)
				end++;
				
		}
		
		return 0;
	}
}
