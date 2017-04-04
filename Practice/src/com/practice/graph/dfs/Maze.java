package com.practice.graph.dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Maze {

	public static void main(String[] args) {
		Maze mz = new Maze();

		int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        
        int[] start = {0,4};
        int[] dest = {4,4};

		System.out.println(mz.hasPath(maze, start, dest));

	}

	// BFS
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		int numRows = maze.length;
		int numCols = maze[0].length;
		
		boolean[][] visited = new boolean[numRows][numCols];
		

		Queue<BallState> queue = new LinkedList<>();
		queue.add(new BallState(start[0], start[1]));
		visited[start[0]][start[1]] = true;

		while (!queue.isEmpty()) {
			BallState current = queue.poll();
			
			if (current.x == destination[0] && current.y == destination[1])
				return true;
			
			populateEndLocations(current, maze, queue, visited);
		}

		return false;
	}

	private void populateEndLocations(BallState current, int[][] maze, Queue<BallState> queue, boolean[][] visited) {

		int numRows = maze.length;
		int numCols = maze[0].length;

		int[][] dir = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		for (int i = 0; i < dir.length; i++) {
			int xx = current.x, yy = current.y;
			while (xx >= 0 && xx < numRows && yy >= 0 && yy < numCols && maze[xx][yy] == 0) {
				xx += dir[i][0];
				yy += dir[i][1];
			}
			xx -= dir[i][0];
			yy -= dir[i][1];
			
			if(!visited[xx][yy]){
				queue.add(new BallState(xx, yy));
				visited[xx][yy] = true;
			}
		}

	}
}

class BallState {
	int x;
	int y;

	BallState(int x, int y) {
		this.x = x;
		this.y = y;
	}
}