package com.practice.backtracking;

import org.junit.Test;

public class SudokuSolver_LC {

    @Test
    public void test() {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.' },
                {'6', '.', '.', '1', '9', '5', '.', '.', '.' },
                {'.', '9', '8', '.', '.', '.', '.', '6', '.' },
                {'8', '.', '.', '.', '6', '.', '.', '.', '3' },
                {'4', '.', '.', '8', '.', '3', '.', '.', '1' },
                {'7', '.', '.', '.', '2', '.', '.', '.', '6' },
                {'.', '6', '.', '.', '.', '.', '2', '8', '.' },
                {'.', '.', '.', '4', '1', '9', '.', '.', '5' },
                {'.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        solveSudoku(board);
    }

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    continue;
                }

                for (char n = '1'; n <= '9'; n++) {// trial. Try 1 through 9
                    if (isValid(board, i, j, n)) {
                        board[i][j] = n; // Put c for this cell

                        if (solve(board))
                            return true; // If it's the solution return true
                        else
                            board[i][j] = '.'; // Otherwise go back
                    }
                }
                return false;
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

            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == n)
                return false; // check 3*3 block
        }
        return true;
    }
}
