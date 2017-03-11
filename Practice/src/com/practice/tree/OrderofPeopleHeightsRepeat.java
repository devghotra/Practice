package com.practice.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderofPeopleHeightsRepeat {

	public static void main(String[] args) {
		OrderofPeopleHeightsRepeat inst = new OrderofPeopleHeightsRepeat();
		Integer[] heights = { 6, 5, 4, 3, 2, 1 };
		Integer[] inFronts = { 0, 0, 2, 1, 2, 3 };

		System.out.println(inst.order(Arrays.asList(heights), Arrays.asList(inFronts)));

	}

	// using ArrayList
	public ArrayList<Integer> order(List<Integer> heights, List<Integer> infronts) {
		ArrayList<Integer> actualHeightOrder = new ArrayList<>();
		
		Map<Integer, Integer> heightToInFrontMap = new HashMap<>();
		for (int i = 0; i < heights.size(); i++) {
			heightToInFrontMap.put(heights.get(i), infronts.get(i));
		}
		
		Collections.sort(heights);
		
		for (int i = heights.size() -1 ; i >= 0; i--) {
			int inFront = heightToInFrontMap.get(heights.get(i));
			if(inFront >= actualHeightOrder.size()){
				actualHeightOrder.add(heights.get(i));
			} else{
				// this is expensive operation - it could be improved by using tree or linked list
				actualHeightOrder.add(inFront, heights.get(i));
			}
		}
		
		return actualHeightOrder;
	}

	
}