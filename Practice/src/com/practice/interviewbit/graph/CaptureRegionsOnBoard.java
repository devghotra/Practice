package com.practice.interviewbit.graph;

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
		int numRows = board.size();
		int numCols = board.get(0).size();
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int index = row*numCols + col;
		board.get(row).set(col, '#');
		queue.add(index);
		
		while(!queue.isEmpty()){
			int indexPos = queue.poll();
			int i = indexPos/numCols;
			int j = indexPos%numCols;
			
			if(i-1 >= 0 && board.get(i-1).get(j)=='O'){
			    board.get(i-1).set(j, '#');
				queue.add((i-1)*numCols+j);
			}
			
			if(i+1 < numRows && board.get(i+1).get(j)=='O'){
			    board.get(i+1).set(j, '#');
				queue.add((i+1)*numCols+j);
			}
			
			if(j-1 >= 0 && board.get(i).get(j-1)=='O'){
			    board.get(i).set(j-1, '#');
				queue.add(i*numCols+j-1);
			}
			
			if(j+1 < numCols && board.get(i).get(j+1)=='O'){
			    board.get(i).set(j+1, '#');
				queue.add(i*numCols+j+1);
			}
			
		}
	}

}
