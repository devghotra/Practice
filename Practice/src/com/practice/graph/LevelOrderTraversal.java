package com.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
	
	public static void main(String[] args){
		TreeNode n3 = new TreeNode(3);
		TreeNode n9 = new TreeNode(9);
		TreeNode n20 = new TreeNode(20);
		TreeNode n15 = new TreeNode(15);
		TreeNode n7 = new TreeNode(7);
		
		n3.left = n9;
		n3.right = n20;
		n20.left = n15;
		n20.right = n7;
				
		levelOrder(n3);
	}
	
	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		if(root == null)
			return result;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		ArrayList<Integer> resRow = new ArrayList<>();
		List<TreeNode> nextNodes = new ArrayList<>();

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			
			if (node.left != null)
				nextNodes.add(node.left);

			if (node.right != null)
				nextNodes.add(node.right);
			
			resRow.add(node.val);

			if (queue.isEmpty()) {
				result.add(resRow);
				queue.addAll(nextNodes);
				resRow = new ArrayList<>();
				nextNodes.clear();
			}
		}

		return result;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}