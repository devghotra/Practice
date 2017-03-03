package com.practice.dp.interviewbit;

import java.util.ArrayList;

public class MaximalRectangle {

	// https://discuss.leetcode.com/topic/6650/share-my-dp-solution

	public static void main(String[] args) {
		String[] a1 = { "01101", "11010", "01110", "11110", "11111", "00000" };
		String[] a2 = { "10100", "10111", "11111", "10010" };
		String[] a3 = { "000","000","111"};

		String[] input = a3;

		// ["01101","11010","01110","11110","11111","00000"]
		// {"10100","10111","11111","10010"};
		// {"11111111","11111110","11111110","11111000","01111000"};
		// {"01101","11010","01110","11110","11111","00000"};

		char[][] matrix = new char[input.length][input[0].length()];
		int i = 0;
		for (String str : input) {
			matrix[i] = str.toCharArray();
			i++;
		}

		System.out.println(maximalSquare(matrix));
	}

	/*
	 * At every node keep count of left continuous 1's
	 * Max area at any node with 1 can be
	 * - current count
	 * - Go upwards and count min of count between starting node and current
	 * node (in same col) and multiply by number of rows moved up to calculate
	 * area
	 * - Keep going until you get 0 or index = 0
	 */

	public int maximalRectangle(ArrayList<ArrayList<Integer>> a) {
		int[][] matrix = new int[a.size()][a.get(0).size()];

		for (int i = 0; i < a.size(); i++) {
			ArrayList<Integer> row = a.get(i);
			for (int j = 0; j < row.size(); j++) {
				matrix[i][j] = row.get(j);
			}
		}

		return maximalRectangle(matrix);
	}

	public static int maximalRectangle(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int maxArea = 0;
		int rows = matrix.length;
		int cols = matrix[0].length;

		int[][] dp = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			int[] row = matrix[i];

			for (int j = 0; j < cols; j++) {
				if (row[j] == 1) {
					dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;
					int area = dp[i][j];

					int boundary = dp[i][j];
					for (int i1 = i - 1; i1 >= 0; i1--) {
						if (dp[i1][j] == 0)
							break;

						boundary = Math.min(boundary, dp[i1][j]);
						area = Math.max(area, boundary * (i - i1 + 1));
					}

					maxArea = Math.max(maxArea, area);
				}
			}
		}

		return maxArea;
	}

	public static int maximalSquare(char[][] matrix) {

		if (matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int[][] leftOnes = new int[matrix.length][matrix[0].length];
		int[][] topOnes = new int[matrix.length][matrix[0].length];

		leftOnes[0][0] = matrix[0][0] == '1' ? 1 : 0;
		topOnes[0][0] = matrix[0][0] == '1' ? 1 : 0;
		int maxArea = matrix[0][0] == '1' ? 1 : 0;

		for (int i = 1; i < matrix[0].length; i++) {
			if (matrix[0][i] == '1') {
				topOnes[0][i] = 1;
				leftOnes[0][i] = leftOnes[0][i - 1] + 1;
				maxArea = Math.max(maxArea, leftOnes[0][i]);
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == '1') {
				topOnes[i][0] = topOnes[i - 1][0] + 1;
				leftOnes[i][0] = 1;
				maxArea = Math.max(maxArea, topOnes[i][0]);
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1') {

					topOnes[i][j] = Math.min(topOnes[i - 1][j - 1], topOnes[i - 1][j]) + 1;
					leftOnes[i][j] = Math.min(leftOnes[i - 1][j - 1], leftOnes[i][j - 1]) + 1;

					int tempArea = Math.max(Math.max(topOnes[i - 1][j] + 1, leftOnes[i][j - 1] + 1), topOnes[i][j] * leftOnes[i][j]);
					maxArea = Math.max(maxArea, tempArea);
				}
			}
		}

		return maxArea;
	}
}