package com.practice.tree.interviewbit;

public class MinDepthBinaryTree {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);

		n1.left = n2;
		n1.right = n3;

		// n2.left = n4;
		// n2.right = n5;

		n3.left = n6;
		n3.right = n7;

		MinDepthBinaryTree inst = new MinDepthBinaryTree();
		System.out.println(inst.minDepth(n1));

	}

	int minDepth = Integer.MAX_VALUE;
	
	public int minDepth(TreeNode root) {
		return getMinDepth(root, 1);
	}

	public int getMinDepth(TreeNode root, int currentDepth) {
		if (root == null)
			return 0;
		
		if (root.left == null && root.right == null) {
			minDepth = Math.min(currentDepth, minDepth);
		}
		
		getMinDepth(root.left, currentDepth+1);
		getMinDepth(root.right, currentDepth+1);
		
		return minDepth;
		
	}

}
