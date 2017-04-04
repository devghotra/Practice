package com.practice.graph.unionfind;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands {

	public static void main(String[] args) {
		NumberOfIslands noi = new NumberOfIslands();
		
		char[][] grid = {
				{'1','0','1','1','1'},
				{'1','0','1','0','1'},
				{'1','1','1','0','1'}
		};
		
		System.out.println(noi.numIslands(grid));
		
	}

	public int numIslands(char[][] grid) {
		
		if (grid.length == 0 || grid[0].length == 0)
			return 0;

		int rows = grid.length;
		int cols = grid[0].length;

		int[] unionSet = new int[rows * cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int index = i * cols + j;
				if (grid[i][j] == '1') {
					unionSet[(index)] = index;
					if (j - 1 >= 0 && grid[i][j - 1] == '1') {
						union(index, index - 1, unionSet);
					}
					
					if (i - 1 >= 0 && grid[i - 1][j] == '1') {
						union(index, index - cols, unionSet);
					}
				}
			}
		}

		Set<Integer> parentIndexes = new HashSet<>();
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == '1'){
					int index = i * cols + j;
					int parent = unionSet[index];
					while(parent != index){
						index = parent;
						parent = unionSet[index];
					}
					parentIndexes.add(parent);
				}
				
			}
		}

		return parentIndexes.size();
	}

	private void union(int childIndex, int parentIndex, int[] unionSet) {
		int childRoot = findSet(childIndex, unionSet);
		int parentRoot = findSet(parentIndex, unionSet);
		
		// put the child in the same set as of parent
		unionSet[childRoot] = unionSet[parentRoot];
	}
	
	private int findSet(int index, int[] unionSet) {
		if (unionSet[index] == index)
			return index;
		// also do compression while finding
		unionSet[index] = findSet(unionSet[index], unionSet);
		return unionSet[index];
	}
}
