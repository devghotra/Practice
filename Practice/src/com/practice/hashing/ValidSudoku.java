package com.practice.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {

	public static void main(String[] args) {
		ValidSudoku vs = new ValidSudoku();
		String[] input = {".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
		System.out.println(vs.isValidSudoku(Arrays.asList(input)));

	}

	public int isValidSudoku(final List<String> input) {
		char[][] board = new char[9][9];

		for (int i = 0; i < input.size(); i++) {
			String row = input.get(i);
			char[] rowArr = row.toCharArray();
			for (int j = 0; j < rowArr.length; j++) {
				board[i][j] = rowArr[j];
			}
		}

		return isValidSudoku(board) ? 1 : 0;
	}

	public boolean isValidSudoku(char[][] board) {

		Set<Character> horizontalSet = null;
		Set<Character> verticalSet = null;

		for (int i = 0; i < board.length; i++) {
			horizontalSet = new HashSet<>();
			verticalSet = new HashSet<>();
			for (int j = 0; j < board.length; j++) {
				char horzNum = board[i][j];
				char verticalNum = board[j][i];

				if (horzNum != '.') {
					if (horizontalSet.contains(horzNum)) {
						return false;
					} else {
						horizontalSet.add(horzNum);
					}
				}

				if (verticalNum != '.') {
					if (verticalSet.contains(verticalNum)) {
						return false;
					} else {
						verticalSet.add(verticalNum);
					}
				}
			}
		}

		// check cubes
		Set<Character> set1 = null;
		Set<Character> set2 = null;
		Set<Character> set3 = null;
		for (int i = 0; i < board.length; i++) {
			if (i % 3 == 0) {
				set1 = new HashSet<>();
				set2 = new HashSet<>();
				set3 = new HashSet<>();
			}
			// check & jump 3 positions in same row
			for (int j = 0; j < 3; j++) {
				if (board[i][j] != '.') {
					if (set1.contains(board[i][j]))
						return false;
					else
						set1.add(board[i][j]);
				}

				if (board[i][j + 3] != '.') {
					if (set2.contains(board[i][j + 3]))
						return false;
					else
						set2.add(board[i][j + 3]);
				}

				if (board[i][j + 6] != '.') {
					if (set3.contains(board[i][j + 6]))
						return false;
					else
						set3.add(board[i][j + 6]);
				}
			}
		}

		return true;
	}

}
