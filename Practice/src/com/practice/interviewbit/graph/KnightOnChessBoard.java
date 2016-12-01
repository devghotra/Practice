package com.practice.interviewbit.graph;

import java.util.LinkedList;
import java.util.Queue;

public class KnightOnChessBoard {

	public static void main(String[] args) {
		KnightOnChessBoard chess = new KnightOnChessBoard();
		System.out.println(chess.knight(8, 8, 1, 1, 8, 8));

	}
	
	public int knight(int X, int Y, int x1, int y1, int x2, int y2) {
		
		boolean[][] visited = new boolean[X][Y];
		
		Queue<Node> Q = new LinkedList<>();
		Node startingNode = new Node(x1, y1, 0);
		Q.add(startingNode);
		
		int minMoves = -1;
		while(!Q.isEmpty()){
			Node n = Q.poll();
			
			if(n.x < 1 || n.x > X || n.y < 1 || n.y > Y || visited[n.x-1][n.y-1]){
				continue;
			}
			
			visited[n.x-1][n.y-1] = true;
			
			if(n.x == x2 && n.y == y2 && (minMoves == -1 || n.move < minMoves)){
				minMoves = n.move;
			}
			
			Q.add(new Node(n.x+1,n.y+2,n.move+1));
			Q.add(new Node(n.x+2,n.y+1,n.move+1));
			Q.add(new Node(n.x+2,n.y-1,n.move+1));
			Q.add(new Node(n.x+1,n.y-2,n.move+1));
			Q.add(new Node(n.x-1,n.y-2,n.move+1));
			Q.add(new Node(n.x-2,n.y-1,n.move+1));
			Q.add(new Node(n.x-2,n.y+1,n.move+1));
			Q.add(new Node(n.x-1,n.y+2,n.move+1));
			
		}
		
		return minMoves;
	}

	static class Node{
		int x; int y; int move;

		public Node(int x, int y, int move) {
			super();
			this.x = x;
			this.y = y;
			this.move = move;
		}

		@Override
		public String toString() {
			return "["+ x + "," + y + ", m" + move + "]";
		}
		
		
		
	}
}
