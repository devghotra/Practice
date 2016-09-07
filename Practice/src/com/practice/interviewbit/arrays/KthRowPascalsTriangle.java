package com.practice.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class KthRowPascalsTriangle {
	
	static Integer[][] store = null;

	public static void main(String[] args) {
		
		System.out.println(pascalRow(7));
	}
	
	
	public static ArrayList<Integer> pascalRow(int a){
		store = new Integer[a+1][a+1];
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0; i<=a; i++){
			arr.add(pascalElement(a, i));
		}
		
		return arr;
	}
	
	
	
	public static int pascalElement(int k, int pos){
		if(k==0){
			if(pos==0)
				return 1;
			else
				return 0;
		} else{
			Integer p1 = 0;
			if(pos-1>=0)
				p1 = store[k-1][pos-1];
			if(p1 == null){
				p1 = pascalElement(k-1, pos-1);
				store[k-1][pos-1] = p1;
			}
			
			Integer p2 = 0;
			if(pos>=0)
				p2 = store[k-1][pos];
			if(p2 == null){
				p2 = pascalElement(k-1, pos);
				store[k-1][pos] = p2;
			}
			
			return p1 + p2;
		}
		
	}

}
