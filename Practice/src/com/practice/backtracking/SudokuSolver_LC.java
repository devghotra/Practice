package com.practice.backtracking;

public class SudokuSolver_LC {

	public void solveSudoku(char[][] board) {
		if (board == null || board.length == 0)
			return;
		solve(board, 0);
	}

	public boolean solve(char[][] board, int startRow) {
		for (int i = startRow; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					for (char n = '1'; n <= '9'; n++) {// trial. Try 1 through 9
						if (isValid(board, i, j, n)) {
							board[i][j] = n; // Put c for this cell

							if (solve(board, startRow))
								return true; // If it's the solution return true
							else
								board[i][j] = '.'; // Otherwise go back
						}
					}

					return false;
				}
			}
		}
		return true;
	}

	private boolean isValid(char[][] board, int row, int col, char n) {
		for (int i = 0; i < 9; i++) {
			if (board[i][col] != '.' && board[i][col] == n)
				return false; // check row
			if (board[row][i] != '.' && board[row][i] == n)
				return false; // check column
			
			if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == n)
				return false; // check 3*3 block
		}
		return true;
	}
}
