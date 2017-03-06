package com.practice.arrays.interviewbit;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleRows {

	public static void main(String[] args) {
		List<List<Integer>> pascalRows = generate(5);
		for(List<Integer> row : pascalRows){
			System.out.println(row);
		}

	}
	
	public static List<List<Integer>> generate(int n) {
		
		List<List<Integer>> pascalRows = new ArrayList<>();
		
		if(n == 0)
			return pascalRows;
		
		ArrayList<Integer> row = new ArrayList<>();
		row.add(1);
		pascalRows.add(row);
		
		for (int i = 1; i < n; i++) {
			row = new ArrayList<>();
			row.add(1);
			
			List<Integer> prevRow = pascalRows.get(i-1);
			for (int j = 1; j < i; j++) {
				row.add(prevRow.get(j-1) + prevRow.get(j));
			}
			
			row.add(1);
			pascalRows.add(row);
		}
		
		return pascalRows;
	}

}
