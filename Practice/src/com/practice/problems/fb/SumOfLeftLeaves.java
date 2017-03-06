package com.practice.problems.fb;

import com.practice.tree.interviewbit.TreeNode;

public class SumOfLeftLeaves {
	
	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		
		System.out.println(sumOfLeftLeaves(one));
		
	}

	private static int sumOfLeftLeaves(TreeNode root) {
		return sumOfLeftLeaves(root, 0, false);
	}

	public static int sumOfLeftLeaves(TreeNode root, int sum, boolean isLeft) {
		if(root == null)
			return sum;
		
		if(root.left == null && root.right == null && isLeft)
			return sum + root.val;
		
		return sumOfLeftLeaves(root.left, sum, true) + sumOfLeftLeaves(root.right, sum, false);
		
	}
}
