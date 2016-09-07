package com.practice.interviewbit.arrays;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {

	public static void main(String[] args) {
		Integer[] arr = { 626, 436, 819, 100, 382, 173, 817, 581, 220, 95, 814, 660, 397, 852, 15, 532, 564, 715, 179, 872, 236, 790, 223, 379, 83, 924, 454, 846, 742, 730, 689, 112, 110, 516, 85, 149, 228, 202, 988, 212, 69, 602, 887, 445, 327, 527, 347, 906, 54, 460, 517, 376, 395, 494, 827, 448, 919, 799, 133, 879, 709, 184, 812, 514, 976, 700, 156, 568, 453, 267, 547, 8, 951, 326, 652, 772, 213, 714, 706, 972, 318, 768, 506, 59, 854, 422, 10 };
		
		//Integer[] arr = { 5, 4, 3, 2, 1};
		List<Integer> a = Arrays.asList(arr);
		nextPermutation(a);
		
		System.out.println(a);
	}
	
	public static void nextPermutation(List<Integer> a) {
		if(a.size() < 2){
			return;
		}
		
		boolean arranged = false;
		int index = -1;
		int number = 0;
		for(int i=a.size()-1; i>=0; i--){
			int thisNum = a.get(i);
			if(i-1>=0){
				int prevNum = a.get(i-1);
				
				if(thisNum > prevNum){
					arranged = true;
					index = i-1;
					number = prevNum;
					break;
				}
			}
			
		}
		
		if(!arranged){
			Collections.sort(a);
		} else{
			List<Integer> subList = a.subList(index, a.size());
			Collections.sort(subList);
			for(int i=0;i<subList.size();i++){
				if(subList.get(i) > number){
					for(int j=i;j>0;j--){
						int temp = subList.get(j);
						subList.set(j, subList.get(j-1));
						subList.set(j-1, temp);
					}
					
					break;
				}
			}
			
		}
	}
	

}
