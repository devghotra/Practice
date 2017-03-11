package com.practice.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveElementFromArray {

	public static void main(String[] args) {
		Integer[] nums = {4,1,1,2,1,3};
		System.out.println(removeElement(new ArrayList<>(Arrays.asList(nums)), 4));
	}

	public static int removeElement(ArrayList<Integer> A, int val) {
		int i = -1;
		int j = 0;

		while (j < A.size()) {
			if(A.get(j) != val){
				i++;
				A.set(i, A.get(j));
				j++;
			} else{
				j++;
			}
		}

		return i+1;
	}

}
