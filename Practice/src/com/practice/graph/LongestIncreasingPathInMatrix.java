package com.practice.graph;

public class LongestIncreasingPathInMatrix {

	public static void main(String[] args) {
		LongestIncreasingPathInMatrix inst = new LongestIncreasingPathInMatrix();
		int[][] matrix = {
				{6,5,4},
				{7,2,3},
				{8,1,4},
				{9,0,6}
		};

		System.out.println(inst.longestIncreasingPath(matrix));
	}

	public int longestIncreasingPath(int[][] matrix) {
		int max = 0;
		
		if(matrix.length == 0 || matrix[0].length == 0)
			return max;
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int[][] countMatrix = new int[rows][cols];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if(countMatrix[i][j] == 0)
					max = Math.max(max, dfs(i, j, matrix, countMatrix));
			}
		}
		
		return max;
	}
	
	private int dfs(int i, int j, int[][] matrix, int[][] countMatrix){
		if(countMatrix[i][j] != 0)
			return countMatrix[i][j];
		
		int l1 = 0, l2 = 0, l3 = 0, l4 = 0;
		int num = matrix[i][j];
		
		// left
		if(j-1 >= 0 && matrix[i][j-1] > num){
			l1 = dfs(i, j-1, matrix, countMatrix);
		}
		
		// right
		if(j+1 < matrix[0].length && matrix[i][j+1] > num){
			l2 = dfs(i, j+1, matrix, countMatrix);
		}
		
		// top
		if(i-1 >= 0 && matrix[i-1][j] > num){
			l3 = dfs(i-1, j, matrix, countMatrix);
		}
		
		// bottom
		if(i+1 < matrix.length && matrix[i+1][j] > num){
			l4 = dfs(i+1, j, matrix, countMatrix);
		}
		
		countMatrix[i][j] = Math.max(Math.max(l1, l2), Math.max(l3, l4)) + 1;
		return countMatrix[i][j];
	}
}
