package com.practice.interviewbit.tree;

public class SymmetricBinaryTree {

	public static void main(String[] args) {
		
	}
	
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;

		return isSymmetric(root.left, root.right);
	}

	public boolean isSymmetric(TreeNode a, TreeNode b) {

		if (a == null && b == null)
			return true;

		if (a == null || b == null || a.val != b.val)
			return false;

		return isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);

	}
	
	public int isSymmetricIB(TreeNode root) {
		if (root == null)
			return 1;

		return isSymmetric(root.left, root.right) ? 1 : 0;
	}

}
