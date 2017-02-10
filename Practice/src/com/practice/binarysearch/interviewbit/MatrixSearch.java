package com.practice.binarysearch.interviewbit;

import java.util.ArrayList;

public class MatrixSearch {

	public static void main(String[] args) {
		int[] r1 = {10,20,30,40};
		int[] r2 = {15,25,35,45};
		int[] r3 = {17,27,37,47};
		int[] r4 = {19,29,39,49};
		
		int[][] matrix = new int[4][4];
		matrix[0] = r1;
		matrix[1] = r2;
		matrix[2] = r3;
		matrix[3] = r4;
		
		System.out.println(searchMatrix(matrix, 37));

	}
	
	/* works even if row 2 has smaller elements than row 1*/
	public static boolean searchMatrix(int[][] matrix, int target) {
		
		int numRows = matrix.length;
		int numCols = matrix[0].length;
		
		for(int i=0; i<numRows && i<numCols; i++){
			int[] rowArr = matrix[i];
			int index = search(rowArr, target, i, numCols-1);
			if(index != -1)
				return true;
			else{
				int[] colArr = new int[numRows-i];
				int pos = 0;
				for(int j=i; j<numRows; j++){
					colArr[pos++]=matrix[j][i];
				}
				index = search(colArr, target, 0, colArr.length-1);
				if(index != -1)
					return true;
			}
		}
		
		return false;
	}
	
	public static int search(int[] arr, int num, int low, int high){
		
		while(low <= high){
			int mid = (low+high)/2;
			if(arr[mid] == num)
				return mid;
			
			if(arr[mid] > num){
				high = mid-1;
			} else{
				low = mid+1;
			}
		}
		
		return -1;
	}
	
	/* interview bit variation */
	/* works only if all elements of row2 are greater than row1 
	 * Integers in each row are sorted from left to right.
		The first integer of each row is greater than or equal to the last integer of the previous row.
	 */
	
	public static int searchMatrixV1(ArrayList<ArrayList<Integer>> matrix, int target) {
		ArrayList<Integer> list = new ArrayList<>();
		for(ArrayList<Integer> row : matrix){
			list.addAll(row);
		}
		
		int index = search(list, target, 0, list.size()-1);
		if(index != -1)
			return 1;
		else
			return 0;
		
	}
	
	public static int searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
		int numRows = matrix.size();
		int numCols = matrix.get(0).size();
		
		for(int i=0; i<numRows && i<numCols; i++){
			ArrayList<Integer> rowArr = matrix.get(i);
			int index = search(rowArr, target, i, numCols-1);
			if(index != -1)
				return 1;
			else{
				ArrayList<Integer> colArr = new ArrayList<>();
				for(int j=i; j<numRows; j++){
					colArr.add(matrix.get(j).get(i));
				}
				index = search(colArr, target, 0, colArr.size()-1);
				if(index != -1)
					return 1;
			}
		}
		
		return 0;
	}
	
	public static int search(ArrayList<Integer> arr, int num, int low, int high){
		
		while(low <= high){
			int mid = (low+high)/2;
			if(arr.get(mid) == num)
				return mid;
			
			if(arr.get(mid) > num){
				high = mid-1;
			} else{
				low = mid+1;
			}
		}
		
		return -1;
	}

}
	