package com.practice19;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution {

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0);
    }

    public boolean solveSudoku(char[][] board, int row) {

        int[] rowNums = new int[10];
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] != '.') {
                rowNums[board[row][j]] = 1;
            }
        }

        for (int j = 0; j < board.length; j++) {
            if (board[row][j] != '.') {
                for (int k = 1; k < 10; k++) {

                }
            }
        }

        return false;
    }

}