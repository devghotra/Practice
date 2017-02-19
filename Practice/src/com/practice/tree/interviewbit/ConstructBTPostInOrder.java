package com.practice.tree.interviewbit;

import java.util.List;

import com.google.common.collect.Lists;

public class ConstructBTPostInOrder {

	public static void main(String[] args) {
		ConstructBTPostInOrder inst = new ConstructBTPostInOrder();
		List<Integer> inorder = Lists.newArrayList(17, 12, 24, 13, 2, 22, 9, 20, 18, 23, 3, 15, 21, 10, 4, 11, 19, 14, 16, 7, 1, 5, 6, 8 );
		List<Integer> postorder = Lists.newArrayList( 17, 13, 2, 22, 24, 18, 20, 9, 15, 3, 11, 4, 10, 14, 16, 19, 1, 7, 21, 23, 12, 6, 8, 5 );

		TreeNode root = inst.buildTree(inorder, postorder);
		System.out.println(root);

	}

	public TreeNode buildTree(List<Integer> inorder, List<Integer> postorder) {

		if (inorder.isEmpty() || postorder.isEmpty())
			return null;

		// last element of post order is always root
		TreeNode root = new TreeNode(postorder.get(postorder.size() - 1));
		
		// find roots index in inorder
		int rootIndex = inorder.indexOf(root.val); // Optimization - use map to gain time complexity
				
		// all nodes prior to rootIndex will be in left
		root.left = buildTree(inorder.subList(0, rootIndex), postorder.subList(0, rootIndex));
		
		// after rootIndex will be right
		root.right = buildTree(inorder.subList(rootIndex + 1, inorder.size()), postorder.subList(rootIndex, postorder.size() - 1));

		return root;
	}

}
