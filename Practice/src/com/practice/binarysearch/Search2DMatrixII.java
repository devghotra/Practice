package com.practice.binarysearch;


//Leetcode
public class Search2DMatrixII {

	public static void main(String[] args) {
		int[][] matrix = {
		                  {1,   4,  7, 11, 15},
		                  {2,   5,  8, 12, 19},
		                  {3,   6,  9, 16, 22},
		                  {21, 23, 24, 27, 34},
		                  {28, 31, 43, 46, 50}
						};
		
		System.out.println(searchMatrix(matrix, 5));

	}
	
	// https://discuss.leetcode.com/topic/28277/java-short-code-o-m-n
	public static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0 || matrix[0].length == 0)
			return false;
		
		int m = matrix.length;
		int n = matrix[0].length;
		int i = 0;
		int j = n - 1;
		
		while (i < m && j >= 0) {
			if (matrix[i][j] == target)
				return true;
			else if (matrix[i][j] < target)
				i++;
			else
				j--;
		}
		return false;
	}

	/* FUDU soln 
	 * CRUX - Since both rows and cols are sorted we can apply binary search on either to find an element
	 * Assuming M*N matrix
	 * Search by row will be O(MlogN)
	 * Search by col will be O(NlogM)
	 * 
	 * to decide search direction
	 * 	- choose search by row if M < N since O(MlogN) < O(NlogM)
	 * 	- else choose search by col
	 *  
	 */
	public static boolean searchMatrix1(int[][] matrix, int target) {

		
		if(matrix.length == 0 || matrix[0].length == 0)
			return false;
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		boolean searchByRow = rows <= cols;
		boolean searchByCol = !searchByRow;

		for (int i = 0; i < Math.min(rows, cols); i++) {
			int startRow = searchByRow ? i : 0; 		// if searchByCol always start from first row
			int startCol = searchByCol ? i : 0; 		// if searchByRow always start from first col
			int endRow = searchByRow ? i : rows - 1; 	// if searchByCol always end at last row
			int endCol = searchByCol ? i : cols - 1;	// if searchByRow always end at last col
			
			while ((searchByCol && startRow <= endRow) || (searchByRow && startCol <= endCol)) {
				int midRow = searchByRow ? startRow : (startRow + endRow) / 2;
				int midCol = searchByCol ? startCol : (startCol + endCol) / 2;
				int mid = matrix[midRow][midCol];

				if (mid == target) {
					return true;
				} else if (mid > target) {
					if (searchByRow)
						endCol = midCol - 1;
					else
						endRow = midRow - 1;
				} else {
					if (searchByRow)
						startCol = midCol + 1;
					else
						startRow = midRow + 1;
				}
			}
		}

		return false;
	}

}
