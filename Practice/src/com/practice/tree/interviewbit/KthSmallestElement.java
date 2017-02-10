package com.practice.tree.interviewbit;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestElement {

	public static void main(String[] args) {
		KthSmallestElement ks = new KthSmallestElement();
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

		System.out.println(ks.kthsmallest(root, 5));

	}

	public int kthsmallest(TreeNode root, int k) {
		List<TreeNode> list = new ArrayList<>();
		inorder(root, list, k);
		return list.get(k - 1).val;
	}

	private void inorderWithRec(TreeNode node, List<TreeNode> list, int k) {
		if (node == null)
			return;

		inorderWithRec(node.left, list, k);
		list.add(node);
		if (list.size() == k) {
			return;
		}
		inorderWithRec(node.right, list, k);

	}

	private void inorder(TreeNode root, List<TreeNode> list, int k) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;

		while (!stack.empty() || p != null) {

			// if it is not null, push to stack and go down the tree to left
			if (p != null) {
				stack.push(p);
				p = p.left;
				continue;
			}

			// if no left child pop stack, process the node then let p point to
			// the right
			TreeNode t = stack.pop();
			list.add(t);
			if (list.size() == k) {
				return;
			}
			p = t.right;
		}

	}

}
