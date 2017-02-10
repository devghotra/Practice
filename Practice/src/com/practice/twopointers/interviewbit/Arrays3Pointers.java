package com.practice.twopointers.interviewbit;

import java.util.Arrays;
import java.util.List;

public class Arrays3Pointers {

	public static void main(String[] args) {
		Integer[] a = {1,4,10};
		Integer[] b = {2,15,20};
		Integer[] c = {20,12};
		
		System.out.println(minimize(Arrays.asList(a), Arrays.asList(b), Arrays.asList(c)));

	}

	/*
	 * Approach - Start from 0 index on all 3 lists
	 * calculate max-diff at current indexes i.e max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))
	 * replace min if this max-diff is smaller
	 * out of all 3 pointers find min number and increment it.
	 */
	public static int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
		int a = 0, b = 0, c = 0;
		
		int min = Integer.MAX_VALUE;
		
		while(a < A.size() && b < B.size() && c < C.size()){
			int aNum = A.get(a);
			int bNum = B.get(b);
			int cNum = C.get(c);
			
			int abDiff = Math.abs(aNum-bNum);
			int bcDiff = Math.abs(bNum-cNum);;
			int caDiff = Math.abs(cNum-aNum);
			
			min = Math.min(min,  Math.max(abDiff, Math.max(bcDiff, caDiff)));
			
			int minNum = Math.min(aNum, Math.min(bNum, cNum));
			if(minNum == aNum)
				a++;
			else if(minNum == bNum)
				b++;
			else
				c++;
			
		}
		
		return min;
	}
}
