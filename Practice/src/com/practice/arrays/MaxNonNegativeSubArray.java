package com.practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxNonNegativeSubArray {

	public static void main(String[] args) {
		Integer[] arr = {1967513926, 1540383426, -1303455736, -521595368 };
		System.out.println(maxset(Arrays.asList(arr)));
	}
	
	public static List<Integer> maxset(List<Integer> a) {
	    
		long maxSum = 0;
		long currentSum = 0;
		
		int maxArrStart = -1;
		int maxArrEnd = -1;
		int currentArrStart = -1;
		int currentArrEnd = -1;
		
		for(int i=0; i<a.size(); i++){
			if(a.get(i) < 0){
				currentArrStart = -1;
				currentSum = 0;
				continue;
			}
			
			if(currentArrStart == -1){
				currentArrStart = i;
			}
			
			currentSum += a.get(i);
			currentArrEnd = i;
			
			if(currentSum > maxSum || (currentSum == maxSum && (currentArrEnd - currentArrStart) > (maxArrEnd - maxArrStart))){
				maxSum = currentSum;
				maxArrStart = currentArrStart;
				maxArrEnd = i;
			}
		}
		
		ArrayList<Integer> max = new ArrayList<>();
		if(maxArrStart > -1){
			for(int i = maxArrStart; i <= maxArrEnd; i++){
				max.add(a.get(i));
			}
		}
		
		return max;
	}

}
