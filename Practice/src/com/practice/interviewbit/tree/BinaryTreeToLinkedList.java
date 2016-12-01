package com.practice.interviewbit.tree;

public class BinaryTreeToLinkedList {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		
		TreeNode root = n1;
		
		n1.left = n2;
		n1.right = n5;
		
		n2.left = n3;
		n2.right = n4;
		
		n5.right = n6;
		
		BinaryTreeToLinkedList inst = new BinaryTreeToLinkedList();
		inst.flatten(root);
		
		System.out.println(root);

	}

	public TreeNode flatten(TreeNode root) {
		helper(root);
		return root;
	}
	
	private TreeNode helper(TreeNode node){
		if(node == null)
			return null;
		
		if(node.left == null && node.right == null)
			return node;
		
		TreeNode leftLast = helper(node.left);
		TreeNode rightLast = helper(node.right);
		
		if(leftLast == null)
			leftLast = node;
		
		TreeNode prevRight = node.right;
		node.right = node.left;
		node.left = null;
		
		leftLast.right = prevRight;
		
		return rightLast != null ? rightLast : leftLast;
	}
	
	
}
