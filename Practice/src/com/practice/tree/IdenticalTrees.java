package com.practice.tree;

public class IdenticalTrees {

	public static void main(String[] args) {
		
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null && q == null)
			return true;

		if (p == null || q == null || p.val != q.val)
			return false;

		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public int isSameTreeIB(TreeNode a, TreeNode b) {

		if (a == null && b == null)
			return 1;

		if (a == null || b == null || a.val != b.val)
			return 0;

		return isSameTreeIB(a.left, b.left) & isSameTreeIB(a.right, b.right);
	}

}
