package com.practice.backtracking;

import java.util.ArrayList;

public class NQueens {

	public static void main(String[] args) {
		NQueens nq = new NQueens();
		System.out.println(nq.solveNQueens(5));

	}
	
	public ArrayList<ArrayList<String>> solveNQueens(int n) {
		ArrayList<ArrayList<String>> validArrangements = new ArrayList<>();
		String[][] board = new String[n][n];
		solveNQueens(n, 0, 0, board, validArrangements);
		return validArrangements;
	}
	
	private void solveNQueens(int n, int row, int beginCol, String[][] board, ArrayList<ArrayList<String>> validArrangements){
		if(n == 0){
			addValidArrangement(validArrangements, board);
		}
		
		if(row < board.length && beginCol < board.length){
			for(int col = beginCol; col < board.length; col++){
				String[][] copyBoard = copyBoard(board);
				boolean valid = fillPositions(copyBoard, row, col);
				if(valid)
					solveNQueens(n-1, row+1, 0, copyBoard, validArrangements);
			}
		}
	}
	
	
	private boolean fillPositions(String[][] board, int row, int col){
		
		// if board[row][col] is already occupied then you cannot place the queen so return false
		if(board[row][col] != null)
			return false;
		
		for(int i = 0; i < board.length; i++){
			if(board[i][col] == null) 
				board[i][col] = ".";
			
			if(board[row][i] == null)
				board[row][i] = ".";
		}
		
		// up left diagonally
		for(int i = row-1, c = col-1; i >= 0 && c >= 0; i--, c--){
			if(board[i][c] == null) 
				board[i][c] = ".";
		}
		
		// up right diagonally
		for(int i = row-1, c = col+1; i >= 0 && c < board.length; i--, c++){
			if(board[i][c] == null) 
				board[i][c] = ".";
		}
		
		// down left diagonally
		for(int i = row+1, c = col-1; i < board.length && c >= 0; i++, c--){
			if(board[i][c] == null) 
				board[i][c] = ".";
		}
		
		// down right diagonally
		for(int i = row+1, c = col+1; i < board.length && c < board.length; i++, c++){
			if(board[i][c] == null) 
				board[i][c] = ".";
		}
		
		board[row][col] = "Q";
		return true;
	}
	
	private void addValidArrangement(ArrayList<ArrayList<String>> validArrangements, String[][] board){
		ArrayList<String> arrangement = new ArrayList<>();
		for(String[] row : board){
			String s = "";
			for(String p : row){
				s = s + p;
			}
			arrangement.add(s);
		}
		validArrangements.add(arrangement);
	}
	
	private String[][] copyBoard(String[][] board){
		String[][] copy = new String[board.length][board.length];
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board.length; j++){
				copy[i][j] = board[i][j];
			}
		}
		return copy;
	}

}
