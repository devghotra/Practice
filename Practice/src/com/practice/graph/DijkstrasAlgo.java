package com.practice.graph;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstrasAlgo {

	public static void main(String[] args) {
		DijkstrasAlgo da = new DijkstrasAlgo();
		int[][] grid = { 
				{ 31, 100, 65, 12, 18 }, 
				{ 10, 13, 47, 157, 6 }, 
				{ 100, 113, 174, 11, 33 }, 
				{ 88, 124, 41, 20, 140 }, 
				{ 99, 32, 111, 41, 20 } };

		System.out.println(da.minCost(grid));

	}

	public int minCost(int[][] graph) {

		Comparator<Node> nodeComparator = (n1, n2) -> n1.cost.compareTo(n2.cost);

		// int[][] costGraph = new int[graph.length][graph.length];
		// costGraph[0][0] = graph[0][0];

		PriorityQueue<Node> pq = new PriorityQueue<>(nodeComparator);
		pq.add(new Node(0, 0, graph[0][0]));

		while (!pq.isEmpty()) {
			Node p = pq.poll();

			if (p.i == graph.length - 1 && p.j == graph[0].length - 1) {
				return p.cost;
			}

			if (p.i - 1 >= 0) {
				Node n = new Node(p.i - 1, p.j, p.cost + graph[p.i - 1][p.j]);
				pq.add(n);
				// relax(costGraph, p.i - 1, p.j, n.cost);
			}

			if (p.i + 1 < graph.length) {
				Node n = new Node(p.i + 1, p.j, p.cost + graph[p.i + 1][p.j]);
				pq.add(n);
				// relax(costGraph, p.i + 1, p.j, n.cost);
			}

			if (p.j - 1 >= 0) {
				Node n = new Node(p.i, p.j - 1, p.cost + graph[p.i][p.j - 1]);
				pq.add(n);
				// relax(costGraph, p.i, p.j - 1, n.cost);
			}

			if (p.j + 1 < graph.length) {
				Node n = new Node(p.i, p.j + 1, p.cost + graph[p.i][p.j + 1]);
				pq.add(n);
				// relax(costGraph, p.i, p.j + 1, n.cost);
			}
		}

		return -1;
	}

	private void relax(int[][] costGraph, int i, int j, int newCost) {
		if (i > 0 && i < costGraph.length && j > 0 && j < costGraph.length) {
			if (costGraph[i][j] == 0) {
				costGraph[i][j] = newCost;
			} else {
				costGraph[i][j] = Math.min(costGraph[i][j], newCost);
			}
		}
	}

	class Node {
		int i, j;
		Integer cost;

		public Node(int i, int j, int cost) {
			super();
			this.i = i;
			this.j = j;
			this.cost = cost;
		}
	}

}
