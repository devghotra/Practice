package com.practice.arrays.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

	public static void main(String[] args){
		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(0);
		list.add(0);
		list.add(0);
		list.add(0);
		list.add(0);
		
		System.out.println(largestNumber(list));
		
	}
	
	public static String largestNumber(final List<Integer> a) {
		StringBuilder res = new StringBuilder();
		
		Collections.sort(a, comparator);
		
		boolean allZeros = true;
		for(Integer num : a){
			if(allZeros && num != 0){
				allZeros = false;
			}
			
			res.append(num);
		}
		
		return allZeros ? "0" : res.toString();
	}
	
	static Comparator<Integer> comparator = new Comparator<Integer>() {
		@Override
		public int compare(Integer n1, Integer n2) {
			long l1 = Long.parseLong(n1+""+n2);
			long l2 = Long.parseLong(n2+""+n1);
			
			if(l1>l2)
				return -1;
			else if(l2>l1)
				return 1;
			else
				return 0;
		}
	};
	
	
}
