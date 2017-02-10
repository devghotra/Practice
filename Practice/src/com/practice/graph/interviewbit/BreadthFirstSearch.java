package com.practice.graph.interviewbit;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
	
	public static void main(String[] args){
		Node nA = new Node('A');
		Node nB = new Node('B');
		Node nC = new Node('C');
		Node nD = new Node('D');
		Node nE = new Node('E');
		Node nF = new Node('F');
		
		Graph graph = new Graph();
		graph.addNode(nA);
		graph.addNode(nB);
		graph.addNode(nC);
		graph.addNode(nD);
		graph.addNode(nE);
		graph.addNode(nF);
		graph.setRootNode(nA);
		
		graph.connectNode(nA,nB);
		graph.connectNode(nA,nC);
		graph.connectNode(nA,nD);	
		graph.connectNode(nB,nE);
		graph.connectNode(nB,nF);
		graph.connectNode(nC,nF);
		
		System.out.println("\nBFS Traversal of a tree is ------------->");
		bfs(graph);
		
	}

	public static void bfs(Graph graph){
		Queue<Node> Q = new LinkedList<>();
		Node rootNode = graph.getRootNode();
		graph.printNode(rootNode);
		rootNode.visited = true;
		Q.add(rootNode);
		while(!Q.isEmpty()){
			Node n = Q.poll();
			Node childNode =graph.getUnvisitedChildNode(n);
			while(childNode != null){
				graph.printNode(childNode);
				childNode.visited = true;
				Q.add(childNode);
				
				childNode = graph.getUnvisitedChildNode(n);
			}
		}
	}
}
