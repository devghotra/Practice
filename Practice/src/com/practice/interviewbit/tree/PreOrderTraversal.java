package com.practice.interviewbit.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class PreOrderTraversal {

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

		PreOrderTraversal inst = new PreOrderTraversal();
		System.out.println(inst.preorderTraversal(n1));

	}

	public List<Integer> preorderTraversal(TreeNode root) {

		ArrayList<Integer> result = new ArrayList<>();
		
		if(root == null)
            return result;
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			TreeNode pn = stack.pop();
			result.add(pn.val);
			
			if(pn.right != null)
				stack.push(pn.right);
			
			if(pn.left != null)
				stack.push(pn.left);
		}
		
		return result;
	
		
	}
}
