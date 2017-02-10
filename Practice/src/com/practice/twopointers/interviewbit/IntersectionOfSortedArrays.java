package com.practice.twopointers.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfSortedArrays {

	public static void main(String[] args) {
		IntersectionOfSortedArrays inst = new IntersectionOfSortedArrays();
		
		Integer[] a1 = {1, 2, 3, 3, 4, 5, 6};
		Integer[] a2 = {3, 3, 5};
		
		ArrayList<Integer> result = inst.intersect(new ArrayList<Integer>(Arrays.asList(a1)), new ArrayList<Integer>(Arrays.asList(a2)));
		System.out.println(result);

	}
	
	public ArrayList<Integer> intersect(ArrayList<Integer> l1,ArrayList<Integer> l2){
		ArrayList<Integer> result = new ArrayList<>();
		
		int p1 = 0;
		int p2 = 0;
		
		while(p1 < l1.size() && p2 < l2.size()){
			int n1 = l1.get(p1);
			int n2 = l2.get(p2);
			
			if(n1 == n2){
				result.add(n1);
				p1++;
				p2++;
			} else if(n1 < n2){
				p1++;
			} else{
				p2++;
			}	
		}
		
		return result;
	}

}
