package com.practice.twopointers;

import java.util.ArrayList;

public class RemoveDuplicatesSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int removeDuplicates(ArrayList<Integer> A) {
		if (A.size() < 2)
			return A.size();

		int i = 0;
		int j = 1;

		while (j < A.size()) {
			if (A.get(i).equals(A.get(j))) {
				j++;
			} else{
				i++;
				A.set(i, A.get(j));
				j++;
			}
		}

		return i + 1;
	}

}
