package com.practice.interviewbit.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.collect.Lists;

public class ConstructBTPostInOrder {

	public static void main(String[] args) {
		ConstructBTPostInOrder inst = new ConstructBTPostInOrder();
		List<Integer> inorder = Lists.newArrayList(2, 0, 1, 3);
		List<Integer> postorder = Lists.newArrayList(0, 2, 3, 1);

		TreeNode root = inst.buildTree(inorder, postorder);
		System.out.println(root);

	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		List<Integer> inorderList = new ArrayList<>();
		List<Integer> postorderList = new ArrayList<>();

		for (int i = 0; i < postorder.length; i++) {
			inorderList.add(inorder[i]);
			postorderList.add(postorder[i]);
		}

		return buildTree(inorderList, postorderList);
	}

	public TreeNode buildTree(List<Integer> inorder, List<Integer> postorder) {
		Map<Integer, Integer> inorderIndexMap = new HashMap<>();
		final AtomicInteger i = new AtomicInteger(-1);
		inorder.stream().forEach(num -> inorderIndexMap.put(num, i.incrementAndGet()));
		return buildTree(inorder, postorder, inorderIndexMap, 0, postorder.size() - 1, 0, inorder.size() - 1);
	}

	public TreeNode buildTree(List<Integer> inorder, List<Integer> postorder, Map<Integer, Integer> inorderIndexMap, 
			int postStart, int postEnd, int inStart, int inEnd) {

		if (postStart > postEnd || inStart > inEnd) {
			return null;
		}

		int num = postorder.get(postEnd);
		TreeNode node = new TreeNode(num);

		int index = inorderIndexMap.get(num);
		int len = inEnd - index;

		node.right = buildTree(inorder, postorder, inorderIndexMap, postEnd - len, postEnd - 1, index + 1, inEnd);
		node.left = buildTree(inorder, postorder, inorderIndexMap, postStart, postEnd - len - 1, inStart, index - 1);

		return node;
	}

}
