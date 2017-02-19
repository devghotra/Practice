package com.practice.binarysearch.interviewbit;

import java.util.ArrayList;

public class MatrixSearch {

	public static void main(String[] args) {
		int[] r1 = { 10, 20, 30, 40 };
		int[] r2 = { 15, 25, 35, 45 };
		int[] r3 = { 17, 27, 37, 47 };
		int[] r4 = { 19, 29, 39, 49 };

		int[][] matrix = new int[4][4];
		matrix[0] = r1;
		matrix[1] = r2;
		matrix[2] = r3;
		matrix[3] = r4;

		// System.out.println(searchMatrix(matrix, 37));

	}

	public static int searchMatrixV1(ArrayList<ArrayList<Integer>> matrix, int target) {
		int l = 0;
		int h = matrix.size() * matrix.get(0).size() - 1;
		int c = matrix.get(0).size();
		while (l <= h) {
			int mid = (l + h) / 2;
			int row = mid / c;
			int col = mid % c;
			if (matrix.get(row).get(col) > target) {
				h = mid - 1;

			} else if (matrix.get(row).get(col) < target) {
				l = mid + 1;
			} else if (matrix.get(row).get(col) == target) {
				return 1;
			}
		}
		return 0;

	}

}
