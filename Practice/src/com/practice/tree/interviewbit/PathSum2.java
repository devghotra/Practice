package com.practice.tree.interviewbit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class PathSum2 {

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode six2 = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		TreeNode eight = new TreeNode(8);

		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		three.right = six;
		four.left = seven;
		six.right = eight;
		five.right = six2;

		PathSum2 ps = new PathSum2();
		ArrayList<ArrayList<Integer>> result = ps.pathSum(one, 14);
		System.out.println(result);

	}

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		if (root == null)
			return result;

		TreeNode nn = root;
		Stack<TreeNode> stack = new Stack<>();
		Set<TreeNode> set = new HashSet<>();  	// to keep track of visited
		List<Integer> list = new ArrayList<>();
		int currentSum = 0;
		
		while (!stack.isEmpty() || nn != null) {
			if (nn != null) {
				stack.push(nn);
				currentSum += nn.val;
				list.add(nn.val);
				nn = nn.left;
				continue;
			}

			TreeNode p = stack.peek();
			if (p.left == null && p.right == null && currentSum == sum) {
				result.add(new ArrayList<>(list));
			}

			// if right is not yet visited, make it a node
			if (p.right != null && !set.contains(p.right)) {
				set.add(p.right);
				nn = p.right;
			} else {
				// both left and right children are traversed, pop the node and subtract from current sum
				p = stack.pop();
				list.remove(list.size() - 1);
				currentSum -= p.val;
			}
		}

		return result;
	}

}
