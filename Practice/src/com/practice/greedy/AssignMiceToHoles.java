package com.practice.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AssignMiceToHoles {

	public static void main(String[] args) {
		Integer[] m = {4,-4,2};
		Integer[] h = {4,0,5};
		
		System.out.println(mice(new ArrayList<>(Arrays.asList(m)), new ArrayList<>(Arrays.asList(h))));

	}
	
	public static int mice(ArrayList<Integer> mouseList, ArrayList<Integer> holeList){
		
		int minTime = Integer.MIN_VALUE;
		
		Collections.sort(mouseList);
		Collections.sort(holeList);
		
		for (int i = 0; i < mouseList.size(); i++) {
			int time = Math.abs(mouseList.get(i) - holeList.get(i));
			minTime = Math.max(minTime, time);
		}
		
		return minTime;
	}

}
