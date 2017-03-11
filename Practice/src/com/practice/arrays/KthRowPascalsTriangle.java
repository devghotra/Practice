package com.practice.arrays;

import java.util.ArrayList;

public class KthRowPascalsTriangle {

	public static void main(String[] args) {
		System.out.println(pascalRow(3));

	}
	
	public static ArrayList<Integer> pascalRow(int n){

		int[][] pascals = new int[n + 1][n + 1];
		pascals[0][0] = 1;

		for (int i = 1; i <= n; i++) {
			pascals[i][0] = 1;
			for (int j = 1; j <= i; j++) {
				pascals[i][j] = pascals[i - 1][j - 1] + pascals[i - 1][j];
			}
		}

		ArrayList<Integer> res = new ArrayList<>();
		for(int num : pascals[n]){
			res.add(num);
		}
		
		return res;
	
	}

}
