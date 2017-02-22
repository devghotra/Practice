package com.practice.tree.interviewbit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
        TreeNode two = new TreeNode(2);
        TreeNode four = new TreeNode(4);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode minusOne = new TreeNode(-1);
        TreeNode five = new TreeNode(5);
        TreeNode one2 = new TreeNode(1);
        TreeNode six = new TreeNode(6);
        TreeNode eight = new TreeNode(8);
        
        root.left = two;
        root.right = four;
        
        two.left = one;
        
        four.left = three;
        four.right = minusOne;
        
        one.left = five;
        one.right = one2;
        
        three.right = six;
        minusOne.right = eight;
		
		ZigzagTraversal o = new ZigzagTraversal();
		ArrayList<ArrayList<Integer>> result = o.zigzagLevelOrderRec(root);
		System.out.println(result);

	}

	/*
	 * Just do level traversal (left -> right), 
	 * while adding to result check the level
	 * For odd levels - Add as is
	 * For even levels - Reverse the order by inserting at beginning 
	 */
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		int level = 1;
		
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
			
			if(level % 2 == 1)
				resRow.add(node.val);
			else
				resRow.add(0, node.val);

			if (queue.isEmpty()) {
				result.add(resRow);
				queue.addAll(nextNodes);
				resRow = new ArrayList<>();
				nextNodes.clear();
				level++;
			}
		}

		return result;
	}
	
	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	
	public ArrayList<ArrayList<Integer>> zigzagLevelOrderRec(TreeNode root) {
		helper(root, 1);
		return result;
	}

	public void helper(TreeNode node, int level) {
		if(node == null)
			return;
		
		ArrayList<Integer> levelList = null;
		if(result.size() < level){
			levelList = new ArrayList<>();
			result.add(levelList);
		} else{
			levelList = result.get(level-1);
		}
		
		if(level % 2 == 1)
			levelList.add(node.val);
		else
			levelList.add(0, node.val);
		
		helper(node.left, level+1);
		helper(node.right, level+1);
		
	}
}
