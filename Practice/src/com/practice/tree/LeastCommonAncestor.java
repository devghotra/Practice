package com.practice.tree;

public class LeastCommonAncestor {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode four1 = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		
		root.left = two;
		root.right = three;
		two.right = four;
		three.left = four1;
		
		LeastCommonAncestor o = new LeastCommonAncestor();
		System.out.println(o.lca(root, 4, 4));

	}

	TreeNode lca = null;
	
	/*
	 * Leetcode - input tree can have duplicate nodes
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		lowestCommonAncestorHelper(root, p, q);
		return lca;
	}
	
	private int lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {

		int matchedNodes = 0;
		if(root == null || lca != null)
			return matchedNodes;
		
		if(root == p){
			matchedNodes++;
		}
		
		if(root == q){
			matchedNodes++;
		}
		
		matchedNodes += lowestCommonAncestorHelper(root.left, p, q);
		matchedNodes += lowestCommonAncestorHelper(root.right, p, q);
		
		if(matchedNodes == 2 && lca == null){
			lca = root;
		} 
		
		return matchedNodes;
		
	}

	/*
	 * Expect no duplicate nodes in tree - works only in IB
	 */
	public int lca(TreeNode root, int p, int q) {
		lcaHelper(root, p, q);
		return lca == null ? -1 : lca.val;
	}
	
	
	public int lcaHelper(TreeNode root, int p, int q) {
		int matchedNodes = 0;
		if(root == null || lca != null)
			return matchedNodes;
		
		if(root.val == p){
			matchedNodes++;
		}
		
		if(root.val == q){
			matchedNodes++;
		}
		
		matchedNodes += lcaHelper(root.left, p, q);
		matchedNodes += lcaHelper(root.right, p, q);
		
		if(matchedNodes == 2 && lca == null){
			lca = root;
		} 
		
		return matchedNodes;
	}
	
}
