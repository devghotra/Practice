package com.practice.interviewbit.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.collect.Lists;

public class ConstructBTPreInOrder {

	public static void main(String[] args) {
		ConstructBTPreInOrder inst = new ConstructBTPreInOrder();
		List<Integer> preorder = Lists.newArrayList(1, 2, 0, 3);
		List<Integer> inorder = Lists.newArrayList(2, 0, 1, 3);

		TreeNode root = inst.buildTree(preorder, inorder);
		System.out.println(root);

	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		List<Integer> preorderList = new ArrayList<>();
		List<Integer> inorderList = new ArrayList<>();

		for (int i = 0; i < preorder.length; i++) {
			preorderList.add(preorder[i]);
			inorderList.add(inorder[i]);
		}

		return buildTree(preorderList, inorderList);
	}

	public TreeNode buildTree(List<Integer> preorder, List<Integer> inorder) {
		Map<Integer, Integer> inorderIndexMap = new HashMap<>();
		final AtomicInteger i = new AtomicInteger(-1);
		inorder.stream().forEach(num -> inorderIndexMap.put(num, i.incrementAndGet()));
		return buildTree(preorder, inorder, inorderIndexMap, 0, preorder.size() - 1, 0, inorder.size() - 1);
	}

	public TreeNode buildTree(List<Integer> preorder, List<Integer> inorder, Map<Integer, Integer> inorderIndexMap, 
			int preStart, int preEnd, int inStart, int inEnd) {

		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}

		int num = preorder.get(preStart);
		TreeNode node = new TreeNode(num);

		int index = inorderIndexMap.get(num);
		int len = index - inStart;

		node.left = buildTree(preorder, inorder, inorderIndexMap, preStart + 1, preStart + len, inStart, index - 1);
		node.right = buildTree(preorder, inorder, inorderIndexMap, preStart + len + 1, preEnd, index + 1, inEnd);

		return node;
	}

	/*
	 * private TreeNode buildTree(List<Integer> preorder, List<Integer> inorder)
	 * {
	 * if (preorder.isEmpty())
	 * return null;
	 * 
	 * int num = preorder.get(0);
	 * TreeNode node = new TreeNode(num);
	 * 
	 * int inorderIndex = inorder.indexOf(num);
	 * node.left = buildTree(preorder.subList(1, inorderIndex + 1),
	 * inorder.subList(0, inorderIndex));
	 * node.right = buildTree(preorder.subList(inorderIndex + 1,
	 * preorder.size()), inorder.subList(inorderIndex + 1, inorder.size()));
	 * 
	 * return node;
	 * }
	 */

}
