package com.practice.interviewbit.tree;

import java.util.Stack;

public class RecoverBST {

	public static void main(String[] args) {
		RecoverBST inst = new RecoverBST();

		TreeNode one = new TreeNode(3);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(1);

		one.right = two;
		two.right = three;

		inst.recoverTreeWithStack(one);

		System.out.println(one);
	}

	TreeNode first;
	TreeNode second;
	TreeNode prev;

	public void recoverTree(TreeNode root) {
		inOrder(root);
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}

	private void inOrder(TreeNode root) {
		if (root == null)
			return;

		inOrder(root.left);

		if (prev == null)
			prev = root;
		else {
			if (prev.val > root.val) {
				if (first == null) {
					first = prev;
				}
				second = root;
			}
			prev = root;
		}

		inOrder(root.right);
	}

	public void recoverTreeWithStack(TreeNode root) {
		TreeNode first = null;
		TreeNode second = null;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode prev = null;
		TreeNode curr = root;
		while (!stack.empty() || curr != null) {
			if (curr != null) {
				stack.push(curr);
				curr = curr.left;
				continue;
			}

			curr = stack.pop();

			// record the reversed pair.
			if (prev != null && prev.val > curr.val) {
				if (first == null) {
					first = prev;
				}
				second = curr;
			}

			prev = curr;
			curr = curr.right;
		}

		int temp = first.val;
		first.val = second.val;
		second.val = temp;

	}

	public void recoverTreeWithLimits(TreeNode root) {
		recoverTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private TreeNode recoverTree(TreeNode node, int min, int max) {
		if (node == null)
			return null;

		TreeNode leftNode = null;
		TreeNode rightNode = null;

		if (node.val < min) {
			rightNode = recoverTree(node.right, node.val, max);
		} else if (node.val > max) {
			leftNode = recoverTree(node.left, min, node.val);
		} else {
			leftNode = recoverTree(node.left, min, node.val);
			rightNode = recoverTree(node.right, node.val, max);
		}

		if (leftNode != null && rightNode != null) {
			swapVals(leftNode, rightNode);
			return null;
		}

		if (leftNode != null) {
			if (leftNode.val >= min && leftNode.val <= max) {
				swapVals(leftNode, node);
				return null;
			}

			return leftNode;
		}

		if (rightNode != null) {
			if (rightNode.val >= min && rightNode.val <= max) {
				swapVals(rightNode, node);
				return null;
			}

			return rightNode;
		}

		if (node.val < min || node.val > max) {
			return node;
		}

		return null;
	}

	private void swapVals(TreeNode n1, TreeNode n2) {
		int temp = n1.val;
		n1.val = n2.val;
		n2.val = temp;
	}

}