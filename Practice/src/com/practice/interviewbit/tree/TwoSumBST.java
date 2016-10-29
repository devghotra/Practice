package com.practice.interviewbit.tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TwoSumBST {

	public static void main(String[] args) {
		TwoSumBST inst = new TwoSumBST();
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

		System.out.println(inst.t2Sum(root, 18));

	}

	public int t2Sum(TreeNode root, int k) {
		Set<Integer> set = new HashSet<>();
		return inorderAndCheck(root, set, k) ? 1 : 0;
	}

	private boolean inorderAndCheck(TreeNode root, Set<Integer> set, int k) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;

		while (!stack.empty() || p != null) {

			// if it is not null, push to stack and go down the tree to left
			if (p != null) {
				stack.push(p);
				p = p.left;
				continue;
			}

			// if no left child pop stack, process the node then let p point to the right
			TreeNode t = stack.pop();
			if (set.contains(k - t.val)) {
				return true;
			}
			set.add(t.val);
			p = t.right;
		}
		return false;
	}

}
