package com.practice.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestElementArray {

	public static void main(String[] args) {
		Integer[] nums = {2, 1, 4, 3, 2};
		System.out.println(kthsmallest(Arrays.asList(nums), 3));

	}
	
	public static int kthsmallest(final List<Integer> nums, int k) {
		
		PriorityQueue<Integer> Q = new PriorityQueue<>(k, (n1,n2) -> n2.compareTo(n1));
		
		for(int n : nums){
			if(Q.size() < k){
				Q.add(n);
			} else if(n < Q.peek()){
				Q.poll();
				Q.add(n);
			}
		}
		
		return Q.poll();
	}

	
}
