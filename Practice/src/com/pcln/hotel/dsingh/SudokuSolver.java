package com.pcln.hotel.dsingh;

public class SudokuSolver {

	public void solveSudoku(int[][] board) {
		if (board == null || board.length == 0)
			return;
		solve(board);
	}

	public boolean solve(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 0) {
					for (int n = 1; n <= 9; n++) {// trial. Try 1 through 9
						if (isValid(board, i, j, n)) {
							board[i][j] = n; // Put c for this cell

							if (solve(board))
								return true; // If it's the solution return true
							else
								board[i][j] = 0; // Otherwise go back
						}
					}

					return false;
				}
			}
		}
		return true;
	}

	private boolean isValid(int[][] board, int row, int col, int n) {
		for (int i = 0; i < 9; i++) {
			if (board[i][col] != 0 && board[i][col] == n)
				return false; // check row
			if (board[row][i] != 0 && board[row][i] == n)
				return false; // check column
			
			// don't code this - just say similarly i can check 3 by 3 grid
			if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != 0 && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == n)
				return false; // check 3*3 block
		}
		return true;
	}
}
