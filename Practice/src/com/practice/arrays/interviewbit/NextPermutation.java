package com.practice.arrays.interviewbit;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {

	public static void main(String[] args) {
		//Integer[] arr = { 626, 436, 819, 100, 382, 173, 817, 581, 220, 95, 814, 660, 397, 852, 15, 532, 564, 715, 179, 872, 236, 790, 223, 379, 83, 924, 454, 846, 742, 730, 689, 112, 110, 516, 85, 149, 228, 202, 988, 212, 69, 602, 887, 445, 327, 527, 347, 906, 54, 460, 517, 376, 395, 494, 827, 448, 919, 799, 133, 879, 709, 184, 812, 514, 976, 700, 156, 568, 453, 267, 547, 8, 951, 326, 652, 772, 213, 714, 706, 972, 318, 768, 506, 59, 854, 422, 10 };
		
		Integer[] arr = {300, 259, 359, 639, 268, 271, 565, 113, 322, 293, 994, 357, 178, 986, 101, 70, 554, 119, 508, 671, 111, 120, 169, 505, 709, 206, 625, 933, 865, 536, 647, 150, 412, 481, 796, 365, 721, 334, 221, 339, 544, 136, 332, 672, 
				781, 317, 529, 729, 874, 983, 296, 973, 563, 244, 802, 104, 179, 556, 782, 315, 278, 542, 252, 369, 917, 233, 58, 245, 627, 833, 424, 444, 658, 373, 859, 985, 471, 846, 511, 521, 673, 20, 299, 476};
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(arr));
		nextPermutation(a);
		
		System.out.println(a);
	}
	/*
	input : 645321
	index : 1
	sublist : 45321
	sorted sublist : 12345
	Going backwards and finding pos of 5 : 51234

	Original list : 651234

	sublist is part of original list, not a new one - changes to sublist will cause changes to original list.
	 */
	
	public static void nextPermutation(ArrayList<Integer> a) {
		if(a.size() < 2){
			return;
		}
		
		// starting from end find a number which is greater than previous number
		// number - number greater than previous & index - index of number
		// if no such number found than list is in desc order and there is no greater permutation
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
		
		// if no number is found from above, sort list in asc order to get next permutation
		if(!arranged){
			Collections.sort(a);
		} else{
			// create a sublist(part of same list, not new one) starting from index to end and sort
		    // find the number greater than number found above, remove it from sublist and 
		    // add at the beginning of sublist to find its position that gives next permutation
			List<Integer> subList = a.subList(index, a.size());
			Collections.sort(subList);
			int i=0;
			for(;i<subList.size();i++){
				if(subList.get(i) > number){
					break;
				}
			}
			
			int temp = subList.remove(i);
			subList.add(0, temp);
			
		}
	}

}
