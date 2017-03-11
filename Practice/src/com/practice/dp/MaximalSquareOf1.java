package com.practice.dp;

public class MaximalSquareOf1 {

	public static void main(String[] args) {
		String[] a1 = {
				"101001110",
				"111000001",
				"001100011",
				"011001001",
				"110110010",
				"011111101",
				"101110010",
				"111010001",
				"011110010",
				"100111000"
				};
		
		String[] a2 = {"10100","10111","11111","10010"};
		
		String[] input = a2;
		char[][] matrix = new char[input.length][input[0].length()];
		
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = input[i].charAt(j);
			}
		}
		
		
		System.out.println(maximalSquare(matrix));
	}

	public static int maximalSquare(char[][] matrix) {

		if (matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
		int max = 0;

		for (int i = 1; i <= matrix.length; i++) {
			for (int j = 1; j <= matrix[0].length; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}

		return max * max;
	}
}
