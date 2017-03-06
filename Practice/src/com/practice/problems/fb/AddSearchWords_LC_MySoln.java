package com.practice.problems.fb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// FB interview question
public class AddSearchWords_LC_MySoln {

	Node root = new Node(' ');

	public void setup(List<String> list) {
		for (String word : list) {
			Node parent = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				Node n = parent.children.get(c);
				if (n == null) {
					n = new Node(c);
					parent.children.put(c, n);
				}
				parent = n;
			}
		}
	}

	public boolean isMember(String word) {
		if (word.charAt(0) != '.')
			return isMember(word, root.children.get(word.charAt(0)));
		else {
			for (Node child : root.children.values()) {
				boolean res = isMember(word, child);
				if (res)
					return true;
			}
			
			return false;
		}
	}

	public boolean isMember(String word, Node startingNode) {
		Node parent = startingNode;

		char firstChar = word.charAt(0);
		if (firstChar != '.' && firstChar != startingNode.val) {
			return false;
		}

		for (int i = 1; i < word.length(); i++) {
			char c = word.charAt(i);

			if (c == '.') {
				for (Node child : parent.children.values()) {
					boolean res = isMember(word.substring(i + 1), child);
					if (res) {
						return true;
					}
				}
			} else {
				Node n = parent.children.get(c);

				if (n == null)
					return false;

				parent = n;

			}
		}

		return true;
	}

	static class Node {
		char val;
		Map<Character, Node> children;

		public Node(char c) {
			this.val = c;
			children = new HashMap<>();
		}
	}
}
