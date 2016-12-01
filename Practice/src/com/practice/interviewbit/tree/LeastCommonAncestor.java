package com.practice.interviewbit.tree;

public class LeastCommonAncestor {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		//root.left = two;
		//root.right = three;
		//two.left = four;
		//two.right = five;
		//three.left = six;
		//five.left = seven;
		LeastCommonAncestor o = new LeastCommonAncestor();
		System.out.println(o.lca(root, 1, 1));

	}

	/*
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || p == null || q == null)
			return null;
		
		if(root.val == p.val || root.val == q.val){
			return root;
		}
		
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		
		return left != null && right != null ? root : left != null ? left : right;
	}*/
	public TreeNode lowestCommonAncestorLC(TreeNode root, TreeNode p, TreeNode q) {
		//helper(root, p, q);
		return lca;
	}
	
	TreeNode lca = null;
	
	public int lca(TreeNode root, int p, int q) {
		helper(root, p, q);
		return lca == null ? -1 : lca.val;
	}
	
	
	public int helper(TreeNode root, int p, int q) {
		int matchedNodes = 0;
		if(root == null || lca != null)
			return matchedNodes;
		
		if(root.val == p){
			matchedNodes++;
		}
		
		if(root.val == q){
			matchedNodes++;
		}
		
		matchedNodes += helper(root.left, p, q);
		matchedNodes += helper(root.right, p, q);
		
		if(matchedNodes == 2 && lca == null){
			lca = root;
		} 
		
		return matchedNodes;
	}
	
}
