package com.practice.tree.interviewbit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class PostOrderTraversal {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);

		n1.left = n2;
		n1.right = n3;

		n2.left = n4;
		n2.right = n5;

		n3.left = n6;
		n3.right = n7;

		PostOrderTraversal inst = new PostOrderTraversal();
		System.out.println(inst.postorderTraversal(n1));

	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();

		Set<TreeNode> set = new HashSet<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode nn = root;

		while (!stack.isEmpty() || nn != null) {
			if (nn != null) {
				stack.push(nn);
				nn = nn.left;
				continue;
			}

			TreeNode pn = stack.peek();
			if (pn.right != null && !set.contains(pn.right)) {
				nn = pn.right;
			} else {
				pn = stack.pop();
				set.add(pn);
				result.add(pn.val);
			}

		}

		return result;
	}
	
	// another approach is to break reference to right child after right child is pushed to stack -> pn.right = null;

	public ArrayList<Integer> postorderTraversalV1(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode nn = root;

		while (!queue.isEmpty() || nn != null) {
			if (nn != null) {
				queue.add(nn);
				if (nn.left != null)
					stack.push(nn.left);

				nn = nn.right;
				continue;
			}

			TreeNode pn = queue.poll();
			result.add(0, pn.val);

			if (queue.isEmpty() && !stack.isEmpty())
				nn = stack.pop();

		}

		return result;
	}
}
