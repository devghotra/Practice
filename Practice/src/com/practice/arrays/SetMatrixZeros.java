package com.practice.arrays;

import java.util.ArrayList;

public class SetMatrixZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void setZeroesIB(ArrayList<ArrayList<Integer>> matrix) {

		// rows containing at least 1 zero
		int[] zeroRows = new int[matrix.size()];

		// cols containing at least 1 zero
		int[] zeroCols = new int[matrix.get(0).size()];

		for (int i = 0; i < zeroRows.length; i++) {
			for (int j = 0; j < zeroCols.length; j++) {
				if (matrix.get(i).get(j).intValue() == 0) {
					zeroRows[i] = 1; // mark this row as it needs to be zero'd
					zeroCols[j] = 1; // mark this col as it needs to be zero'd
				}
			}
		}

		for (int i = 0; i < zeroRows.length; i++) {
			if (zeroRows[i] == 1) {
				for (int j = 0; j < zeroCols.length; j++) {
					matrix.get(i).set(j, 0);
				}
			}
		}

		for (int i = 0; i < zeroCols.length; i++) {
			if (zeroCols[i] == 1) {
				for (int j = 0; j < zeroRows.length; j++) {
					matrix.get(j).set(i, 0);
				}
			}
		}
	}

	public void setZeroes(int[][] matrix) {

		// rows containing at least 1 zero
		int[] zeroRows = new int[matrix.length];

		// cols containing at least 1 zero
		int[] zeroCols = new int[matrix[0].length];

		for (int i = 0; i < zeroRows.length; i++) {
			for (int j = 0; j < zeroCols.length; j++) {
				if (matrix[i][j] == 0) {
					zeroRows[i] = 1; // mark this row as it needs to be zero'd
					zeroCols[j] = 1; // mark this col as it needs to be zero'd
				}
			}
		}

		for (int i = 0; i < zeroRows.length; i++) {
			if (zeroRows[i] == 1) {
				for (int j = 0; j < zeroCols.length; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < zeroCols.length; i++) {
			if (zeroCols[i] == 1) {
				for (int j = 0; j < zeroRows.length; j++) {
					matrix[j][i] = 0;
				}
			}
		}
	}

}
