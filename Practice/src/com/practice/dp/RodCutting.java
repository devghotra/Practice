package com.practice.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RodCutting {

	public static void main(String[] args) {
		RodCutting rc = new RodCutting();
		
		Integer[] weekIndexes = {1,2,5}; // 6
		//Integer[] weekIndexes = {40, 70, 74, 82, 108, 114, 124, 130, 153, 169, 184, 190, 228, 247, 248, 265, 267, 273, 276, 277, 281, 292, 301, 319, 348, 351, 390, 447, 450, 455, 463, 468, 473, 486}; // 500
		
		long start = System.currentTimeMillis();
		System.out.println(rc.rodCut(6, Arrays.asList(weekIndexes)));
		System.out.println(System.currentTimeMillis() - start);
	}

	public ArrayList<Integer> rodCut(int length, List<Integer> weakIndexes) {
		
		if(weakIndexes == null || weakIndexes.isEmpty() || length < 1){
			return new ArrayList<>();
		}

		Node[][] dp = new Node[length + 1][length + 1];
		boolean[] weakPoints = new boolean[length + 1];

		for (int weekIndex : weakIndexes) {
			weakPoints[weekIndex] = true;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < dp.length - i; j++) {
				int r = j;
				int c = i + j;

				for (int k = r + 1; k < c; k++) {
					if (weakPoints[k]) {
						int cost = (c - r) + (dp[r][k] == null ? 0 : dp[r][k].cost) + (dp[k][c] == null ? 0 : dp[k][c].cost);
						
						if(dp[r][c] == null || cost < dp[r][c].cost){
							Node node = new Node(cost, k);
							
							if(dp[r][k] != null){
								node.points.addAll(dp[r][k].points);
							}
							
							if(dp[k][c] != null){
								node.points.addAll(dp[k][c].points);
							}
							
							dp[r][c] = node;
						}
					}
				}
			}
		}

		return dp[0][length].points;
	}
	
	static class Node{
		int cost;
		ArrayList<Integer> points = new ArrayList<>();
		
		public Node(int cost, int firstPoint){
			this.cost = cost;
			points.add(firstPoint);
		}
	}

}
