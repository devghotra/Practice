package com.practice.graph.interviewbit;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	public Node rootNode;
	public List<Node> nodes = new ArrayList<>();
	public int[][] adjMatrix;
	public int size;
	
	public Node getRootNode() {
		return rootNode;
	}
	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}
	
	public void addNode(Node n){
		nodes.add(n);
	}
	
	public void connectNode(Node start,Node end){
		if(adjMatrix == null){
			size=nodes.size();
			adjMatrix = new int[size][size];
		}
		
		int startIndex = nodes.indexOf(start);
		int endIndex = nodes.indexOf(end);
		
		adjMatrix[startIndex][endIndex] = 1;
		adjMatrix[endIndex][startIndex] = 1;
		
	}
	
	public Node getUnvisitedChildNode(Node n){
		int index = nodes.indexOf(n);
		for(int i=0; i<size; i++){
			if(adjMatrix[index][i] == 1 & !nodes.get(i).visited){
				return nodes.get(i);
			}
		}
		
		return null;
	}
	
	// Utility methods for clearing visited property of node
	public void clearNodes() {
		int i = 0;
		while (i < size) {
			Node n = (Node) nodes.get(i);
			n.visited = false;
			i++;
		}
	}

	// Utility methods for printing the node's label
	public void printNode(Node n) {
		System.out.print(n.label + " ");
	}
	
}


class Node 
{
	public char label;
	public boolean visited=false;
	public Node(char l)
	{
		this.label=l;
	}
}