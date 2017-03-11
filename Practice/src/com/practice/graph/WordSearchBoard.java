package com.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class WordSearchBoard {

	public static void main(String[] args) {
		/*
		 * BGGAGBGE
		 * EFFAGBEG
		 * FGGCBBFF
		 * BEEBDEDC
		 * FACABDCD
		 * ECGEFFED
		 * GDBEGACG
		 * GCECFBBD
		 */

		WordSearchBoard wsb = new WordSearchBoard();
		String[] boardArr = { "CDGCG", "CDAAA", "ECDDB", "FBGEC", "BEBBF", "DFGEF", "CGGAD", "AACGG", "BDGGB" };
		List<String> board = Arrays.asList(boardArr);
		System.out.println(wsb.exist(board, "BABABC"));

	}

	public int exist(List<String> board, String word) {
		char[][] cBoard = new char[board.size()][board.get(0).length()];
		int i = 0;
		for (String s : board) {
			cBoard[i] = s.toCharArray();
			i++;
		}

		return exist(cBoard, word) ? 1 : 0;
	}

	public boolean exist(char[][] board, String word) {

		Stack<Node> stack = new Stack<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				
				if(board[i][j] != word.charAt(0))
				    continue;
				
				int indexToCheck = 0;
				stack.add(new Node(i, j, 0));

				while (!stack.isEmpty()) {
					Node n = stack.pop();
					
					if(n.i < 0 || n.j < 0 || n.i >= board.length || n.j >= board[0].length)
						continue;

					if (n.k < indexToCheck)
						indexToCheck--;

					if (board[n.i][n.j] == word.charAt(indexToCheck) && n.k == indexToCheck) {

						indexToCheck++;

						stack.add(new Node(n.i - 1, n.j, indexToCheck));
						stack.add(new Node(n.i + 1, n.j, indexToCheck));
						stack.add(new Node(n.i, n.j - 1, indexToCheck));
						stack.add(new Node(n.i, n.j + 1, indexToCheck));

						if (indexToCheck == word.length()) {
							return true;
						}
					}
				}
				indexToCheck = 0;
			}
		}

		return false;
	}
	
	/* Using recursion */
	public int exist2(ArrayList<String> a, String word) {
		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < a.get(0).length(); j++) {
				if (dfs(a, word, i, j, 0))
					return 1;
			}
		}

		return 0;

	}

	private boolean dfs(ArrayList<String> a, String word, int i, int j, int k) {

		if (i < 0 || i >= a.size() || j < 0 || j >= a.get(0).length()) {
			return false;
		}

		if (word.charAt(k) != a.get(i).charAt(j)) {
			return false;
		}
		
		if (k == word.length() - 1) {
			return true;
		} else if (dfs(a, word, i - 1, j, k + 1) || dfs(a, word, i, j + 1, k + 1) || dfs(a, word, i + 1, j, k + 1) || dfs(a, word, i, j - 1, k + 1)) {
			return true;
		}

		return false;
	}

	static class Node {
		int i;
		int j;
		int k;

		Node(int i, int j, int k) {
			this.i = i;
			this.j = j;
			this.k = k;
		}
	}

}
