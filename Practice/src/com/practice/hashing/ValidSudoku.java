package com.practice.hashing;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ValidSudoku {

    @Test
    public void test() {
        String[] input = {".87654321", "2........", "3........", "4........", "5........", "6........", "7........", "8........", "9........"};
        assertEquals(1, isValidSudoku(Arrays.asList(input)));

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
        for (int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            Set<Character> boxSet = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                if (rowSet.contains(board[i][j])) {
                    return false;
                } else if (board[i][j] != '.') {
                    rowSet.add(board[i][j]);
                }

                if (colSet.contains(board[j][i])) {
                    return false;
                } else if (board[j][i] != '.') {
                    colSet.add(board[j][i]);
                }

                // Checking box horizontally
                int bRow = 3 * (i / 3) + j / 3;
                int bCol = 3 * (i % 3) + j % 3;
                if (boxSet.contains(board[bRow][bCol])) {
                    return false;
                } else if (board[bRow][bCol] != '.') {
                    boxSet.add(board[bRow][bCol]);
                }
            }
        }
        return true;
    }

}
