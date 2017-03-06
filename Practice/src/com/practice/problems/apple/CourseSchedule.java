package com.practice.problems.apple;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class CourseSchedule {

	public static void main(String[] args) {
		
		int numCourses = 4;
		int[][] prerequisites = {{0,1}, {1,2}, {1,3}, {3, 0}};

		System.out.println(canFinish(numCourses, prerequisites));
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {

		int[][] graph = new int[numCourses][numCourses];
		boolean[] visited = new boolean[graph.length];
		Set<Integer> onStack = new HashSet<>();
		
		for (int i = 0; i < prerequisites.length; i++) {
			int[] pr = prerequisites[i];
			graph[pr[0]][pr[1]] = 1;
		}
		
		for (int i = 0; i < numCourses; i++) {
			if(!visited[i] && !dfs(graph, i, visited, onStack)){
				return false;
			}
		}
		
		
		return true;
	}
	
	private static boolean dfs(int[][] graph, int sc, boolean[] visited, Set<Integer> onStack){
		
		Stack<Integer> stack = new Stack<>();
		stack.push(sc);
		onStack.add(sc);
		
		while(!stack.isEmpty()){
			int pc = stack.peek();
			Integer nextChild = getNextUnvisitedChild(graph, visited, pc);
			
			if(nextChild != null){
				if(onStack.contains(nextChild)){
					return false;
				}
				
				stack.push(nextChild);
				onStack.add(nextChild);
				continue;
			} else{
				pc = stack.pop();
				visited[pc] = true;
				onStack.remove(pc);
			}
			
			
		}
		
		return true;
	}

	private static Integer getNextUnvisitedChild(int[][] graph, boolean[] visited, int pc) {
		for (int j = 0; j < graph.length; j++) {
			if(!visited[j] && graph[pc][j] == 1){
				return j;
			}
		}
		
		return null;
	}

}
