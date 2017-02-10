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
		
		for(int i=0; i<numRows; i++){
	        if(board.get(i).get(0) =='O'){
	            bfs(board, i, 0);
	        }
	        
	        if(board.get(i).get(numCols-1) =='O'){
	            bfs(board, i, numCols-1);
	        }
	    }
		
		for(int j=0; j<numCols; j++){
			
			if(board.get(0).get(j) =='O'){
	            bfs(board, 0, j);
	        }
	        
			if(board.get(numRows-1).get(j) =='O'){
	            bfs(board, numRows-1, j);
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
			
			if(n.x < 0 || n.x == board.size() || n.y < 0 || n.y == board.get(0).size() || board.get(n.x).get(n.y) == '#' || board.get(n.x).get(n.y) == 'X')
				continue;
			
			board.get(n.x).set(n.y, '#');
			
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

