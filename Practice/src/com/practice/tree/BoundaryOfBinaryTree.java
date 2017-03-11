package com.practice.tree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
        TreeNode o1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode f4 = new TreeNode(4);
        TreeNode f5 = new TreeNode(5);
        TreeNode s6 = new TreeNode(6);
        TreeNode s7 = new TreeNode(7);
        TreeNode e8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);

        root.left = o1;
        root.right = t2;

        o1.left = t3;
        o1.right = f4;
        
        t2.left = f5;
        t2.right = s6;
        s6.left = n10;
        
        
        t3.left = s7;
        t3.right = e8;
        f4.left = n9;
        BoundaryOfBinaryTree inst = new BoundaryOfBinaryTree();
        System.out.println(inst.printBoundary(root));

	}
	
	public List<Integer> printBoundary(TreeNode n){
		List<Integer> nodes = new ArrayList<>();
		nodes.add(n.val);
		printLeftEdge(n.left, nodes);
		printLeaves(n, nodes);
		printRightEdge(n.right, nodes);

		return nodes;
	}
	
	public void printLeftEdge(TreeNode n, List<Integer> nodes){
		if(n.left != null){
			nodes.add(n.val);
			printLeftEdge(n.left, nodes);
		} else{
			nodes.add(n.val);
		}
	}
	
	public void printRightEdge(TreeNode n, List<Integer> nodes){
		if(n.right != null){
			printRightEdge(n.right, nodes);
			nodes.add(n.val);
		} else{
			nodes.add(n.val);
		}
	}
	
	public void printLeaves(TreeNode n, List<Integer> nodes){
		if(n == null)
			return;
		
		if(n.left == null && n.right == null){
			nodes.add(n.val);
		} else{
			printLeaves(n.left, nodes);
			printLeaves(n.right, nodes);
		}
	}
}
