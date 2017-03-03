package com.practice.graph.interviewbit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.google.common.primitives.Chars;

public class CaptureRegionsOnBoard {
	
	public static void main(String[] args){
		List<List<Character>> board = new ArrayList<>();
		board.add(Chars.asList("XXXX".toCharArray()));
		board.add(Chars.asList("XOOX".toCharArray()));
		board.add(Chars.asList("XXOX".toCharArray()));
		board.add(Chars.asList("XOXX".toCharArray()));
	}
	
	
	public void solve(ArrayList<ArrayList<Character>> board) {
		if(board==null || board.size()==0 || board.get(0).size()==0)
	        return;
		
		int numRows = board.size();
		int numCols = board.get(0).size();
		
		// Mark 'O' as '#' on the border -> top row, bottom row, 1st col, last col
		for(int i=0; i<numRows; i++){
			for(int j=0; j<numCols; j++){
				if(i == 0 || j == 0 || i == numRows - 1 || j == numCols - 1){
					bfs(board, i, j);
				}
			}
		}
		
		for(int i=0; i<numRows; i++){
	        for(int j=0; j<numCols; j++){
	            if(board.get(i).get(j)=='O'){
	            	board.get(i).set(j, 'X');
	            }
	            if(board.get(i).get(j)=='#'){
	            	board.get(i).set(j, 'O');
	            }
	        }
	    }
	}
	
	public static void bfs(ArrayList<ArrayList<Character>> board, int row, int col){
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(new Node(row, col));
		
		while(!queue.isEmpty()){
			Node n = queue.poll();
			
			if(n.x < 0 || n.x == board.size() || n.y < 0 || n.y == board.get(0).size() 	// if x,y are invalid
					|| board.get(n.x).get(n.y) == '#' 									// if its already marked
					|| board.get(n.x).get(n.y) == 'X')									// if its X
				continue;
			
			board.get(n.x).set(n.y, '#'); // mark this position as #
			
			queue.add(new Node(n.x-1, n.y));
			queue.add(new Node(n.x+1, n.y));
			queue.add(new Node(n.x, n.y-1));
			queue.add(new Node(n.x, n.y+1));
			
		}
	}

	static class Node{
		int x; int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}

