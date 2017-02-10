package com.practice.tree.interviewbit;

import java.math.BigInteger;

public class SumRootToLeafs {

	int sum = 0;
	BigInteger mod = new BigInteger("1003");

	public int sumNumbers(TreeNode root) {
		helper(root, "");
		return sum % mod.intValue();
	}

	public void helper(TreeNode node, String rootToLeaf) {
		if (node == null)
			return;

		rootToLeaf += node.val;

		if (node.left == null && node.right == null) {
			BigInteger branchNumsConcatenated = new BigInteger(rootToLeaf);
			sum += branchNumsConcatenated.mod(mod).intValue();
			return;
		}
		
		helper(node.left, rootToLeaf);
		helper(node.right, rootToLeaf);
	}
}
