package com.practice.twopointers.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesSortedArray2 {

	public static void main(String[] args) {
		Integer[] nums = { 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3};
		System.out.println(removeDuplicates(new ArrayList<>(Arrays.asList(nums))));

	}

	public static int removeDuplicates(ArrayList<Integer> A) {
		if (A.size() < 2)
			return A.size();

		int i = 0;
		int j = 1;

		int c = 1;

		while (j < A.size()) {
			if (A.get(i).equals(A.get(j))) {
				if(c < 2){
					i++;
					A.set(i, A.get(j));
				}
				j++;
				c++;
			} else{
				i++;
				A.set(i, A.get(j));
				j++;
				c=1;
			}			
		}

		System.out.println(A);
		return i + 1;
	}

}
