package com.practice.interviewbit.tree;

public class PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int hasPathSum(TreeNode root, int sum) {
		return hasPathSumLC(root, sum) ? 1 : 0;
	}
	
	public boolean hasPathSumLC(TreeNode root, int sum) {

		if (root == null)
			return false;

		if (root.val == sum && root.left == null && root.right == null)
			return true;

		boolean leftResult = hasPathSumLC(root.left, sum - root.val);
		boolean rightResult = hasPathSumLC(root.right, sum - root.val);

		return leftResult || rightResult;
	}

}
