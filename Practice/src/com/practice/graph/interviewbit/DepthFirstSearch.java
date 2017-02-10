package com.practice.graph.interviewbit;

import java.util.Stack;

public class DepthFirstSearch {

	public static void main(String[] args) {
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
		
		System.out.println("\nDFS Traversal of a tree is ------------->");
		dfs(graph);

	}
	
	public static void dfs(Graph graph){
		Stack<Node> stack = new Stack<>();
		Node rootNode = graph.getRootNode();
		graph.printNode(rootNode);
		rootNode.visited=true;
		stack.push(rootNode);
		
		while(!stack.isEmpty()){
			Node n = stack.peek();
			Node childNode = graph.getUnvisitedChildNode(n);
			if(childNode != null){
				graph.printNode(childNode);
				childNode.visited=true;
				stack.push(childNode);
			} else{
				stack.pop();
			}
		}
	}

}
