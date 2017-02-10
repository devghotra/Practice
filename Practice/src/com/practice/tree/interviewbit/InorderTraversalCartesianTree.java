package com.practice.tree.interviewbit;

import java.util.Arrays;
import java.util.List;

public class InorderTraversalCartesianTree {

	public static void main(String[] args) {
		InorderTraversalCartesianTree inst = new InorderTraversalCartesianTree();
		Integer[] nums = { 5, 10, 40, 33, 30, 35, 50 };
		TreeNode root = inst.buildTree(Arrays.asList(nums));
		System.out.println(root);

	}

	public TreeNode buildTree(List<Integer> nums) {
		return buildTree(nums, 0, nums.size() - 1);
	}

	private TreeNode buildTree(List<Integer> nums, int start, int end) {

		TreeNode node = null;

		int maxElementIndex = getIndexOfMax(nums, start, end);
		if (maxElementIndex != -1) {
			node = new TreeNode(nums.get(maxElementIndex));
			node.left = buildTree(nums, start, maxElementIndex - 1);
			node.right = buildTree(nums, maxElementIndex + 1, end);
		}

		return node;
	}

	private int getIndexOfMax(List<Integer> nums, int start, int end) {

		int max = 0;
		int maxElementIndex = -1;
		for (int i = start; i <= end; i++) {
			if (maxElementIndex == -1 || nums.get(i) > max) {
				max = nums.get(i);
				maxElementIndex = i;
			}
		}

		return maxElementIndex;
	}

	public TreeNode buildTreeV1(List<Integer> nums) {

		TreeNode root = null;
		TreeNode prevNode = null;
		for (int i = 0; i < nums.size(); i++) {
			TreeNode node = new TreeNode(nums.get(i));

			if (root == null) {
				root = node;
			} else {
				if (node.val > root.val) {
					node.left = root;
					root = node;
				} else if (node.val < prevNode.val) {
					prevNode.right = node;
				} else {
					TreeNode checkNode = root;
					while (checkNode.right != null) {
						if (checkNode.right.val < node.val) {
							node.left = checkNode.right;
							checkNode.right = node;
							break;
						}
						checkNode = checkNode.right;
					}

					if (checkNode.right == null) {
						checkNode.right = node;
					}
				}
			}

			prevNode = node;
		}

		return root;
	}

}
