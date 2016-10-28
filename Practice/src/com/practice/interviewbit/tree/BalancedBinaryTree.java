package com.practice.interviewbit.tree;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);

		root.left = two;
		// root.right = three;

		// two.left = four;
		// four.left = five;
		// five.left = six;

		BalancedBinaryTree o = new BalancedBinaryTree();
		System.out.println(o.isBalanced(root));

	}

	public int isBalanced(TreeNode root) {
		int height = getHeight(root);
		return height != -1 ? 1 : 0;
	}

	public int getHeight(TreeNode root) {
		if (root == null)
			return 0;

		int leftTreeHeight = getHeight(root.left);
		if (leftTreeHeight == -1)
			return -1;
		
		int rightTreeHeight = getHeight(root.right);
		if (rightTreeHeight == -1)
			return -1;

		if (Math.abs(leftTreeHeight - rightTreeHeight) > 1)
			return -1;
		
		return Math.max(leftTreeHeight, rightTreeHeight) + 1;

	}
}