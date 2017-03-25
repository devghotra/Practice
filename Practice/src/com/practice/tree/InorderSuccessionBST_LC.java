package com.practice.tree;

public class InorderSuccessionBST_LC {
	
	public TreeNode inorderSuccessor(TreeNode root, TreeNode node){
		TreeNode succ = null;
		
		while(root != null){
			// only node you can surely set is root, if its not correct successor it will be overridden
			if(node.val < root.val){
				succ = root;
				root = root.left;
			} else{
				root = root.right;
			}
		}
		
		return succ;
	}
	
	public static void main(String[] args) {
		InorderSuccessionBST_LC inst = new InorderSuccessionBST_LC();

		TreeNode zero = new TreeNode(0);
		TreeNode root = new TreeNode(5);
		TreeNode three = new TreeNode(3);
		TreeNode eight = new TreeNode(8);
		TreeNode two = new TreeNode(2);
		TreeNode four = new TreeNode(4);
		TreeNode seven = new TreeNode(7);
		TreeNode nine = new TreeNode(9);

		root.left = three;
		root.right = eight;

		three.left = two;
		three.right = four;

		eight.left = seven;
		eight.right = nine;

		if (true) {
			System.out.println("2 - " + inst.inorderSuccessor(root, two));
			System.out.println("3 - " + inst.inorderSuccessor(root, three));
			System.out.println("4 - " + inst.inorderSuccessor(root, four));
			System.out.println("5 - " + inst.inorderSuccessor(root, root));
			System.out.println("7 - " + inst.inorderSuccessor(root, seven));
			System.out.println("8 - " + inst.inorderSuccessor(root, eight));
			System.out.println("9 - " + inst.inorderSuccessor(root, nine));
		}

	}

}
