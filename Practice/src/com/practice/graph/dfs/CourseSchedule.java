package com.practice.graph.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

// Apple
public class CourseSchedule {

	public static void main(String[] args) {
		
		int numCourses = 4;
		int[][] prerequisites = {{0,1}, {1,2}, {1,3}, {2, 1}, {3,2}};
		
		System.out.println(canFinish_TopologicalSort_BFS(numCourses, prerequisites));
	}
	
	// BFS Topological sort - LC Soln
	public static boolean canFinish_TopologicalSort_BFS(int numCourses, int[][] prerequisites) {
	    int[][] matrix = new int[numCourses][numCourses]; // i -> j
	    int[] numOfPreReqOfCourse = new int[numCourses];
	    
	    for (int i=0; i<prerequisites.length; i++) {
	        int course = prerequisites[i][0];
	        int pre = prerequisites[i][1];
	        if (matrix[pre][course] == 0)
	            numOfPreReqOfCourse[course]++; //duplicate case
	        matrix[pre][course] = 1;		   // matrix[i][j]=1 implies course i is pre-req of course j
	    }
	    
	    int count = 0;
	    Queue<Integer> queue = new LinkedList<>();
	    for (int i=0; i<numOfPreReqOfCourse.length; i++) {
	        if (numOfPreReqOfCourse[i] == 0) 
	        	queue.offer(i);
	    }
	    
	    while (!queue.isEmpty()) {
	        int course = queue.poll();
	        count++;
	        for (int i=0; i<numCourses; i++) {
	            if (matrix[course][i] != 0) {
	                if (--numOfPreReqOfCourse[i] == 0)
	                    queue.offer(i);
	            }
	        }
	    }
	    return count == numCourses;
	}

	// My soln based on just DFS
	public static boolean canFinish_DFS(int numCourses, int[][] prerequisites) {

		// represent graph as Adjacency list
		List<List<Integer>> graph = new ArrayList<>(numCourses);
		while(graph.size() < numCourses){
			graph.add(new ArrayList<>());
		}
		
		boolean[] visited = new boolean[numCourses];
		Set<Integer> underProcessing = new HashSet<>();
		
		for (int i = 0; i < prerequisites.length; i++) {
			int[] pr = prerequisites[i];
			graph.get(pr[0]).add(pr[1]);
		}
		
		for (int i = 0; i < numCourses; i++) {
			if(!visited[i] && !dfs(graph, i, visited, underProcessing)){
				return false;
			}
		}
		
		
		return true;
	}
	
	private static boolean dfs(List<List<Integer>> graph, int course, boolean[] visited, Set<Integer> underProcessing){
		
		Stack<Integer> stack = new Stack<>();
		stack.push(course);
		underProcessing.add(course);
		
		while(!stack.isEmpty()){
			int pc = stack.peek();
			Integer nextChild = getNextUnvisitedChild(graph, visited, pc);
			
			if(nextChild != null){
				if(underProcessing.contains(nextChild)){
					return false; // cycle
				}
				
				stack.push(nextChild);
				underProcessing.add(nextChild);
				continue;
			} else{
				pc = stack.pop();
				visited[pc] = true;
				underProcessing.remove(pc);
			}
			
			
		}
		
		return true;
	}

	private static Integer getNextUnvisitedChild(List<List<Integer>> graph, boolean[] visited, int course) {
		
		for(Integer preReq : graph.get(course)){
			if(!visited[preReq]){
				return preReq;
			}
		}
		
		return null;
	}

}
