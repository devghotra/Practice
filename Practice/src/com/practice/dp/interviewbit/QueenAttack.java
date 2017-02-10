package com.practice.dp.interviewbit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class QueenAttack {

	public static void main(String[] args) {
		QueenAttack inst = new QueenAttack();
		ArrayList<String> boardArrList = new ArrayList<>();
		boardArrList.add("110");
		boardArrList.add("011");
		boardArrList.add("110");

		ArrayList<ArrayList<Integer>> attacks = inst.queenAttack(boardArrList);

		System.out.println(attacks);

	}

	public ArrayList<ArrayList<Integer>> queenAttack(ArrayList<String> boardArrList) {
		if (boardArrList.isEmpty()) {
			return new ArrayList<ArrayList<Integer>>();
		}

		int[][] attacks = getCount(boardArrList);

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		for (int[] a : attacks) {
			ArrayList<Integer> l = new ArrayList<>();
			for (int i : a) {
				l.add(i);
			}

			result.add(new ArrayList<>(l));
		}

		return result;
	}

	public int[][] getCount(ArrayList<String> board) {
		int m = board.size();
		int n = board.get(0).length();

		int[][] attacks = new int[m][n];
		Queue<Node> Q = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board.get(i).charAt(j) == '1') {
					Q.add(new Node(i, j - 1, 0, -1)); 		// left
					Q.add(new Node(i - 1, j - 1, -1, -1)); 	// left up diagonal
					Q.add(new Node(i - 1, j, -1, 0)); 		// up
					Q.add(new Node(i - 1, j + 1, -1, 1));	// right up diagonal
					Q.add(new Node(i, j + 1, 0, 1));		// right
					Q.add(new Node(i + 1, j + 1, 1, 1)); 	// right down diagonal
					Q.add(new Node(i + 1, j, 1, 0));		// bottom
					Q.add(new Node(i + 1, j - 1, 1, -1));	// bottom left
				}

				processQ(board, m, n, attacks, Q);
			}
		}

		return attacks;
	}

	private void processQ(ArrayList<String> board, int m, int n, int[][] attacks, Queue<Node> Q) {
		while (!Q.isEmpty()) {
			Node node = Q.poll();

			if (node.i == m || node.i < 0 || node.j == n || node.j < 0)
				continue;

			attacks[node.i][node.j] += 1;

			if (board.get(node.i).charAt(node.j) != '1')
				continueInDirection(Q, node);

		}
	}

	private void continueInDirection(Queue<Node> Q, Node node) {
		Q.add(new Node(node.i + node.dx, node.j + node.dy, node.dx, node.dy));
	}

	static class Node {
		int i;
		int j;
		int dx;
		int dy;

		public Node(int i, int j, int dx, int dy) {
			super();
			this.i = i;
			this.j = j;
			this.dx = dx;
			this.dy = dy;
		}
	}
}
