package com.practice.tree.interviewbit;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<>();
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode nn = root;
		
		while(!stack.isEmpty() || nn != null){
			if(nn != null){
				stack.push(nn);
				nn = nn.left;
				continue;
			}
			
			TreeNode pn = stack.pop();
			result.add(pn.val);
			nn = pn.right;
		}
		
		return result;
	}
}
