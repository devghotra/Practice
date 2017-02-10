package com.practice.graph.interviewbit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BlackShapes {

	// http://qa.geeksforgeeks.org/4131/count-the-number-of-shapes
	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<>();
		a.add("XXXX");
		a.add("XOOX");
		a.add("XXOX");
		a.add("XOXX");
		
		System.out.println(black(a));

	}

	public static int black(ArrayList<String> a) {
		if (a.size() == 0)
			return 0;
		
		int[][] arr = new int[a.size()][a.get(0).length()];

		int i = 0;
		for (String str : a) {
			for (int j = 0; j < str.length(); j++) {
				arr[i][j] = 0;
				if (str.charAt(j) == 'X')
					arr[i][j] = 1;
			}
			i++;
		}

		return dfs(arr);
	}
	
	// clean it up - do same as CaptureRegionsOnBoard - use Node
	public static int dfs(int [][]arr) {
		int count = 0;
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				if(arr[i][j] == 1){
					Stack<String> stack = new Stack<>();
					stack.push(i+","+j);
					arr[i][j] = 0;
					
					while(!stack.isEmpty()){
						String pos = stack.peek();
						String[] posArr = pos.split(",");
						int r = Integer.valueOf(posArr[0]);
						int c = Integer.valueOf(posArr[1]);
						
						int left = c-1>=0 ? arr[r][c-1] : 0; 
						if(left == 1){
							stack.push(r+","+(c-1));
							arr[r][c-1] = 0;
							continue;
						}
						
						int right = c+1<arr[r].length ? arr[r][c+1] : 0; 
						if(right == 1){
							stack.push(r+","+(c+1));
							arr[r][c+1] = 0;
							continue;
						}
						
						int up = r-1>=0 ? arr[r-1][c] : 0; 
						if(up == 1){
							stack.push((r-1)+","+c);
							arr[r-1][c] = 0;
							continue;
						}
						
						int down = r+1<arr.length ? arr[r+1][c] : 0;
						if(down == 1){
							stack.push((r+1)+","+c);
							arr[r+1][c] = 0;
							continue;
						}
						
						stack.pop();
					}
					
					count++;
				}
			}
		}
		
		return count;
	}

}
