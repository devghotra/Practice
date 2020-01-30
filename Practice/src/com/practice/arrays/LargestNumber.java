package com.practice.arrays;

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
		
		Collections.sort(a, (n1, n2) -> (n1+""+n2).compareTo(n2+""+n1));
		for(Integer num : a){
			res.append(num);
		}

        return a.get(0) == 0 ? "0" : res.toString();
	}
	
}
