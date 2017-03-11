package com.practice.arrays;

import java.util.ArrayList;

public class AntiDiagnoals {
	
	public static void main(String[] args) {
		
	}

	public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
	
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		int row = 0, col = 0;
		int n = a.size();
		
		for(int i=0; i<n+n-1; i++){
			ArrayList<Integer> outputList = new ArrayList<>();
			
			int rowIndex = row, colIndex = col;
			while(colIndex >= row){
				ArrayList<Integer> inputList = a.get(rowIndex);
				int element = inputList.get(colIndex);
				outputList.add(element);
				
				rowIndex++;
				colIndex--;
			}
			
			if(col<n-1){
				col++;
			} else{
				row++;
			}
			
			result.add(outputList);
			
		}
		
		return result;
	}
}
