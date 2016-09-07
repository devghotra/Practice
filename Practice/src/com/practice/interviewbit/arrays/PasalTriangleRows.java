package com.practice.interviewbit.arrays;

import java.util.ArrayList;

public class PasalTriangleRows {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> pascalRows = generate(10);
		for(ArrayList<Integer> row : pascalRows){
			System.out.println(row);
		}

	}
	
	public static ArrayList<ArrayList<Integer>> generate(int a) {
		
		ArrayList<ArrayList<Integer>> pascalRows = new ArrayList<ArrayList<Integer>>();
		
		
		ArrayList<Integer> row = new ArrayList<>();
		
		for(int i=1; i<=a; i++){
			if(i==1){
				row.add(1);
				pascalRows.add(row);
				continue;
			}
			
			ArrayList<Integer> nextRow = new ArrayList<>();
			for(int j=0; j<i; j++){
				int num1 = j-1 >= 0 ? row.get(j-1) : 0;
				int num2 = j == row.size() ? 0 : row.get(j);
				
				nextRow.add(num1+num2);
			}
			
			pascalRows.add(nextRow);
			row = nextRow;
			
		}
		
		
		return pascalRows;
	}

}
