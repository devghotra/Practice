package com.practice.interviewbit.arrays;

import java.util.ArrayList;

public class PasalTriangleRows {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> pascalRows = generate(10);
		for(ArrayList<Integer> row : pascalRows){
			System.out.println(row);
		}

	}
	
	public static ArrayList<ArrayList<Integer>> generate1(int n) {
		
		ArrayList<ArrayList<Integer>> pascalRows = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i <= n; i++) {
			ArrayList<Integer> row = new ArrayList<>();
			row.add(1);
			
			ArrayList<Integer> prevRow = pascalRows.get(i-1);
			for (int j = 1; j <= i; j++) {
				row.add(prevRow.get(j-1) + prevRow.get(j));
				//pascals[i][j] = pascals[i - 1][j - 1] + pascals[i - 1][j];
			}
		}
		
		return null;
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
