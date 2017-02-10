package com.practice.dp.interviewbit;

import java.util.ArrayList;

public class MinSumPathInMatrix {

	public static void main(String[] args) {
		MinSumPathInMatrix inst = new MinSumPathInMatrix();
		int[][] grid = new int[2][2];
		
		int[] grid0 = {1,2};
		int[] grid1 = {1,1};
		
		grid[0] = grid0;
		grid[1] = grid1;

		
		System.out.println(inst.minPathSum(grid));
	}
	
	public int minPathSum(ArrayList<ArrayList<Integer>> a) {
		int[][] grid = new int[a.size()][a.get(0).size()];
		
		for (int i = 0; i < a.size(); i++) {
			ArrayList<Integer> row = a.get(i);
			for (int j = 0; j < row.size(); j++) {
				grid[i][j] = row.get(j);
			}
		}
		
		return minPathSum(grid);
	}
	
	public int minPathSum(int[][] grid) {
		
		int rows = grid.length;
		int cols = grid[0].length;
		
		Integer[][] dp = new Integer[rows+1][cols+1];
		dp[1][1] = grid[0][0];
		
		for(int r = 1; r <= rows; r++){
			int[] row = grid[r-1];
			for(int c = 1; c <= cols; c++){
				if(dp[r][c] != null)
					continue;
				
				int num = row[c-1];
				int left = dp[r][c-1] == null ? Integer.MAX_VALUE : dp[r][c-1]+num;
				int top = dp[r-1][c] == null ?  Integer.MAX_VALUE : dp[r-1][c]+num;
				dp[r][c] = Math.min(left, top);
			}
		}
		
		return dp[rows][cols];
    }

}
