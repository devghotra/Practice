package com.practice.tree.interviewbit;

public class MaxDepthBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxDepth(TreeNode root) {
		return getMaxDepth(root, 0);
	}

	public int getMaxDepth(TreeNode root, int currentDepth) {
		if (root == null)
			return currentDepth;

		int leftDepth = getMaxDepth(root.left, currentDepth+1);
		int rightDepth = getMaxDepth(root.right, currentDepth+1);

		return Math.max(leftDepth, rightDepth);
	}

}
