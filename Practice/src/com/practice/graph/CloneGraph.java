package com.practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CloneGraph {

	public static void main(String[] args) {
		CloneGraph cg = new CloneGraph();
		
		UndirectedGraphNode n01 = new UndirectedGraphNode(0);
		UndirectedGraphNode n02 = new UndirectedGraphNode(0);
		UndirectedGraphNode n03 = new UndirectedGraphNode(0);
		
		n01.neighbors.add(n02);
		n01.neighbors.add(n03);
		
		n02.neighbors.add(n01);
		n02.neighbors.add(n03);
		
		n03.neighbors.add(n01);
		n03.neighbors.add(n02);
		
		UndirectedGraphNode copy = cg.cloneGraph(n01);
		
		System.out.println(copy);
	}
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode root) {
		
		if(root == null)
			return null;

		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		UndirectedGraphNode copyRoot = new UndirectedGraphNode(root.label);
		map.put(root, copyRoot);
		
		Set<UndirectedGraphNode> processedNodesSet = new HashSet<>();
		
		Queue<UndirectedGraphNode> Q = new LinkedList<>();
		processedNodesSet.add(root);
		Q.add(root);
		
		
		while(!Q.isEmpty()){
			UndirectedGraphNode node = Q.poll();
			UndirectedGraphNode copy = null;
			
			if(map.containsKey(node)){
				copy = map.get(node);
			} else{
				copy = new UndirectedGraphNode(node.label);
				map.put(node, copy);
			}
			
			for(UndirectedGraphNode neighbor : node.neighbors){
				UndirectedGraphNode neighborCopy = null;
				
				if(map.containsKey(neighbor)){
					neighborCopy = map.get(neighbor);
				} else{
					neighborCopy = new UndirectedGraphNode(neighbor.label);
					map.put(neighbor, neighborCopy);
				}
				
				copy.neighbors.add(neighborCopy);
				
				if(!processedNodesSet.contains(neighbor)){
					processedNodesSet.add(neighbor);
					Q.add(neighbor);
				}
			}
		}
		
		return copyRoot;
	}

	static class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}
}
