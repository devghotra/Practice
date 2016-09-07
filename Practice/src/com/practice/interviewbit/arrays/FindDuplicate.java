package com.practice.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDuplicate {

	public static void main(String[] args) {
		Integer[] arr =  {1, 2, 3, 1, 3, 6, 6};
		List<Integer> a = Arrays.asList(arr);
		System.out.println(findDuplicates(a));
	}
	
	public static List<Integer> findDuplicates(List<Integer> a){
		
		int n = a.size();
		Integer[] countArr = new Integer[n];
		
		for(int i=0; i<a.size(); i++){
			int num = a.get(i);
			Integer count = countArr[num];
			if(count == null){
				countArr[num] = 1;
			} else{
				countArr[num] = count+1;
			}
		}
		
		List<Integer> result = new ArrayList<>();
		for(int i=0; i<countArr.length; i++){
			if(countArr[i] != null && countArr[i] > 1)
				result.add(i);
		}
		
		return result;
	}
	
	public static int repeatedNumber(final List<Integer> a) {
	
		int n = a.size();
		Integer[] countArr = new Integer[n];
		
		for(int i=0; i<a.size(); i++){
			int num = a.get(i);
			
			if(countArr[num-1] == null){
				countArr[num-1] = 1;
			} else{
				return num;
			}
		}
		
		return 0;
	}
}
