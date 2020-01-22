package com.practice.tree;

public class InvertBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode invertTree(TreeNode root) {
		if(root == null)
			return root;
		
		TreeNode leftInverted = invertTree(root.left);
		TreeNode rightInverted = invertTree(root.right);
		
		root.left = rightInverted;
		root.right = leftInverted;
		
		return root;
	}
}