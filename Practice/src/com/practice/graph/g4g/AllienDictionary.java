package com.practice.graph.g4g;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class AllienDictionary {

	public static void main(String[] args) {
		AllienDictionary ad = new AllienDictionary();
		String[] words = { "baa", "abcd", "abca", "cab", "cad"};
		System.out.println(ad.alienOrder(words));

	}

	public String alienOrder(String[] words) {
		StringBuilder sb = new StringBuilder();

		Map<Character, Node> nodeMap = new HashMap<>();

		buildGraph(words, nodeMap);

		Stack<Node> stack = new Stack<>();
		Node firstNode = nodeMap.get(words[0].charAt(0)); // words[0].charAt(0)) will be highest char
		firstNode.visited = true;
		stack.push(firstNode); 
		
		while (!stack.isEmpty()) {
			Node n = stack.peek();

			Node nn = n.getNextUnvisitedChild();
			if(nn != null){
				stack.push(nn);
				nn.visited = true;
			} else{
				Node p = stack.pop();
				sb.insert(0, p.c);
			}
		}

		return sb.toString();
	}

	private void buildGraph(String[] words, Map<Character, Node> nodeMap) {
		for (int i = 0; i < words.length - 1; i++) {
			String thisWord = words[i];
			String nextWord = words[i + 1];

			for (int j = 0; j < Math.min(thisWord.length(), nextWord.length()); j++) {
				if (thisWord.charAt(j) != nextWord.charAt(j)) {
					char biggerChar = thisWord.charAt(j);
					char smallerChar = nextWord.charAt(j);

					Node biggerCharNode = nodeMap.get(biggerChar);
					if (biggerCharNode == null) {
						biggerCharNode = new Node(biggerChar);
						nodeMap.put(biggerChar, biggerCharNode);
					}

					Node smallerCharNode = nodeMap.get(smallerChar);
					if (smallerCharNode == null) {
						smallerCharNode = new Node(smallerChar);
						nodeMap.put(smallerChar, smallerCharNode);
					}

					biggerCharNode.smallerNodes.add(smallerCharNode);
					break;
				}
			}
		}
	}

	class Node {
		char c;
		List<Node> smallerNodes = new ArrayList<>();
		boolean visited;

		Node(char c) {
			this.c = c;
		}
		
		public Node getNextUnvisitedChild(){
			for(Node n : smallerNodes){
				if(!n.visited)
					return n;
			}
			
			return null;
		}

		@Override
		public String toString() {
			return "[ " + c + ", visited=" + visited + "]";
		}

	}

}
