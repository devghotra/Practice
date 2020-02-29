package com.practice.tree;

import com.practice.tree.util.TreeNode;

public class InorderPredecessorBST_LC {

    public TreeNode inorderPredecessor(TreeNode root, TreeNode node) {
        TreeNode predecessor = null;

        while (root != null) {
            if (node.val > root.val) {
                predecessor = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return predecessor;
    }

    public static void main(String[] args) {
        InorderPredecessorBST_LC inst = new InorderPredecessorBST_LC();

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
            System.out.println("2 - " + inst.inorderPredecessor(root, two));
            System.out.println("3 - " + inst.inorderPredecessor(root, three));
            System.out.println("4 - " + inst.inorderPredecessor(root, four));
            System.out.println("5 - " + inst.inorderPredecessor(root, root));
            System.out.println("7 - " + inst.inorderPredecessor(root, seven));
            System.out.println("8 - " + inst.inorderPredecessor(root, eight));
            System.out.println("9 - " + inst.inorderPredecessor(root, nine));
        }

    }
}
