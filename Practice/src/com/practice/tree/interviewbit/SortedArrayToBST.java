package com.practice.tree.interviewbit;

import java.util.Arrays;
import java.util.List;

public class SortedArrayToBST {

	public static void main(String[] args) {
		SortedArrayToBST bst = new SortedArrayToBST();
		Integer[] nums = { 1, 2, 3, 4, 5 };
		TreeNode root = bst.sortedArrayToBST(Arrays.asList(nums));
		System.out.println(root.val);
	}

	public TreeNode sortedArrayToBST(final List<Integer> nums) {
		if (nums.size() == 0)
			return null;

		return sortedArrayToBST(nums, 0, nums.size() - 1);
	}

	public TreeNode sortedArrayToBST(List<Integer> nums, int begin, int end) {

		if (end < begin)
			return null;
		
		int mid = (begin + end) / 2;
		TreeNode root = new TreeNode(nums.get(mid));

		root.left = sortedArrayToBST(nums, begin, mid - 1);
		root.right = sortedArrayToBST(nums, mid + 1, end);

		return root;
	}

}
