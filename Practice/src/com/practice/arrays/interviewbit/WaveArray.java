package com.practice.arrays.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WaveArray {

	public static void main(String[] args) {
		Integer[] arr = { 5, 4, 3, 2, 1, 6};
		List<Integer> a = Arrays.asList(arr);
		System.out.println(wave(a));
	}
	
	public static List<Integer> wave(List<Integer> a) {
		ArrayList<Integer> res = new ArrayList<>();
		
		if(a.size() < 2)
			return a;
		
		Collections.sort(a);
		for(int i=1; i<a.size();i=i+2){
			res.add(a.get(i));
			res.add(a.get(i-1));
			
			if(i+2==a.size()){
				res.add(a.get(i+1));
			}
			
		}
		
		return res;
		
	}

}
