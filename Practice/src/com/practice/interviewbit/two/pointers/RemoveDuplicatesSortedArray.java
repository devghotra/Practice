package com.practice.interviewbit.two.pointers;

import java.util.ArrayList;

public class RemoveDuplicatesSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int removeDuplicates(ArrayList<Integer> l){
		
		if(l.size() < 2)
			return l.size();
		
		int p1 = 0;
		int p2 = 1;
		
		if(l.get(p2).equals(l.get(p1))){
			l.remove(p2);
		} else{
			p1++;
			p2++;
		}
		
		return l.size();
	}

}
