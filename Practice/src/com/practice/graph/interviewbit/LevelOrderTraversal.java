package com.practice.graph.interviewbit;

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
		
		Queue<TreeNode> nodeQ = new LinkedList<>();
		nodeQ.add(root);
		
		Queue<Integer> levelQ = new LinkedList<>();
		levelQ.add(1);
		
		int previousLevel = 0;
		ArrayList<Integer> levelList = null;
		
		while(!nodeQ.isEmpty()){
			int level = levelQ.poll();
			if(level > previousLevel){
				levelList = new ArrayList<>();
				result.add(levelList);
				previousLevel = level;
			}
			
			TreeNode node = nodeQ.poll();
			levelList.add(node.val);
			
			if(node.left != null){
				nodeQ.add(node.left);
				levelQ.add(level+1);
			}
			
			if(node.right != null){
				nodeQ.add(node.right);
				levelQ.add(level+1);
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