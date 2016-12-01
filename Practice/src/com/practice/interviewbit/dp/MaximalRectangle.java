package com.practice.interviewbit.dp;

public class MaximalRectangle {

	public static void main(String[] args) {
		String[] input = { "01101", "11010", "01110", "11110", "11111", "00000" };

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

		System.out.println(maximalRectangle(matrix));
	}
	
	/*
	 * At every node keep count of left and top continuous 1's
	 * Max area at any node with 1 can be 
	 * 		- max(left, top)
	 * 		- Go upwards and count min number of 1's between starting node and current node (in same col) and multiply by number of rows moved up to calculate area
	 * 		- Keep going until you get 0 or index = 0
	 */

	public static int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int maxArea = 0;
		int rows = matrix.length;
		int cols = matrix[0].length;

		Node[][] dp = new Node[rows][cols];
		int num00 = matrix[0][0] == '1' ? 1 : 0;
		dp[0][0] = new Node(num00, num00);
		maxArea = num00;

		char[] firstRow = matrix[0];
		for (int i = 1; i < firstRow.length; i++) {
			dp[0][i] = firstRow[i] == '1' ? new Node(1, dp[0][i - 1].left + 1) : new Node();
			maxArea = Math.max(maxArea, dp[0][i].left);
		}

		for (int i = 1; i < matrix.length; i++) {
			dp[i][0] = matrix[i][0] == '1' ? new Node(dp[i - 1][0].top + 1, 1) : new Node();
			maxArea = Math.max(maxArea, dp[i][0].top);
		}

		for (int i = 1; i < matrix.length; i++) {
			char[] row = matrix[i];

			for (int j = 1; j < row.length; j++) {
				if (row[j] == '1') {
					int left = dp[i][j - 1].left + 1;
					int top = dp[i - 1][j].top + 1;

					int area = Math.max(left, top);

					if (left > 1 && top > 1) {
						int maxOnes = left;
						for (int i1 = i - 1; i1 >= 0; i1--) {
							if (dp[i1][j].left == 0)
								break;

							maxOnes = Math.min(maxOnes, dp[i1][j].left);
							area = Math.max(area, maxOnes * (i - i1 + 1));
						}
					}

					maxArea = Math.max(maxArea, area);

					dp[i][j] = new Node(top, left);
				} else {
					dp[i][j] = new Node();
				}
			}
		}

		return maxArea;
	}

	static class Node {
		int top;
		int left;

		public Node() {
			super();
		}

		public Node(int top, int left) {
			super();
			this.top = top;
			this.left = left;
		}

	}
}