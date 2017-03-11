package com.practice.tree;

import java.util.Stack;

public class BSTIterator {

	Stack<TreeNode> stack = new Stack<>();

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode three = new TreeNode(3);
		TreeNode eight = new TreeNode(8);
		TreeNode two = new TreeNode(2);
		TreeNode four = new TreeNode(4);
		TreeNode seven = new TreeNode(7);
		TreeNode nine = new TreeNode(9);

		root.left = three;
		root.right = eight;

		three.left = two;
		three.right = four;

		eight.left = seven;
		eight.right = nine;

		BSTIterator i = new BSTIterator(root);
		while (i.hasNext()) {
			System.out.println(i.next());
		}

	}

	public BSTIterator(TreeNode root) {
		push(root);
	}

	private void push(TreeNode p) {
		while (p != null) {
			stack.push(p);
			p = p.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node = stack.pop();
		if (node.right != null) {
			push(node.right);
		}
		return node.val;
	}
}
